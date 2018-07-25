package demo.controller;




import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import demo.entity.User;


@RestController
public class UserController {
	
	
	@RequestMapping(path = "/user", method = RequestMethod.POST)

	public @ResponseBody User user(@RequestBody User user) {
		
		User newUser = new User(0, user.getName());
		return newUser;
		
    }	
}