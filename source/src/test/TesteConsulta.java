package test;

import static org.junit.Assert.*;
import org.junit.Test;

import dao.ConsultaDAO;
import model.Consulta;

public class TesteConsulta {
	private ConsultaDAO pessoaDAO;
	private Consulta pessoa;

	@Test
	public void testSalvar() {
		pessoa = new Consulta();

		pessoa.setId(1);
		pessoa.setNome("Teste Inserção Cliente");
		pessoa.setEmail("pessoa@teste.com");
		pessoa.setTelefone("4599991231");

		pessoaDAO = new ConsultaDAO();
		pessoaDAO.salvar(pessoa);

		assertTrue(pessoaDAO.listarTodos().size() > 0);

	}

}