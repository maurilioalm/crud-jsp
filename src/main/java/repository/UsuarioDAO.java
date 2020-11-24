package repository;

import java.util.List;

import javax.persistence.EntityManager;

import entities.Usuario;

public class UsuarioDAO extends DAO<Usuario> {

	public UsuarioDAO() {
		super(Usuario.class);

	}
	
	public boolean autenticar(String email, String senha) {
		List<Usuario> listaUsuarios = this.findAll();
		for(Usuario u: listaUsuarios){
			if(u.getEmail().toLowerCase().equals(email.toLowerCase()) && u.getSenha().toLowerCase().equals(senha)) {
				return true;
			}
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> findAll(){
		List<Usuario> lista = null;
		EntityManager em = super.em();
		try {
			lista = em.createQuery("from Usuario").getResultList();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return lista;
	}



	/*public void deleteTelefones(Long id) {
		int query = super.em().createQuery("DELETE FROM Telefone WHERE usuario_id = '" + id + "'").executeUpdate();
		System.out.println(query);
	}*/
}
