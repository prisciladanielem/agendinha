package controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.HorarioDAO;
import model.Horario;

@ManagedBean
public class HorarioMB {
	private Horario horario;
	private HorarioDAO horarioDAO;
	private List<Horario> Lista;	
	
	public HorarioMB() {
		horarioDAO = new HorarioDAO();
		horario = new Horario();
		
		Lista = horarioDAO.listarTodos();				
	}
	
	public void salvar() {
		horarioDAO.salvar(horario);
		horario = new Horario();
		Lista = horarioDAO.listarTodos();

		addMessage("consulta salvo com sucesso!!");
		
	}
	
	public void addMessage(String summary) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public List<Horario> getList() {
		return this.Lista;
	}
	
	public void retornaLista() {
		Lista = getList();
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	
}	
    
