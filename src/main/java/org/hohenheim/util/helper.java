package org.hohenheim.util;

import java.util.*;


/* @Tool Class
 * @Last Updated: 25.06 21:02 by @Simon
 * @Description:
 * Contains static helper functions we may often need.
 */

public abstract class helper {

	
	/*
	 * Returns the classname of an object as string. This cannot be used in generic classes.
	 * @param obj:	The object you want to get the type of.
	 * @return:	The class name as string.
	 */
	static public String getNameOfClass(Object obj){
		return obj.getClass().getSimpleName();
	}
	
	/*
	 * check if a list is initialized. If its not, it is automatically initialized.
	 * @param list:	The list
	 * @return:		true if list is not null (initialized).
	 */
	static public <T> boolean checkList(List<T> list){
		if(list != null)
			return true;
		else{
			list = new ArrayList<T>();
			return false;
		}
	}
	/*
	 * check if a set is initialized. If its not, it is automatically initialized.
	 * @param set:	The set
	 * @return:		true if list is not null (initialized).
	 */
	static public <T> boolean checkSet(Set<T> set){
		if(set != null)
			return true;
		else{
			set = new TreeSet<T>();
			return false;
		}
	}

}
