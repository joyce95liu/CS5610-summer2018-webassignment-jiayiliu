package com.example.myapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.myapp.models.FillInTheBlankQuestionJoined;



public interface FillInTheBlankQuestionRepositoryJoined
	extends CrudRepository<FillInTheBlankQuestionJoined, Integer>{

}