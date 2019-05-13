package com.sha.microserviceusermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sha.microserviceusermanagement.model.Role;
import com.sha.microserviceusermanagement.model.User;
import com.sha.microserviceusermanagement.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(Role.USER);
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<String> findUsers(List<Long> idList) {
		return this.userRepository.findUserNames(idList);
	}

}
