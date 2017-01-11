package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;


import DAO.DAOFornecedor;
import DAO.DAOProduto;
import visao.*;

public class ControlePrincipal implements ActionListener {
	private TelaPrincipal tp;

	public ControlePrincipal (TelaPrincipal tp)
	{
	this.tp=tp;
	tp.escuta(this);
	}
	public void prod(){
		TelaProduto tc = new TelaProduto();
		
		try
		{ DAOFornecedor DAOT = new DAOFornecedor();
		ArrayList tipos = DAOT.consultarTodos();
		tc.preenchefornecedor(tipos);
		}
		catch(Exception E){}
		tp.MostrarTela(tc);
		@SuppressWarnings("unused")
		ControleProduto c = new ControleProduto (tc,tp);
		
	}
	public void Pedido() {
		TelaPedido tv = new TelaPedido();
		try {
			DAOProduto de = new DAOProduto();
			if  (de.codprod()){
						tv.gerente();
					
					tp.MostrarTela(tv);
					@SuppressWarnings("unused")
					ControlePedido cv = new ControlePedido(tv, tp);

				} else {
					prod();
				}
			return;
		} catch (Exception e1) {
				e1.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Produto")) {
			prod();
		}
		if (e.getActionCommand().equals("Cliente")) {
		}
		if (e.getActionCommand().equals("Cadastro Pedidos")) {
			Pedido();
		}
		
		if (e.getActionCommand().equals("CLIENTE")) {
		}
		if (e.getActionCommand().equals("PRODUTO")) {
			prod();
		}
		if (e.getActionCommand().equals("REGISTRAR Pedido")) {
			Pedido();
		}
		if (e.getActionCommand().equals("Sair")) {
			tp.fecharTela();

		}

	}
}
