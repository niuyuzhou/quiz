package dao;

import entity.User;

public interface UserRepository {
    User getUserById(long id);
}