package com.gng.gngbackend.dto;

public class UserAnswerDTO {
	
	private Long userId;
	private Long questionId;
	private Integer selectedOption;
	
	public UserAnswerDTO(Long userId, Long questionId, Integer selectedOption) {
		super();
		this.userId = userId;
		this.questionId = questionId;
		this.selectedOption = selectedOption;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Integer getSelectedOption() {
		return selectedOption;
	}

	public void setSelectedOption(Integer selectedOption) {
		this.selectedOption = selectedOption;
	}
	
}
