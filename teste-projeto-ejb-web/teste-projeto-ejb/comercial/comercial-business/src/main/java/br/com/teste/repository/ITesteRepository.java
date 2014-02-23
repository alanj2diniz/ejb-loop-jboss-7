package br.com.teste.repository;

import br.com.teste.entity.Teste;

public interface ITesteRepository extends IDefaultRepository<Teste>  {

	Teste obterPorId(long id);

}