package br.com.teste.service;

import br.com.teste.entity.Teste;

public interface ITesteService {

	String SERVICE_JNDI = "java:global/comercial-app/comercial-business/TesteService";

	void salvar(Teste teste);

	Teste obterPorId(long id);

}