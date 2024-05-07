package com.gng.gngbackend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "quizzes")
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String quizName;
	
	@JsonIgnoreProperties("quiz")
	@OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
	private List<QuizQuestion> quizQuestions;
	
	public Quiz(Long id, String quizName, List<QuizQuestion> quizQuestions) {
		super();
		this.id = id;
		this.quizName = quizName;
		this.quizQuestions = quizQuestions;
	}
	
	public Quiz(String quizName, List<QuizQuestion> quizQuestions) {
		super();
		this.quizName = quizName;
		this.quizQuestions = quizQuestions;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	public List<QuizQuestion> getQuizQuestions() {
		return quizQuestions;
	}

	public void setQuizQuestions(List<QuizQuestion> quizQuestions) {
		this.quizQuestions = quizQuestions;
	}
	
}
