package com.example.myapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.myapp.models.MultipleChoiceQuestionJoined;

public interface MultipleChoiceQuestionRepositoryJoined 
extends CrudRepository<MultipleChoiceQuestionJoined, Integer>{

}
