package org.hohenheim.model.io;
import java.util.*;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hohenheim.model.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

/* @DB Class
 * @Last Updated: 24.06 22:23 by @Simon
 * @Description:
 *
 * Database Connector Class
 * This class is the implementation of IDBConnection interface. Use this class to get
 * access to the database. this is the class to interact with db(!). For description of
 * all methods, consult IDBConnection interface.
 *
 */

public class DBConnection<T extends BaseEntity> implements IDBConnection<T> {

	@Autowired
	private SessionFactory session;
	
	private Session getSession(){
		return this.session.getCurrentSession();
	}
	
	@Override
	public String getNameOfClass(T obj){
		return obj.getClass().getSimpleName();
	}
	
	@Override
	public List runQuery(String query){
		Session session = this.getSession();
		Transaction tr = null;
		List result = new ArrayList();
		
		try{
			tr = session.beginTransaction();
			
			Query _query = session.createQuery(query);
			result = _query.list();
			
			tr.commit();
		}
		catch(Exception e){
			if(tr != null)
				tr.rollback();
		}
		return result;
	}
	
	@Override
	public List getAllObjectsFromTable(T obj, boolean OrderedByCreation) {
		String query = "FROM " + this.getNameOfClass(obj) + " AS T";
		
		if(OrderedByCreation)
			query += " ORDERED BY T.Created ASC";
		
		return this.runQuery(query);
	}
	
	
	@Override
	public boolean deleteObject(T obj){
		String query = "DELETE FROM " + this.getNameOfClass(obj) + "WHERE ID = :id";
		int result = 0;
		
		try{
			Query q = this.getSession().createQuery(query);
			q.setParameter("id", obj.ID);
			result = q.executeUpdate();
		}
		catch(Exception e){
			
		}
		return (result != 0);
	}
	
	@Override
	public T getObjectById(int Id, T obj){
		String query = "SELECT FROM " + this.getNameOfClass(obj) + "WHERE ID = :id";
		List result = null;
		
		try{
			Query q = this.getSession().createQuery(query);
			q.setParameter("id", Id);
			result = q.list();
			
			if(result.size() > 0)
				return (T)result.get(0);
			else
				return null;
		}
		catch(Exception e){
			return null;
		}
	}
	
	@Override
	public List runQueryWithRestrictions(T obj, List<SimpleExpression> criterias, int paginate_start, int paginate_range){
		
		List result = new ArrayList();
		try{
			Criteria cr = this.getSession().createCriteria(obj.getClass());
		
			for(int i = 0; i < criterias.size(); i++)
				cr.add(criterias.get(i));
			
			if(paginate_start > 0)
				cr.setFirstResult(paginate_start);
			if(paginate_range != -1)
				cr.setMaxResults(paginate_range);
			
			result = cr.list();
		}
		catch(Exception e){
			
		}
		return result;
	}

	@Override
	public long saveObject(T obj){
		
		long result = (long)0;
		try{
			result = (long)this.getSession().save(obj);
		}
		catch(Exception e){
			
		}
		
		return result;
	}
	
	
}
