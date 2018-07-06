package com.example.myapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.models.BaseQuestionJoined;
import com.example.myapp.models.EssayQuestionJoined;
import com.example.myapp.models.Exam;
import com.example.myapp.models.FillInTheBlankQuestionJoined;
import com.example.myapp.models.MultipleChoiceQuestionJoined;
import com.example.myapp.models.TrueOrFalseQuestionJoined;
import com.example.myapp.repositories.BaseQuestionRepositoryJoined;
import com.example.myapp.repositories.EssayQuestionRepositoryJoined;
import com.example.myapp.repositories.ExamRepository;
import com.example.myapp.repositories.FillInTheBlankQuestionRepositoryJoined;
import com.example.myapp.repositories.MultipleChoiceQuestionRepositoryJoined;
import com.example.myapp.repositories.TrueOrFalseQuestionRepositoryJoined;



@RestController
public class ServiceJoined {
	@Autowired
	BaseQuestionRepositoryJoined baseRepo;
	@Autowired
	FillInTheBlankQuestionRepositoryJoined fillRepo;
	@Autowired
	TrueOrFalseQuestionRepositoryJoined trueRepo;
	@Autowired
	MultipleChoiceQuestionRepositoryJoined multiRepo;
	@Autowired
	EssayQuestionRepositoryJoined essayRepo;
	@Autowired
	ExamRepository examRepository;
//	@Autowired
//	ChoiceRepository choiceRepo;
	
	@PostMapping("/api/inheritance/joined/base")
	public BaseQuestionJoined createBaseQuestion() {
		BaseQuestionJoined q = new BaseQuestionJoined();
		q.setDescription("descriptions 123");
		q.setInstructions("instructions 123");
		q.setPoints("123");
		q.setTitle("title 123");
		return baseRepo.save(q);
	}
	
	
//	@PostMapping("/api/inheritance/joined/true")
//	public TrueOrFalseQuestionJoined createTrueQuestion(@RequestBody TrueOrFalseQuestionJoined question) {	
//		return trueRepo.save(question);
//	}
	
	@PostMapping("/api/exam/{examId}/inheritance/joined/true")
	public TrueOrFalseQuestionJoined createTrueOrFalseQuestion(
			@PathVariable("examId") int examId,
			@RequestBody TrueOrFalseQuestionJoined newQuestion) {
		Optional<Exam> data = examRepository.findById(examId);
		if(data.isPresent()) {
			Exam exam = data.get();
			newQuestion.setExam(exam);
			return trueRepo.save(newQuestion);
		}
		return null;		
	}
	
	@PostMapping("/api/exam/{examId}/inheritance/joined/multi")
	public MultipleChoiceQuestionJoined createMultipleChoiceQuestion(
			@PathVariable("examId") int examId,
			@RequestBody MultipleChoiceQuestionJoined newQuestion) {
		Optional<Exam> data = examRepository.findById(examId);
		if(data.isPresent()) {
			Exam exam = data.get();
			newQuestion.setExam(exam);
			return multiRepo.save(newQuestion);
		}
		return null;		
	}
	
	@PutMapping("/api/inheritance/joined/multi/{questionId}")
	public MultipleChoiceQuestionJoined updateMultipleChoiceQuestion(@PathVariable("questionId") int questionId, @RequestBody MultipleChoiceQuestionJoined question) {
		Optional<MultipleChoiceQuestionJoined> optional = multiRepo.findById(questionId);
		if(optional.isPresent()) {
			MultipleChoiceQuestionJoined mtquestion = optional.get();
			mtquestion.setPoints(question.getPoints());
			mtquestion.setInstructions(question.getInstructions());
			mtquestion.setDescription(question.getDescription());
			mtquestion.setOptions(question.getOptions());
			mtquestion.setCorrectOption(question.getCorrectOption());
			mtquestion.setTitle(question.getTitle());
			multiRepo.save(mtquestion);
			return mtquestion;
		}
		return null;
	}
	
	
	
	@PutMapping("/api/inheritance/joined/true/{questionId}")
	public TrueOrFalseQuestionJoined updateTrueOrFalseQuestion(@PathVariable("questionId") int questionId, @RequestBody TrueOrFalseQuestionJoined question) {
		Optional<TrueOrFalseQuestionJoined> optional = trueRepo.findById(questionId);
		if(optional.isPresent()) {
			TrueOrFalseQuestionJoined tfquestion = optional.get();
			tfquestion.setPoints(question.getPoints());
			tfquestion.setInstructions(question.getInstructions());
			tfquestion.setDescription(question.getDescription());
			tfquestion.setIsTrue(question.getIsTrue());
			tfquestion.setTitle(question.getTitle());
			trueRepo.save(tfquestion);
			return tfquestion;
		}
		return null;
	}
	
	@PostMapping("/api/exam/{examId}/inheritance/joined/essay")
	public EssayQuestionJoined createEssayQuestion(
			@PathVariable("examId") int examId,
			@RequestBody EssayQuestionJoined newQuestion) {
		Optional<Exam> data = examRepository.findById(examId);
		if(data.isPresent()) {
			Exam exam = data.get();
			newQuestion.setExam(exam);
			return essayRepo.save(newQuestion);
		}
		return null;		
	}
	
	@PutMapping("/api/inheritance/joined/essay/{questionId}")
	public EssayQuestionJoined updateEssayQuestion(@PathVariable("questionId") int questionId, @RequestBody EssayQuestionJoined question) {
		Optional<EssayQuestionJoined> optional = essayRepo.findById(questionId);
		if(optional.isPresent()) {
			EssayQuestionJoined essayquestion = optional.get();
			essayquestion.setPoints(question.getPoints());
			essayquestion.setInstructions(question.getInstructions());
			essayquestion.setDescription(question.getDescription());
			essayquestion.setText(question.getText());
			essayquestion.setTitle(question.getTitle());
			essayRepo.save(essayquestion);
			return essayquestion;
		}
		return null;
	}
	
	@PostMapping("/api/exam/{examId}/inheritance/joined/fill")
	public FillInTheBlankQuestionJoined createFillInBlankQuestion(
			@PathVariable("examId") int examId,
			@RequestBody FillInTheBlankQuestionJoined newQuestion) {
		Optional<Exam> data = examRepository.findById(examId);
		if(data.isPresent()) {
			Exam exam = data.get();
			newQuestion.setExam(exam);
			return fillRepo.save(newQuestion);
		}
		return null;		
	}
	
	@PutMapping("/api/inheritance/joined/fill/{questionId}")
	public FillInTheBlankQuestionJoined updateFillInBlankQuestion(@PathVariable("questionId") int questionId, @RequestBody FillInTheBlankQuestionJoined question) {
		Optional<FillInTheBlankQuestionJoined> optional = fillRepo.findById(questionId);
		if(optional.isPresent()) {
			FillInTheBlankQuestionJoined fillinquestion = optional.get();
			fillinquestion.setPoints(question.getPoints());
			fillinquestion.setInstructions(question.getInstructions());
			fillinquestion.setDescription(question.getDescription());
			fillinquestion.setVariables(question.getVariables());
			fillinquestion.setTitle(question.getTitle());
			fillRepo.save(fillinquestion);
			return fillinquestion;
		}
		return null;
	}
	
	@DeleteMapping("/api/question/{questionId}")
    public void deleteQuestion(
    @PathVariable("questionId") int id) {
		baseRepo.deleteById(id);
    }
	
//	@DeleteMapping("/api/choice/{choiceId}")
//    public void deleteChoicesForQuestion(
//    @PathVariable("choiceId") int id) {
//		choiceRepo.deleteById(id);
//    }
//	
//	@GetMapping("/api/question/{questionId}/choices")
//	public List<Choice> findAllChoicesForQuestion(@PathVariable("questionId") int questionId) {
//		Optional<MultipleChoiceQuestionJoined> optionalQuestion = multiRepo.findById(questionId);
//		if(optionalQuestion.isPresent()) {
//			MultipleChoiceQuestionJoined questions = optionalQuestion.get();
//			List<Choice> choices = questions.getChoices();
//			return choices;
//		}
//		return null;
//	}
//	
//	@PostMapping("/api/question/{questionId}/choice")
//	public Choice createChoiceForQuestion(
//			@PathVariable("questionId") int questionId,
//			@RequestBody Choice newChoice) {
//		Optional<MultipleChoiceQuestionJoined> optionalQuestion = multiRepo.findById(questionId);
//		if(optionalQuestion.isPresent()) {
//			MultipleChoiceQuestionJoined question = optionalQuestion.get();
//			newChoice.setMultiplechoicequestion(question);
//			return choiceRepo.save(newChoice);
//		}
//		return null;		
//	}

}
