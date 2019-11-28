package demo.service;

import demo.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {
    int getTotalNumbersForName(String name);
}
