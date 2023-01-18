package com.vitor.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitor.workshopmongo.domain.Post;
import com.vitor.workshopmongo.repository.PostRepository;
import com.vitor.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	public List<Post> findAll(){
		return postRepository.findAll();
	}
	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	public Post insert(Post obj) {
		return postRepository.insert(obj);
		
	}
	public void delete(String id) {
		postRepository.deleteById(id);
	} 
	public List<Post> findByTitle(String text){
		//return PostRepository.findByTitleContainingIgnoreCase(text);
		return postRepository.findByTitleSearchTitle(text);
	}
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 / 60 / 1000);
		return postRepository.fullSearch(text, minDate, maxDate);
	}
	/*
	public Post update(Post obj) {
		Post newObj = PostRepository.findById(obj.getId()).get();
		updateData(newObj, obj);
		return PostRepository.save(newObj);
	}
	
	private void updateData(Post newObj, Post obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
		
		
	}
	public Post fromDTO(PostDTO objDTO) {
		return new Post(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
	*/
}
