package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import DAO.DAOFornecedor;
import DAO.DAOProduto;
import modelo.*;
import utilitariosSO.IUpdate;
import visao.*;

public class ControleProduto implements ActionListener, IUpdate,MouseListener {
	private TelaProduto te;
	private TelaPrincipal tp;
	private Produto e;

	public ControleProduto(TelaProduto te, TelaPrincipal tp) {
		te.jTnome1.requestFocus();
		this.te = te;
		this.tp = tp;
		te.escuta(this);
		te.escutamouse(this);
		e=new Produto();
		te.mostrarUltimoCodigoInserido();
		DAOProduto daop = new DAOProduto();
		try {
			te.getProdutos(daop.consultarTodos());
			te.getProdutosprod(daop.consultarTodos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void actionPerformed(ActionEvent a) {
		if (a.getActionCommand().equals("Sair")) {
			te.fecharTela();
		}
		if (a.getActionCommand().equals("ADICIONAR FORNECEDOR")) {
			te.setVisible(false);
			TelaFornecedor tf = new TelaFornecedor();
			tp.MostrarTela(tf);
			@SuppressWarnings("unused")
			ControleFornecedor m = new ControleFornecedor(tf,te);
			m.setIUpdate2(this);
			try {
				DAOFornecedor DAOT = new DAOFornecedor();
				ArrayList tipos;
				tipos = DAOT.consultarTodos();
				tf.preenchefornecedor(tipos);
			} catch (Exception e) {	}
		}
		if (a.getActionCommand().equals("Cadastrar")) {
			e = new Produto();
			DAOProduto de = new DAOProduto();
			try {
				String qtdneg = te.getQtd();
				if(!(qtdneg.indexOf("-")==-1))  
			    {           
			        te.mostrarmsg("Quantidade negativa");
			    	return;
			    }  
				e.setNome(te.getNome());
				e.setDescricao(te.getDescricao1());
			e.setQtd_disponivel(Integer.parseInt((te.getQtd())));
			Fornecedor f = (Fornecedor) te.getFornecedor();
			if (f.getNome().equals("FORNECEDOR")) {
				te.mostrarmsg("Selecione o fornecedor!!!");
				return;
			}
			e.setFornecedor(f);
				if (de.nomeRepetido(e.getNome())) {
					te.mostrarmsg(e.getNome() + " jah existente!!!");
					return;
				}
				if(te.getNome().length() > 10){
					te.mostrarmsg("Nome do produto muito grande. Maximo de 10 caracteres");
					return;
				}
				e.setValor_unit(Float.parseFloat(te.getPreco()));
				de.cadastrar(e);
				te.mostrarmsg(e.getNome() + " cadastrado com sucesso!!!");
				te.limpartela();
				te.limparTabela();
				te.mostrarUltimoCodigoInserido();
				ArrayList<Produto> lista = de.consultarTodos();
				te.getProdutos(lista);
				te.getProdutosprod(lista);

			} catch (Exception e1) {
				te.mostrarmsg(e.getNome() + " nao foi cadastrado!!!");
				e1.printStackTrace();
			}
		}
		if (a.getActionCommand().equals("Alterar")) 
		{
			e.setCod_produto(Integer.parseInt(te.getcod2()));
			e.setNome(te.getNome2());
			e.setQtd_disponivel(Integer.parseInt((te.getQtd2())));
			e.setValor_unit(Float.valueOf(te.getPreco2()));
			e.setFornecedor((Fornecedor) te.getFornecedor2());
			e.setDescricao(te.getDescricao2());
			try {
				DAOProduto de = new DAOProduto();
				de.alterar(e);
				te.mostrarmsg(e.getNome() + " foi alterado com sucesso!!!");
				te.limpartelaalt();
			} catch (Exception e1) {
				te.mostrarmsg("O " + e.getNome() + " nao foi alterado!!!");
				e1.printStackTrace();
			}
		}		
		if (a.getActionCommand().equals("Consultar")) {
			alterar();
		}
		if (a.getActionCommand().equals("Excluir")) {
			try {
				DAOProduto de = new DAOProduto();
				de.excluir(e);
				te.mostrarmsg(e.getNome() + " foi excluido com sucesso!!!");
				te.limpartelaexc();
				te.limparTabela();
				ArrayList<Produto> lista = de.consultarTodos();
				te.getProdutos(lista);
				te.getProdutosprod(lista);
			} catch (Exception e1) {
				te.mostrarmsg("O " + e.getNome() + " nao foi excluido!!!");
				e1.printStackTrace();
			}
			}
		
	}
	public void alterar(){
		e = new Produto();
		e.setCod_produto(Integer.parseInt(te.getcod2()));
		try {
			DAOProduto dp = new DAOProduto();
			e = dp.consultar(e);
			
			if(dp.cod(e.getCod_produto())){
				te.setNome2(e.getNome());
				te.setQtd2(String.valueOf(e.getQtd_disponivel()));
				te.setfornecedor2(e.getFornecedor());
				te.setPreco2(String.valueOf(e.getValor_unit()));
				te.setDescricao2(e.getDescricao());
				te.jTnome2.setEditable(true);
				te.jTQtd2.setEditable(true);
				te.jCforn2.setEnabled(true);
				te.jTPreco2.setEditable(true);
				te.jTdesc2.setEditable(true);
				return;
			}else {
				te.mostrarmsg("O codigo "+te.getcod2()+" nao existe");
		}
		} catch (Exception e1) {
			te.jTCod2.requestFocus();
		}
	}
	public void mouseClicked(MouseEvent arg0) {
		if (te.jTableprod.isRowSelected(te.jTableprod.getSelectedRow())) {  
			e = new Produto();
			e.setCod_produto(Integer.parseInt(te.getCodigo()));
			try {
				DAOProduto dp = new DAOProduto();
				e = dp.consultar(e);
				if(dp.cod(e.getCod_produto())){
					te.setcod121(String.valueOf(e.getCod_produto()));
					te.setfornecedor12((Fornecedor)e.getFornecedor());
					te.setQtd12(String.valueOf(e.getQtd_disponivel()));
					te.setNome12(e.getNome());
					te.setPreco12(String.valueOf(e.getValor_unit()));
					te.setDesc12(e.getDescricao());
				}else {
					
			}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			}  
	}
	public void Update() {

		try {
			DAOFornecedor DAOT = new DAOFornecedor();
			ArrayList tipos = DAOT.consultarTodos();
			te.preenchefornecedor(tipos);

		} catch (Exception E) {
		}
	}
	public void Update2() {
		try {
			DAOFornecedor DAOT = new DAOFornecedor();
			ArrayList tipos = DAOT.consultarTodos();
			te.preenchefornecedor(tipos);
			} catch (Exception E) {
		}
	}
	

	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
}