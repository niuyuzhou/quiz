package demo.service.impl;

import demo.dao.UserHardCodeRepository;
import demo.dao.UserRepository;
import demo.entity.User;
import demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangzhe on 24/9/19.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public int getTotalNumbersForName(String name) {
        List<User> userList = userRepository.getUsers();
        int count = 0;
        for (User user : userList){
            if (name.toLowerCase().equals(user.getName().toLowerCase())) {
                count++;
            }
        }
        return count;
    }
}
