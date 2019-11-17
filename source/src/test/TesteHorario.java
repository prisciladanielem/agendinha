package test;

import static org.junit.Assert.*;
import org.junit.Test;

import dao.HorarioDAO;
import model.Horario;

public class TesteHorario {
	private HorarioDAO horarioDAO;
	private Horario horario;

	@Test
	public void testSalvar() {
		horario = new Horario();

		horario.setId(1);
		horario.setNome("Teste Inserção Cliente");
		horario.setEmail("pessoa@teste.com");
		horario.setTelefone("4599991231");

		horarioDAO = new HorarioDAO();
		horarioDAO.salvar(horario);

		assertTrue(horarioDAO.listarTodos().size() > 0);

	}
}