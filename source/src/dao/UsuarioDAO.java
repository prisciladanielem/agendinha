package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Usuario;

public class UsuarioDAO {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("conexao");
	private EntityManager em = factory.createEntityManager();



	public Usuario logar(String nome, String senha) {

		try {
			Usuario usuario = (Usuario) em.createQuery("select usuario from Usuario usuario");
//        .setParameter("name", nome)
//        .setParameter("senha", senha).getSingleResult();

			return usuario;
		} catch (NoResultException e) {
			return null;
		}
	}

	public Usuario getUsuario2(String nome, String senha) {
		em.getTransaction().begin();
		javax.persistence.Query consultaBanco = em.createQuery("select usuario from Usuario usuario");
//	    .setParameter("nome", nome)
//		.setParameter("senha", senha);
		em.getTransaction().commit();
		em.close();

		return (Usuario) consultaBanco;
	}

	public boolean inserirUsuario(Usuario usuario) {
		try {
			em.persist(usuario);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletarUsuario(Usuario usuario) {
		try {
			em.remove(usuario);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void salvar(Usuario usuario) {
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
		em.close();

	}

	public Usuario getUsuario(String nome, String senha) {

		try {
			Query query = em.createQuery("select u from Usuario u where u.nome = :nome and u.senha = :senha ");
			query.setParameter("nome", nome);
			query.setParameter("senha", senha);
			Usuario u = (Usuario) query.getSingleResult();

			return (Usuario) u;
		} catch (NoResultException nre) {
			return null;
		}

	}

}