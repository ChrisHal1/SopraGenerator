package org.hohenheim.model.entity.education;

import java.util.*;

import javax.persistence.*;
import org.hohenheim.model.entity.*;
import org.hohenheim.util.helper;

/* @Entity Class
 * @Last Updated: 24.06 00:05 by @Simon
 * @Description:
 * Question-Entity-Class.
 */

@Entity
public class Question extends BaseEntity {
	
	/*
	 * Fields
	 *******************/
	@Column(length=4096, nullable=false)
	public String text;
	public ArrayList<String> answers;
	@Column(nullable=false)
	public int solution;
	@Column(nullable=false)
	public int points;

	
	/*
	 * Constructor
	 *******************/
	public Question(Test fromTest){
		super();
		this.text = "";
		this.answers = new ArrayList<String>();
		
		/*Instantiate Relations*/
		this.fromTest = fromTest;
	}
	
	
	/*
	 * Relation mapping 
	 *******************/
	@ManyToOne
	public Test fromTest;

	
	/*
	 * Methods
	 *******************/
	public void setProperties(int solution, int points){
		this.solution = solution;
		this.points = points;
	}
	public void addQuestion(String question){
		helper.checkList(this.answers);
		
		this.answers.add(question);
	}
	public void deleteQuestion(int index){
		helper.checkList(this.answers);
		
		this.answers.remove(index);
	}
	public void setSolution(int solution){
		if(solution < 0 || solution >= this.answers.size())
			solution = 0;
		this.solution = solution;
	}

}
