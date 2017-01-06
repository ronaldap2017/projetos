package DAO;
import java.util.ArrayList;

import modelo.Email;
import modelo.Fornecedor;
import modelo.Telefone;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import controle.ControleFornecedor;

public class DAOFornecedor {
	private SessionFactory	fabrica;
	@SuppressWarnings("unused")
	private ControleFornecedor cc;
	public DAOFornecedor(){
		fabrica = Fabrica.obtemFabrica();
		}
	public void cadastrar (Fornecedor p) throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.save(p);
		transacao.commit();
		sessao.flush();
		sessao.close();
	}
	public void excluir (Fornecedor e) throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.delete(e);
		transacao.commit();
		sessao.flush();
		sessao.close();
	}
	
	public ArrayList<Fornecedor> consultarTodos() throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		Query q = sessao.createQuery("from modelo.Fornecedor");
		ArrayList<Fornecedor> list = (ArrayList<Fornecedor>)q.list();
		transacao.commit();
		sessao.flush();
		sessao.close();
		return list;
	}
	public void alterar (Fornecedor e) throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.update(e);
		transacao.commit();
		sessao.flush();
		sessao.close();
	}
	public Boolean cod(String nome)
	{
		Boolean retorno = false;
		
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		retorno = Integer.parseInt(sessao.createSQLQuery("SELECT COUNT(cod_fornecedor) FROM Fornecedor WHERE nome = '" + nome + "'").uniqueResult().toString()) > 0;
		transacao.commit();
		sessao.flush();
		sessao.close();
		return retorno;
	}
}

