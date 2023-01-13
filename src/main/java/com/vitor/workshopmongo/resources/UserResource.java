package com.vitor.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vitor.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	// @GetMapping usar getmapping eh a mesma coisa q usar o metodo abaixo pasasndo RequestMethod.GET
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		List<User> list = new ArrayList<>();
		User maria = new User("1001", "Maria Brown", "maria@gmail.com");
		User alex = new User("1002", "Alex Green", "alex@gmail.com");
		list.addAll(Arrays.asList(maria,alex));
		return ResponseEntity.ok().body(list);
		
	}
	

}
