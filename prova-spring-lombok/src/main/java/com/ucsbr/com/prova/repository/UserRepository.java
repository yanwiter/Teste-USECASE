package com.ucsbr.com.prova.repository;

import com.ucsbr.com.prova.entity.User;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	  Optional<User> findByEmailEquals(String email);
	  public Optional<User> findByLogin(String login);
}

