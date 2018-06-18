package com.example.myapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.models.Course;
import com.example.myapp.models.Lesson;
import com.example.myapp.models.Module;
import com.example.myapp.models.Widget;
import com.example.myapp.repositories.LessonRepository;
import com.example.myapp.repositories.WidgetRepository;

@RestController
@CrossOrigin(origins = "*")
public class WidgetService {
	@Autowired
	WidgetRepository repository;
	
	@Autowired
	LessonRepository lessonrepository;
	
//	@GetMapping("/api/widget")
//public List<Widget> findAllWidgets(){
//	return (List<Widget>)repository.findAll();
//}
	@GetMapping("/api/lesson/{lessonId}/widget")
public List<Widget> findAllWidgets(@PathVariable("lessonId") int lessonId){
		Optional<Lesson> data = lessonrepository.findById(lessonId);
		if (data.isPresent()) {
			Lesson lesson = data.get();
			return lesson.getWidgets();
		}
		return null;
}
	
	@PostMapping("/api/lesson/{lessonId}/widget/save")
		public void saveAllWidgets(@PathVariable("lessonId") int lessonId, @RequestBody List<Widget> widgets) {
		Optional<Lesson> data = lessonrepository.findById(lessonId);
		if (data.isPresent()) {
			Lesson lesson = data.get();
			 for (Widget widget:lesson.getWidgets()) {
			repository.delete(widget);
			 }
			 
			for (Widget newwidget:widgets) {
			newwidget.setLesson(lesson);
			repository.save(newwidget);
		     }
		
		}
		
	}
}
