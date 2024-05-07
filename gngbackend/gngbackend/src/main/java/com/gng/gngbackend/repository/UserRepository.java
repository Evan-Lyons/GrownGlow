package com.gng.gngbackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.gng.gngbackend.model.User;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public List<User> findByUsername(String username);
	
	Optional<User>findOneByEmailAndPassword(String email, String password);
	
	User findByEmail(String email);

}
