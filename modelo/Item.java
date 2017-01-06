package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo_pedido_codigo_produto;
	@Column (length=10)
	private int qtd;
	@Column (length=10)
	private Float valor_unit;
	@Column (length=10)
	private Float valor_total;
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
@JoinColumn(name="codigo_produto")
 private Produto produto;
 @ManyToOne(fetch = FetchType.LAZY, optional = false)
 @JoinColumn(name="codigo_pedido")
 private Pedido pedido;
 
public boolean equals(Object o) {
 if (this == o)
 return true;
	 if (o == null || getClass() != o.getClass())
	 return false;
 if (!(o instanceof Item))
	 return false;
	 
 Item that = (Item) o;
 
 if (this.produto != null ? !this.produto.equals(that.produto) : that.produto != null)
return false;
if (this.pedido != null ? !this.pedido.equals(that.pedido) : that.pedido != null)
return false;

return true;
}

public int hashCode() {
int result;
result = (this.produto != null ? this.produto.hashCode() : 0);
result = 31 * result + (this.pedido != null ? this.pedido.hashCode() : 0);
return result;
}

public Produto getProduto() {
	return produto;
}

public void setProduto(Produto produto) {
	this.produto = produto;
}

public Pedido getpedido() {
	return pedido;
}

public void setpedido(Pedido pedido) {
	this.pedido = pedido;
}

public int getQtd() {
	return qtd;
}

public void setQtd(int qtd) {
	this.qtd = qtd;
}

public Float getValor_total() {
	return valor_total;
}

public void setValor_total(Float valor_total) {
	this.valor_total = valor_total;
}

public Float getValor_unit() {
	return valor_unit;
}

public void setValor_unit(Float valor_unit) {
	this.valor_unit = valor_unit;
}

public int getId() {
	return codigo_pedido_codigo_produto;
}

public void setId(int id) {
	this.codigo_pedido_codigo_produto = id;
}
	
}
