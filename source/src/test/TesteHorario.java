package test;

import static org.junit.Assert.*;
import org.junit.Test;

import dao.HorarioDAO;
import model.Horario;

public class TesteConsulta {
	private HorarioDAO pessoaDAO;
	private Horario pessoa;

	@Test
	public void testSalvar() {
		pessoa = new Horario();

		pessoa.setId(1);
		pessoa.setNome("Teste Inserção Cliente");
		pessoa.setEmail("pessoa@teste.com");
		pessoa.setTelefone("4599991231");

		pessoaDAO = new HorarioDAO();
		pessoaDAO.salvar(pessoa);

		assertTrue(pessoaDAO.listarTodos().size() > 0);

	}

}