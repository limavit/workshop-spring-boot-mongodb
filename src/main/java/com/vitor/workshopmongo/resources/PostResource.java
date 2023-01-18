package com.vitor.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vitor.workshopmongo.domain.Post;
import com.vitor.workshopmongo.resources.util.URL;
import com.vitor.workshopmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	@Autowired
	private PostService postService;
	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = postService.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	@GetMapping(value="/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue = "") String text){
		text = URL.decodeParam(text);
		List<Post> list = postService.findByTitle(text);
				
		return ResponseEntity.ok().body(list);
		
	}
	@GetMapping(value="/fullsearch")
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value="text", defaultValue = "") String text,
			@RequestParam(value="minDate", defaultValue = "") String minDate,
			@RequestParam(value="maxDate", defaultValue = "") String maxDate){
		text = URL.decodeParam(text);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());
		List<Post> list = postService.fullSearch(text, min, max);
		
		
		return ResponseEntity.ok().body(list);
		
	}
	
	/*
	// @GetMapping usar getmapping eh a mesma coisa q usar o metodo abaixo pasasndo RequestMethod.GET
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PostDTO>> findAll(){
		List<Post> list = PostService.findAll();
		List<PostDTO> listDTO = list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody PostDTO objDTO){
		Post obj = PostService.fromDTO(objDTO);
		obj = PostService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	//@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		PostService.delete(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@RequestBody PostDTO objDTO, @PathVariable String id){
		Post obj = PostService.fromDTO(objDTO);
		obj.setId(id);
		obj = PostService.update(obj);
		return ResponseEntity.noContent().build();
	}
	@GetMapping(value="/{id}/posts")
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
		Post obj = PostService.findById(id);		
		return ResponseEntity.ok().body(obj.getPosts());
		
	}
	
	*/

}
