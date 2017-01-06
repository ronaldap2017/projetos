package visao;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.Rectangle;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JComboBox;
import utilitariosSO.LogManager;
import modelo.Email;
import modelo.Fornecedor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TelaFornecedor extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	public JTabbedPane jTFornecedor;
	private JInternalFrame JIcadastrar = null;
	private JLabel nome = null;
	private JTextField jTnomecad = null;
	private JButton jBcad = null;
	private JButton jBsair = null;
	private JLabel nomealt = null;
	public JTextField jTnomealt = null;
	private JButton jBalt = null;
	private JButton jBsairalt = null;
	public JComboBox jCBnome = null;
	private JTextField jTdescricaocad = null;
	private JTextField jTcidadecad = null;
	private JTextField jTbairrocad = null;
	private JTextField jTEnderecocad = null;
	private JTextField jTnumerocad = null;
	private JLabel descricaocad = null; 
	private JLabel cidadecad = null;
	private JLabel bairrocad = null;
	private JLabel Enderecocad = null;
	private JLabel numerocad = null;
	private JLabel jLabelCNPJ = null;
	private JLabel jLabelemailcad = null;
	private JTextField jTextFieldemailcad = null;
	private JTextField 	jTextFielddddcad = null;
	private JLabel jLabeltelcad = null;
	private JLabel jLabelrefemailcad = null;
	private JLabel jLabelreftelcad = null;	
	private JTextField jTextFieldtelcad = null;
	private JTextField jTextFieldcelcad = null;
	private JTextField jTextFieldrefemailcad = null;
	private JTextField jTextFieldreftelcad = null;
	private JLabel jLabelDadoscad = null;
	private JLabel jLabelEnderecocad = null;
	private JTabbedPane getJTfornecedor() {
		jTFornecedor = null;
		if (jTFornecedor == null) {
			jTFornecedor = new JTabbedPane();
			jTFornecedor.setName("Cadastrar");
			jTFornecedor.setTabPlacement(JTabbedPane.TOP);
			jTFornecedor.addTab("Cadastrar", null, getJIcadastrar(), null);
		}
		return jTFornecedor;
	}
	public TelaFornecedor() {
		super("",false, true, false);
		initialize();
	}
	private void initialize() {
		this.setSize(800,500);
		this.setTitle("Fornecedor");
		this.setContentPane(getJTfornecedor());
		this.setVisible(true);
	}
	private JPanel getJcadastrar() {
		if (jContentPane == null) {
			jLabelEnderecocad = new JLabel();
			jLabelEnderecocad.setBounds(new Rectangle(447, 28, 149, 19));
			jLabelEnderecocad.setText("Endereço");
			jLabelEnderecocad.setFont(new Font("Ebrima", Font.BOLD, 13));
			jLabelDadoscad = new JLabel();
			jLabelDadoscad.setBounds(new Rectangle(64, 28, 149, 19));
			jLabelDadoscad.setText("Dados");
			jLabelDadoscad.setFont(new Font("Ebrima", Font.BOLD, 13));
			jLabeltelcad = new JLabel();
			jLabeltelcad.setBounds(new Rectangle(6, 187, 110, 27));
			jLabeltelcad.setFont(new Font("Ebrima", Font.BOLD, 13));
			jLabeltelcad.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabeltelcad.setText("Telefone:");
			jLabelreftelcad = new JLabel();
			jLabelreftelcad.setBounds(new Rectangle(6, 217, 110, 27));
			jLabelreftelcad.setFont(new Font("Ebrima", Font.BOLD, 13));
			jLabelreftelcad.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelreftelcad.setText("Ref. Telefone:");

			jLabelemailcad = new JLabel();
			jLabelemailcad.setBounds(new Rectangle( 6, 127, 110, 27));
			jLabelemailcad.setFont(new Font("Ebrima", Font.BOLD, 13));
			jLabelemailcad.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelemailcad.setText("Email:");
			jLabelrefemailcad = new JLabel();
			jLabelrefemailcad.setBounds(new Rectangle(6, 157, 110, 27));
			jLabelrefemailcad.setFont(new Font("Ebrima", Font.BOLD, 13));
			jLabelrefemailcad.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelrefemailcad.setText("Ref. E-mail:");
			numerocad = new JLabel();
			numerocad.setBounds(new Rectangle(448, 187, 71, 27));
			numerocad.setFont(new Font("Ebrima", Font.BOLD, 13));
			numerocad.setHorizontalAlignment(SwingConstants.RIGHT);
			numerocad.setText("Numero:");
			Enderecocad = new JLabel();
			Enderecocad.setBounds(new Rectangle(448, 157, 73, 27));
			Enderecocad.setFont(new Font("Ebrima", Font.BOLD, 13));
			Enderecocad.setHorizontalAlignment(SwingConstants.RIGHT);
			Enderecocad.setText("Endereco:");
			bairrocad = new JLabel();
			bairrocad.setBounds(new Rectangle(448, 127, 70, 27));
			bairrocad.setFont(new Font("Ebrima", Font.BOLD, 13));
			bairrocad.setHorizontalAlignment(SwingConstants.RIGHT);
			bairrocad.setText("Bairro:");
			cidadecad = new JLabel();
			cidadecad.setBounds(new Rectangle(448, 97, 96, 27));
			cidadecad.setFont(new Font("Ebrima", Font.BOLD, 13));
			cidadecad.setHorizontalAlignment(SwingConstants.RIGHT);
			cidadecad.setText("Cidade:");
			descricaocad = new JLabel();
			descricaocad.setBounds(new Rectangle(376, 67, 110, 27));
			descricaocad.setFont(new Font("Ebrima", Font.BOLD, 13));
			descricaocad.setHorizontalAlignment(SwingConstants.RIGHT);
			descricaocad.setText("Descricao:");
			nome = new JLabel();
			nome.setBounds(new Rectangle(6, 97, 110, 27));
			nome.setFont(new Font("Ebrima", Font.BOLD, 13));
			nome.setHorizontalAlignment(SwingConstants.RIGHT);
			nome.setText("Nome:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(nome, null);
			jContentPane.add(getJTnomecad(), null);
			jContentPane.add(getJBcad(), null);
			jContentPane.add(getJBsair(), null);
			jContentPane.add(getJTdescricaocad(), null);
			jContentPane.add(getJTcomplementocad(), null);
			jContentPane.add(getJTbairrocad(), null);
			jContentPane.add(getJTEnderecocad(), null);
			jContentPane.add(getJTnumerocad(), null);
			jContentPane.add(descricaocad, null);
			jContentPane.add(cidadecad, null);
			jContentPane.add(bairrocad, null);
			jContentPane.add(jLabelrefemailcad, null);			
			jContentPane.add(jLabelreftelcad, null);
			jContentPane.add(Enderecocad, null);
			jContentPane.add(numerocad, null);
			jContentPane.add(jLabelemailcad, null);
			jContentPane.add(getJTextFieldemailcad(), null);
			jContentPane.add(jLabeltelcad, null);
			jContentPane.add(getJTextFieldtelcad(), null);
			jContentPane.add(getJTextFieldreftelcad(), null);
			jContentPane.add(getJTextFieldrefemailcad(), null);
			jContentPane.add(jLabelDadoscad, null);
			jContentPane.add(jLabelEnderecocad, null);
			jContentPane.add(getJTextFielddddcad(), null);
			
		}
		return jContentPane;
	}
	private JTextField getJTnomecad() {
		if (jTnomecad == null) {
			jTnomecad = new JTextField();
			jTnomecad.setBounds(new Rectangle(117, 97, 300, 27));
		}
		return jTnomecad;
	}
	private JButton getJBcad() {
		if (jBcad == null) {
			jBcad = new JButton();
			jBcad.setBounds(new Rectangle(155, 332, 154, 33));
			jBcad.setText("Cadastrar");
		}
		return jBcad;
	}
	private JButton getJBsair() {
		if (jBsair == null) {
			jBsair = new JButton();
			jBsair.setBounds(new Rectangle(455, 332, 154, 33));
			jBsair.setText("Sair");
		}
		return jBsair;
	}
	public JInternalFrame getJIcadastrar()
	{
		if (JIcadastrar == null) {
			JIcadastrar = new JInternalFrame();
			JIcadastrar.setTitle("Cadastrar");
			JIcadastrar.setContentPane(getJcadastrar());
		}
		return JIcadastrar;
	}
	
	
	//get - set
	public String getNome()
	{
		return jTnomecad.getText();
	}
	public String getNomealt()
	{
		return jTnomealt.getText();
	}
	public void setNome(String Nome)
	{
		jTnomecad.setText(Nome);
	}
	
	//metodos
	public void fecharTela()
	{
		this.dispose();
	}
	public void mostrarmsg(String msg)
	{
		JOptionPane.showMessageDialog(null,msg);
	}
	public void escuta(ActionListener l)
	{
		jBcad.addActionListener(l);
		jBsair.addActionListener(l);
	}
	/**
	 * This method initializes jCBnome	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJCBnome() {
		if (jCBnome == null) {
			jCBnome = new JComboBox();
			jCBnome.setBounds(new Rectangle(134, 9, 89, 25));
		}
		return jCBnome;
	}
	public void preenchefornecedor(ArrayList tipos){
		jCBnome.removeAllItems();
		Fornecedor f = new Fornecedor();
		f.setNome("FORNECEDOR");
		jCBnome.addItem(f);
		for (int i=0;i<tipos.size();i++){
			jCBnome.addItem(tipos.get(i));
		}
	}
	public void escutamouse(MouseListener l)
	{
		if(jCBnome != null){jCBnome.addMouseListener(l);}else{LogManager.WriteDefaultLog("TelaProduto: jCBnome is null");}
	}
	/**
	 * This method initializes jTruacad	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTdescricaocad() {
		if (jTdescricaocad == null) {
			jTdescricaocad = new JTextField();
			jTdescricaocad.setBounds(new Rectangle(486, 67, 240, 27));
		}
		return jTdescricaocad;
	}
	/**
	 * This method initializes jTcomplementocad	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTcomplementocad() {
		if (jTcidadecad == null) {
			jTcidadecad = new JTextField();
			jTcidadecad.setBounds(new Rectangle(545, 97, 181, 27));
		}
		return jTcidadecad;
	}
	/**
	 * This method initializes jTbairrocad	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTbairrocad() {
		if (jTbairrocad == null) {
			jTbairrocad = new JTextField();
			jTbairrocad.setBounds(new Rectangle(520, 127, 206, 27));
		}
		return jTbairrocad;
	}
	/**
	 * This method initializes jTEnderecocad	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTEnderecocad() {
		if (jTEnderecocad == null) {
			jTEnderecocad = new JTextField();
			jTEnderecocad.setBounds(new Rectangle(520, 157, 205, 27));
		}
		return jTEnderecocad;
	}
	/**
	 * This method initializes jTestadocad	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTnumerocad() {
		if (jTnumerocad == null) {
			jTnumerocad = new JTextField();
			jTnumerocad.setBounds(new Rectangle( 520, 187, 205, 27));
		}
		return jTnumerocad;
	}
	/**
	 * This method initializes jTcepcad	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	

	
	public String getBairrocad()
	{
		return jTbairrocad.getText();
	}
	public String getdescricaocad()
	{
		return jTdescricaocad.getText();
	}
	public String getrefemailcad()
	{
		return jTextFieldrefemailcad.getText();
	}
	public String getdddcad()
	{
		return jTextFielddddcad.getText();
	}
	public String getreftelcad()
	{
		return jTextFieldreftelcad.getText();
	}
	public String getcidadecad()
	{
		return jTcidadecad.getText();
	}
	public String getEnderecocad()
	{
		return jTEnderecocad.getText();
	}	
	public String getnumerocad()
	{
		return jTnumerocad.getText();
	}
	public String getemailcad()
	{
		return jTextFieldemailcad.getText();
	}
	
	
	public String gettelefonecad()
	{
		return jTextFieldtelcad.getText();
	}
	
	/**
	 * This method initializes jTextFieldemailcad	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldemailcad() {
		if (jTextFieldemailcad == null) {
			jTextFieldemailcad = new JTextField();
			jTextFieldemailcad.setBounds(new Rectangle(117, 127, 300, 27));
		}
		return jTextFieldemailcad;
	}
	/**
	 * This method initializes jTextFieldtelcad	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFielddddcad() {
		if (jTextFielddddcad == null) {
			jTextFielddddcad = new JTextField();
			jTextFielddddcad.setBounds(new Rectangle(117, 187, 50, 27));
		}
		return jTextFielddddcad;
	}
	private JTextField getJTextFieldtelcad() {
		if (jTextFieldtelcad == null) {
			jTextFieldtelcad = new JTextField();
			jTextFieldtelcad.setBounds(new Rectangle(167, 187, 250, 27));
		}
		return jTextFieldtelcad;
	}
	private JTextField getJTextFieldreftelcad() {
		if (jTextFieldreftelcad == null) {
			jTextFieldreftelcad = new JTextField();
			jTextFieldreftelcad.setBounds(new Rectangle(117, 217, 300, 27));
		}
		return jTextFieldreftelcad;
	}
	private JTextField getJTextFieldrefemailcad() {
		if (jTextFieldrefemailcad == null) {
			jTextFieldrefemailcad = new JTextField();
			jTextFieldrefemailcad.setBounds(new Rectangle(117, 157, 300, 27));
		}
		return jTextFieldrefemailcad;
	}
	
	
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
