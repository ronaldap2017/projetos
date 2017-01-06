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

public class ControleProduto implements ActionListener, IUpdate {
	private TelaProduto te;
	private TelaPrincipal tp;
	private Produto e;

	public ControleProduto(TelaProduto te, TelaPrincipal tp) {
		te.jTnome1.requestFocus();
		this.te = te;
		this.tp = tp;
		te.escuta(this);
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
				te.mostrarUltimoCodigoInserido();
			} catch (Exception e1) {
				te.mostrarmsg(e.getNome() + " nao foi cadastrado!!!");
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