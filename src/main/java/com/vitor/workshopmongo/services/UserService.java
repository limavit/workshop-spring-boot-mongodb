package com.vitor.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitor.workshopmongo.domain.User;
import com.vitor.workshopmongo.dto.UserDTO;
import com.vitor.workshopmongo.repository.UserRepository;
import com.vitor.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	public List<User> findAll(){
		return userRepository.findAll();
	}
	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	public User insert(User obj) {
		return userRepository.insert(obj);
		
	}
	public void delete(String id) {
		userRepository.deleteById(id);
	}
	public User update(User obj) {
		User newObj = userRepository.findById(obj.getId()).get();
		updateData(newObj, obj);
		return userRepository.save(newObj);
	}
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
		
		
	}
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}
