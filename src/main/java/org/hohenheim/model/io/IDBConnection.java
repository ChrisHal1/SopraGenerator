package org.hohenheim.model.io;

import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.SimpleExpression;
import org.hohenheim.model.entity.BaseEntity;

/* @Interface
 * @Last Updated: 24.06 22:23 by @Simon
 * @Description:
 *
 * Database Connector Interface
 * This Interface is for the generic DBConnector Class. Consult this interface to get an
 * overview of all methods u can use with this class, thus no need to refer to the implementation.
 * 
 * This interface provides all methods u can use to interact with the database.
 * 
 * This interface(and so the class) is generic, so u can use it for every Class that derives from
 * org.hohenheim.model.entity.BaseEntity (every entity class stored in the db).
 *
 */

interface IDBConnection<T extends BaseEntity> {

/*
 * Methods (public only)
 *******************/ 
	
	/*
	 * This will get you the name of the class T as String.
	 * 
	 * @param obj: an object of type T(why? see description of function below).
	 */
	public String getNameOfClass(T obj);
	
	
	/*
	 * This will return you a list of all entitys stored in a specific table
	 * (all persisted objects of a type, e.g. all users or all posts).
	 * 
	 * @param obj:	an object of the type you want to get all persisted objects of. This
	 * object is of the same type as the one you already provided when you created the
	 * IDBConnection class instance.
	 * This duplication is necessary because its impossible to determine T inside the class,
	 * so you have to provide it here again.
	 * @param OrderedByCreation:  set this to true if the list should be ordered by the creation date of the object in ascending order.
	 */
	public List getAllObjectsFromTable(T obj, boolean OrderedByCreation);
	
	/*
	 * This will execute a given query and return the results.
	 * If possible, dont use this method directly, first check if a more appropriate method
	 * exists for your needs. Most methods use this method to run their query, but you should use those methods
	 * as they construct the query based on your parameters, which is more safe and unlikely to produce errors
	 * in the query string.
	 */
	public List runQuery(String query);

	
	/*
	 * hibernate enables you to provide multiple criterias to a query.
	 * These criterias are represented by SimpleExpression objects. Use this method
	 * to run a query on the T table with the given criterias. (they are created using Restriction.function(...):
	 * SimpleExpression example = Restrictions.eq("name", "Simon");
	 * This method also supports pagination, where only entrys starting at row X up to row Y are returned.
	 * Provide the range as params (see blow). If you dont want to use this, set both to -1
	 * @param obj:  object of type T
	 * @param criteras: List of Restrictions you want to apply.
	 * @paginate_start: starting at what entry?
	 * @paginate_end: how many entrys?
	 * @return: List of all objects out of the T table that meet all criterias.
	 */
	public List runQueryWithRestrictions(T obj, List<SimpleExpression> criterias, int paginate_start, int paginate_range);

	/*
	 * Deletes an object (using its id).
	 * @param obj:	The object that should be deleted.
	 * @return:		true if successful, false if not.
	 */
	public boolean deleteObject(T obj);
	
}