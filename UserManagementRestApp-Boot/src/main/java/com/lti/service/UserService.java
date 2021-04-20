package com.lti.service;

import java.util.List;

import com.lti.model.Address;
import com.lti.model.User;

public interface UserService {
	User addOrUpdateUser(User user);

	User findUserById(int userId);

	List<User> viewAllUsers();

	boolean isValidUser(int userId, String userPassword);

	Address addOrUpdateAddressOfAUser(Address address, int userId);

	Address findAddressById(int addressId);

	Address findAddressByUserId(int userId);
	String updateUserPhone(String userPhone,int userId);

}
