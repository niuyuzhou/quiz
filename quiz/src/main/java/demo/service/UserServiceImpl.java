package demo.service;

import demo.dao.UserRepository;
import demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<User> users = this.userRepository.getUsers();
        int nums = 0;
        for(int i=0; i< users.size();i++){
            if (users.get(i).getName() == name) {
                nums++;
            }
        }
        return nums;
    }
}
