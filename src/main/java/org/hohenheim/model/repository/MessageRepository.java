package org.hohenheim.model.repository;

import org.hohenheim.model.entity.communication.Message;
import org.springframework.stereotype.Repository;;

@Repository
public class MessageRepository extends BaseRepository<Message> {

	public MessageRepository(){
		super();
	}
}
