package br.com.daniele.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.daniele.util.jsf.FacesMessages;

@Named
@ViewScoped
public class LoginBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String usuario;
	private String senha;
	
	@Inject
	private FacesMessages msg;
	
	public String logar(){
		if(!this.usuario.equals("admin") && !this.senha.equals("admin")){
			msg.error("Usuário não cadastrado");
			return null;
		}
		return "CadastroPessoa.xhtml?faces-redirect=true";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
