package com.felipealves.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipealves.workshopmongo.domain.Post;
import com.felipealves.workshopmongo.domain.User;
import com.felipealves.workshopmongo.repository.PostRepository;
import com.felipealves.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public List<Post> findAll() {
		return repo.findAll();
	}

	public Post findById(String id) {
		
		try {
			Post post = repo.findById(id).orElseThrow();
			return post;

		} catch (RuntimeException e) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
	}

}
