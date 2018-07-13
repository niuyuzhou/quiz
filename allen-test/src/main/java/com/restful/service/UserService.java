package com.restful.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.bean.User;
import com.restful.bean.UserQueryResultBean;
import com.restful.dao.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public UserQueryResultBean getUserTotalsByUsergetUserTotalsByUser(User user) {
		UserQueryResultBean result = new UserQueryResultBean();
		List<User> userResult = this.userDao.getUsersByName(user);
		
//		userResult.stream().filter(w -> w.getUserName().equals(user.getUserName())).mapToInt(w->w.get);
		Map<String, Integer> ra = userResult.parallelStream().collect(Collectors.groupingBy(User::getName,Collectors.summingInt(p -> 1)));
		
		int raa = ra.get(user.getName());
		
		System.out.println(raa);
		
		result.setTotalNumbers(raa);
		result.setName(user.getName());
		
		return result;
	}
}
