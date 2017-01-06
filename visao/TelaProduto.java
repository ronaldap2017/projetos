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
	//tela
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
	public void escuta(ActionListener l)
	{
		if(jBcad != null){jBcad.addActionListener(l);}else{LogManager.WriteDefaultLog("TelaProduto: jBcad is null");}
		if(jBsair1 != null){jBsair1.addActionListener(l);}else{LogManager.WriteDefaultLog("TelaProduto: jBsair1 is null");}
		if(jButton1 != null){jButton1.addActionListener(l);}else{LogManager.WriteDefaultLog("TelaProduto: jButton1 is null");}
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
	
	
	//preenche
	public void preenchefornecedor(ArrayList tipos){
		jCforn1.removeAllItems();
		Fornecedor f = new Fornecedor();
		f.setNome("FORNECEDOR");
		jCforn1.addItem(f);
		for (int i=0;i<tipos.size();i++){
			jCforn1.addItem(tipos.get(i));
		}
		if (this.update != null) {
			this.update.Update();
		}
	}
	public void escutamouse(MouseListener l) {
		jTableprod.addMouseListener(l);
		
	}
			
	}  //  @jve:decl-index=0:visual-constraint="10,10"  
