package demo.service;

import demo.dao.UserRepository;
import demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public int getTotalNumbersForName(String name) {
        if (name == null || name.length() == 0) return 0;

        List<User> users = this.userRepository.getUsers();
        int nums = 0;
        for (User user : users) {
            if (name.equals(user.getName())) {
                nums++;
            }
        }
        return nums;
    }
}
