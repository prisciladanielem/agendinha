package test;

import org.junit.Assert;
import org.junit.Test;

import controller.UsuarioMB;
import dao.UsuarioDAO;

import model.Usuario;

public class UsuariosTest {
	
	private UsuarioDAO usuarioDAO;
	private UsuarioMB usuarioMB;
	private Usuario usuario;

	@Test
	public void DeveRetornarSucessoQuandoOUsuarioForCriadoCorretamente() {
		 usuario = new Usuario();
		 
		 usuario.setId(1);
		 usuario.setNome("Priscila Moreira");
		 usuario.setCpf("13006273605");
		 usuario.setSenha("123456");
		 usuario.setAdministrador(true);
		 
		 usuarioDAO = new UsuarioDAO();
		 usuarioDAO.inserirUsuario(usuario);
		 
		 usuarioMB = new UsuarioMB();
		 usuarioMB.cadastrarUsuario();
		 
		 Assert.assertEquals(1, usuario.getId());
		 Assert.assertEquals("Priscila Moreira", usuario.getNome());
	}
	
	@Test
	public void DeveRetornarSucessoQuandoOUsuarioForDeletado() {
		 usuario = new Usuario();
		 
		 usuario.setId(2);
		 usuario.setNome("Priscila Moreira");
		 usuario.setCpf("13006273645");
		 usuario.setSenha("123456");
		 usuario.setAdministrador(true);
		 
		 usuarioDAO = new UsuarioDAO();
		 usuarioDAO.inserirUsuario(usuario);
		 usuarioDAO.deletarUsuario(usuario);
		 
		 Assert.assertNull(usuario);
		 
	}
}
