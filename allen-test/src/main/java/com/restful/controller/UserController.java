package com.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restful.bean.User;
import com.restful.bean.UserQueryResultBean;
import com.restful.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(path = "/user", method = RequestMethod.POST)
	public UserQueryResultBean createUser(@RequestBody User user) {
		
		//TODO, We need to validate the input parameter
		//TOTO, we need to add the exception handler
		UserQueryResultBean result = this.userService.getUserTotalsByUsergetUserTotalsByUser(user);
		
		return result;
	}
}
