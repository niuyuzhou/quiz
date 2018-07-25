package demo.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import demo.dao.UserHardCodeRepository;
import demo.entity.User;

public class UserServiceImpl implements UserService{

	@Override
	public int getTotalNumbersForName(String userName) {
		// TODO Auto-generated method stub
		UserHardCodeRepository userRep = new UserHardCodeRepository();
		List<User> userList = userRep.getUsers();

		Map<String, Integer> userMap = userList.parallelStream().collect(Collectors.groupingBy(User::getName,Collectors.summingInt(p -> 1)));
		
		return userMap.get(userName)!=null?userMap.get(userName):0;
	}

}
