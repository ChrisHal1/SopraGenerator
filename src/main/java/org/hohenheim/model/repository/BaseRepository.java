package org.hohenheim.model.repository;

import java.lang.reflect.ParameterizedType;
import java.util.*;

import org.hibernate.*;
import org.hibernate.criterion.SimpleExpression;
import org.hohenheim.model.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/* @Repository base class
 * @Last Updated: 05.07 21:24 by @Simon
 * @Description:
 *
 * Repository Base class
 * This Repository is the base class for every repository. It provides some simple and often used methods
 * for managing, persisting and retrieving objects of an entity type to database. Every entity type must have
 * its own repository, inheriting from this class.
 * This class represents the interface for the db.
 * 
 *
 */

@Transactional
@Repository
public abstract class BaseRepository<T extends BaseEntity> implements IRepository<T> {

	@Autowired
	protected SessionFactory session;
	public void setSession(SessionFactory session){ this.session = session; }
	
	public BaseRepository() {
	}
	
	protected Session getSession(){
		return this.session.getCurrentSession();
	}
	
	@Override
	public String getNameOfClass(){
		return ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();

	}
	
	@Override
	public boolean save(T obj) throws Exception{
		
		return (boolean)((long)this.getSession().save(obj) > 0);
	}
	
	@Override
	public boolean delete(T obj){
		String query = "DELETE FROM " + this.getNameOfClass() + "WHERE ID = :id";
		int result = 0;
		
		try{
			Query q = this.getSession().createQuery(query);
			q.setParameter("id", obj.ID);
			result = q.executeUpdate();
		}
		catch(HibernateException e){
			
		}
		return (result != 0);
	}

	@Override
	public List<T> runQuery(String query){
		Session session = this.getSession();
		
		try{
			Query _query = session.createQuery(query);
			return (List<T>)_query.list();
		}
		catch(HibernateException e){
		}
		return new ArrayList<T>();
	}
	
	@Override
	public List<T> getAllObjectsFromTable(boolean OrderedByCreation) {
		String query = "from " + this.getNameOfClass() + " as T";
		
		if(OrderedByCreation)
			query += " order by T.Created asc";
		
		return (List<T>)this.runQuery(query);
	}
	
	@Override
	public T getById(long Id){
		String query = "from " + this.getNameOfClass() + " as T where T.ID = :id";
		List<T> result = null;
		
		try{
			Query q = this.getSession().createQuery(query);
			q.setParameter("id", Id);
			result = (List<T>)q.list();
			
			if(result.size() > 0)
				return (T)result.get(0);
			else
				return null;
		}
		catch(HibernateException e){
			return null;
		}
	}
	@Override
	public T getByUniqueAttribute(String attribute, String value){
		String query = "from " + this.getNameOfClass() + " as T where T." + attribute + " = :val";
		List<T> result = null;
		
		try{
			Query q = this.getSession().createQuery(query);
			q.setParameter("val", value);
			result = (List<T>)q.list();
			
			if(result.size() > 0)
				return (T)result.get(0);
			else
				return null;
		}
		catch(HibernateException e){
			return null;
		}
	}
	
	@Override
	public List<T> runQueryWithRestrictions(Class<T> Tclass, List<SimpleExpression> criterias, int paginate_start, int paginate_range){
		
		List<T> result = new ArrayList<T>();

		try{
			Criteria cr = this.getSession().createCriteria(Tclass);
		
			for(int i = 0; i < criterias.size(); i++)
				cr.add(criterias.get(i));
			
			if(paginate_start > 0)
				cr.setFirstResult(paginate_start);
			if(paginate_range != -1)
				cr.setMaxResults(paginate_range);
			
			result = (List<T>)cr.list();
		}
		catch(HibernateException e){
			
		}
		return result;
	}

}
