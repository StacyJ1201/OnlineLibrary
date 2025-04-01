package com.synergisticit.service;

import java.util.List;

import com.synergisticit.domain.User;

public interface UserService {
	 User save(User u);
	 User findById(int id);
     List<User> findAll();
     void deleteById(int id);
}
