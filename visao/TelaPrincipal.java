package visao;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.event.*;
import javax.swing.JButton;
import java.awt.Point;
import javax.swing.JToolBar;


import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.Font;

public class TelaPrincipal {

	private JFrame jFrame2 = null;  //  @jve:decl-index=0:visual-constraint="46,17"
	private JMenuBar jJMenuBar = null;
	public JMenu jMcadastro = null;
	public JMenu jMenu = null;
	private JMenu jMPedidos = null;
	public JMenu jRel = null;
	private JMenuItem jMIestoque = null;
	private JMenuItem jMIPedidos = null;
	private JMenuItem jdata = null;
	public JMenuItem jMImarca = null;
	public JMenuItem jMIfornecedor = null;
	private JMenuItem jMIproduto = null;
	private JDesktopPane jDesktopPane = null;
	public JLabel usuario = null;
	private JLabel data = null;
	public JButton jBSair = null;
	public JButton jBProd = null;
	public JButton jBCliente = null;
	public JButton jBEstoque = null;
	public JButton jBPedido = null;
	public JButton jBrela = null;
	public JButton jBFuncionario = null;
	private JToolBar jJToolBarBar = null;  //  @jve:decl-index=0:visual-constraint="359,803"
	private JButton jBusuario = null;
	private JButton jBIndice = null;
	private JTextField welcome = null;
	private JTextField welcome1 = null;
	private JLabel jLabelfigcao = null;
	public TelaPrincipal(){
					getJFrame2();
	}
	private JFrame getJFrame2() {
		if (jFrame2 == null) {
			jFrame2 = new JFrame();
			jFrame2.setSize(new Dimension(830, 670));
			jFrame2.setTitle("Menu Principal");
			jFrame2.setPreferredSize(new Dimension(800, 600));
			jFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame2.setLocation(new Point(0, 0));
			jFrame2.setContentPane(getJDesktopPane());
			jFrame2.setVisible(true);
			//essa eh a tela gerente
		}
		return jFrame2;
	}
	private JDesktopPane getJDesktopPane() {
		if (jDesktopPane == null) {
			data = new JLabel();
			data.setBounds(new Rectangle(3, 468, 136, 38));
			data.setText("");
			usuario = new JLabel();
			usuario.setBounds(new Rectangle(5, 407, 188, 28));			
			usuario.setFont(new Font("Ebrima", Font.BOLD, 12));
			jDesktopPane = new JDesktopPane();
			jDesktopPane.setPreferredSize(new Dimension(800, 600));
			jDesktopPane.add(usuario, null);
			jDesktopPane.add(data, null);
			jDesktopPane.add(getJJToolBarBar(), null);
		}
		return jDesktopPane;
	}
	private JToolBar getJJToolBarBar() {
		if (jJToolBarBar == null) {
			jJToolBarBar = new JToolBar();
			jJToolBarBar.setBounds(new Rectangle(343, 136, 154, 244));
			jJToolBarBar.setOrientation(JToolBar.VERTICAL);
			jJToolBarBar.setLayout(new GridLayout(8,1));
			jJToolBarBar.setEnabled(false);
			jJToolBarBar.setBackground(Color.white);
			jJToolBarBar.setComponentOrientation(ComponentOrientation.UNKNOWN);
			jJToolBarBar.add(getJBProd());
			jJToolBarBar.add(getJBPedido());
			jJToolBarBar.add(getJBSair());
			}
		return jJToolBarBar;
	}
	private JButton getJBProd() {
		if (jBProd == null) {
			jBProd = new JButton();
			jBProd.setText("PRODUTO");
		}
		return jBProd;
	}
	private JButton getJBPedido() {
		if (jBPedido == null) {
			jBPedido = new JButton();
			jBPedido.setText("REGISTRAR Pedido");
		} 
		return jBPedido;
	}
	private JButton getJBSair() {
		if (jBSair == null) {
			jBSair = new JButton();
			jBSair.setText("Sair");
		}
		return jBSair;
	}
	
	//metodos
	public void escuta(ActionListener l)
	{
		jBSair.addActionListener(l);
		jBProd.addActionListener(l);
		jBPedido.addActionListener(l);
		//jBIndice.addActionListener(l);
	}
	public void escutafunc(ActionListener l)
	{
		jMIproduto.addActionListener(l);
		jMIestoque.addActionListener(l);
		jMIPedidos.addActionListener(l);
		jBSair.addActionListener(l);
		jdata.addActionListener(l);
		jMImarca.addActionListener(l);
		jMIfornecedor.addActionListener(l);
		jBProd.addActionListener(l);
		jBPedido.addActionListener(l);
		jBusuario.addActionListener(l);
		jBIndice.addActionListener(l);
	}
	public void fecharTela()
	{
		jFrame2.dispose();
	}
	public void MostrarTela(JInternalFrame tela){
		jDesktopPane.add(tela);
		try{
			tela.setSelected(true);
		}
		catch(Exception e)
		{}
		}
	public void UsuarioLogado(String strNome)
	{
		usuario.setText(strNome);
	}
	
	public void DataPc(int dia,int mes,int ano)
	{
		mes = mes +1;
		data.setText(String.valueOf(dia+"/"+mes+"/"+ano));
	}
	
	/**
	 * This method initializes welcome1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
}