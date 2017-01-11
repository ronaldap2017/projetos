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
	public class Transportadora {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		@Column (length=20)
		private String nome;	
		
		
		 @ManyToOne(fetch = FetchType.LAZY, optional = false)
		 @JoinColumn(name="cod_fornecedor ")
		 private Pedido pedido;


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}


		public Pedido getPedido() {
			return pedido;
		}


		public void setPedido(Pedido pedido) {
			this.pedido = pedido;
		}

		

	
	}