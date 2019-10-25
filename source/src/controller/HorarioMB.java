package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.HorarioDAO;
import model.Horario;
import model.HorarioCliente;

@ManagedBean
public class HorarioMB {
	private Horario horario;
	private HorarioCliente horarioCliente;
	private List<HorarioCliente> listHorarioCliente;
	private List<String> listHora;
	private HorarioDAO horarioDAO;
	private List<Horario> Lista;

	public HorarioMB() {
		horarioDAO = new HorarioDAO();
		horario = new Horario();
		horarioCliente = new HorarioCliente();
		listHora = new ArrayList<String>();

		Lista = horarioDAO.listarTodos();
	}

	public void salvar() {

		horarioDAO.salvar(horario);
		horario = new Horario();
		Lista = horarioDAO.listarTodos();

		addMessage("Horario salvo com sucesso!!");
	}

	public void salvaDataHorar() throws ParseException {

		horarioDAO.salvarDataHora(horarioCliente);
		horarioCliente = new HorarioCliente();

		addMessage("Data e Hora salvo com sucesso!!");
	}

	public List<String> buscarHoraPelaData(Date data) {
		listHorarioCliente = horarioDAO.sdfsdfos(data);
		listHora = new ArrayList<String>();
		for (HorarioCliente horarioCliente : listHorarioCliente) {

			listHora.add(horarioCliente.getHora());
		}

		return listHora;

	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
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

	public HorarioCliente getHorarioCliente() {
		return horarioCliente;
	}

	public void setHorarioCliente(HorarioCliente horarioCliente) {
		this.horarioCliente = horarioCliente;
	}

	public List<HorarioCliente> getListHorarioCliente() {
		return listHorarioCliente;
	}

	public void setListHorarioCliente(List<HorarioCliente> listHorarioCliente) {
		this.listHorarioCliente = listHorarioCliente;
	}

	public List<String> getListHora() {
		return listHora;
	}

	public void setListHora(List<String> listHora) {
		this.listHora = listHora;
	}

}
