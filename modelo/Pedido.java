package modelo;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int codigo_pedido;
	@Column (length=10)
private int notafiscal;
	@Column (length=10)
private Float valortotal;
	@Column (length=8)
private Date data;
	@Column (length=10)
	private Float valorfrete;
	@Column (length=10)
	private Float desconto;
	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<Item> itens;
	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<Transportadora> transportadora;
	
	public Set<Transportadora> getTransportadora() {
		return transportadora;
	}
	public void setTransportadora(Set<Transportadora> transportadora) {
		this.transportadora = transportadora;
	}
	public Set<Item> getItens() {
		return itens;
	}
	public void setItens(Set<Item> itens) {
		this.itens = itens;
	}
	public int getCodigo_pedido() {
		return codigo_pedido;
	}
	public void setCodigo_pedido(int codigo_pedido) {
		this.codigo_pedido = codigo_pedido;
	}
	public int getNotafiscal() {
		return notafiscal;
	}
	public void setNotafiscal(int notafiscal) {
		this.notafiscal = notafiscal;
	}
	public Float getValortotal() {
		return valortotal;
	}
	public void setValortotal(Float valortotal) {
		this.valortotal = valortotal;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Float getValorfrete() {
		return valorfrete;
	}
	public void setValorfrete(Float valorfrete) {
		this.valorfrete = valorfrete;
	}
	public Float getDesconto() {
		return desconto;
	}
	public void setDesconto(Float desconto) {
		this.desconto = desconto;
	}
		
}
