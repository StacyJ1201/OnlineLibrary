package com.synergisticit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.synergisticit.dao.UserDao;
import com.synergisticit.domain.User;

@Service
public class UserServiceImpl implements UserService {
   
	@Autowired 
	UserDao userDao;
	
	@Override
	public User save(User e) {
		return userDao.save(e);
	}

	@Override
	public User findById(int empId) {
		return userDao.findById(empId);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User UpdateById(int empId) {	
		return findById(empId);
	}

	@Override
	public void deleteById(int empId) {
		userDao.deleteById(empId);

	}

}
