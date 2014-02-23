package br.com.teste.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.teste.entity.Teste;
import br.com.teste.service.ITesteService;

@ManagedBean
@SessionScoped
public class TesteController  {

	@EJB(lookup = ITesteService.SERVICE_JNDI)
	private ITesteService testeService;
	
	public void testar() {
		System.out.println("chamou");
		exemplo1();
		//exemplo2();
	}
	
	private void exemplo1() {
		System.out.println("chamou");
		Teste teste = this.testeService.obterPorId(1L);
	}
	
	private void exemplo2() {
		Teste teste = new Teste();
		teste.setTeste("teste");
		this.testeService.salvar(teste);
	}
	
}