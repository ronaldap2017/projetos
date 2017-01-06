package controle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import defaultmodel.Pedidotable;
import DAO.DAOProduto;
import DAO.DAOPedido;
import modelo.*;
import visao.*;

public class ControlePedido implements ActionListener,ItemListener{
	private TelaPedido tv;
	private Produto e;
	private Pedido v;
	private int c = 0;
	private int cont=2;
	private int qtdvend;
	DecimalFormat deci = new DecimalFormat("0.00");
	private int qtdPedidolt;
	public ArrayList produtos;
	int todos;
	public ControlePedido (TelaPedido tv, TelaPrincipal tp)
	{
		try
		{ 
		DAOPedido DAOC = new DAOPedido();
		todos = DAOC.consultarnota();
		tv.nota(todos);
		GregorianCalendar calendar = new GregorianCalendar();
		int dia = calendar.get(GregorianCalendar.DAY_OF_MONTH);
		int mes = calendar.get(GregorianCalendar.MONTH);
		int ano = calendar.get(GregorianCalendar.YEAR);
		tv.DataPc(dia, mes, ano);
		}
		catch(Exception E){
			E.printStackTrace();
		}
		
		Parametros par = new Parametros();
		par.setCod_par(1);
		
		try
		{ 
		DAOProduto DAOC = new DAOProduto();
		produtos = DAOC.consultarTodos();
		tv.preenchenomeprodutocad(produtos);
		}
		catch(Exception E){}
		try
		{ 
		DAOPedido DAOT = new 	DAOPedido();
		par = DAOT.consulta(par);
		par.setCod_par(4);
		par = DAOT.consulta(par);
		/*ArrayList tipos = DAOP.consultarTodospg();
		tv.preenchepagamentoalt(tipos);
		tv.preenchepagamentocon(tipos);*/
		}
		catch(Exception E){}
		this.tv=tv;
		tv.escuta(this);
		tv.escutaitem(this);
	}
	public void actionPerformed(ActionEvent a) {
		if(a.getActionCommand().equals("Sair"))	{ tv.fecharTela();	}
		//cadastrar
		
		if(a.getActionCommand().equals("Registrar Pedido"))	{ registrarPedido();	}
		if(a.getSource()==tv.jBadd){ adicionarcad();	}
		if(a.getSource()==tv.jBremcad){	removercad();}
	
		
	}

	
	//cadastrar	
	public void atualizar_estoquecad() {
		for (int i = 0; i < tv.vdtcad.getRowCount(); i++) {
			Produto p = new Produto();
			int cod = (Integer) tv.vdtcad.getValueAt(i, 0);
			p.setCod_produto(cod);
			try {
				DAOProduto dp = new DAOProduto();
				p = dp.consultar(p);
				int qtd;
				qtd = (Integer) tv.vdtcad.getValueAt(i, 2);
				p.setQtd_disponivel(p.getQtd_disponivel() - qtd);
				dp.alterar(p);
			} catch (Exception e1) {
				msgerro();
				e1.printStackTrace();
			}
		}
	}

	
	
	public void Imprimir() {
		Object[] options = { "Sim", "Nao" };
		int op = JOptionPane.showOptionDialog(null, "Imprimir nota fiscal?", "Imprimir nota fiscal?",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
				options, options[0]);
		if (op == 0) {
			notafiscal();
		}
		if (op == 1) {
			
		}
	}
	public void notafiscal(){
		try {
			DAOPedido dv = new DAOPedido();
			ArrayList data = (ArrayList) dv.notafiscal();

			JRBeanCollectionDataSource jr = new JRBeanCollectionDataSource(
					data);
			JasperFillManager.fillReportToFile("notafiscal.jasper",
					new HashMap(), jr);
			JasperViewer.viewReport("notafiscal.jrprint", false, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void consultarprodutocad(){
		tv.jBadd.setVisible(true);
		e = new Produto();
		/*try {
			DAOProduto DAOT = new DAOProduto();
			ArrayList tipos;
			tipos = DAOT.consultarTodos();
				e = (Produto) tipos.get(tv.jTNomecad.getSelectedIndex()-1);
		} catch (Exception e1) {	
			e1.printStackTrace();
		}*/
		int prod = tv.jTNomecad.getSelectedIndex()-1;
		if(prod==-1){
			tv.jTCodigocad.setText("");
			tv.qtdestoque.setVisible(false);
			tv.setNome("");
			tv.jTvlunitariocad.setText("");
			tv.estoque.setVisible(false);
			tv.qtdestoque.setVisible(false);
		}else{
		e = (Produto) produtos.get(tv.jTNomecad.getSelectedIndex()-1);
		
		//try {
			/*DAOProduto de = new DAOProduto();
			e = de.consultar(e);*/
			tv.setCodigo(e.getCod_produto());
			tv.setQtdestoque(String.valueOf(e.getQtd_disponivel()));
			tv.setNome(e.getNome());
			String val = deci.format(e.getValor_unit());
			tv.setvlrunit(val.replace(",", "."));
			tv.estoque.setVisible(true);
			tv.qtdestoque.setVisible(true);
			return;}
	}
	
			/*if(de.cod(e.getCod_produto())){
				
			}else {
				if (e.getNome()==null)
				{
					tv.mostrarmsg("Selecione o produto.");
					tv.jTNomecad.requestFocus();
					return;
				}
				tv.mostrarmsg("O Produto "+e.getNome()+" nao existe.");
				}*/
		/*} catch (Exception e1) {
			tv.mostrarmsg("Nao achou.");
			e1.printStackTrace();
		}*/
	public void registrarPedido(){
		v = new Pedido();
		Transportadora tr = new Transportadora();
		DAOPedido dv = new DAOPedido();
			try {
				v.setValortotal(tv.getTotal());
				String teste = tv.getData();   
				SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );     
				Date data = sdf.parse(teste);     
				v.setData(data);
				v.setNotafiscal(Integer.parseInt(tv.getNota()));
				v.setValorfrete(tv.getfrete());
				v.setDesconto(tv.getdesc());
				Set<Transportadora> lista_transportadora = new HashSet<Transportadora>(); 
				lista_transportadora.add(tr);
				v.setTransportadora(lista_transportadora);
				tr.setPedido(v);
				if (dv.nomeRepetido(String.valueOf(v.getNotafiscal()))) {	msgnotafiscal(); return;	}
				Set<Item> listaItens = new HashSet<Item>();
				Pedidotable model = (Pedidotable) tv.jTablecad.getModel();
				for(Item item:model.getItens()){
					item.setpedido(v);
					listaItens.add(item);
				}
				v.setItens(listaItens);
				tr.setNome(tv.getTransportadora());
				atualizar_estoquecad();
				dv.cadastrar(v);
				tv.mostrarmsg("O Pedido foi concluido com sucesso.");
				tv.limparTabela();
				model.clear();
			} catch (Exception e1) {
				if(tv.getNota().equals("")){
					tv.mostrarmsg("Campo nota vazio!");
					tv.jTnotacad.requestFocus();
					return;
				}
				if(tv.getData()==null){
					tv.mostrarmsg("Campo data vazio!");
					tv.jTDatacad.requestFocus();
					return;
				}
				if(tv.getValor().equals("")){
					tv.mostrarmsg("Campo valor vazio!");
					tv.jTvlunitariocad.requestFocus();
					return;
				}
				if(String.valueOf(tv.getQtd()).equals("")){
					tv.mostrarmsg("Campo quantidade vazio!");
					tv.jTQtdcad.requestFocus();
					return;
				}
				tv.mostrarmsg("Nao cadastrou.");
				e1.printStackTrace();
			}
			tv.fecharTela();
	}
	public void adicionarcad(){
		if(tv.jTQtdcad.getText().equals("")){
			tv.mostrarmsg("Informe a quantidade desejada.");
			tv.jTQtdcad.requestFocus();
			return;
		}
		/*if (String.valueOf(tv.getQtd()).length() != 0){
			try {
			}catch(NumberFormatException ex){
			tv.mostrarmsg("O campo quantidade só aceita números");
			return;
			}
			}*/	
			tv.ValidaNumero(tv.jTQtdcad);
			int i;  
			int posis=0;
			boolean achou=false;
			Produto p = new Produto();
			DAOProduto dp = new DAOProduto();
			try{
				int qtdteste = Integer.parseInt(tv.getQtd());
			}catch(NumberFormatException e){
				tv.mostrarmsg("O campo quantidade aceita somente números.");
				return;
			}
			int qtd = Integer.parseInt(tv.getQtd());
			try {
				String qtdneg = tv.getQtd();
				if(!(qtdneg.indexOf("-")==-1))  
			    {           
			        tv.mostrarmsg("Quantidade negativa");
			    	return;
			    }  
				if(qtd==0){
					 tv.mostrarmsg("A quantidade selecionada deve ser maior que zero.");
				    	return;
				}
				p.setCod_produto(Integer.parseInt(String.valueOf(tv.getCodigo())));
				p = dp.consulta(p);
				if (p.getQtd_disponivel() - qtd < 0) {
					tv.mostrarmsg("Quantidade de itens superior ao disponível no estoque.");
					return;
				}
				
				if(tv.vdtcad==null){}else{
				for (i = 0; i < tv.vdtcad.getRowCount() && achou == false; i++) { 
				    Object prod2 = tv.vdtcad.getValueAt(i, 0);   
				    if (prod2.equals(tv.getCodigoSetcad())) {  
				        posis = i;                                                    
				        achou = true;
				    }  
				}
				if(cont==2){
				Object qtd2 = tv.vdtcad.getValueAt(posis,2); 
				int qtd2con = Integer.parseInt(qtd2.toString());  
				qtd2con += tv.getQuantidadeSet();
				int qtdtotal = qtd2con-qtdvend;
				if(qtdtotal<p.getQtd_disponivel()){
				
				}
				}
				}
				if(achou){
					if(cont==3){
						Object[] options = { "Sim", "Nao" };
						int op = JOptionPane.showOptionDialog(null, "Adicionar mais produtos?", "Adicionar?",
								JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
								options, options[0]);
						if (op == 0) {
							Object vlr2 = tv.vdtcad.getValueAt(posis, 3);
						     Object qtd2 = tv.vdtcad.getValueAt(posis,2); 
						     Object vlrtotal2 = tv.vdtcad.getValueAt(posis, 4);
						     float vlr2con = Float.parseFloat(vlr2.toString());    
						     int qtd2con = Integer.parseInt(qtd2.toString());   
						     float vlrtotal2con = Float.parseFloat(vlrtotal2.toString()); 
						     qtd2con += tv.getQuantidadeSet();
						     vlr2con = (tv.getvlrunitSet()+vlr2con)/2;
						     vlrtotal2con = qtd2con * vlr2con; 
						     int qtdtotal = qtd2con-qtdvend;
						     if(qtd2con>p.getQtd_disponivel()){
									tv.mostrarmsg("Tentativa de retirar mais produtos do que existem!");
									return;
								}else{
						     qtd2 = qtd2con;  
						     vlr2 = vlr2con;
						     vlrtotal2 = vlrtotal2con;
						     tv.vdtcad.setValueAt(qtd2, posis, 2);
						     tv.vdtcad.setValueAt(vlr2, posis, 3);
						     tv.vdtcad.setValueAt(vlrtotal2, posis, 4);
						     tv.RecalcularTotal();}
						}
						if (op == 1) {
							
						}
					}
					
				}else{  
					tv.addSociocad(); 
					tv.RecalcularTotal();
				}  
			} catch (Exception e1) {
				msgerro();
				e1.printStackTrace();
			}
			tv.jBremcad.setVisible(true);
	}
	public void removercad(){
		int linha=tv.jTablecad.getSelectedRow();
		if(linha==-1){
			tv.mostrarmsg("Selecione o produto a ser removido.");
			return;
		}
		Object[] options = { "Sim", "Nao" };
		int op = JOptionPane.showOptionDialog(null, "Realmente quer remover os produtos?", "Remover?",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
				options, options[0]);
		if (op == 0) {
			tv.RemoverLinhaTabela();
			tv.RecalcularTotal();
		}
		if(op ==1){
			
		}
		int i = tv.vdtcad.getRowCount();
		if(i ==0){
			tv.jBremcad.setVisible(false);
			
		}
	}
	
	
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	public void itemStateChanged(ItemEvent e) {
		//cadastrar
		if( e.getItem()==tv.getNome()){
			consultarprodutocad();
		}
		
		
	}
	//mensagens
	public void msgerro(){
		tv.mostrarmsg("ERRO.");
	}
	public void msgparcelas(){
		tv.mostrarmsg("Selecione a quantidade de parcelas.");
	}	
	public void msgvalorentrada(){
		tv.mostrarmsg("Valor da entrada superior ao valor da compra.");
	}
	public void msgselecionepag(){
		tv.mostrarmsg("Selecione o tipo de pagamento.");
	}
	public void msgcliente(){
		tv.mostrarmsg("Selecione um Cliente.");
	}
	public void msgnotafiscal(){
		tv.mostrarmsg(v.getNotafiscal()+" já existente.");
	}
}