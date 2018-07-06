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
import com.example.myapp.models.Lesson;
import com.example.myapp.repositories.AssignmentRepository;
import com.example.myapp.repositories.LessonRepository;



@RestController
@CrossOrigin(origins = "*")
public class AssignmentService {

	@Autowired
	AssignmentRepository assignmentRepository;
	@Autowired
	LessonRepository lessonRepository;

	
    @PostMapping("/api/lesson/{lessonId}/assignment")   
	public Assignment createAssignment(@PathVariable("lessonId") int lessonId, @RequestBody Assignment newassignment) {
	    Optional<Lesson> data = lessonRepository.findById(lessonId);
	    if(data.isPresent()) {
	        Lesson lesson = data.get();
	        newassignment.setLesson(lesson);
	        return assignmentRepository.save(newassignment);
	    }
	    return null;
	}
    
	@PutMapping("/api/assignment/{assignmentId}")
	public Assignment updateAssignment(@PathVariable("assignmentId") int assignmentId, @RequestBody Assignment newassignment) {
		Optional<Assignment> optional = assignmentRepository.findById(assignmentId);
		if(optional.isPresent()) {
			Assignment assignment = optional.get();
			assignment.setFile(newassignment.getFile());
			assignment.setLink(newassignment.getLink());
			assignment.setDescription(newassignment.getDescription());
			assignment.setEssay(newassignment.getEssay());
			assignment.setTitle(newassignment.getTitle());
			assignmentRepository.save(assignment);
			return assignment;
		}
		return null;
	}
	
//	@GetMapping("/api/lesson/{lessonId}/assignment")
//	public List<Widget> findAllAssignmentForLesson(@PathVariable("lessonId") int lessonId) {
//		Optional<Lesson> optionalLesson = lessonRepository.findById(lessonId);
//		if(optionalLesson.isPresent()) {
//			Lesson lesson = optionalLesson.get();
//			List<Widget> assignment = lesson.getWidgets();
//			return assignment;
//		}
//		return null;
//	}
	
	@GetMapping("/api/assignment")
	public List<Assignment> findAllAssignments() {
		return (List<Assignment>) assignmentRepository.findAll();
	}
}
