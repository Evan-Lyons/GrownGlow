package com.gng.gngbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_answers")
public class UserAnswers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;
	
	@Column(nullable = false)
	private int selectedOption;
	
	public UserAnswers() {
		super();
	}
	
	public UserAnswers(Long id, User user, Question question, int selectedOption) {
		super();
		this.id = id;
		this.user = user;
		this.question = question;
		this.selectedOption = selectedOption;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public int getSelectedOption() {
		return selectedOption;
	}

	public void setSelectedOption(int selectedOption) {
		this.selectedOption = selectedOption;
	}
	
}
