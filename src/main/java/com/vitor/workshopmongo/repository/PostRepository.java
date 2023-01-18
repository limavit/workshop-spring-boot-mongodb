package com.vitor.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.vitor.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	List<Post> findByTitleContainingIgnoreCase(String title);
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> findByTitleSearchTitle(String title);

}
