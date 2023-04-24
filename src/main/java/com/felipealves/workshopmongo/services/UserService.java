package com.felipealves.workshopmongo.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipealves.workshopmongo.domain.User;
import com.felipealves.workshopmongo.repository.UserRepository;
import com.felipealves.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		
		try {
			User user = repo.findById(id).orElseThrow();
			return user;

		} catch (RuntimeException e) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
	}
}
