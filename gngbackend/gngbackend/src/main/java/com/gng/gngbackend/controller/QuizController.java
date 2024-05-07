package com.gng.gngbackend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gng.gngbackend.model.Question;
import com.gng.gngbackend.model.Quiz;
import com.gng.gngbackend.model.QuizQuestion;
import com.gng.gngbackend.service.QuizService;

@RestController
@RequestMapping("/api/quizzes")
@CrossOrigin(origins = "http://localhost:3306")
public class QuizController {
	
	private final QuizService quizService;
	
	public QuizController(QuizService quizService) {
		this.quizService = quizService;
	}
	
	@PostMapping
	public Quiz createQuiz(@RequestBody Quiz quiz) {
		List<QuizQuestion> quizQuestions = quiz.getQuizQuestions();
		for(QuizQuestion quizQuestion : quizQuestions) {
			quizQuestion.setQuiz(quiz); // Set the quiz for each quiz question
		}
		return quizService.createQuiz(quiz);
	}
	
	@GetMapping("/{id}")
	public Quiz getQuizById(@PathVariable Long id) {
		return quizService.getQuizById(id);
	}
	
	@PutMapping("/{id}")
	public Quiz updateQuiz(@PathVariable Long id, @RequestBody Quiz quiz) {
		return quizService.updateQuiz(id, quiz);
	}
	
	@DeleteMapping("/{id}")
	public void deleteQuiz(@PathVariable Long id) {
		quizService.deleteQuiz(id);
	}
	
	@GetMapping("/getQuizQuestById/{id}")
	public List<Question> getQuizQuestById(@PathVariable Long id){
		System.out.println("Inside get quiz quest by id");
		return quizService.getQuizQuestById(id);
	}
	
}