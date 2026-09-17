package com.ecomm.repository;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.ecomm.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	Optional<User>findByEmail(String email);
}
