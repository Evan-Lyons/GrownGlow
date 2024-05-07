package com.gng.gngbackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gng.gngbackend.model.Question;
import com.gng.gngbackend.model.Quiz;
import com.gng.gngbackend.model.QuizQuestion;
import com.gng.gngbackend.repository.QuestionRepository;
import com.gng.gngbackend.repository.QuizQuestionRepository;
import com.gng.gngbackend.repository.QuizRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class QuizService {
	
	@Autowired
	private final QuizRepository quizRepository;
	
	@Autowired
	private QuizQuestionRepository quizQuestionRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public QuizService(QuizRepository quizRepository) {
		this.quizRepository = quizRepository;
	}
	
	public Quiz createQuiz(Quiz quiz) {
		// Perform any necessary validation or business logic
		// Save the quiz entity in the database
		
		return quizRepository.save(quiz);
	}
	
	public Quiz getQuizById(Long id) {
		return quizRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Quiz not found"));
	}
	
	public Quiz updateQuiz(Long id, Quiz updatedQuiz) {
		Quiz quiz = getQuizById(id);
		quiz.setQuizName(updatedQuiz.getQuizName());
		return quizRepository.save(quiz);
	}
	
	public void deleteQuiz(Long id) {
		Quiz quiz = getQuizById(id);
		quizRepository.delete(quiz);
	}
	
	public List<Quiz> getAllQuizzes(){
		return quizRepository.findAll();
	}
	
	public List<Question> getQuizQuestById(Long id){
		System.out.println("Id"+id);
		List<QuizQuestion> quizQuesList = quizQuestionRepository.findByQuiz(getQuizById(id));
		List<Question> questionList = new ArrayList<>();
		for(QuizQuestion quizQues: quizQuesList) {
			Optional<Question> optionalQuestions = questionRepository.findById(quizQues.getQuestion().getId());
			optionalQuestions.ifPresent(questionList::add);
		}
		
		questionList.forEach(q->System.out.println(q.getQuestionText()));
		return questionList;
	}
	
}
