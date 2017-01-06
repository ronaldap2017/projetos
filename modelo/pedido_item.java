package modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class pedido_item {
	@Id
	private int pedido_codigo_pedido;
	private int itens_codigo_pedido_codigo_produto;
}
