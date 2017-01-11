package modelo;

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
public class Fornecedor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cod_fornecedor;
	@Column (length=130)
	private String nome;
	@Column (length=130)
	private String descricao;
	@Column (length=150)
	private String endereco;
	@Column (length=40)
	private String cidade;
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	@Column (length=40)
	private String bairro;
	@Column (length=40)
	private int numero;
	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<Email> emails;
	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<Telefone> telefones;
	
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Set<Email> getEmails() {
		return emails;
	}
	public void setEmails(Set<Email> emails) {
		this.emails = emails;
	}
	public Set<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	public String toString(){
		return nome;
	}
}