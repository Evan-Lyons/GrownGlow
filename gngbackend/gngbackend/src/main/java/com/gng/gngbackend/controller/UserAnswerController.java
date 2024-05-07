package com.gng.gngbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gng.gngbackend.dto.UserAnswerDTO;
import com.gng.gngbackend.model.Question;
import com.gng.gngbackend.model.User;
import com.gng.gngbackend.model.UserAnswers;
import com.gng.gngbackend.repository.QuestionRepository;
import com.gng.gngbackend.repository.UserAnswerRepository;
import com.gng.gngbackend.repository.UserRepository;
import com.gng.gngbackend.service.UserAnswerService;

@RestController
@RequestMapping("/api/user-answers")
@CrossOrigin(origins = "http://localhost:3306")
public class UserAnswerController {
	
	private final UserAnswerService userAnswerService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private UserAnswerRepository userAnswerRepository;
	
	public UserAnswerController(UserAnswerService userAnswerService) {
		this.userAnswerService = userAnswerService;
	}
	
	@PostMapping
	public UserAnswers createUserAnswer(@RequestBody UserAnswerDTO userAnswerDto) {
		User user = userRepository.findById(userAnswerDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("User not found"));
		Question question = questionRepository.findById(userAnswerDto.getQuestionId()).orElseThrow(() -> new IllegalArgumentException("Question not found"));
		
		UserAnswers userAnswer = new UserAnswers();
		userAnswer.setUser(user);
		userAnswer.setQuestion(question);
		userAnswer.setSelectedOption(userAnswerDto.getSelectedOption());
		
		return userAnswerRepository.save(userAnswer);
	}
	
	@GetMapping("/{id}")
	public UserAnswers getUserAnswerById(@PathVariable Long id) {
		return userAnswerService.getUserAnswerById(id);
	}
	
	@PutMapping("/{id}")
	public UserAnswers updateUserAnswer(@PathVariable Long id, @RequestBody UserAnswers userAnswer) {
		return userAnswerService.updateUserAnswer(id, userAnswer);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserAnswer(@PathVariable Long id) {
		userAnswerService.deleteUserAnswer(id);
	}
	
	@GetMapping
	public List<UserAnswers> getAllUserAnswers(){
		return userAnswerService.getAllUserAnswers();
	}
	
}
