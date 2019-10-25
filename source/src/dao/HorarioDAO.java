package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Horario;
import model.HorarioCliente;

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
	
	public void salvarDataHora(HorarioCliente horaCliente) {
		em.getTransaction().begin();
		em.merge(horaCliente);
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
		Query consultaBanco = em.createQuery("select horario from Horario horario");
		List<Horario> horario = consultaBanco.getResultList();
		em.getTransaction().commit();
		emf.close();
		return horario;
	}
	
	@SuppressWarnings("unchecked")
	public List<HorarioCliente> obterHoraPelaData(Date data) {

			Query query = em.createQuery("select h from HorarioCliente h where h.data = :data");
			query.setParameter("data", data);
			List<HorarioCliente> list = (List<HorarioCliente>) query.getSingleResult();

			return (List<HorarioCliente>) list;		
	}
	
	@SuppressWarnings("unchecked")
	public List<HorarioCliente> sdfsdfos(Date data) {
		em.getTransaction().begin();
		Query consultaBanco = em.createQuery("select h from HorarioCliente h where h.data = :data");
		consultaBanco.setParameter("data", data);
		List<HorarioCliente> horario = consultaBanco.getResultList();
		em.getTransaction().commit();
		emf.close();
		return horario;
	}
}