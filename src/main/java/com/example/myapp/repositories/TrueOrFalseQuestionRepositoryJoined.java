package com.example.myapp.repositories;
import org.springframework.data.repository.CrudRepository;

import com.example.myapp.models.TrueOrFalseQuestionJoined;

public interface TrueOrFalseQuestionRepositoryJoined
	extends CrudRepository<TrueOrFalseQuestionJoined, Integer>{}