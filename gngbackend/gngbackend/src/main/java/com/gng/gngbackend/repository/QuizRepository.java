package com.gng.gngbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gng.gngbackend.model.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long>{
	// Custom methods for quiz-related operations
}
