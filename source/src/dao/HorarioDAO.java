package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Horario;

public class HorarioDAO {
	EntityManagerFactory emf;
	EntityManager em;

	public HorarioDAO() {
		emf = Persistence.createEntityManagerFactory("conexao");
		em = emf.createEntityManager();

	}

	public void salvar(Horario horario) {
		em.getTransaction().begin();
		em.merge(horario);
		em.getTransaction().commit();
		emf.close();

	}

	public void excluir(Horario horario) {
		em.getTransaction().begin();
		em.remove(horario);
		em.getTransaction().commit();
		emf.close();
	}
	@SuppressWarnings("unchecked")
	public List<Horario> listarTodos() {
		em.getTransaction().begin();
		Query consultaBanco = em.createQuery("select consulta from Consulta consulta");
		List<Horario> horario = consultaBanco.getResultList();
		em.getTransaction().commit();
		emf.close();
		return horario;
	}
}