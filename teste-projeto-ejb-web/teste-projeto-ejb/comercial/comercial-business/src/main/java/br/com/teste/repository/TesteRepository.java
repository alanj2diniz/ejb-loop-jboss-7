package br.com.teste.repository;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.hibernate.SQLQuery;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;

import br.com.teste.entity.Teste;

@Stateless(name = "TesteRepository")
@Local(ITesteRepository.class)
public class TesteRepository extends DefaultRepository<Teste> implements ITesteRepository  {

	@Override
	public Teste obterPorId(long id) {
		SQLQuery query = createSession().createSQLQuery("select id, teste from teste where id = :id ");
		
		query.setParameter("id", id);
		
		query.addScalar("id", LongType.INSTANCE);
		query.addScalar("teste", StringType.INSTANCE);
		
		return (Teste) query.uniqueResult();
	}

}