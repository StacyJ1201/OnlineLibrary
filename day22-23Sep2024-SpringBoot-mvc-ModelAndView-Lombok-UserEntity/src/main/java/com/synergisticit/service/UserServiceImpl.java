package com.synergisticit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.dao.RoleRepository;
import com.synergisticit.dao.UserRepository;
import com.synergisticit.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired UserRepository  userRepository;
	
	@Override
	public User save(User u) {
		return userRepository.save(u);
	}

	@Override
	public User findById(int id) {
		Optional<User> optUser = userRepository.findById(id);
		if(optUser.isPresent()) {
			return optUser.get();
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void deleteById(int id) {
		userRepository.deleteById(id);

	}

}
