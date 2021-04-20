package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lti.dto.LoginDto;
import com.lti.model.Address;
import com.lti.model.User;
import com.lti.service.UserService;

//@Component
//@Controller
@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService userService;
	
	//http://localhost:9090/RestAppWeb/rest/registeruser
	@RequestMapping(value="/registeruser",method=RequestMethod.POST)
			//,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public User addOrUpdateUser(@RequestBody User user){
		User userPersisted=userService.addOrUpdateUser(user);
		return userPersisted;	
	}
	//http://localhost:9090/RestAppWeb/rest/showuser/{userId}
	@GetMapping(value="/showuser/{userId}")
	public User findUserById(@PathVariable("userId")int userId){
		User userPersisted1=userService.findUserById(userId);
		return userPersisted1;
		
	}
	//http://localhost:9090/RestAppWeb/rest/showuser/loginuser
	@PostMapping(value="/loginuser")
	public boolean isValidUser(@RequestBody LoginDto loginData){
		return userService.isValidUser(loginData.getUserId(),loginData.getUserPassword());
	}
	
	@PutMapping(value="/updatePhone")
	public String updateUserPhone(int userId,String userPhone){
		return userService.updateUserPhone(userPhone, userId);
	}
	//http://localhost:9090/RestAppWeb/rest/
	@GetMapping(value="users/{userId}")
	public User findUser(@PathVariable("userId")int userId){
		return userService.findUserById(userId);
	}
	//http://localhost:9090/RestAppWeb/rest/addaddress
	@PostMapping(value="/addaddress")
	public Address addOrUpdateAddressOfUser(@RequestBody Address address, @RequestParam("userId")int userId){
		return userService.addOrUpdateAddressOfAUser(address, userId);
	}
	//http://localhost:9090/RestAppWeb/rest/finaddbyuserid
	@GetMapping(value = "/finaddbyuserid/{userId}")
    public Address finAddressByUserId(@PathVariable("userId") int userId) {
    return userService.findAddressByUserId(userId);
    }
	
	
	
	
	
}
