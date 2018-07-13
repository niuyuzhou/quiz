package com.restful.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.restful.bean.User;

@Component
public class UserDao {
	public List<User> getUsersByName(User user){
		List<User> users = new ArrayList<User>();
		
		User userT = new User();
		userT.setName("allen");
		userT.setUserId("1");
		
		users.add(userT);
		
		userT.setName("allen");
		userT.setUserId("2");
		
		users.add(userT);
		
		return users;
	}
}
