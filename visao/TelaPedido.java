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
			estoque.setBackground(new Color(0, 102, 51));
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
			jTvalorPedidocad.setForeground(new Color(204, 0, 0));
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
			jBcad.setForeground(new Color(0, 102, 51));
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
			
	}
	public void escutaitem(ItemListener l) {
		jTNomecad.addItemListener(l);
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
		for (int i = 0; i < tipos.size(); i++) {
			jTNomecad.addItem(tipos.get(i));
		}
		if (this.update != null) {
			this.update.Update();
		}
	}
	
	
}  //  @jve:decl-index=0:visual-constraint="8,26"
