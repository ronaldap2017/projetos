package modelo;
	
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


	
	@Entity
	public class Produto {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cod_produto;
		@Column
	private String nome;
		@Column (length=10)
	private Float valor_unit;
		@Column (length=10)
	private int qtd_disponivel;
		@Column (length=30)
	private String descricao;
		@ManyToOne
	private Fornecedor fornecedor;
		
		
		
		public String getDescricao() {
			return descricao;
		}



		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}



		public int getCod_produto() {
			return cod_produto;
		}



		public void setCod_produto(int cod_produto) {
			this.cod_produto = cod_produto;
		}

		public Fornecedor getFornecedor() {
			return fornecedor;
		}



		public void setFornecedor(Fornecedor fornecedor) {
			this.fornecedor = fornecedor;
		}



		public String getNome() {
			return nome;
		}



		public void setNome(String nome) {
			this.nome = nome;
		}



		public int getQtd_disponivel() {
			return qtd_disponivel;
		}



		public void setQtd_disponivel(int qtd_disponivel) {
			this.qtd_disponivel = qtd_disponivel;
		}






		public float getValor_unit() {
			return valor_unit;
		}



		public void setValor_unit(float valor_unit) {
			this.valor_unit = valor_unit;
		}



		public String toString(){
			return nome;
		}

	}