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
	public class Email {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		@Column (length=30)
		private String email;
		@Column (length=30)
		private String referencia;
		 @ManyToOne(fetch = FetchType.LAZY, optional = false)
		 @JoinColumn(name="cod_fornecedor ")
		 private Fornecedor fornecedor;
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
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