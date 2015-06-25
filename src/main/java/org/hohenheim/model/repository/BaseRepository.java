package org.hohenheim.model.repository;

import org.hohenheim.model.entity.BaseEntity;
import org.hohenheim.model.io.DBConnection;
import org.springframework.stereotype.Repository;

/* @Repository base class
 * @Last Updated: 25.06 15:36 by @Simon
 * @Description:
 *
 * Repository Base class
 * This Repository is the base class for every repository. It provides some simple and often used methods
 * for managing, persisting and retrieving objects of an entity type to database. Every entity type must have
 * its own repository, inheriting from this class.
 * 
 *
 */

@Repository
public abstract class BaseRepository<T extends BaseEntity> implements IRepository<T> {

	private DBConnection<T> db;
	
	public BaseRepository() {
		this.db = new DBConnection<T>();
	}

	@Override
	public boolean save(T entity){
		try{
			return (this.db.saveObject(entity) != 0);
		}
		catch(Exception e){
			return false;
		}
	}
	
	@Override
	public boolean delete(T entity){
		try{
			return (this.db.deleteObject(entity));
		}
		catch(Exception e){
			return false;
		}
	}
	
	@Override
	public T getById(int Id){
		//todo
		return null;
	}

}
