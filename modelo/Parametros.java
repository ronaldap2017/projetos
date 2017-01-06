package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@SequenceGenerator(name = "cod_par", sequenceName = "cod_par", allocationSize=1 )  
public class Parametros {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cod_par")  
	private int cod_par;
	@Column (length=150)
	private String parametro;
	@Column (length=10)
	private String valor;
	public int getCod_par() {
		return cod_par;
	}
	public void setCod_par(int cod_par) {
		this.cod_par = cod_par;
	}
	public String getParametro() {
		return parametro;
	}
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
}
