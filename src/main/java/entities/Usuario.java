package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String senha;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Telefone> telefones = new ArrayList<Telefone>();

	public Usuario() {
	}

	public Usuario(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefone(Telefone telefone) {
		telefone.setUsuario(this);
		this.telefones.add(telefone);
	}

	public void setTelefones(List<Telefone> telefones) {
		for(Telefone t: telefones) {
			t.setUsuario(this);
		}
		this.telefones = telefones;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void atualizarUsuario(String nome, String email) {
		setNome(nome);
		setEmail(email);
	}

	@Override
	public String toString() {
		return "Usuario [id= " + id + ", nome= " + nome + ", email= " + email + ", senha= " + senha + ", telefones ="
				+ telefones + "]";
	}

}
