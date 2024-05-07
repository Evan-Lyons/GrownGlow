package com.gng.gngbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gng.gngbackend.model.Question;
import com.gng.gngbackend.repository.QuestionRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class QuestionService {
	
	private final QuestionRepository questionRepository;
	
	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	
	public Question createQuestion(Question question) {
		// Perform any necessary validation or business logic
		// Save the question entity in the database
		return questionRepository.save(question);
	}
	
	public Question getQuestionById(Long id) {
		return questionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Question not found"));
	}
	
	public Question updateQuestion(Long id, Question updatedQuestion) {
		Question question = getQuestionById(id);
		// Perform any necessary validation or business logic
		// Update the question entity with the new values
		question.setQuestionText(updatedQuestion.getQuestionText());
		question.setOption1(updatedQuestion.getOption1());
		question.setOption1(updatedQuestion.getOption2());
		question.setOption1(updatedQuestion.getOption3());
		question.setOption1(updatedQuestion.getOption4());
		question.setCorrectOption(updatedQuestion.getCorrectOption());
		return questionRepository.save(question);
	}
	
	public void deleteQuestion(Long id) {
		Question question = getQuestionById(id);
		// Perform any necessary validation or business logic
		questionRepository.delete(question);
	}
	
	public List<Question> getAllQuestions(){
		return questionRepository.findAll();
	}
	
}
