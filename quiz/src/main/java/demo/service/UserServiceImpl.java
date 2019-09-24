package demo.service;

import demo.dao.UserRepository;
import demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type User service.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public int getTotalNumbersForName(String name) {
        List<User> userList = userRepository.getUsers();
        int number = 0;
        if(userList !=  null) {
            number = (int) userList.stream().filter(user -> user.getName().equals(name)).count();
        }
        return number;
    }
}
