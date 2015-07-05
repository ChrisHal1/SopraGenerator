package org.hohenheim.model.repository;

import org.hohenheim.model.entity.education.Question;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionRepository extends BaseRepository<Question> {

	public QuestionRepository(){
		super();
	}
}
