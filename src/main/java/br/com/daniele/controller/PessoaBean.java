package br.com.daniele.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.daniele.model.Pessoa;
import br.com.daniele.repository.PessoaRepository;
import br.com.daniele.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PessoaBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private PessoaRepository pessoaRepository;
	
	@Inject
	private FacesMessages msg;
	
	private Pessoa pessoa;
	private List<Pessoa> todasPessoas = new ArrayList<Pessoa>();
	
	
	public PessoaBean(){
		pessoa = new Pessoa();
	}
	
	public void inicializar(){
		todasPessoas = this.pessoaRepository.todos();
	}
	
	public void cadastrar(){
		this.pessoaRepository.salvar(this.pessoa);
		msg.info("Usuário cadastrado com sucesso");
		
		pessoa = new Pessoa();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public List<Pessoa> getTodasPessoas() {
		return todasPessoas;
	}
	
	public List<Pessoa> pegarTudo(){
		List<Pessoa> ps = new ArrayList<Pessoa>();
		Pessoa p = new Pessoa();
		p.setNome("Ok");
		p.setEmail("Email");
		p.setId(20L);
		ps.add(p);
		return ps;
	}


}
