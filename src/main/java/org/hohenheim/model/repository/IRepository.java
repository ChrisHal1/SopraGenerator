package org.hohenheim.model.repository;

import java.util.*;

import org.hibernate.criterion.SimpleExpression;
import org.hohenheim.model.entity.BaseEntity;
import org.hohenheim.util.ORDER;

/* @Interface
 * @Last Updated: 25.06 15:29 by @Simon
 * @Description:
 *
 * Repository Interface
 * This Interface is the base interface for Repository Class, which is the superclass for every repository.
 * Every Entity has its own repository, but every repository inherits these methods from repository class.
 * 
 * Repositorys manage entitys and their representation in the database. Use repositorys to add, remove, update etc. entitys.
 * Entitys use DBConnection class to interact with database, this class contains generic methods for general interaction with db.
 *
 */

public interface IRepository<T extends BaseEntity> {

	/*
	 * returns you the name of T class as string. 
	 */
	
	public String getNameOfClass();
	
	/*
	 * Use this method to save an object of entity type T.
	 * @param Entity:	Entity to save in database.
	 * @return:			true if successful.
	 */
	public boolean save(T Entity) throws Exception;
	
	/*
	 * Use this method to delete the "Entity" object of type T.
	 * @param entity:	entity to delete from database.
	 * @return:			true if successful.
	 */
	public boolean delete(T Entity) throws Exception;
	
	/*
	 * Use this method to fetch an object by id.
	 * @param id:	The id of the object you want to fetch.
	 * @return:		The object with id = Id.
	 */
	public T getById(long Id) throws Exception;
	
	/*
	 * Use this method to fetch an object by any attribute (should be unique).
	 * @param attribute:	The Name of the attribute.
	 * @param value:		The value of the object to fetch for that attribute.
	 */
	public T getByUniqueAttribute(String attribute, String value) throws Exception;

	/*
	 * run a simple SQL-Query.
	 */
	public List<T> runQuery(String query) throws Exception;

	/*
	 * Get all saved objects of a specific entity-type.
	 * specify the prefered order with an org.hohenheim.util.ORDER constant.
	 */
	public List<T> getAllObjectsFromTable(ORDER order) throws Exception;

	/*
	 * Run a query with Expression objects.
	 */
	public List<T> runQueryWithRestrictions(Class<T> Tclass, List<SimpleExpression> criterias, int paginate_start, int paginate_range) throws Exception;

}
