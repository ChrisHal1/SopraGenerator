package org.hohenheim.services;

import org.hohenheim.model.entity.communication.Message;
import org.hohenheim.model.entity.user.User;
import org.hohenheim.model.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* @Service class
 * @Last Updated: 07.07 14:15 by @Simon
 * @Description:
 *
 * Messaging Service class
 * This service provides methods to manage messages. It uses the MessageRepository to interact with the database.
 */

@Service
public class MessagingService extends BaseService {

	@Autowired
	MessageRepository messageRepository;
	
	public MessagingService() {
		super();
	}
	
	public boolean sendMessage(User from, User to, String content){
		Message message = new Message(from, to, content);
		/*from.send.add(message);
		to.received.add(message); */
		try {
			return this.messageRepository.save(message);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean getMessagesReceivedFromUser(User user, User from){
		return this.messageRepository.getMessagesReceivedFrom(user, from);
	}

}
