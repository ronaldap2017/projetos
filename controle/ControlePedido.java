package controle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
	private int qtdvendalt;
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
		//alterar
				if(a.getSource().equals(tv.jBsairalt)){
					
				}
				if(a.getSource().equals(tv.jBconsnota)||a.getSource()==tv.jTnotaalt){ consultarnota();	}
				if(a.getActionCommand().equals("Alterar")){	alterar();	}
				if(a.getSource()==tv.jBaddalt){	adicionaralt();	}
				if(a.getSource()==tv.jBremalt){	removeralt();	}
			
				//consultar e excluir
				if(a.getSource().equals(tv.jBexcluir)){	excluir();	}
				if(a.getSource()==tv.jTnotacon ||a.getSource().equals(tv.jBconsultar)){consultar(); }	
				if(a.getSource().equals(tv.jBimprimir)){notafiscal();}
			
		
	}
	//consultar e excluir
		public void consultar(){
			v = new Pedido();
			tv.ValidaNumero(tv.jTnotacon);
			try{
				int nota = Integer.parseInt(tv.getNotacon());
			}catch(NumberFormatException e){
				tv.mostrarmsg("O campo nota aceita somente números.");
				return;
			}
			if(tv.jTnotacon.getText().equals("")){
				tv.mostrarmsg("Informe a nota desejada.");
				tv.jTnotacon.requestFocus();
				return;
			}
			int nota = Integer.parseInt(tv.getNotacon());
					String notaneg = tv.getNotacon();
					if(!(notaneg.indexOf("-")==-1))  
				    {           
				        tv.mostrarmsg("nao existe nota negativa.");
				    	return;
				    }  
					if(nota==0){
						 tv.mostrarmsg("A nota 0 nao existe.");
					    	return;
					}
				tv.vdtcon = (Pedidotable)tv.jTablecon.getModel();
				v.setNotafiscal(Integer.parseInt(tv.getNotacon()));
				try {
					DAOPedido dp = new DAOPedido();
					v = dp.consul(v);
					if(dp.cod(v.getNotafiscal())){
						tv.setNotacon(String.valueOf(v.getNotafiscal()));
						String data = (new SimpleDateFormat("dd/MM/yyyy").format(v.getData()));
						tv.setDatacon(data);
						tv.setFretecon(String.valueOf(v.getValorfrete()));
						tv.setDescontocon(String.valueOf(v.getDesconto()));
						tv.setVendacon(String.valueOf(v.getValortotal()));
						tv.vdtcon.clear();
						tv.setItemscon(v.getItens());
						
					}else {
						tv.mostrarmsg(v.getNotafiscal()+" nao existe.");
				}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				}
		public void excluir(){
			v.setNotafiscal(Integer.parseInt(tv.getNotacon()));
			try {
				DAOPedido dv = new DAOPedido();
				v = dv.consul(v);
				if(v==null){
					tv.mostrarmsg("Nao achou.");
					}else if(v==v){
						
				dv.excluir(v);
				tv.mostrarmsg("Excluido.");}
			} catch (Exception e1) {
				tv.mostrarmsg("Nao excluiu.");
				e1.printStackTrace();
			}
		}
	//alterar	
		public void consultarnota(){
			v = new Pedido();
			tv.ValidaNumero(tv.jTnotaalt);
			try{
				int nota = Integer.parseInt(tv.getNotaalt());
			}catch(NumberFormatException e){
				tv.mostrarmsg("O campo nota aceita somente números.");
				return;
			}
			if(tv.jTnotaalt.getText().equals("")){
				tv.mostrarmsg("Informe a nota desejada.");
				tv.jTnotaalt.requestFocus();
				return;
			}
			int nota = Integer.parseInt(tv.getNotaalt());
					String notaneg = tv.getNotaalt();
					if(!(notaneg.indexOf("-")==-1))  
				    {           
				        tv.mostrarmsg("nao existe nota negativa.");
				    	return;
				    }  
					if(nota==0){
						 tv.mostrarmsg("A nota 0 nao existe.");
					    	return;
					}
			tv.vdtalt = (Pedidotable)tv.jTablealt.getModel();
			v.setNotafiscal(Integer.parseInt(tv.getNotaalt()));
			
			try {
				DAOPedido dv = new DAOPedido();
				v = dv.consul(v);
				if (dv.cod(v.getNotafiscal())) {

					tv.vdtalt.clear(); 
					String data = (new SimpleDateFormat("dd/MM/yyyy").format(v.getData()));
					tv.setDataalt(data);
					tv.setItemsalt(v.getItens());
					tv.setVendaalt(String.valueOf(v.getValortotal()));
					tv.jTQtdalt.setEditable(true);
					tv.jBaddalt.setEnabled(true);
					tv.jBremalt.setEnabled(true);
					tv.jBalt.setEnabled(true);
					tv.jVendaalt.setVisible(true);
					tv.jTvlunitarioalt.setEnabled(true);
					tv.jTvalorvendaalt.setVisible(true);
					return;
				} else {
					tv.mostrarmsg(v.getNotafiscal()+" nao existe.");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		public void atualizar_estoquealt() {
			for (int i = 0; i < tv.vdtalt.getRowCount(); i++) {
				Produto p = new Produto();
				int cod = (Integer) tv.vdtalt.getValueAt(i, 0);
				p.setCod_produto(cod);
				try {
					DAOProduto dp = new DAOProduto();
					p = dp.consultar(p);
					int qtd;
					qtd = (Integer) tv.vdtalt.getValueAt(i, 2);
					p.setQtd_disponivel(p.getQtd_disponivel() - qtd);
					dp.alterar(p);
				} catch (Exception e1) {
					msgerro();
					e1.printStackTrace();
				}
			}
		}
		
		
		public void alterar(){
			DAOPedido dv = new DAOPedido();
			v = new Pedido();
			try {
			String teste = tv.getDataalt();   
			SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );     
			Date data = sdf.parse(teste);     
			v.setData(data);
			v.setValortotal(tv.getTotalalt());
			v.setNotafiscal(Integer.parseInt(tv.getNotaalt()));
			List<Item> listaItens = new ArrayList<Item>();
			Pedidotable model = (Pedidotable) tv.jTablealt.getModel();
			for(Item item:model.getItens()){
				item.setpedido(v);
				listaItens.add(item);
			}
			//v.setItens(listaItens);
			dv.alterar(v);
			tv.mostrarmsg("A venda foi alterada com sucesso.");
			tv.limparTabelaalt();
			model.clear();
			} catch (Exception e1) {
				tv.mostrarmsg("Nao alterou.");
				e1.printStackTrace();
			}
			tv.fecharTela();
		}
		public void selecionealt(){
		}
		public void adicionaralt(){
		selecionealt();
		if(tv.jTQtdalt.getText().equals("")){
			tv.mostrarmsg("Informe a quantidade desejada.");
			tv.jTQtdalt.requestFocus();
			return;
		}
		/*if (String.valueOf(tv.getQtd()).length() != 0){
			try {
			}catch(NumberFormatException ex){
			tv.mostrarmsg("O campo quantidade só aceita números");
			return;
			}
			}*/	
			tv.ValidaNumero(tv.jTQtdalt);
			int i;  
			int posis=0;
			boolean achou=false;
			Produto p = new Produto();
			DAOProduto dp = new DAOProduto();
			try{
				int qtdteste = Integer.parseInt(tv.getQtdalt());
			}catch(NumberFormatException e){
				tv.mostrarmsg("O campo quantidade aceita somente números.");
				return;
			}
			int qtd = Integer.parseInt(tv.getQtdalt());
			try {
				String qtdneg = tv.getQtdalt();
				if(!(qtdneg.indexOf("-")==-1))  
			    {           
			        tv.mostrarmsg("Quantidade negativa");
			    	return;
			    }  
				if(qtd==0){
					 tv.mostrarmsg("A quantidade selecionada deve ser maior que zero.");
				    	return;
				}
				p.setCod_produto(Integer.parseInt(String.valueOf(tv.getCodigoalt())));
				p = dp.consulta(p);
				if (p.getQtd_disponivel() - qtd < 0) {
					tv.mostrarmsg("Quantidade de itens superior ao disponível no estoque.");
					return;
				}
				if(cont==2){
					
					cont++;
				}
				
				if(tv.vdtalt==null){}else{
				for (i = 0; i < tv.vdtalt.getRowCount() && achou == false; i++) { 
				    Object prod2 = tv.vdtalt.getValueAt(i, 0);   
				    if (prod2.equals(tv.getCodigoSetalt())) {  
				        posis = i;                                                    
				        achou = true;
				    }  
				}
				if(cont==2){
				Object qtd2 = tv.vdtalt.getValueAt(posis,2); 
				int qtd2con = Integer.parseInt(qtd2.toString());  
				qtd2con += tv.getQuantidadeSetalt();
				int qtdtotal = qtd2con-qtdvendalt;
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
							Object vlr2 = tv.vdtalt.getValueAt(posis, 3);
						     Object qtd2 = tv.vdtalt.getValueAt(posis,2); 
						     Object vlrtotal2 = tv.vdtalt.getValueAt(posis, 4);
						     float vlr2con = Float.parseFloat(vlr2.toString());    
						     int qtd2con = Integer.parseInt(qtd2.toString());
						     int qtdinicial = qtd2con;
						     float vlrtotal2con = Float.parseFloat(vlrtotal2.toString()); 
						     qtd2con += tv.getQuantidadeSetalt();
						     vlr2con = (tv.getvlrunitSetalt()+vlr2con)/2;
						     vlrtotal2con = qtd2con * vlr2con; 
						     int qtdtotal = qtd2con-qtdvendalt;
						     int qtdalt = tv.getQuantidadeSetalt();
						     int qtdestoquebd = e.getQtd_disponivel();
						     int qtdestoque = Integer.parseInt(tv.qtdestoquealt.getText());
						     int qtda = +qtdalt;
						     if(qtda>qtdestoque){
									tv.mostrarmsg("Tentativa de retirar mais produtos do que existem!");
									return;
								}else{
									if(qtdtotal<p.getQtd_disponivel()){
										 	
									}
						     qtd2 = qtd2con;  
						     vlr2 = vlr2con;
						     vlrtotal2 = vlrtotal2con;
						     tv.vdtalt.setValueAt(qtd2, posis, 2);
						     tv.vdtalt.setValueAt(vlr2, posis, 3);
						     tv.vdtalt.setValueAt(vlrtotal2, posis, 4);
						     tv.RecalcularTotalalt();
						     int qtdajustada=qtdestoque-qtdalt;
						     tv.qtdestoquealt.setText(""+qtdajustada);
						     int qtdfinalalt=qtd2con-qtdinicial;
						     int qtdfinalbd = qtdestoquebd-qtdfinalalt;
						     for (int it = 0; it < tv.vdtalt.getRowCount(); it++) {
									int cod = (Integer) tv.vdtalt.getValueAt(it, 0);
									p.setCod_produto(cod);
									try {
										p = dp.consultar(p);
										p.setQtd_disponivel(qtdfinalbd);
										dp.alterar(p);
									} catch (Exception e1) {
										msgerro();
										e1.printStackTrace();
									}
								}
						     try {
									p = dp.consultar(p);
									}catch (Exception e1) {
										msgerro();
										e1.printStackTrace();
									}
						     
								}
						}
						if (op == 1) {
							
						}
					}
					
				}else{  
					tv.addSocioalt(); 
					tv.RecalcularTotalalt();
					Object vlr2 = tv.vdtalt.getValueAt(posis, 3);
				     Object qtd2 = tv.vdtalt.getValueAt(posis,2); 
				     Object vlrtotal2 = tv.vdtalt.getValueAt(posis, 4);
				     float vlr2con = Float.parseFloat(vlr2.toString());    
				     int qtd2con = Integer.parseInt(qtd2.toString());
				     int qtdinicial = qtd2con;
				     float vlrtotal2con = Float.parseFloat(vlrtotal2.toString()); 
				     qtd2con += tv.getQuantidadeSetalt();
				     vlr2con = (tv.getvlrunitSetalt()+vlr2con)/2;
				     vlrtotal2con = qtd2con * vlr2con; 
				     int qtdtotal = qtd2con-qtdvendalt;
				     int qtdalt = tv.getQuantidadeSetalt();
				     int qtdestoquebd = e.getQtd_disponivel();
				     int qtdestoque = Integer.parseInt(tv.qtdestoquealt.getText());
				     int qtda = +qtdalt;
				     if(qtda>qtdestoque){
							tv.mostrarmsg("Tentativa de retirar mais produtos do que existem!");
							return;
						}else{
							if(qtdtotal<p.getQtd_disponivel()){
								 
							}
				     qtd2 = qtd2con;  
				     vlr2 = vlr2con;
				     vlrtotal2 = vlrtotal2con;
				     tv.vdtalt.setValueAt(qtd2, posis, 2);
				     tv.vdtalt.setValueAt(vlr2, posis, 3);
				     tv.vdtalt.setValueAt(vlrtotal2, posis, 4);
				     tv.RecalcularTotalalt();
				     int qtdajustada=qtdestoque-qtdalt;
				     tv.qtdestoquealt.setText(""+qtdajustada);
				     int qtdfinalalt=qtd2con-qtdinicial;
				     int qtdfinalbd = qtdestoquebd-qtdfinalalt;
				     for (int it = 0; it < tv.vdtalt.getRowCount(); it++) {
							int cod = (Integer) tv.vdtalt.getValueAt(it, 0);
							p.setCod_produto(cod);
							try {
								p = dp.consultar(p);
								p.setQtd_disponivel(qtdfinalbd);
								dp.alterar(p);
							} catch (Exception e1) {
								msgerro();
								e1.printStackTrace();
							}
						}
				     try {
							p = dp.consultar(p);
							}catch (Exception e1) {
								msgerro();
								e1.printStackTrace();
							}
				     
						}
				}  
			} catch (Exception e1) {
				msgerro();
				e1.printStackTrace();
			}
			tv.jBalt.setVisible(true);
			tv.jBremalt.setVisible(true);
		
	}


		public void removeralt(){
			int linha=tv.jTablealt.getSelectedRow();
			if(linha==-1){
				tv.mostrarmsg("Selecione o produto a ser removido.");
				return;
			}
			Object[] options = { "Sim", "Nao" };
			int op = JOptionPane.showOptionDialog(null, "Realmente quer remover os produtos?", "Remover?",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
					options, options[0]);
			if (op == 0) {
				Produto p = new Produto();
				DAOProduto dp = new DAOProduto();
			     Object qtd2 = tv.vdtalt.getValueAt(linha,2); 
			    int qtd2con = Integer.parseInt(qtd2.toString());
			     int qtdestoquebd = e.getQtd_disponivel();
			     int qtdatualestoque = qtdestoquebd+qtd2con;
			     for (int it = 0; it < tv.vdtalt.getRowCount(); it++) {
						int cod = (Integer) tv.vdtalt.getValueAt(it, 0);
						p.setCod_produto(cod);
						try {
							p = dp.consultar(p);
							p.setQtd_disponivel(qtdatualestoque);
							dp.alterar(p);
						} catch (Exception e1) {
							msgerro();
							e1.printStackTrace();
						}
					}
			     try {
						p = dp.consultar(p);
						}catch (Exception e1) {
							msgerro();
							e1.printStackTrace();
						}
						tv.RemoverLinhaTabelaalt();
						tv.RecalcularTotalalt();
					}
			if(op ==1){
				
			}
			int i = tv.vdtalt.getRowCount();
			if(i ==0){
				tv.jBremalt.setVisible(false);
			}
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
	public void consultarprodutoalt(){
		tv.jBaddalt.setVisible(true);
		e = new Produto();
		/*try {
			DAOProduto DAOT = new DAOProduto();
			ArrayList tipos;
			tipos = DAOT.consultarTodos();
				e = (Produto) tipos.get(tv.jTNomecad.getSelectedIndex()-1);
		} catch (Exception e1) {	
			e1.printStackTrace();
		}*/
		int prod = tv.jTNomealt.getSelectedIndex()-1;
		if(prod==-1){
			tv.jTCodigoalt.setText("");
			tv.qtdestoquealt.setVisible(false);
			tv.setNomealt("");
			tv.jTvlunitarioalt.setText("");
			tv.estoquealt.setVisible(false);
			tv.qtdestoquealt.setVisible(false);
			tv.jTfretealt.setEditable(true);
			tv.jTdescalt.setEditable(true);
			tv.jTtransportadoraalt.setEditable(true);
		}else{
		e = (Produto) produtos.get(tv.jTNomealt.getSelectedIndex()-1);
		
		//try {
			/*DAOProduto de = new DAOProduto();
			e = de.consultar(e);*/
			tv.setCodigoalt(e.getCod_produto());
			tv.setQtdestoquealt(String.valueOf(e.getQtd_disponivel()));
			tv.setNomealt(e.getNome());
			String val = deci.format(e.getValor_unit());
			tv.setvlrunitalt(val.replace(",", "."));
			tv.estoquealt.setVisible(true);
			tv.qtdestoquealt.setVisible(true);
			tv.jTtransportadoraalt.setEditable(true);
			tv.jTfretealt.setEditable(true);
			tv.jTdescalt.setEditable(true);

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
		if( e.getItem()==tv.getNomealt()){
			consultarprodutoalt();
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