package br.com.daniele.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.daniele.model.Pessoa;
import br.com.daniele.util.jpa.Transactional;

public class PessoaRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	@Transactional
	public void salvar(Pessoa pessoa){
		manager.persist(pessoa);
	}
	
	public List<Pessoa> todos(){
		return manager.createQuery("from Pessoa", Pessoa.class).getResultList();
	}

}
