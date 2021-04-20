package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.UserDao;
import com.lti.model.Address;
import com.lti.model.User;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	public User addOrUpdateUser(User user) {
		return userDao.addOrUpdateUser(user);
	}

	public User findUserById(int userId) {
		return userDao.findUserById(userId);
	}

	public List<User> viewAllUsers() {
		return userDao.viewAllUsers();
	}

	public boolean isValidUser(int userId, String userPassword) {
		return userDao.isValidUser(userId, userPassword);
	}

	public Address addOrUpdateAddressOfAUser(Address address, int userId) {
		return userDao.addOrUpdateAddressOfAUser(address, userId);
	}

	public Address findAddressById(int addressId) {
		return userDao.findAddressById(addressId);
	}

	public Address findAddressByUserId(int userId) {
		return userDao.findAddressByUserId(userId);
	}

	public String updateUserPhone(String userPhone, int userId) {
		return userDao.updateUserPhone(userPhone, userId);
	}

}
