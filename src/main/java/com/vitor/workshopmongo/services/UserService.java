package com.vitor.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitor.workshopmongo.domain.User;
import com.vitor.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
}
