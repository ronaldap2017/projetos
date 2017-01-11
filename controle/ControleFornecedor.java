package controle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


import DAO.DAOFornecedor;
import modelo.*;
import utilitariosSO.IUpdate;
import visao.*;

public class ControleFornecedor implements ActionListener,IUpdate{
	private TelaFornecedor tf;
	private TelaProduto tp;
	private Fornecedor c;
	private Email e;
	private Telefone t;
	private IUpdate update2;
	public ControleFornecedor (TelaFornecedor tf, TelaProduto tp)
	{
		this.tf=tf;
		this.tp=tp;
		tf.escuta(this);
	}
	public void actionPerformed(ActionEvent a) {
		if(a.getActionCommand().equals("Sair"))
		{
			tf.fecharTela();
			tp.setVisible(true);
		}
		if(a.getActionCommand().equals("Cadastrar"))
		{
			c = new Fornecedor();
			e = new Email();
			t = new Telefone();
			c.setNome(tf.getNome());
			c.setBairro(tf.getBairrocad());
			c.setEndereco(tf.getEnderecocad());
			c.setCidade(tf.getcidadecad());
			c.setDescricao(tf.getdescricaocad());
			c.setNumero(Integer.parseInt(tf.getnumerocad()));
			e.setEmail(tf.getemailcad());
			e.setReferencia(tf.getrefemailcad());
			 Set<Email> lista_email = new HashSet<Email>(); 
			 lista_email.add(e);
			c.setEmails(lista_email);
			t.setDdd(tf.getdddcad());
			t.setNumero(tf.gettelefonecad());
			t.setReferencia(tf.getreftelcad());
			Set<Telefone> lista_telefone = new HashSet<Telefone>(); 
			lista_telefone.add(t);
			c.setTelefones(lista_telefone);
			t.setFornecedor(c);
			e.setFornecedor(c);
			try {
				DAOFornecedor de = new DAOFornecedor();
				if (de.cod(c.getNome())) {
					tf.mostrarmsg(c.getNome() + " jah existente!!!");
					return;
				}
				de.cadastrar(c);
				tf.mostrarmsg(c.getNome()+" cadastrado com sucesso!!!");
				setIUpdate2(this);
				if(this.update2 != null)
				{
					this.update2.Update2();
				}
				try {
					ArrayList tipos;
					tipos = de.consultarTodos();
					tp.preenchefornecedor(tipos);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e1) {
				tf.mostrarmsg(c.getNome()+" nao foi cadastrado!!!");
				e1.printStackTrace();
			}
		}
		}
	public void setIUpdate2(IUpdate update2)
	{
		this.update2 = update2;
	}
	public void Update() {
		
	}
	public void Update2() {
		try {
			DAOFornecedor DAOT = new DAOFornecedor();
			ArrayList tipos = DAOT.consultarTodos();
			tp.preenchefornecedor(tipos);
			}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
	}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
}