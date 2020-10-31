package br.edu.faculdadedelta.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.faculdadedelta.dao.ServicoDAOGabriel;
import br.edu.faculdadedelta.modelo.ServicoGabriel;

@ManagedBean
@SessionScoped
public class ServicoControllerGabriel {
private ServicoGabriel servico = new ServicoGabriel();
private ServicoDAOGabriel dao = new ServicoDAOGabriel();


public ServicoGabriel getServico() {
	return servico;
}
public void setServico(ServicoGabriel servico) {
	this.servico = servico;
}
public void limparcampos() {
	servico = new ServicoGabriel();
}
public String salvar() {
	try {
		if(servico.getId() == null){
		
			dao.incluir(servico);
			FacesMessage mensagem = new FacesMessage("Inclusao Realizada!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			limparcampos();
	}else{
		dao.alterar(servico);
		FacesMessage mensagem = new FacesMessage("Alteraçao realiazada com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
		limparcampos();
	} 
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			FacesMessage mensagem = new FacesMessage("Erro ao Realizar operaçao"
					+ " tente novamente mais tarde!!" + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			limparcampos();
			}
			
	return"CadastroServico.xhmtl";
	
}
public List<ServicoGabriel> getlista(){
	List<ServicoGabriel> listaRetorno = new ArrayList<ServicoGabriel>();
	try {
		listaRetorno = dao.listar();
	} catch (ClassNotFoundException | SQLException e) {
		FacesMessage mensagem = new FacesMessage("Erro ao Realizar operaçao"
				+ " tente novamente mais tarde!!" + e.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
		e.printStackTrace();
	}
	return listaRetorno;
}
public String editar() {
	
	return "CadastroServico.xhtml";
}
public String excluir() {
	try {
		dao.excluir(servico);
		
		FacesMessage mensagem = new FacesMessage("Exclusao realizada");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
		limparcampos();
		
	} catch (ClassNotFoundException | SQLException e) {
		
		FacesMessage mensagem = new FacesMessage("Erro ao Realizar operaçao"
				+ " tente novamente mais tarde!!" + e.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
		e.printStackTrace();
	}
	return "ListaServico.xhtml";
}
}
