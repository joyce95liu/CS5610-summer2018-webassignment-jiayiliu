package com.example.myapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.models.Assignment;
import com.example.myapp.models.BaseQuestionJoined;
import com.example.myapp.models.Exam;
import com.example.myapp.models.FillInTheBlankQuestionJoined;
import com.example.myapp.models.Lesson;
import com.example.myapp.models.TrueOrFalseQuestionJoined;
import com.example.myapp.repositories.ExamRepository;
import com.example.myapp.repositories.FillInTheBlankQuestionRepositoryJoined;
import com.example.myapp.repositories.LessonRepository;
import com.example.myapp.repositories.TrueOrFalseQuestionRepositoryJoined;



@RestController
@CrossOrigin(origins = "*")
public class ExamService {
	@Autowired
	ExamRepository examRepository;
	@Autowired
	TrueOrFalseQuestionRepositoryJoined trueFalseRepository;
	@Autowired
	FillInTheBlankQuestionRepositoryJoined fillinRepo;
	@Autowired
	LessonRepository lessonRepository;
	
	@GetMapping("/api/exam")
	public List<Exam> findAllAssignments() {
		return (List<Exam>) examRepository.findAll();
	}
	
	@GetMapping("/api/exam/{examId}")
	public Exam findExamById(@PathVariable("examId") int id) {
		Optional<Exam> exam = examRepository.findById(id);
		if(exam.isPresent()) {
			return exam.get();
		}
		return null;
	}

	@GetMapping("/api/multi/{questionId}")
	public FillInTheBlankQuestionJoined findFillInBlankById(@PathVariable("questionId") int questionId) {
		Optional<FillInTheBlankQuestionJoined> optional =fillinRepo.findById(questionId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@GetMapping("/api/truefalse/{questionId}")
	public TrueOrFalseQuestionJoined findTrueFalseQuestionById(@PathVariable("questionId") int questionId) {
		Optional<TrueOrFalseQuestionJoined> optional = trueFalseRepository.findById(questionId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	@GetMapping("/api/exam/{examId}/question")
	public List<BaseQuestionJoined> findAllQuestionsForExam(@PathVariable("examId") int examId) {
		Optional<Exam> optionalExam = examRepository.findById(examId);
		if(optionalExam.isPresent()) {
			Exam exam = optionalExam.get();
			List<BaseQuestionJoined> questions = exam.getQuestions();
			return questions;
		}
		return null;
	}
	
    @PostMapping("/api/lesson/{lessonId}")   
	public Exam createExam(@PathVariable("lessonId") int lessonId, @RequestBody Exam newexam) {
	    Optional<Lesson> data = lessonRepository.findById(lessonId);
	    if(data.isPresent()) {
	        Lesson lesson = data.get();
	        newexam.setLesson(lesson);
	        return examRepository.save(newexam);
	    }
	    return null;
	}
    
	@PutMapping("/api/exam/{examId}")
	public Exam updateExam(@PathVariable("examId") int examId, @RequestBody Exam newexam) {
		Optional<Exam> optional = examRepository.findById(examId);
		if(optional.isPresent()) {
			Exam exam = optional.get();
			exam.setDescription(newexam.getDescription());
			exam.setTitle(newexam.getDescription());
			exam.setQuestions(newexam.getQuestions());
			examRepository.save(exam);
			return exam;
		}
		return null;
	}
    
}
