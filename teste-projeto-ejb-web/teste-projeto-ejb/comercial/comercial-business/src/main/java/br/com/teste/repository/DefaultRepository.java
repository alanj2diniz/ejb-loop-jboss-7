package br.com.teste.repository;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Stateless(name = "DefaultRepository")
@Remote(IDefaultRepository.class)
public class DefaultRepository<T> implements IDefaultRepository<T> {

private Class<T> type;
	
	@PersistenceContext(unitName = "PortalPU")
	private EntityManager entityManager;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DefaultRepository() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		this.type = (Class) pt.getActualTypeArguments()[0];
	}

	@Override
	public T findById(Long id) {
		return this.entityManager.find(type, id);
	}
	
	@Override
	public T findById(String id) {
		return this.entityManager.find(type, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return createSession().createCriteria(type).list();
	}

	public void delete(Object object) {
		this.entityManager.remove(object);
	}
	
	@Override
	public void create(Object object) {
		this.entityManager.persist(object);
	}

	@Override
	public void update(Object object) {
		this.entityManager.merge(object);
	}
	
	protected Session createSession() {
		return (Session) this.entityManager.getDelegate();
	}
	
	protected Criteria createCriteria(){
		return createSession().createCriteria(this.type);
	}

	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

	@Override
	public T getReference(Long id) {
		return this.getEntityManager().getReference(this.type, id);
	}
	
}