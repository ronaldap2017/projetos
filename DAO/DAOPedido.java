package DAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Item;
import modelo.Parametros;
import modelo.Produto;
import modelo.Pedido;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


import controle.ControleProduto;

public class DAOPedido {
	private SessionFactory	fabrica;
	@SuppressWarnings("unused")
	private ControleProduto ce;
	public DAOPedido(){
		fabrica = Fabrica.obtemFabrica();
		}
	public void cadastrar (Pedido v) throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.save(v);
		transacao.commit();
		sessao.flush();
		sessao.close();
	}
	public void cadastrar (Parametros par) throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.save(par);
		transacao.commit();
		sessao.flush();
		sessao.close();
	}
	public void excluirv (Pedido v) throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		String sql = "delete from pedido where notafiscal = "+v.getNotafiscal();
		Query q = sessao.createQuery(sql);
		q.executeUpdate();
		transacao.commit();
		sessao.flush();
		sessao.close();
	}
	public void excluir (Pedido e) throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.delete(e);
		transacao.commit();
		sessao.flush();
		sessao.close();
	}
	public void excluirit (Pedido i) throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		String sql = "delete from Item where codigo_pedido = "+i.getNotafiscal();
		Query q = sessao.createQuery(sql);
		q.executeUpdate();
		transacao.commit();
		sessao.flush();
		sessao.close();
	}
	public void excluirvi (Pedido vi) throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		String sql = "delete from pedido_item where pedido_codigo_pedido = "+vi.getNotafiscal();
		Query q = sessao.createQuery(sql);
		q.executeUpdate();
		transacao.commit();
		sessao.flush();
		sessao.close();
	}
	
	public void alterar (Pedido v) throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.update(v);
		transacao.commit();
		sessao.flush();
		sessao.close();
	}
	public Produto consultar (Produto p) throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		Query q = sessao.createQuery("from modelo.Produto where codigo=:x");
		q.setInteger("x",p.getCod_produto());
		if(q.list().size()!=0){
		p = (Produto)(q.list()).get(0);}
		else p=null;
		transacao.commit();
		sessao.flush();
		sessao.close();
		return p;
	}
	public Pedido consulta (Pedido p) throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		Query q = sessao.createQuery("from modelo.pedido where codigo=:x");
		q.setInteger("x",p.getCodigo_pedido());
		if(q.list().size()!=0){
		p = (Pedido)(q.list()).get(0);}
		else p=null;
		transacao.commit();
		sessao.flush();
		sessao.close();
		return p;
	}
	public Parametros consulta (Parametros pa) throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		Query q = sessao.createQuery("from modelo.Parametros where cod_par=:x");
		q.setInteger("x",pa.getCod_par());
		if(q.list().size()!=0){
		pa = (Parametros)(q.list()).get(0);}
		else pa=null;
		transacao.commit();
		sessao.flush();
		sessao.close();
		return pa;
	}
	public Pedido consul (Pedido v) throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		Query r = sessao.createQuery("from modelo.Pedido where notafiscal=:x");
		r.setInteger("x",v.getNotafiscal());
		if(r.list().size()!=0){
		v = (Pedido)(r.list()).get(0);}
		transacao.commit();
		sessao.flush();
		sessao.close();
		return v;
	}
	public int consultarnota() throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		Query query=sessao.createQuery("select max(notafiscal+1) from modelo.Pedido");
		String q="1";
		Object obj = query.uniqueResult();
		if(obj!=null){
			q = obj.toString();
		}
		int list =Integer.parseInt(q);
		transacao.commit();
		sessao.flush();
		sessao.close();
		return list;
	}
	public ArrayList<Pedido> consultarTodos() throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		Query q = sessao.createQuery("from modelo.pedido");
		ArrayList<Pedido> list = (ArrayList<Pedido>)q.list();
		transacao.commit();
		sessao.flush();
		sessao.close();
		return list;
	}
	public ArrayList<Item> consultarTodosit() throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		Query q = sessao.createQuery("from modelo.ItemPK");
		ArrayList<Item> list = (ArrayList<Item>)q.list();
		transacao.commit();
		sessao.flush();
		sessao.close();
		return list;
	}
	public ArrayList<Item> consultarPorNota(Pedido v) throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		Query r = sessao.createQuery("from modelo.pedido where notafiscal=:x");
		r.setInteger("x",v.getNotafiscal());
		ArrayList<Item> list = (ArrayList<Item>)r.list();
		transacao.commit();
		sessao.flush();
		sessao.close();
		return list;
	}
	public ArrayList notafiscal(){
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		Criteria cr = sessao.createCriteria(Item.class);//.add(Restrictions.eq("pedido", v));
		cr.setResultTransformer(Criteria.ROOT_ENTITY);
		//Query q = sessao.createQuery(" from modelo.Produto,modelo.pedido,modelo.Funcionario,modelo.Item");		
		ArrayList ordens = (ArrayList) cr.list();
		transacao.commit();
		sessao.flush();
		sessao.close();
		
		return ordens;
	}
	public ArrayList consultaPorData(Date jTDataInicial, Date jTDataFinal){
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		
		Query q = sessao.createQuery(" from modelo.pedido" +
				                     " where data >= :i " +
				                     "   and data <= :f ");
		q.setDate("i", jTDataInicial);
		q.setDate("f", jTDataFinal);
		
		ArrayList ordens = (ArrayList) q.list();
		transacao.commit();
		sessao.flush();
		sessao.close();
		
		return ordens;
	}
	public ArrayList pago(String jpg){
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		Query q = sessao.createQuery(" from modelo.pedido" +
									 " where pagamento = :i ");		
		q.setText("i", jpg);
		ArrayList ordens = (ArrayList) q.list();
		transacao.commit();
		sessao.flush();
		sessao.close();
		
		return ordens;
	}
	public Boolean cod(int nome)
	{
		Boolean retorno = false;
		
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		retorno = Integer.parseInt(sessao.createSQLQuery("SELECT COUNT(codigo_pedido) FROM pedido WHERE notafiscal = '" + nome + "'").uniqueResult().toString()) > 0;
		
		transacao.commit();
		sessao.flush();
		sessao.close();
		
		return retorno;
	}
	public ArrayList<Parametros> consultarTodospar() throws Exception
	{
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		Query q = sessao.createQuery("from modelo.Parametros");
		ArrayList<Parametros> list = (ArrayList<Parametros>)q.list();
		transacao.commit();
		sessao.flush();
		sessao.close();
		return list;
	}
	public Boolean nomeRepetido(String notafiscal)
	{
		Boolean retorno = false;
		
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		
		retorno = Integer.parseInt(sessao.createSQLQuery("SELECT COUNT(codigo_pedido) FROM pedido WHERE notafiscal = '" + notafiscal + "'").uniqueResult().toString()) > 0;
		
		transacao.commit();
		sessao.flush();
		sessao.close();
		
		return retorno;
	}
}

