package DAO;
import java.util.ArrayList;
import modelo.Produto;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import controle.ControleProduto;

public class DAOProduto {
	private SessionFactory	fabrica;
	@SuppressWarnings("unused")
	private ControleProduto ce;
	public DAOProduto(){
		fabrica = Fabrica.obtemFabrica();
		}
	
	public String maxCodigo () throws Exception
	{		
		String maxCodigo;
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		maxCodigo = sessao.createSQLQuery("SELECT MAX(cod_produto+1) FROM Produto").uniqueResult().toString();
		transacao.commit();	
		sessao.flush();
		sessao.close();
		return maxCodigo;
	}
	public void cadastrar (Produto p) throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.save(p);
		transacao.commit();
		sessao.flush();
		sessao.close();
	}
	public void excluir (Produto e) throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.delete(e);
		transacao.commit();
		sessao.flush();
		sessao.close();
	}
	public void alterar (Produto e) throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.update(e);
		transacao.commit();
		sessao.flush();
		sessao.close();
	}
	
	public Produto codigo (Produto e) throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		Query q = sessao.createQuery("FROM Produto WHERE cod_produto=:x");
		q.setInteger("x",e.getCod_produto());
		if(q.list().size()!=0){
		e = (Produto)(q.list()).get(0);}
		transacao.commit();
		sessao.flush();
		sessao.close();
		return e;
	}
	public Object codigo(String nome)
	{
		Object retorno;
		
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		
		retorno = sessao.createSQLQuery("SELECT codigo FROM Produto WHERE cod_produto = '" + nome + "'");
		
		transacao.commit();
		sessao.flush();
		sessao.close();
		
		return retorno;
	}
	public Produto consulta (Produto e) throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		Query q = sessao.createQuery("FROM Produto WHERE cod_produto=:x");
		q.setInteger("x",e.getCod_produto());
		if(q.list().size()!=0){
		e = (Produto)(q.list()).get(0);}
		transacao.commit();
		sessao.flush();
		sessao.close();
		return e;
	}
	public Produto consultar (Produto e) throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		Query q = sessao.createQuery("FROM Produto WHERE cod_produto=:x");
		q.setInteger("x",e.getCod_produto());
		if(q.list().size()!=0){
		e = (Produto)(q.list()).get(0);}
		transacao.commit();
		sessao.flush();
		sessao.close();
		return e;
	}
	public ArrayList<Produto> consultarTodos() throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		Query q = sessao.createQuery("from modelo.Produto order by nome");
		ArrayList<Produto> list = (ArrayList<Produto>)q.list();
		transacao.commit();
		sessao.flush();
		sessao.close();
		return list;
	}
	public ArrayList estoque(){
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		Query q = sessao.createQuery(" from modelo.Produto");		
		ArrayList ordens = (ArrayList) q.list();
		transacao.commit();
		sessao.flush();
		sessao.close();
		
		return ordens;
	}
	
	public Boolean nomeRepetido(String nome)
	{
		Boolean retorno = false;
		
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		
		retorno = Integer.parseInt(sessao.createSQLQuery("SELECT COUNT(cod_produto) FROM Produto WHERE nome = '" + nome + "'").uniqueResult().toString()) > 0;
		
		transacao.commit();
		sessao.flush();
		sessao.close();
		
		return retorno;
	}
	public Boolean codprod()
	{
		Boolean retorno = false;
		
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		
		//será q isso funciona =DD
		retorno = Integer.parseInt(sessao.createSQLQuery("SELECT COUNT(2) FROM PRODUTO").uniqueResult().toString()) > 0;
		
		transacao.commit();
		sessao.flush();
		sessao.close();
		
		return retorno;
	}
	
	public Boolean cod(int nome)
	{
		Boolean retorno = false;
		
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();

		retorno = Integer.parseInt(sessao.createSQLQuery("SELECT COUNT(cod_produto) FROM Produto WHERE cod_produto = '" + nome + "'").uniqueResult().toString()) > 0;
		
		transacao.commit();
		sessao.flush();
		sessao.close();
		
		return retorno;
	}

}

