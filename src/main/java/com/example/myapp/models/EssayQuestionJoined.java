package com.example.myapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "JOINED_ESSAY_QUESTION")
public class EssayQuestionJoined 
		extends BaseQuestionJoined {
		@Column(name = "VARIABLES", nullable = false)
		private String text;
		
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
	}
