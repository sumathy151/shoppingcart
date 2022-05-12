package com.mindtree.shoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.shoppingcart.exceptions.UserAlreadyExistsException;
import com.mindtree.shoppingcart.exceptions.UserNotFoundException;
import com.mindtree.shoppingcart.model.UserDetails;
import com.mindtree.shoppingcart.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserDetails validateUser(String userName, String password) throws UserNotFoundException {

		UserDetails user = userRepository.findByUserNameAndPassword(userName, password);

		if (user == null) {
			throw new UserNotFoundException("User Not Found");
		} else
			return user;

	}

	public void registerUser(String userName, String password) throws UserAlreadyExistsException {

		UserDetails user = checkUser(userName);

		if (user == null) {
			userRepository.save(userName, password);

		} else {
			throw new UserAlreadyExistsException("User Name already exists");
		}

	}

	public UserDetails checkUser(String userName) {
		return userRepository.findByUserName(userName);
	}

}
