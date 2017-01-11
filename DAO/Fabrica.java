package DAO;

import modelo.Email;
import modelo.Fornecedor;
import modelo.Item;
import modelo.Parametros;
import modelo.Produto;
import modelo.Telefone;
import modelo.Transportadora;
import modelo.Pedido;
import modelo.pedido_item;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Fabrica {
private static SessionFactory fabrica;
	
	private Fabrica() {
		fabrica = new AnnotationConfiguration().
		addAnnotatedClass(Fornecedor.class).
		addAnnotatedClass(Item.class).
		addAnnotatedClass(Pedido.class).
		addAnnotatedClass(Produto.class).
		addAnnotatedClass(Parametros.class).
		addAnnotatedClass(pedido_item.class).
		addAnnotatedClass(Telefone.class).
		addAnnotatedClass(Email.class).
		addAnnotatedClass(Transportadora.class).
		buildSessionFactory();
	}
	public static SessionFactory obtemFabrica() {
		if (fabrica == null);
		{
			new Fabrica();
		}return fabrica;
	}
	
}
