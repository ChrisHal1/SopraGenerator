package org.hohenheim.model.repository;

import org.hohenheim.model.entity.BaseEntity;

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
	 * Use this method to save an object of entity type T.
	 * @param Entity:	Entity to save in database.
	 * @return:			true if successful.
	 */
	public boolean save(T Entity);
	
	/*
	 * Use this method to delete the "Entity" object of type T.
	 * @param entity:	entity to delete from database.
	 * @return:			true if successful.
	 */
	public boolean delete(T Entity);
	
	/*
	 * Use this method to fetch an object by id.
	 * @param id:	The id of the object you want to fetch.
	 * @return:		The object with id = Id.
	 */
	public T getById(int Id);
}
