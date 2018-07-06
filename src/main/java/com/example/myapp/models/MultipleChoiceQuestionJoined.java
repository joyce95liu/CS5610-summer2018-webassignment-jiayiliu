package com.example.myapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "JOINED_MULTIPLE_CHOICE_QUESTION")
public class MultipleChoiceQuestionJoined extends BaseQuestionJoined {
	@Column(name = "OPTIONS", nullable = false)
	private String options;	
	private String correctoption;
	
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public String getCorrectOption() {
		return correctoption;
	}
	public void setCorrectOption(String correctoption) {
		this.correctoption = correctoption;
}
}

