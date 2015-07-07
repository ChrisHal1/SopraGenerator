package org.hohenheim.model.repository;

import java.util.List;

import org.hohenheim.model.entity.communication.Message;
import org.hohenheim.model.entity.user.User;
import org.springframework.stereotype.Repository;;

/* @Repository class
 * @Last Updated: 07.07 14:24 by @Simon
 * @Description:
 *
 * Message Repository
 * This Repository provides methods to manage messages within the database.
 * 
 *
 */

@Repository
public class MessageRepository extends BaseRepository<Message> {

	public MessageRepository(){
		super();
	}
	
	public List<Message> getConversation(User recipient, User sender){
		try{
			return this.runQuery("FROM Message AS M WHERE M.recipient = '" + recipient +  "' AND M.sender = '" + sender + "'");
		}
		catch(Exception e){
			return null;
		}
	}
}
