package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Consulta;

public class ConsultaDAO {
	EntityManagerFactory emf;
	EntityManager em;

	public ConsultaDAO() {
		emf = Persistence.createEntityManagerFactory("conexao");
		em = emf.createEntityManager();

	}

	public void salvar(Consulta consulta) {
		em.getTransaction().begin();
		em.merge(consulta);
		em.getTransaction().commit();
		emf.close();

	}

	public void excluir(Consulta consulta) {
		em.getTransaction().begin();
		em.remove(consulta);
		em.getTransaction().commit();
		emf.close();
	}
	@SuppressWarnings("unchecked")
	public List<Consulta> listarTodos() {
		em.getTransaction().begin();
		Query consultaBanco = em.createQuery("select consulta from Consulta consulta");
		List<Consulta> consulta = consultaBanco.getResultList();
		em.getTransaction().commit();
		emf.close();
		return consulta;
	}

}