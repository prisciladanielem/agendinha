package controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.ConsultaDAO;
import model.Consulta;

@ManagedBean
public class ConsultaMB {
	private Consulta consulta;
	private ConsultaDAO consultaDAO;
	private List<Consulta> Lista;	
	
	public ConsultaMB() {
		consultaDAO = new ConsultaDAO();
		consulta = new Consulta();
		
		Lista = consultaDAO.listarTodos();				
	}
	
	public void salvar() {
		consultaDAO.salvar(consulta);
		consulta = new Consulta();
		Lista = consultaDAO.listarTodos();

		addMessage("consulta salvo com sucesso!!");
		
	}
	
	public void addMessage(String summary) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public Consulta getconsulta(){
		return this.consulta;
	}
	
	public void setconsulta(Consulta consulta){
		this.consulta = consulta;
	}
	
	public List<Consulta> getList() {
		return this.Lista;
	}
	
	public void retornaLista() {
		Lista = getList();
	}
	
}	
    
