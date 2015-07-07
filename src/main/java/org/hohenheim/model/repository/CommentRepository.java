package org.hohenheim.model.repository;

import org.hohenheim.model.entity.posting.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository extends BaseRepository<Comment> {

	public CommentRepository(){
		super(); 
	}
}
