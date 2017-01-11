package visao;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;
import javax.swing.JTextField;
import javax.swing.JButton;

import DAO.DAOProduto;
import modelo.Fornecedor;
import modelo.Produto;
import javax.swing.JComboBox;
import java.awt.event.KeyEvent;
import javax.swing.JTabbedPane;

import utilitariosSO.FixedLengthDocument;
import utilitariosSO.IUpdate;
import utilitariosSO.LogManager;
import java.awt.Point;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class TelaProduto extends JInternalFrame {
	//tela
	private static final long serialVersionUID = 1L;//  @jve:decl-index=0:visual-constraint="64,59"
	public JTabbedPane jTabbedPane;
	private IUpdate update;
	//cadastrar
	public JButton jBcad = null;
	private JButton jBsair1 = null;
	private DefaultTableModel dtm;
	private JInternalFrame jInternalFrame = null;
	public JPanel jContentPane1 = null;
	private JLabel jCod1 = null;
	private JLabel jcod1 = null;
	private JLabel jPreco1 = null;
	private JLabel jQtd1 = null;
	private JLabel jFornecedor1 = null;
	private JLabel jdescri1 = null;
	private JLabel ultimoCodCriado1;
	public JTextField jTnome1 = null;
	private JTextField jTPreco1 = null;
	private JTextField jTQtd1 = null;
	public JComboBox jCforn1 = null;
	public JTextField jTdesc1 = null;
	private JButton jButton1 = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	public JTable jTableprod = null;
	private DefaultTableModel dtmprod;
	//alterar
		private JInternalFrame jInternalFrame2 = null;
		public JPanel jContentPane111 = null;
		private JLabel jCod2 = null;
		private JLabel jcod2 = null;
		private JLabel jPreco2 = null;
		private JLabel jQtd2 = null;
		private JLabel jFornecedor2 = null;
		private JLabel jDescricao2 = null;
		public JTextField jTnome2 = null;
		public JTextField jTPreco2 = null;
		public JTextField jTQtd2 = null;
		public JTextField jTdesc2 = null;
		public JComboBox jCforn2 = null;
		public JTextField jTCod2 = null;
		private JButton jBAlt2 = null;
		private JButton jBCon2 = null;
		private JButton jBsair2 = null;
//		consultar
		private JInternalFrame jInternalFrame1 = null;
		private JPanel jContentPane11 = null;
		private JLabel jCod12 = null;
		private JLabel jcod12 = null;
		private JLabel jCusto12 = null;
		private JLabel jQtd12 = null;
		private JLabel jFornecedor12 = null;
		private JLabel jdescr12 = null;
		private JLabel jTnome12 = null;
		private JLabel jTPreco12 = null;
		private JLabel jTQtd12 = null;
		private JComboBox jCforn12 = null;
		private JLabel jTdesc12 = null;
		private JButton jBsair11 = null;
		private JButton jBexcluir2 = null;
		private JLabel jTCod121 = null;
		private JButton jButton = null;
		private JScrollPane jScrollPaneprod = null;	//tela
	public TelaProduto() {
		super("",false, true, false);
		initialize();
	}
	public void initialize() {
		this.setSize(560, 401);
		this.setLocation(new Point(0, 0));
		this.setTitle("Produto");
		this.setVisible(true);
		setContentPane(getJTabbedPane2());
	}
	private JTabbedPane getJTabbedPane2() {
		jTabbedPane = null;
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.setName("Cadastrar");
			jTabbedPane.setTabPlacement(JTabbedPane.TOP);
			jTabbedPane.addTab("Cadastrar", null, getJIcadastrar(), null);
			jTabbedPane.addTab("Alterar", null, getJIalterar(), null);
			jTabbedPane.addTab("Consultar e Excluir", null, getJIconsultar(), null);

		}
		return jTabbedPane;
	}
 	@SuppressWarnings("unchecked")
	public HashSet getProdutos(ArrayList<Produto> lista){
		HashSet hs = new HashSet();
		dtm = (DefaultTableModel)jTable.getModel();
		Vector v = new Vector();
		v.add("Codigo");
		v.add("Nome");
		dtm.setColumnIdentifiers(v); 
		for (int i = 0;i < lista.size(); i++) {   
            Vector linha = new Vector();    
            linha.add(lista.get(i).getCod_produto());
            linha.add(lista.get(i).getNome());
            dtm.addRow(linha);   
   }   

		for(int i=0; i<dtm.getRowCount();i++)
			for(int j=0; j<2;j++){
				hs.add(dtm.getValueAt(i, j));
			}
			
		return hs;
	}
	@SuppressWarnings("unchecked")
	public HashSet getProdutosprod(ArrayList<Produto> lista){
		HashSet hs = new HashSet();
		dtmprod = (DefaultTableModel)jTableprod.getModel();
		Vector v = new Vector();
		v.add("Codigo");
		v.add("Nome");
		dtmprod.setColumnIdentifiers(v); 
		for (int i = 0;i < lista.size(); i++) {   
            Vector linha = new Vector();    
            linha.add(lista.get(i).getCod_produto());
            linha.add(lista.get(i).getNome());
            dtmprod.addRow(linha);   
   }   

		for(int i=0; i<dtmprod.getRowCount();i++)
			for(int j=0; j<2;j++){
				hs.add(dtmprod.getValueAt(i, j));
			}
			
		return hs;
	}

//cadastrar
	public JInternalFrame getJIcadastrar() {
		if (jInternalFrame == null) {
			jInternalFrame = new JInternalFrame();
			jInternalFrame.setTitle("Cadastrar");
			jInternalFrame.setContentPane(getJContentPane1());
		}
		return jInternalFrame;
	}
	public JPanel getJContentPane1() {
		if (jContentPane1 == null) {
			ultimoCodCriado1 = new JLabel();
			ultimoCodCriado1.setBounds(new Rectangle(149, 14, 19, 16));
			ultimoCodCriado1.setText("1");
			jdescri1 = new JLabel();
			jdescri1.setBounds(new Rectangle(74, 183, 65, 16));
			jdescri1.setText("Descricao");
			jFornecedor1 = new JLabel();
			jFornecedor1.setBounds(new Rectangle(74, 150, 65, 16));
			jFornecedor1.setText("Fornecedor");
			jQtd1 = new JLabel();
			jQtd1.setBounds(new Rectangle(74, 117, 65, 16));
			jQtd1.setText("Quantidade");
			jQtd1.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jPreco1 = new JLabel();
			jPreco1.setBounds(new Rectangle(106, 84, 87, 16));
			jPreco1.setText("Preco");
			jcod1 = new JLabel();
			jcod1.setBounds(new Rectangle(106, 51, 33, 16));
			jcod1.setText("Nome");
			jCod1 = new JLabel();
			jCod1.setBounds(new Rectangle(100, 18, 39, 16));
			jCod1.setText("Codigo");
			jContentPane1 = new JPanel();
			jContentPane1.setLayout(null);
			jContentPane1.add(jCod1, null);
			jContentPane1.add(jcod1, null);
			jContentPane1.add(jPreco1, null);
			jContentPane1.add(jQtd1, null);
			jContentPane1.add(jFornecedor1, null);
			jContentPane1.add(jdescri1, null);
			jContentPane1.add(ultimoCodCriado1, null);
			jContentPane1.add(getJTnome1(), null);
			jContentPane1.add(getJTPreco1(), null);
			jContentPane1.add(getJTQtd1(), null);
			jContentPane1.add(getJCforn1(), null);
			jContentPane1.add(getJTdesc1(), null);
			jContentPane1.add(getJBcad(), null);
			jContentPane1.add(getJBsair1(), null);
			jContentPane1.add(getJTable(), null);
			jContentPane1.add(getJTableprod(), null);
			jContentPane1.add(getJButton1(), null);
			jContentPane1.add(getJScrollPane(), null);

		}
		return jContentPane1;
	}
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(212, 241, 178, 26));
			jButton1.setText("ADICIONAR FORNECEDOR");
		}
		return jButton1;
	}
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(394, -1, 135, 305));
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}
	private JTextField getJTnome1() {
		if (jTnome1 == null) {
			jTnome1 = new JTextField();
			jTnome1.setBounds(new Rectangle(150, 45, 159, 20));
			jTnome1.setDocument(new FixedLengthDocument(10));
		}
		return jTnome1;
	}
	private JTextField getJTPreco1() {
		if (jTPreco1 == null) {
			jTPreco1 = new JTextField();
			jTPreco1.setBounds(new Rectangle(150, 77, 159, 20));
		}
		return jTPreco1;
	}
	private JTextField getJTQtd1() {
		if (jTQtd1 == null) {
			jTQtd1 = new JTextField();
			jTQtd1.setBounds(new Rectangle(150, 109, 159, 20));
		}
		return jTQtd1;
	}
	private JComboBox getJCforn1() {
		if (jCforn1 == null) {
			jCforn1 = new JComboBox();
			jCforn1.setBounds(new Rectangle(150, 141, 180, 25));
		}
		return jCforn1;
	}
	public JTextField getJTdesc1() {
		if (jTdesc1 == null) {
			jTdesc1 = new JTextField();
			jTdesc1.setBounds(new Rectangle(150, 178, 180, 25));
		}
		return jTdesc1;
	}
	private JButton getJBcad() {
		if (jBcad == null) {
			jBcad = new JButton();
			jBcad.setText("Cadastrar");
			jBcad.setBounds(new Rectangle(149, 209, 91, 26));
		}
		return jBcad;
	}
	private JButton getJBsair1() {
		if (jBsair1 == null) {
			jBsair1 = new JButton();
			jBsair1.setBounds(new Rectangle(272, 209, 57, 26));
			jBsair1.setText("Sair");
		}
		return jBsair1;
	}
	
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable();
		}
		return jTable;
	}
	
	public String getCodigo()  
	{  
		int lin=jTableprod.getSelectedRow();    
	   return jTableprod.getModel().getValueAt(lin,0).toString();       
	}  
	private JTable getJTableprod() {
		if (jTableprod == null) {
			jTableprod = new JTable();
		}
		return jTableprod;
	}
	
	
	
//alterar
	private JInternalFrame getJIalterar() {
		if (jInternalFrame2 == null) {
			jInternalFrame2 = new JInternalFrame();
			jInternalFrame2.setTitle("Alterar");
			jInternalFrame2.setContentPane(getJContentPane111());
		}
		return jInternalFrame2;
	}
	private JPanel getJContentPane111() {
		if (jContentPane111 == null) {
			jFornecedor2 = new JLabel();
			jFornecedor2.setBounds(new Rectangle(12, 149, 65, 16));
			jFornecedor2.setText("Fornecedor");
			jQtd2 = new JLabel();
			jQtd2.setBounds(new Rectangle(12, 116, 65, 16));
			jQtd2.setText("Quantidade");
			jQtd2.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jPreco2 = new JLabel();
			jPreco2.setBounds(new Rectangle(35, 83, 40, 16));
			jPreco2.setText("Preco");
			jcod2 = new JLabel();
			jcod2.setBounds(new Rectangle(44, 50, 33, 16));
			jcod2.setText("Nome");
			jCod2 = new JLabel();
			jCod2.setBounds(new Rectangle(38, 17, 39, 16));
			jCod2.setText("Codigo");
			jDescricao2 = new JLabel();
			jDescricao2.setBounds(new Rectangle(12, 182, 65, 16));
			jDescricao2.setText("Descricao");
			jContentPane111 = new JPanel();
			jContentPane111.setLayout(null);
			jContentPane111.add(jCod2, null);
			jContentPane111.add(jcod2, null);
			jContentPane111.add(jPreco2, null);
			jContentPane111.add(jQtd2, null);
			jContentPane111.add(jFornecedor2, null);
			jContentPane111.add(jDescricao2, null);
			jContentPane111.add(getJTnome2(), null);
			jContentPane111.add(getJTPreco2(), null);
			jContentPane111.add(getJTQtd2(), null);
			jContentPane111.add(getJCforn2(), null);
			jContentPane111.add(getJTCod2(), null);
			jContentPane111.add(getJBAlt2(), null);
			jContentPane111.add(getJBCon2(), null);
			jContentPane111.add(getJBsair2(), null);
			jContentPane111.add(getJCdesc2(), null);
		}
		return jContentPane111;
	}
	private JTextField getJTnome2() {
		if (jTnome2 == null) {
			jTnome2 = new JTextField();
			jTnome2.setBounds(new Rectangle(88, 44, 159, 20));
			jTnome2.setEditable(false);
		}
		return jTnome2;
	}
	private JTextField getJTPreco2() {
		if (jTPreco2 == null) {
			jTPreco2 = new JTextField();
			jTPreco2.setBounds(new Rectangle(88, 76, 159, 20));
			jTPreco2.setEditable(false);
		}
		return jTPreco2;
	}
	private JTextField getJTCod2() {
		if (jTCod2 == null) {
			jTCod2 = new JTextField();
			jTCod2.setBounds(new Rectangle(88, 11, 160, 20));
		}
		return jTCod2;
	}
	private JTextField getJTQtd2() {
		if (jTQtd2 == null) {
			jTQtd2 = new JTextField();
			jTQtd2.setBounds(new Rectangle(88, 108, 159, 20));
			jTQtd2.setEditable(false);
		}
		return jTQtd2;
	}
	private JComboBox getJCforn2() {
		if (jCforn2 == null) {
			jCforn2 = new JComboBox();
			jCforn2.setBounds(new Rectangle(88, 140, 180, 25));
			jCforn2.setEnabled(false);
		}
		return jCforn2;
	}
	private JTextField getJCdesc2() {
		if (jTdesc2 == null) {
			jTdesc2 = new JTextField();
			jTdesc2.setBounds(new Rectangle(88, 172, 160, 25));
			jTdesc2.setEditable(false);
		}
		return jTdesc2;
	}
	private JButton getJBAlt2() {
		if (jBAlt2 == null) {
			jBAlt2 = new JButton();
			jBAlt2.setBounds(new Rectangle(87, 208, 91, 26));
			jBAlt2.setText("Alterar");
		}
		return jBAlt2;
	}
	private JButton getJBCon2() {
		if (jBCon2 == null) {
			jBCon2 = new JButton();
			jBCon2.setBounds(new Rectangle(250, 11	, 91, 26));
			jBCon2.setText("Consultar");
		}
		return jBCon2;
	}
	private JButton getJBsair2() {
		if (jBsair2 == null) {
			jBsair2 = new JButton();
			jBsair2.setBounds(new Rectangle(210, 208, 57, 26));
			jBsair2.setText("Sair");
		}
		return jBsair2;
	}
	private JButton getJBexcluir2() {
		if (jBexcluir2 == null) {
			jBexcluir2 = new JButton();
			jBexcluir2.setBounds(new Rectangle(120, 208, 80, 26));
			jBexcluir2.setText("Excluir");
		}
		return jBexcluir2;
	}
	//consultar
	private JInternalFrame getJIconsultar() {
		if (jInternalFrame1 == null) {
			jInternalFrame1 = new JInternalFrame();
			jInternalFrame1.setTitle("Consultar");
			jInternalFrame1.setContentPane(getJContentPane113());
		}
		return jInternalFrame1;
	}
	private JPanel getJContentPane113() {
		if (jContentPane11 == null) {
			jdescr12 = new JLabel();
			jdescr12.setBounds(new Rectangle(12, 183, 65, 16));
			jdescr12.setText("Descricao");
			jFornecedor12 = new JLabel();
			jFornecedor12.setBounds(new Rectangle(12, 149, 65, 16));
			jFornecedor12.setText("Fornecedor");
			jQtd12 = new JLabel();
			jQtd12.setBounds(new Rectangle(12, 116, 65, 16));
			jQtd12.setText("Quantidade");
			jQtd12.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jCusto12 = new JLabel();
			jCusto12.setBounds(new Rectangle(12, 83, 65, 16));
			jCusto12.setText("Preco");
			jcod12 = new JLabel();
			jcod12.setBounds(new Rectangle(44, 50, 33, 16));
			jcod12.setText("Nome");
			jCod12 = new JLabel();
			jCod12.setBounds(new Rectangle(38, 17, 39, 16));
			jCod12.setText("Codigo");
			jTCod121 = new JLabel();
			jTCod121.setBounds(new Rectangle(88, 11, 160, 20));
			jTnome12 = new JLabel();
			jTnome12.setBounds(new Rectangle(88, 44, 159, 20));
			jTPreco12 = new JLabel();
			jTPreco12.setBounds(new Rectangle(88, 76, 159, 20));
			jTQtd12 = new JLabel();
			jTQtd12.setBounds(new Rectangle(88, 108, 159, 20));
			jTdesc12 = new JLabel();
			jTdesc12.setBounds(new Rectangle(88, 178, 180, 25));
			jContentPane11 = new JPanel();
			jContentPane11.setLayout(null);
			jContentPane11.add(jCod12, null);
			jContentPane11.add(jcod12, null);
			jContentPane11.add(jCusto12, null);
			jContentPane11.add(jQtd12, null);
			jContentPane11.add(jFornecedor12, null);
			jContentPane11.add(jdescr12, null);
			jContentPane11.add(jTnome12, null);
			jContentPane11.add(jTPreco12, null);
			jContentPane11.add(jTQtd12, null);
			jContentPane11.add(jTdesc12, null);
			jContentPane11.add(getJCforn12(), null);
			jContentPane11.add(getJBsair11(), null);
			jContentPane11.add(jTCod121, null);
			jContentPane11.add(getJBexcluir2(), null);
			jContentPane11.add(getJScrollPaneprod(),null);
		}
		return jContentPane11;
	}
	private JComboBox getJCforn12() {
		if (jCforn12 == null) {
			jCforn12 = new JComboBox();
			jCforn12.setBounds(new Rectangle(88, 140, 180, 25));
			jCforn12.setEnabled(false);
		}
		return jCforn12;
	}
	private JButton getJBsair11() {
		if (jBsair11 == null) {
			jBsair11 = new JButton();
			jBsair11.setBounds(new Rectangle(210, 208, 57, 26));
			jBsair11.setText("Sair");
		}
		return jBsair11;
	}

	private JScrollPane getJScrollPaneprod() {
		if (jScrollPaneprod == null) {
			jScrollPaneprod = new JScrollPane();
			jScrollPaneprod.setBounds(new Rectangle(303, 0, 135, 267));
			jScrollPaneprod.setViewportView(getJTableprod());
		}
		return jScrollPaneprod;
	}
	//metodos
	public void gerente(){
		setContentPane(getJTabbedPane2());
	}
	
	public void limpartela(){
		jTnome1.setText("");
		jCforn1.setSelectedIndex(0);
		jTdesc1.setText("");
		jTQtd1.setText("");
		jTPreco1.setText("");
	}
	public void limpartelaalt(){
		jTnome2.setText("");
		jCforn2.setSelectedIndex(0);
		jTdesc2.setText("");
		jTQtd2.setText("");
		jTPreco2.setText("");
	}
	public void limpartelaexc(){
		jTnome12.setText("");
		jCforn12.setSelectedIndex(0);
		jTdesc12.setText("");
		jTQtd12.setText("");
		jTPreco12.setText("");
	}
	public void escuta(ActionListener l)
	{
		if(jBcad != null){jBcad.addActionListener(l);}else{LogManager.WriteDefaultLog("TelaProduto: jBcad is null");}
		if(jBAlt2 != null){jBAlt2.addActionListener(l);}else{LogManager.WriteDefaultLog("TelaProduto: jBAlt2 is null");}
		if(jBsair1 != null){jBsair1.addActionListener(l);}else{LogManager.WriteDefaultLog("TelaProduto: jBsair1 is null");}
		if(jBsair11 != null){jBsair11.addActionListener(l);}else{LogManager.WriteDefaultLog("TelaProduto: jBsair11 is null");}
		if(jBsair2 != null){jBsair2.addActionListener(l);}else{LogManager.WriteDefaultLog("TelaProduto: jBsair2 is null");}
		if(jButton != null){jButton.addActionListener(l);}else{LogManager.WriteDefaultLog("TelaProduto: jButton is null");}
		if(jButton1 != null){jButton1.addActionListener(l);}else{LogManager.WriteDefaultLog("TelaProduto: jButton1 is null");}
		if(jTCod2 != null){jTCod2.addActionListener(l);}else{LogManager.WriteDefaultLog("TelaProduto: jTCod2 is null");}
		if(jBCon2 != null){jBCon2.addActionListener(l);}else{LogManager.WriteDefaultLog("TelaProduto: jBCon2 is null");}		
		if(jBexcluir2 != null){jBexcluir2.addActionListener(l);}else{LogManager.WriteDefaultLog("TelaProduto: jBexcluir2 is null");}		
	}
	public void mostrarmsg(String msg)
	{
		JOptionPane.showMessageDialog(null,msg);
	}
	public void fecharTela()
	{
		this.dispose();
	}
	public void mostrarUltimoCodigoInserido()
	{
		String maxCod;
		DAOProduto daop = new DAOProduto();
		try {
			maxCod = daop.maxCodigo();
			
			this.ultimoCodCriado1.setText(maxCod);
			
		} catch (Exception e) {
				mostrarmsg("Nenhum produto cadastrado!!!");
		}
	}
	public void limparTabela(){
		dtm.setRowCount(0);
		dtmprod.setRowCount(0);
	}
	
	//get - set
	public void setfornecedor (Object Fornecedor){
		jCforn1.setSelectedItem(Fornecedor);
	}
	public void setPreco(String Preco)
	{
		jTPreco1.setText(Preco);
	}
	public void setDescricao(String Descricao)
	{
		jTdesc1.setText(Descricao);
	}
	public void setQtd(String Qtd)
	{
		jTQtd1.setText(Qtd);
	}
	public void setNome(String Nome)
	{
		jTnome1.setText(Nome);
	}
	public Object getFornecedor()
	{
		return jCforn1.getSelectedItem();
	}
	public String getDescricao1()
	{
		return jTdesc1.getText();
	}
	public String getPreco()
	{
		return jTPreco1.getText();
	}
	public String getQtd()
	{
		return jTQtd1.getText();
	}
	public String getNome()
	{
		return jTnome1.getText();
	}
	//alterar
	public void setcod2(String cod)
	{
		jTCod2.setText(cod);
	}
	public String getcod2()
	{
		return jTCod2.getText();
	}
	public void setfornecedor2(Object Fornecedor){
		jCforn2.setSelectedItem(Fornecedor);
	}
	public void setPreco2(String Preco)
	{
		jTPreco2.setText(Preco);
	}
	public void setDescricao2(String Descricao)
	{
		jTdesc2.setText(Descricao);
	}
	public void setQtd2(String Qtd)
	{
		jTQtd2.setText(Qtd);
	}
	public void setNome2(String Nome)
	{
		jTnome2.setText(Nome);
	}
	public Object getFornecedor2()
	{
		return jCforn2.getSelectedItem();
	}
	public String getPreco2()
	{
		return jTPreco2.getText();
	}
	public String getDescricao2()
	{
		return jTdesc2.getText();
	}
	public String getQtd2()
	{
		return jTQtd2.getText();
	}
	public String getNome2()
	{
		return jTnome2.getText();
	}
	public void setfornecedor12 (Object Fornecedor){
		jCforn12.setSelectedItem(Fornecedor);
	}
	public void setPreco12(String Custo)
	{
		jTPreco12.setText(Custo);
	}
	public void setQtd12(String Qtd)
	{
		jTQtd12.setText(Qtd);
	}	
	public void setNome12(String Nome)
	{
		jTnome12.setText(Nome);
	}
	public void setDesc12(String Nome)
	{
		jTdesc12.setText(Nome);
	}
	public Object getFornecedor12()
	{
		return jCforn12.getSelectedItem();
	}
	public void setcod121(String cod)
	{
		jTCod121.setText(cod);
	}
	public String getCusto12()
	{
		return jTPreco12.getText();
	}
	public String getQtd12()
	{
		return jTQtd12.getText();
	}
	public String getNome12()
	{
		return jTnome12.getText();
	}
	//preenche
	public void preenchefornecedor(ArrayList tipos){
		jCforn1.removeAllItems();
		jCforn2.removeAllItems();
		jCforn12.removeAllItems();
		Fornecedor f = new Fornecedor();
		f.setNome("FORNECEDOR");
		jCforn1.addItem(f);
		jCforn2.addItem(f);
		jCforn12.addItem(f);
		for (int i=0;i<tipos.size();i++){
			jCforn1.addItem(tipos.get(i));
			jCforn2.addItem(tipos.get(i));
			jCforn12.addItem(tipos.get(i));
		}
		if (this.update != null) {
			this.update.Update();
		}
	}
	
	public void escutamouse(MouseListener l) {
		jTableprod.addMouseListener(l);
		
	}
	
	
			
	}  //  @jve:decl-index=0:visual-constraint="10,10"  
