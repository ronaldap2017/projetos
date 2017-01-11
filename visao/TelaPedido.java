package visao;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import defaultmodel.Pedidotable;

import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

import modelo.Item;
import modelo.Produto;
import modelo.Pedido;
import utilitariosSO.FixedLengthDocument;
import utilitariosSO.IUpdate;
import utilitariosSO.LogManager;
import java.lang.String;

import com.toedter.calendar.JDateChooser;


import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class TelaPedido extends JInternalFrame {
	// principal
	private IUpdate update;
	private static final long serialVersionUID = 1L;
	public JTabbedPane jTabbedPane;
	public Pedidotable vdtcon;
	public Pedidotable vdtcad;
	public Pedidotable vdtalt;
	DecimalFormat deci = new DecimalFormat("0.00");  //  @jve:decl-index=0:
	DefaultTableModel dtmPedidos;
	public Pedido v;
	String form;
	
	// cadastrar
	private JPanel jCPcadastrar = null;
	public JTable jTablecad;
	private JLabel jNomecad = null;
	private JLabel jcodcad = null;
	private JLabel jQtdcad = null;
	public JComboBox jTNomecad = null;
	public JTextField jTCodigocad = null;
	public JTextField jTQtdcad = null;
	public JTextField jTfretecad = null;
	public JTextField jTdesccad = null;
	public JTextField jTtransportadoracad = null;
	public JButton jBcad = null;
	private JButton jBsaircad = null;
	private JLabel jPedidocad = null;
	public JLabel jTvalorPedidocad = null;
	private JLabel jnotacad = null;
	public JTextField jTnotacad = null;
	private JLabel jDatacad = null;
	public JTextField jTDatacad = null;
	private JInternalFrame jIFCadastrar = null;
	private JScrollPane jPCadastrar;
	public JButton jBadd = null;
	public JButton jBremcad = null;
	public JTextField jTvlunitariocad = null;
	private JLabel jLvlunitariocad = null;
	private JLabel jLvlfretecad = null;
	private JLabel jLvldescontocad = null;
	public JLabel estoque = null;
	public JLabel transportadora = null;
	public JLabel qtdestoque = null;
	public ButtonGroup GREntradaalt;  //  @jve:decl-index=0:
	// alterar
		private JPanel jCPalterar = null;
		public JTable jTablealt;
		public JLabel jNomealt = null;
		public JLabel jcodalt = null;
		public JLabel jQtdalt = null;
		public JLabel porcendescalt = null;
		public JComboBox jTNomealt = null;
		public JTextField jTCodigoalt = null;
		public JTextField jTQtdalt = null;
		public JButton jBalt = null;
		public JButton jBsairalt = null;
		public JLabel jVendaalt = null;
		public JLabel jTvalorvendaalt = null;
		private JLabel jnotaalt = null;
		public JTextField jTnotaalt = null;
		private JLabel jDataalt = null;
		public JTextField jTDataalt = null;
		public JTextField jTfretealt = null;
		public JTextField jTdescalt = null;
		public JTextField jTtransportadoraalt = null;
		private JInternalFrame jIFAlterar = null;
		private JScrollPane jPalterar;
		public JButton jBaddalt = null;
		public JButton jBremalt = null;
		public JTextField jTvlunitarioalt = null;
		private JLabel jLvlunitarioalt = null;
		private JLabel Transportadoraalt = null;
		private JLabel jLvlfretealt = null;
		private JLabel jLvldescontoalt = null;
		public JComboBox jCclientealt = null;
		private JLabel jLclientealt = null;
		private JLabel Vendedoralt = null;
		public JLabel estoquealt = null;
		public JLabel qtdestoquealt = null;
		public JLabel jLpgalt = null;
		public JLabel qtdparcelasalt = null;
		public JComboBox jTparcelasalt = null;
		public JLabel Entradaalt = null;
		public JTextField jTentradaalt = null;
		public JLabel descontoalt = null;
		public JLabel descontalt = null;
		public JLabel jurosalt = null;
		public JLabel descalt = null;
		public JLabel porcenalt = null;
		public JLabel pagamentoalt = null;
		public JLabel vlrpagoalt = null;
		public JLabel valorparcalt = null;
		public JLabel vlrparcealt = null;
		public JLabel Faltaalt = null;
		public JLabel faltacadalt = null;
		public JButton jBconsnota = null;
		private JLabel codigo_vendaalt = null;
		
		// consultar
		private JPanel jCconsultar = null;
		public JTable jTablecon;
		private JButton jBsaircon = null;
		private JLabel jVendacon = null;
		public JLabel jTvalorvendacon = null;
		private JLabel jnotacon = null;
		public JTextField jTnotacon = null;
		private JLabel jDatacon = null;
		public JTextField jTDatacon = null;
		private JLabel jLpgcon = null;
		public JComboBox jCpgcon = null;
		private JInternalFrame jIFconsultar = null;
		private JScrollPane jPconsultar;
		public JComboBox jCclientecon = null;
		private JLabel jLclientecon = null;
		private JLabel Vendedorcon = null;
		public JButton jBexcluir = null;
		private JLabel vendedorconsulta = null;
		private JLabel vendedoralterar = null;
		public JLabel sementrad = null;
		public ButtonGroup GREntrada;  //  @jve:decl-index=0:
		public JLabel sementradalt = null;
		public JLabel comentradaalt = null;
		public JRadioButton entradalt = null;
		public JRadioButton sementradaalt = null;
		public JButton jBOK = null; 
		public JButton jBOKalt = null;
		public JButton jBconsultar = null;
		public JButton jBimprimir = null;
		public JLabel jTfretecon = null;
		public JLabel jTdesccon = null;
		public JLabel jTtransportadoracon = null;
		public JLabel Transportadoracon = null;
		public JLabel jLvldescontocon = null;
		public JLabel jLvlfretecon = null;
		
	
	public TelaPedido() {
		super("", false, true, false);
		initialize();
	}
	private void initialize() {
		this.setSize(800, 600);
		this.setResizable(true);
		this.setTitle("Registrar Pedidos");
		this.setVisible(true);
		setContentPane(getJTabbedPane2());
	}
	
	private JTabbedPane getJTabbedPane2() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.setTabPlacement(JTabbedPane.TOP);
			jTabbedPane.addTab("Cadastrar", null, getJIFcadastrar(), null);
			jTabbedPane.addTab("Alterar", null, getJIFalterar(), null);// alterar
			jTabbedPane.addTab("Consultar", null, getJIConsultar(), null);
		}
		return jTabbedPane;
	}
	// cadastrar inicio
	private JInternalFrame getJIFcadastrar() {
		if (jIFCadastrar == null) {
			jIFCadastrar = new JInternalFrame();
			jIFCadastrar.setTitle("Cadastrar");
			jIFCadastrar.setResizable(true);
			jIFCadastrar.setContentPane(getJPCadastrar());
		}
		return jIFCadastrar;
	}
	private JPanel getJPCadastrar() {
		if (jCPcadastrar == null) {
			qtdestoque = new JLabel();
			qtdestoque.setBounds(new Rectangle(234, 166, 59, 16));
			qtdestoque.setText("");
			estoque = new JLabel();
			estoque.setBounds(new Rectangle(20, 166, 214, 16));
			estoque.setText("Quantidade disponivel no estoque:");
			transportadora = new JLabel();
			transportadora.setBounds(new Rectangle(254, 166, 214, 16));
			transportadora.setText("Transportadora:");
			estoque.setVisible(false);
			qtdestoque.setVisible(false);
			jLvlunitariocad = new JLabel();
			jLvlunitariocad.setBounds(new Rectangle(533, 121, 97, 16));
			jLvlunitariocad.setFont(new Font("Ebrima", Font.BOLD, 13));
			jLvlunitariocad.setText("Valor Unitário:");
			jLvlfretecad = new JLabel();
			jLvlfretecad.setBounds(new Rectangle(630, 121, 97, 16));
			jLvlfretecad.setFont(new Font("Ebrima", Font.BOLD, 13));
			jLvlfretecad.setText("Vlr Frete:");
			jLvldescontocad = new JLabel();
			jLvldescontocad.setBounds(new Rectangle(700, 121, 97, 16));
			jLvldescontocad.setFont(new Font("Ebrima", Font.BOLD, 13));
			jLvldescontocad.setText("Vlr Desc.:");
			jDatacad = new JLabel();
			jDatacad.setBounds(new Rectangle(160, 72, 64, 16));
			jDatacad.setFont(new Font("Ebrima", Font.BOLD, 13));
			jDatacad.setText("Data:");
			jnotacad = new JLabel();
			jnotacad.setBounds(new Rectangle(20, 72, 80, 16));
			jnotacad.setFont(new Font("Ebrima", Font.BOLD, 13));
			jnotacad.setText("Nota Fiscal:");
			jPedidocad = new JLabel();
			jPedidocad.setBounds(new Rectangle(16, 409, 149, 16));
			jPedidocad.setFont(new Font("Ebrima", Font.BOLD, 13));
			jPedidocad.setText("Valor total do Pedido:");
			jQtdcad = new JLabel();
			jQtdcad.setBounds(new Rectangle(438, 121, 84, 16));
			jQtdcad.setFont(new Font("Ebrima", Font.BOLD, 13));
			jQtdcad.setText("Quantidade:");
			jcodcad = new JLabel();
			jcodcad.setBounds(new Rectangle(20, 121, 69, 16));
			jcodcad.setFont(new Font("Ebrima", Font.BOLD, 13));
			jcodcad.setText("Codigo:");
			jNomecad = new JLabel();
			jNomecad.setBounds(new Rectangle(106, 121, 320, 16));
			jNomecad.setFont(new Font("Ebrima", Font.BOLD, 13));
			jNomecad.setText("Produto:");
			jCPcadastrar = new JPanel();
			jCPcadastrar.setLayout(null);
			//label
			jCPcadastrar.setFont(new Font("Ebrima", Font.BOLD, 13));
			jCPcadastrar.add(jNomecad, null);
			jCPcadastrar.add(jcodcad, null);
			jCPcadastrar.add(jPedidocad, null);
			jCPcadastrar.add(jQtdcad, null);
			jCPcadastrar.add(jnotacad, null);
			jCPcadastrar.add(jDatacad, null);
			jCPcadastrar.add(jLvlunitariocad, null);
			jCPcadastrar.add(estoque, null);
			jCPcadastrar.add(qtdestoque, null);
			jCPcadastrar.add(jLvldescontocad, null);
			jCPcadastrar.add(jLvlfretecad, null);
			jCPcadastrar.add(transportadora, null);
			
			
			//textfield
			jCPcadastrar.add(getJTCodigocad(), null);
			jCPcadastrar.add(getJTQtdcad(), null);
			jCPcadastrar.add(getJTvalorPedidocad(), null);
			jCPcadastrar.add(getJTnotacad(), null);
			jCPcadastrar.add(getJTDatacad(), null);
			jCPcadastrar.add(getJTvlunitariocad(), null);
			jCPcadastrar.add(getJTfretecad(), null);
			jCPcadastrar.add(getJTdesccad(), null);		
			jCPcadastrar.add(getJTtransportadoracad(), null);		

			//combobox
			jCPcadastrar.add(getJCNomecad(), null);
			
			
			
			//button
			jCPcadastrar.add(getJBcad(), null);
			jCPcadastrar.add(getJBsaircad(), null);
			jCPcadastrar.add(getJBaddcad(), null);
			jCPcadastrar.add(getJBremcad(), null);
			
			//scroll
			jCPcadastrar.add(getJScrollPanecad(), null);
			
			
		}
		return jCPcadastrar;
	}
	
	
	//JTextfield - cad
	private JTextField getJTvlunitariocad() {
		if (jTvlunitariocad == null) {
			jTvlunitariocad = new JTextField();
			jTvlunitariocad.setBounds(new Rectangle(532, 137, 98, 20));
			jTvlunitariocad.setEditable(false);
		}
		return jTvlunitariocad;
	}
	private JTextField getJTCodigocad() {
		if (jTCodigocad == null) {
			jTCodigocad = new JTextField();
			jTCodigocad.setBounds(new Rectangle(20, 137, 69, 20));
			jTCodigocad.setEditable(false);
		}
		return jTCodigocad;
	}
	private JTextField getJTQtdcad() {
		if (jTQtdcad == null) {
			jTQtdcad = new JTextField();
			jTQtdcad.setDocument(new FixedLengthDocument(10));
			jTQtdcad.setBounds(new Rectangle(438, 137, 84, 20));
			
		}
		return jTQtdcad;
	}
	private JTextField getJTfretecad() {
		if (jTfretecad == null) {
			jTfretecad = new JTextField();
			jTfretecad.setDocument(new FixedLengthDocument(10));
			jTfretecad.setBounds(new Rectangle(630, 137, 75, 20));
			jTfretecad.setText("0");
		}
		return jTfretecad;
	}
	private JTextField getJTdesccad() {
		if (jTdesccad == null) {
			jTdesccad = new JTextField();
			jTdesccad.setDocument(new FixedLengthDocument(10));
			jTdesccad.setBounds(new Rectangle(700, 137, 75, 20));
			jTdesccad.setText("0");
		}
		return jTdesccad;
	}
	private JTextField getJTtransportadoracad() {
		if (jTtransportadoracad == null) {
			jTtransportadoracad = new JTextField();
			jTtransportadoracad.setDocument(new FixedLengthDocument(10));
			jTtransportadoracad.setBounds(new Rectangle(350, 166, 214, 20));
			
		}
		return jTtransportadoracad;
	}
	private JLabel getJTvalorPedidocad() {
		if (jTvalorPedidocad == null) {
			jTvalorPedidocad = new JLabel();
			jTvalorPedidocad.setBounds(new Rectangle(16, 427, 149, 20));
			jTvalorPedidocad.setFont(new Font("Ebrima", Font.BOLD, 14));
			//jTvalorPedidocad.setEditable(false);
		}
		return jTvalorPedidocad;
	}
	private JTextField getJTnotacad() {
		if (jTnotacad == null) {
			jTnotacad = new JTextField();
			jTnotacad.setBounds(new Rectangle(20, 88, 93, 20));
			jTnotacad.setEditable(false);
		}
		return jTnotacad;
	}
	public void nota(int todos){
		jTnotacad.setText(String.valueOf(todos));
	}
	private JTextField getJTDatacad() {
		if (jTDatacad == null) {
			jTDatacad = new JTextField();
			jTDatacad.setBounds(new Rectangle(160, 88, 115, 20));
			jTDatacad.setEditable(false);
		}
		return jTDatacad;
	}
	
	
	//JCombobox - cad
	
	private JComboBox getJCNomecad() {
		if (jTNomecad == null) {
			jTNomecad = new JComboBox();
			jTNomecad.setBounds(new Rectangle(106, 137, 320, 20));
		}
		return jTNomecad;
	}
	

	private JButton getJBaddcad() {
		if (jBadd == null) {
			jBadd = new JButton();
			jBadd.setBounds(new Rectangle(654, 200, 116, 25));
			jBadd.setText("Adicionar");
			jBadd.setFont(new Font("Ebrima", Font.BOLD, 12));
			jBadd.setForeground(new Color(0, 102, 51));
			jBadd.setVisible(false);
		}
		return jBadd;
	}
	private JButton getJBremcad() {
		if (jBremcad == null) {
			jBremcad = new JButton();
			jBremcad.setBounds(new Rectangle(654, 264, 116, 25));
			jBremcad.setText("Remover");
			jBremcad.setForeground(new Color(204, 0, 0));
			jBremcad.setFont(new Font("Ebrima", Font.BOLD, 12));
			jBremcad.setVisible(false);
		}
		return jBremcad;
	}
	private JButton getJBcad() {
		if (jBcad == null) {
			jBcad = new JButton();
			jBcad.setBounds(new Rectangle(236, 465, 154, 26));
			jBcad.setText("Registrar Pedido");
			jBcad.setFont(new Font("Ebrima", Font.BOLD, 13));
		}
		return jBcad;
	}
	private JButton getJBsaircad() {
		if (jBsaircad == null) {
			jBsaircad = new JButton();
			jBsaircad.setBounds(new Rectangle(428, 465, 154, 26));
			jBsaircad.setFont(new Font("Ebrima", Font.BOLD, 13));
			jBsaircad.setText("Sair");
		}
		return jBsaircad;
	}
	
	//JScrollpane - cad
	private JScrollPane getJScrollPanecad() {
		if (jPCadastrar == null) {
			jPCadastrar = new JScrollPane();
			jPCadastrar.setBounds(new Rectangle(20, 200, 610,90));
			jPCadastrar.setViewportView(getJTablecad());
		}
		return jPCadastrar;
	}
	

	//Jtable - cad
	private JTable getJTablecad() {
		if (jTablecad == null) {
			jTablecad = new JTable();
			jTablecad.setModel(new Pedidotable());
		}
		return jTablecad;
	}
	//alterar inicio
		private JInternalFrame getJIFalterar() {
			if (jIFAlterar == null) {
				jIFAlterar = new JInternalFrame();
				jIFAlterar.setTitle("Alterar");
				jIFAlterar.setContentPane(getJPAlterar());
			}
			return jIFAlterar;
		}
		private JPanel getJPAlterar() {
			if (jCPalterar == null) {
				codigo_vendaalt = new JLabel();
				codigo_vendaalt.setBounds(new Rectangle(494, 75, 75, 16));
				codigo_vendaalt.setText("");
				codigo_vendaalt.setFont(new Font("Ebrima", Font.BOLD, 13));
				codigo_vendaalt.setVisible(false);
				qtdestoquealt = new JLabel();
				qtdestoquealt.setBounds(new Rectangle(234, 166, 59, 16));
				qtdestoquealt.setText("");
				qtdestoquealt.setVisible(false);
				estoquealt = new JLabel();
				estoquealt.setBounds(new Rectangle(20, 166, 214, 16));
				estoquealt.setText("Quantidade disponivel no estoque:");
				estoquealt.setVisible(false);
				jLvlunitarioalt = new JLabel();
				jLvlunitarioalt.setBounds(new Rectangle(533, 121, 97, 16));
				jLvlunitarioalt.setText("Valor Unitário:");
				jLvlunitarioalt.setFont(new Font("Ebrima", Font.BOLD, 13));
				Transportadoraalt = new JLabel();
				Transportadoraalt.setBounds(new Rectangle(254, 166, 214, 16));
				Transportadoraalt.setText("Transportadora:");
				jLvlfretealt = new JLabel();
				jLvlfretealt.setBounds(new Rectangle(630, 121, 97, 16));
				jLvlfretealt.setFont(new Font("Ebrima", Font.BOLD, 13));
				jLvlfretealt.setText("Vlr Frete:");
				jLvldescontoalt = new JLabel();
				jLvldescontoalt.setBounds(new Rectangle(700, 121, 97, 16));
				jLvldescontoalt.setFont(new Font("Ebrima", Font.BOLD, 13));
				jLvldescontoalt.setText("Vlr Desc.:");
				jDataalt = new JLabel();
				jDataalt.setBounds(new Rectangle(160, 72, 64, 16));
				jDataalt.setFont(new Font("Ebrima", Font.BOLD, 13));
				jDataalt.setText("Data:");
				jnotaalt = new JLabel();
				jnotaalt.setBounds(new Rectangle(20, 72, 80, 16));
				jnotaalt.setFont(new Font("Ebrima", Font.BOLD, 13));
				jnotaalt.setText("Nota Fiscal");
				jVendaalt = new JLabel();
				jVendaalt.setBounds(new Rectangle(16, 409, 149, 16));
				jVendaalt.setFont(new Font("Ebrima", Font.BOLD, 13));
				jVendaalt.setText("Valor total da venda:");
				jQtdalt = new JLabel();
				jQtdalt.setBounds(new Rectangle(438, 121, 84, 16));
				jQtdalt.setFont(new Font("Ebrima", Font.BOLD, 13));
				jQtdalt.setText("Quantidade:");
				jcodalt = new JLabel();
				jcodalt.setBounds(new Rectangle(20, 121, 69, 16));
				jcodalt.setFont(new Font("Ebrima", Font.BOLD, 13));
				jcodalt.setText("Codigo:");
				jNomealt = new JLabel();
				jNomealt.setBounds(new Rectangle(106, 121, 320, 16));
				jNomealt.setFont(new Font("Ebrima", Font.BOLD, 13));
				jNomealt.setText("Produto:");
				jCPalterar = new JPanel();
				jCPalterar.setLayout(null);
				//label
				jCPalterar.add(jNomealt, null);
				jCPalterar.add(jcodalt, null);
				jCPalterar.add(jVendaalt, null);
				jCPalterar.add(jQtdalt, null);
				jCPalterar.add(jnotaalt, null);
				jCPalterar.add(jDataalt, null);
				jCPalterar.add(jLvlunitarioalt, null);
				jCPalterar.add(estoquealt, null);
				jCPalterar.add(qtdestoquealt, null);
				jCPalterar.add(codigo_vendaalt, null);
				jCPalterar.add(jLvldescontoalt, null);
				jCPalterar.add(jLvlfretealt, null);
				jCPalterar.add(Transportadoraalt, null);
				
				
				//textfield
				jCPalterar.add(getJTNomealt(), null);
				jCPalterar.add(getJTCodigoalt(), null);
				jCPalterar.add(getJTQtdalt(), null);
				jCPalterar.add(getJTvalorvendaalt(), null);
				jCPalterar.add(getJTnotaalt(), null);
				jCPalterar.add(getJTDataalt(), null);
				jCPalterar.add(getJTparcelasalt(), null);
				jCPalterar.add(getJTentradaalt(), null);
				jCPalterar.add(getJTfretealt(), null);
				jCPalterar.add(getJTdescalt(), null);		
				jCPalterar.add(getJTtransportadoraalt(), null);		

				//combobox
				
				//button
				jCPalterar.add(getJBaddalt(), null);
				jCPalterar.add(getJBremalt(), null);
				jCPalterar.add(getJBalt(), null);
				jCPalterar.add(getJBsairalt(), null);
				jCPalterar.add(getJTvlunitarioalt(), null);
				jCPalterar.add(getJBconsnota(), null);
				
				//scrollpane
				jCPalterar.add(getJScrollPanealt(), null);
			}
			return jCPalterar;
		}
		private JTable getJTablealt() {
			if (jTablealt == null) {
				jTablealt = new JTable();
				jTablealt.setModel(new Pedidotable());
			}
			return jTablealt;
		}
		private Pedidotable getModelalt() {
			if (vdtalt == null) {
				vdtalt = (Pedidotable) getJTablealt().getModel();
			}
			return vdtalt;
		}
		private JScrollPane getJScrollPanealt() {
			if (jPalterar == null) {
				jPalterar = new JScrollPane();
				jPalterar.setBounds(new Rectangle(20, 200, 610, 90));
				jPalterar.setViewportView(getJTablealt());
			}
			return jPalterar;
		}
		//textfield - alt
		private JTextField getJTCodigoalt() {
			if (jTCodigoalt == null) {
				jTCodigoalt = new JTextField();
				jTCodigoalt.setBounds(new Rectangle(20, 137, 69, 20));
				jTCodigoalt.setEditable(false);
			}
			return jTCodigoalt;
		}
		private JTextField getJTfretealt() {
			if (jTfretealt == null) {
				jTfretealt = new JTextField();
				jTfretealt.setDocument(new FixedLengthDocument(10));
				jTfretealt.setBounds(new Rectangle(630, 137, 55, 20));
				jTfretealt.setEditable(false);
			}
			return jTfretealt;
		}
		private JTextField getJTdescalt() {
			if (jTdescalt == null) {
				jTdescalt = new JTextField();
				jTdescalt.setDocument(new FixedLengthDocument(10));
				jTdescalt.setBounds(new Rectangle(700, 137, 55, 20));
				jTdescalt.setEditable(false);
			}
			return jTdescalt;
		}
		private JTextField getJTtransportadoraalt() {
			if (jTtransportadoraalt == null) {
				jTtransportadoraalt = new JTextField();
				jTtransportadoraalt.setDocument(new FixedLengthDocument(10));
				jTtransportadoraalt.setBounds(new Rectangle(350, 166, 214, 20));
				jTtransportadoraalt.setEditable(false);
				
			}
			return jTtransportadoraalt;
		}
		private JTextField getJTQtdalt() {
			if (jTQtdalt == null) {
				jTQtdalt = new JTextField();
				jTQtdalt.setBounds(new Rectangle(438, 137, 84, 20));
				jTQtdalt.setEditable(false);
			}
			return jTQtdalt;
		}
		private JLabel getJTvalorvendaalt() {
			if (jTvalorvendaalt == null) {
				jTvalorvendaalt = new JLabel();
				jTvalorvendaalt.setBounds(new Rectangle(16, 427, 149, 20));
				jTvalorvendaalt.setForeground(new Color(204, 0, 0));
				jTvalorvendaalt.setFont(new Font("Ebrima", Font.BOLD, 14));
			}
			return jTvalorvendaalt;
		}
		private JTextField getJTnotaalt() {
			if (jTnotaalt == null) {
				jTnotaalt = new JTextField();
				jTnotaalt.setBounds(new Rectangle(20, 88, 93, 20));
			}
			return jTnotaalt;
		}
		private JTextField getJTDataalt() {
			if (jTDataalt == null) {
				jTDataalt = new JTextField();
				jTDataalt.setBounds(new Rectangle(160, 88, 115, 20));
				jTDataalt.setEditable(false);
			}
			return jTDataalt;
		}
		private JTextField getJTvlunitarioalt() {
			if (jTvlunitarioalt == null) {
				jTvlunitarioalt = new JTextField();
				jTvlunitarioalt.setBounds(new Rectangle(532, 137, 98, 20));
				jTvlunitarioalt.setEditable(false);
			}
			return jTvlunitarioalt;
		}
		private JTextField getJTentradaalt() {
			if (jTentradaalt == null) {
				jTentradaalt = new JTextField();
				jTentradaalt.setBounds(new Rectangle(378, 408, 68, 20));
				jTentradaalt.setDocument(new FixedLengthDocument(10));
				jTentradaalt.setVisible(false);
				jTentradaalt.setText("0");
			}
			return jTentradaalt;
		}
		
		//button - alt
		private JButton getJBalt() {
			if (jBalt == null) {
				jBalt = new JButton();
				jBalt.setBounds(new Rectangle(236, 465, 154, 26));
				jBalt.setForeground(new Color(0, 102, 51));
				jBalt.setFont(new Font("Ebrima", Font.BOLD, 13));
				jBalt.setText("Alterar");
				jBalt.setEnabled(false);
			}
			return jBalt;
		}
		private JButton getJBsairalt() {
			if (jBsairalt == null) {
				jBsairalt = new JButton();
				jBsairalt.setBounds(new Rectangle(428, 465, 154, 26));
				jBsairalt.setFont(new Font("Ebrima", Font.BOLD, 13));
				jBsairalt.setText("Sair");
			}
			return jBsairalt;
		}
		private JButton getJBaddalt() {
			if (jBaddalt == null) {
				jBaddalt = new JButton();
				jBaddalt.setBounds(new Rectangle(654, 200, 116, 25));
				jBaddalt.setFont(new Font("Ebrima", Font.BOLD, 12));
				jBaddalt.setForeground(new Color(0, 102, 51));
				jBaddalt.setText("Adicionar Item");
				jBaddalt.setEnabled(false);
			}
			return jBaddalt;
		}
		private JButton getJBremalt() {
			if (jBremalt == null) {
				jBremalt = new JButton();
				jBremalt.setBounds(new Rectangle(654, 264, 116, 25));
				jBremalt.setForeground(new Color(204, 0, 0));
				jBremalt.setFont(new Font("Ebrima", Font.BOLD, 12));
				jBremalt.setText("Remover Item");
				jBremalt.setEnabled(false);
			}
			return jBremalt;
		}
		private JButton getJBconsnota() {
			if (jBconsnota == null) {
				jBconsnota = new JButton();
				jBconsnota.setBounds(new Rectangle(669, 88, 89, 26));
				jBconsnota.setText("Consultar");
			}
			return jBconsnota;
		}
		
		//combobox - alt
		private JComboBox getJTNomealt() {
			if (jTNomealt == null) {
				jTNomealt = new JComboBox();
				jTNomealt.setBounds(new Rectangle(106, 137, 320, 20));
				jTNomealt.setEditable(false);
			}
			return jTNomealt;
		}
		public JComboBox getJTparcelasalt() {
			if (jTparcelasalt == null) {
				jTparcelasalt = new JComboBox();
				jTparcelasalt.setBounds(new Rectangle(298, 372, 171, 25));
				jTparcelasalt.setVisible(false);
			}
			return jTparcelasalt;
		}
		
		// consultar
		private JInternalFrame getJIConsultar() {
			if (jIFconsultar == null) {
				jIFconsultar = new JInternalFrame();
				jIFconsultar.setTitle("Consultar");
				jIFconsultar.setContentPane(getJPconsultar());
			}
			return jIFconsultar;
		}
		private JPanel getJPconsultar() {
			if (jCconsultar == null) {
				jDatacon = new JLabel();
				jDatacon.setBounds(new Rectangle(160, 72, 64, 16));
				jDatacon.setFont(new Font("Ebrima", Font.BOLD, 13));
				jDatacon.setText("Data:");
				jnotacon = new JLabel();
				jnotacon.setBounds(new Rectangle(20, 72, 80, 16));
				jnotacon.setFont(new Font("Ebrima", Font.BOLD, 13));
				jnotacon.setText("Nota Fiscal:");
				jVendacon = new JLabel();
				jVendacon.setBounds(new Rectangle(16, 409, 149, 16));
				jVendacon.setFont(new Font("Ebrima", Font.BOLD, 13));
				jVendacon.setText("Valor total da venda:");
				jTvalorvendacon = new JLabel();
				jTvalorvendacon.setBounds(new Rectangle(16, 427, 149, 20));
				jTvalorvendacon.setForeground(new Color(204, 0, 0));
				jTvalorvendacon.setFont(new Font("Ebrima", Font.BOLD, 14));
				jCconsultar = new JPanel();
				jCconsultar.setLayout(null);
				Transportadoracon = new JLabel();
				Transportadoracon.setBounds(new Rectangle(254, 166, 214, 16));
				Transportadoracon.setText("Transportadora:");
				jLvlfretecon = new JLabel();
				jLvlfretecon.setBounds(new Rectangle(630, 121, 97, 16));
				jLvlfretecon.setFont(new Font("Ebrima", Font.BOLD, 13));
				jLvlfretecon.setText("Vlr Frete:");
				jLvldescontocon = new JLabel();
				jLvldescontocon.setBounds(new Rectangle(700, 121, 97, 16));
				jLvldescontocon.setFont(new Font("Ebrima", Font.BOLD, 13));
				jLvldescontocon.setText("Vlr Desc.:");
				jTfretecon = new JLabel();
				jTfretecon.setBounds(new Rectangle(630, 137, 75, 20));
				jTdesccon = new JLabel();
				jTdesccon.setBounds(new Rectangle(700, 137, 75, 20));
				jTtransportadoracon = new JLabel();
				jTtransportadoracon.setBounds(new Rectangle(350, 166, 214, 20));
				
				
				//label
				jCconsultar.add(jnotacon, null);
				jCconsultar.add(jDatacon, null);
				jCconsultar.add(jTvalorvendacon, null);
				jCconsultar.add(jLvldescontocon, null);
				jCconsultar.add(jLvlfretecon, null);
				jCconsultar.add(jVendacon, null);
				jCconsultar.add(jTdesccon, null);
				jCconsultar.add(jTfretecon, null);
				
				
				//textfield
				jCconsultar.add(getjTnota(), null);
				jCconsultar.add(getJTDatacon(), null);
				//button
				jCconsultar.add(getJBsaircon(), null);
				jCconsultar.add(getJBexcluir(), null);
				//scrollpane
				jCconsultar.add(getJScrollPanecon(), null);
				jCconsultar.add(getJBconsultar(), null);
					
			}
			return jCconsultar;
		}
		private JScrollPane getJScrollPanecon() {
			if (jPconsultar == null) {
				jPconsultar = new JScrollPane();
				jPconsultar.setBounds(new Rectangle(20, 200, 610, 90));
				jPconsultar.setViewportView(getJTablecon());
			}
			return jPconsultar;
		}
		private JButton getJBconsultar() {
			if (jBconsultar == null) {
				jBconsultar = new JButton();
				jBconsultar.setBounds(new Rectangle(296, 86, 89, 26));
				jBconsultar.setText("Consultar");
			}
			return jBconsultar;
		}
		private JTable getJTablecon() {
			if (jTablecon == null) {
				jTablecon = new JTable();
				jTablecon.setModel(new Pedidotable());
				jTablecon.setEnabled(false);
			}
			return jTablecon;
		}
		//textfield - con
		private JTextField getjTnota() {
			if (jTnotacon == null) {
				jTnotacon = new JTextField();
				jTnotacon.setBounds(new Rectangle(20, 88, 93, 20));
			}
			return jTnotacon;
		}
		private JTextField getJTDatacon() {
			if (jTDatacon == null) {
				jTDatacon = new JTextField();
				jTDatacon.setBounds(new Rectangle(160, 88, 115, 20));
				jTDatacon.setEditable(false);
			}
			return jTDatacon;
		}
		//button - con
		private JButton getJBsaircon() {
			if (jBsaircon == null) {
				jBsaircon = new JButton();
				jBsaircon.setBounds(new Rectangle(428, 465, 154, 26));
				jBsaircon.setFont(new Font("Ebrima", Font.BOLD, 13));
				jBsaircon.setText("Sair");

			}
			return jBsaircon;
		}
		private JButton getJBexcluir() {
			if (jBexcluir == null) {
				jBexcluir = new JButton();
				jBexcluir.setBounds(new Rectangle(236, 465, 154, 26));
				jBexcluir.setForeground(new Color(0, 102, 51));
				jBexcluir.setFont(new Font("Ebrima", Font.BOLD, 13));
				jBexcluir.setText("Excluir");
			}
			return jBexcluir;
		}
		
		//combobox - con
		private JComboBox getJComboBoxcon() {
			if (jCpgcon == null) {
				jCpgcon = new JComboBox();
				jCpgcon.setBounds(new Rectangle(16, 338, 152, 25));
				jCpgcon.setEnabled(false);
			}
			return jCpgcon;
		}
		private JComboBox getJCclientecon() {
			if (jCclientecon == null) {
				jCclientecon = new JComboBox();
				jCclientecon.setBounds(new Rectangle(20, 35, 553, 25));
				jCclientecon.setEnabled(false);
			}
			return jCclientecon;
		}
		
	
	// metodos
	public void mostrarmsg(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	public void fecharTela() {
		this.dispose();
	}
	public void escuta(ActionListener l) {
		if (jBcad != null) {jBcad.addActionListener(l);	} else {LogManager.WriteDefaultLog("TelaPedido: jBcad is null");}
		if (jBsaircad != null) {jBsaircad.addActionListener(l);	} else {LogManager.WriteDefaultLog("TelaPedido: jBsair is null");}
		if (jBadd != null) {jBadd.addActionListener(l);	} else {LogManager.WriteDefaultLog("TelaPedido: jBadd is null");}
		if (jBremcad != null) {	jBremcad.addActionListener(l);} else {LogManager.WriteDefaultLog("TelaPedido: jBremcad is null");}
		if (jBconsnota != null) {	jBconsnota.addActionListener(l);} else {LogManager.WriteDefaultLog("TelaPedido: jBconsnota is null");}
		if (jBsairalt != null) {	jBsairalt.addActionListener(l);} else {LogManager.WriteDefaultLog("TelaPedido: jBsairalt is null");}
		if (jBconsultar != null) {	jBconsultar.addActionListener(l);} else {LogManager.WriteDefaultLog("TelaPedido: jBconsultar is null");}
		if (jBsaircon != null) {	jBsaircon.addActionListener(l);} else {LogManager.WriteDefaultLog("TelaPedido: jBsaircon is null");}
		if (jBaddalt != null) {jBaddalt.addActionListener(l);	} else {LogManager.WriteDefaultLog("TelaPedido: jBaddalt is null");}
		if (jBremalt != null) {	jBremalt.addActionListener(l);} else {LogManager.WriteDefaultLog("TelaPedido: jBremalt is null");}
		if (jBalt != null) {	jBalt.addActionListener(l);} else {LogManager.WriteDefaultLog("TelaPedido: jBalt is null");}
		if (jBexcluir != null) {	jBexcluir.addActionListener(l);} else {LogManager.WriteDefaultLog("TelaPedido: jBexcluir is null");}

			
	}
	public void escutaitem(ItemListener l) {
		jTNomecad.addItemListener(l);
		jTNomealt.addItemListener(l);
	}
	public void ValidaNumero(JTextField Numero) {
		if (Numero.getText().length() != 0){
		try {
		}catch(NumberFormatException ex){
		mostrarmsg("Esse Campo só aceita números");
		return;
		}
		}
		} 	
	public void DataPc(int dia,int mes,int ano)
	{
		mes = mes +1;
		jTDatacad.setText(String.valueOf(dia+"/"+mes+"/"+ano));
	}
	public void gerente() {
		setContentPane(getJTabbedPane2());
	}
	public void funcionario() {

		setContentPane(getJIFcadastrar());
	}
	public void limpar() {
		jTCodigocad.setText("");
		jTNomecad.setSelectedIndex(0);
		//jTCustocad.setText("");
		//jTfornecedorcad.setText("");
		jTvalorPedidocad.setText("");
		jTQtdcad.setText("");
		jTvlunitariocad.setText("");
		estoque.setText("");
		jTQtdcad.setText("");
		qtdestoque.setVisible(false);
		jBcad.setVisible(false);
	}
	public void limparTabela(){
		vdtcad.clear();
	}
	public void limparTabelaalt(){
		vdtalt.clear();
	}

	
//	 get - set
	
	//set cadastrar
	public void setNota(String Nota) {
		jTnotacad.setText(Nota);
	}
	public void setCodigo(int codigo) {
		jTCodigocad.setText(String.valueOf(codigo));
	}
	public void setNome(String Nome) {
		jTNomecad.setSelectedItem(Nome);
	}
	public void setNomealt(String Nome) {
		jTNomealt.setSelectedItem(Nome);
	}
	public void setQtd(String Qtd) {
		jTQtdcad.setText(Qtd);
	}
	public void setQtdestoque(String Qtd) {
		qtdestoque.setText(Qtd);
	}
	public void setData(String data) {
		jTDatacad.setText(data);
	}
	public void setPedido(String Pedido) {
		jTvalorPedidocad.setText(Pedido);
	}
	public void addSociocad() {
		getModelcad().adiciona(getSocio());
	}
	public void setCodigoalt(int codigo) {
		jTCodigoalt.setText(String.valueOf(codigo));
	}
	public void setQtdalt(String Qtd) {
		jTQtdalt.setText(Qtd);
	}
	public void setQtdestoquealt(String Qtd) {
		qtdestoquealt.setText(Qtd);
	}
	public void setPedidoalt(String Pedido) {
		jTvalorPedidocad.setText(Pedido);
	}
	public void removesociocad() {
		int linha = jTablecad.getSelectedRow();
		vdtcad = (Pedidotable) jTablecad.getModel();
		vdtcad.removeSocio(linha);
	}
	public void RecalcularTotal(String value) {
		jTvalorPedidocad.setText(value);
	}
	public void RecalcularTotal() {
		int nRow = jTablecad.getRowCount();
		float nTotal = 0;
		float nTot;
		for (int i = 0; i < nRow; i++) {
			nTot = Float.valueOf(this.jTablecad.getValueAt(i, 4).toString());

			nTotal += nTot;
		}
		nTotal = nTotal + getfrete()-getdesc();
		jTvalorPedidocad.setText(String.valueOf(deci.format(nTotal)).replace(",", "."));
	}
	public void setvlrunit(String vlr)
	{
		jTvlunitariocad.setText(vlr);
	}
	public void setvlrunitalt(String vlr)
	{
		jTvlunitarioalt.setText(vlr);
	}
	public void RemoverLinhaTabela()
	{
		int linha=jTablecad.getSelectedRow();
		if(linha==-1){
			mostrarmsg("Selecione o produto a ser removido.");
			return;
		}
		Pedidotable DTM = (Pedidotable) jTablecad.getModel();
		DTM.removeSocio(linha);
	}
	
	//get cadastrar
	public Integer getCodigo() {
		return Integer.parseInt(jTCodigocad.getText());
	}
	public String getTransportadora() {
		return jTtransportadoracad.getText();
	}
	public String getQtd() {
		return jTQtdcad.getText();
	}
	public String getNota() {
		return jTnotacad.getText();
	}
	public Object getNome() {
		return jTNomecad.getSelectedItem();
	}
	
	
	public String getData() {
		return jTDatacad.getText();
	}
	public String getCodigo_prod() {
		return jTCodigocad.getText();
	}
	private Pedidotable getModelcad() {
		if (vdtcad == null) {
				vdtcad = (Pedidotable) getJTablecad().getModel();
			}
			return vdtcad;
		}
	private Item getSocio() {
			Item socio = new Item();
			Produto produto = new Produto();
			produto.setCod_produto(getCodigoSetcad());
			produto.setNome(String.valueOf(getNomeSet()));
			socio.setValor_unit(getvlrunitSet());
			socio.setValor_total(getvlrtotalSet());
			socio.setProduto(produto);
			socio.setQtd(getQuantidadeSet());
			return socio;
		}
	public Float getValor() {
			Float vlr = Float.valueOf(jTvlunitariocad.getText());
			return vlr;
		}
	
	public int getCodigoSetcad() {
		return Integer.parseInt(jTCodigocad.getText());
	}
	public int getQuantidadeSet() {
		return Integer.parseInt(jTQtdcad.getText());
	}
	public float getvlrunitSet() {
		return Float.parseFloat(jTvlunitariocad.getText());
	}
	public float getvlrtotalSet() {
		float a = Float.valueOf(jTvlunitariocad.getText());
		float b = Float.valueOf(jTQtdcad.getText());
		float c = a * b;
		return c;
	}
	public float getTotal() {
		return Float.parseFloat(jTvalorPedidocad.getText());
	}
	public float getfrete() {
		return Float.parseFloat(jTfretecad.getText());
	}
	public float getdesc() {
		return Float.parseFloat(jTdesccad.getText());
	}
	public Object getNomeSet() {
		return jTNomecad.getSelectedItem();
	}
	public Object getTotalSet() {
		float value = 0;
		if (!(jTvalorPedidocad.getText().equals(""))) {
			value = Float.parseFloat(jTvalorPedidocad.getText());
		}
		float uni = Integer.parseInt(jTvlunitariocad.getText());
		float qtd = Integer.parseInt(jTQtdcad.getText());
		float total = uni * qtd;
		return total + value;
	}
	public Object getTotalSetmenos() {
		float value = 0;
		if (!(jTvalorPedidocad.getText().equals(""))) {
			value = Float.parseFloat(jTvalorPedidocad.getText());
		}
		float uni = Integer.parseInt(jTvlunitariocad.getText());
		float qtd = Integer.parseInt(jTQtdcad.getText());
		float total = uni * qtd;
		return total - value;
	}
	

	
	// preenchw
	
	public void preenchenomeprodutocad(ArrayList tipos) {
		Produto p = new Produto();
		p.setNome("Selecione");
		jTNomecad.addItem(p);
		jTNomealt.addItem(p);
		for (int i = 0; i < tipos.size(); i++) {
			jTNomecad.addItem(tipos.get(i));
			jTNomealt.addItem(tipos.get(i));
		}
		if (this.update != null) {
			this.update.Update();
		}
	}
	//get con
		public String getNotacon()  
		{  
		   return jTnotacon.getText(); 
		}  
		
		//set con
		public void setVendacon(String Venda) {
			jTvalorvendacon.setText(Venda);
		}
		public void removesociocon() {
			int linha = jTablecon.getSelectedRow();
			vdtcon = (Pedidotable) jTablecon.getModel();
			vdtcon.removeSocio(linha);
		}
		public void setVendedorcon(Object vendedor) {
			Vendedorcon.setText("Vendedor: " + String.valueOf(vendedor));
		}
		public void setpagamentocon(Object pagamento) {
			jCpgcon.setSelectedItem(pagamento);
		}
		public void setclientecon(Object cliente) {
			jCclientecon.setSelectedItem(cliente);
		}
		public void setNotacon(String nota)
		{
			jTnotacon.setText(nota);
		}
		public void setFretecon(String nota)
		{
			jTfretecon.setText(nota);
		}
		public void setDescontocon(String nota)
		{
			jTdesccon.setText(nota);
		}
		public void setDatacon(String data)
		{
			jTDatacon.setText(data);
		}
		public void setItemscon(Set<Item> it){
			Pedidotable dtm = (Pedidotable) jTablecon.getModel();
				dtm.addRow(it);
		}
		//get alterar
		public String getQtdalt() {
			return jTQtdalt.getText();
		}
		public Integer getCodigoalt() {
			return Integer.parseInt(jTCodigoalt.getText());
		}
		public Float getValoralt() {
			Float vlr = Float.valueOf(jTvlunitarioalt.getText());
			return vlr;
		}
		public Integer getcodigo_vendaalt(){
			return Integer.parseInt(codigo_vendaalt.getText());
		}
		public String getNotaalt() {
			return jTnotaalt.getText();
		}
		public Object getNomealt() {
			return jTNomealt.getSelectedItem();
		}
		public String getDataalt() {
			return jTDataalt.getText();
		}
		private Item getSocioalt() {
			Item socio = new Item();
			Produto produto = new Produto();
			produto.setCod_produto(getCodigoSetalt());
			produto.setNome(String.valueOf(getNomealt()));
			socio.setValor_unit(getvlrunitSetalt());
			socio.setValor_total(getvlrtotalSetalt());
			produto.setQtd_disponivel(getQuantidadeSetalt());
			socio.setProduto(produto);
			socio.setQtd(getQuantidadeSetalt());
			return socio;
		}
		public void addSocioalt() {
			getModelalt().adiciona(getSocioalt());
		}
		public void removesocioalt() {
			int linha = jTablealt.getSelectedRow();
			vdtalt = (Pedidotable) jTablealt.getModel();
			vdtalt.removeSocio(linha);
		}
		public void RecalcularTotalalt() {
			int nRow = jTablealt.getRowCount();
			int nTotal = 0;
			float nTot;
			for (int i = 0; i < nRow; i++) {
				nTot = Float.valueOf(this.jTablealt.getValueAt(i, 4).toString());

				nTotal += nTot;
			}
			jTvalorvendaalt.setText(String.valueOf(deci.format(nTotal)).replace(",", "."));
		}
		public int getCodigoSetalt() {
			return Integer.parseInt(jTCodigoalt.getText());
		}
		public int getQuantidadeSetalt() {
			return Integer.parseInt(jTQtdalt.getText());
		}
		public float getTotalalt() {
			return Float.parseFloat(jTvalorvendaalt.getText());
		}
		public float getvlrunitSetalt() {
			return Float.parseFloat(jTvlunitarioalt.getText());
		}
		public float getvlrtotalSetalt() {
			float a = Float.valueOf(jTvlunitarioalt.getText());
			float b = Float.valueOf(jTQtdalt.getText());
			float c = a * b;
			return c;
		}
		public void RemoverLinhaTabelaalt()
		{
			int linha=jTablealt.getSelectedRow();
			Pedidotable DTM = (Pedidotable) jTablealt.getModel();
			DTM.removeSocio(linha);
		}
		public void setDataalt(String data) {
			jTDataalt.setText(data);
		}
		public void setVendaalt(String valor) {
			jTvalorvendaalt.setText(valor);
		}
		public void setItemsalt(Set<Item> it){
			Pedidotable dtm = (Pedidotable) jTablealt.getModel();
				dtm.addRow(it);
		}
}  //  @jve:decl-index=0:visual-constraint="8,26"
