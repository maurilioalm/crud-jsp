package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Telefone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int ddd;
	private String numero;
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Telefone() {
	}

	public Telefone(int ddd, String numero, String tipo, Usuario usuario) {
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

	@Override
	public String toString() {
		return "Telefone [id= " + id + ", ddd= " + ddd + ", numero= " + numero + ", tipo= " + tipo + "]";
	}

}
