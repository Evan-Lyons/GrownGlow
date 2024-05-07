package com.gng.gngbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "quiz_questions")
public class QuizQuestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "quiz_id")
	private Quiz quiz;
	
	@ManyToOne
	@JoinColumn(name = "question_id", nullable = false)
	private Question question;
	
	public QuizQuestion(Long id, Quiz quiz, Question question) {
		super();
		this.id = id;
		this.quiz = quiz;
		this.question = question;
	}
	
	public QuizQuestion(Quiz quiz, Question question) {
		super();
		this.quiz = quiz;
		this.question = question;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
}
