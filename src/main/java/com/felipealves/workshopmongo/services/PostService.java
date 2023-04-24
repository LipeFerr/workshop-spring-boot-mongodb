package com.felipealves.workshopmongo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipealves.workshopmongo.domain.Post;
import com.felipealves.workshopmongo.repository.PostRepository;
import com.felipealves.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {

		try {
			Post post = repo.findById(id).orElseThrow();
			return post;

		} catch (RuntimeException e) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
	}

	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		
		return repo.fullSearch(text, minDate, maxDate);
	}
	
}
