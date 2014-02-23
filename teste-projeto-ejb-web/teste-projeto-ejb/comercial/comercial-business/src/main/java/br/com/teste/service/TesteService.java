package br.com.teste.service;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.teste.entity.Teste;
import br.com.teste.repository.ITesteRepository;

@Stateless(name = "TesteService")
@Remote(ITesteService.class)
public class TesteService implements ITesteService {

	@EJB
	private ITesteRepository testeRepository;

	@Override
	public void salvar(Teste teste) {
		this.testeRepository.create(teste);
	}

	@Override
	public Teste obterPorId(long id) {
		//return this.testeRepository.findById(id);
		return this.testeRepository.obterPorId(id);
	}
	
}