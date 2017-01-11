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
	public class Telefone {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		@Column (length=20)
		private String ddd;	
		@Column (length=20)
		private String numero;	
		@Column (length=20)
		private String referencia;	
		
		 @ManyToOne(fetch = FetchType.LAZY, optional = false)
		 @JoinColumn(name="cod_fornecedor ")
		 private Fornecedor fornecedor;

		public String getDdd() {
			return ddd;
		}

		public void setDdd(String ddd) {
			this.ddd = ddd;
		}

		public String getNumero() {
			return numero;
		}

		public void setNumero(String numero) {
			this.numero = numero;
		}

		public String getReferencia() {
			return referencia;
		}

		public void setReferencia(String referencia) {
			this.referencia = referencia;
		}

		public Fornecedor getFornecedor() {
			return fornecedor;
		}

		public void setFornecedor(Fornecedor fornecedor) {
			this.fornecedor = fornecedor;
		}

	
	}