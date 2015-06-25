package org.hohenheim.model.entity.education;

import java.util.*;
import javax.persistence.*;
import org.hohenheim.model.entity.*;

/* @Entity Class
 * @Last Updated: 24.06 00:05 by @Simon
 * @Description:
 * Test-Entity-Class.
 */

@Entity
public class Test extends BaseEntity {
	
	/*
	 * Fields
	 *******************/
	public boolean passed;
	public boolean taken;
	@Column(nullable=false)
	public int points;
	@Column(nullable=false)
	public int pointsToPass;
	/*date: When was Test taken. this differs from created/updated timestampes.*/
	public Date takenDate;

	
	/*
	 * Constructor
	 *******************/
	public Test(Group group){
		super();
		this.passed = false;
		this.taken = false;
		this.points = 0;
		
		/*Instantiate Relations*/
		this.inGroup = group;
		this.questions = new ArrayList<Question>();
	}


	/*
	 * Relation mapping
	 *******************/
	@ManyToOne
	public Group inGroup;
	
	@OneToMany(mappedBy="fromTest")
	public List<Question> questions;
	

	/*
	 * Methods
	 *******************/
	public void testTaken(){
		this.takenDate = new Date();
		this.taken = true;
	}
	
	public int getMaximumPoints(){
		int xpoints = 0;
		for(int i = 0; i < this.questions.size(); i++){
			xpoints += this.questions.get(i).points;
		}
		
		return xpoints;
	}
	
	public void addQuestion(Question nQuestion){
		if(this.questions == null)
			this.questions = new ArrayList<Question>();
		
		this.questions.add(nQuestion);
	}
	
	public void removeQuestions(Question nQuestion){
		if(this.questions == null){
			this.questions = new ArrayList<Question>();
			return;
		}
		else
		this.questions.remove(nQuestion);
	}
}
