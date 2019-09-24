package demo.dao;

import demo.entity.User;

import java.util.List;

/**
 * The interface User repository.
 */
public interface UserRepository {
    /**
     * Gets users.
     * @return the users
     */
    List<User> getUsers();
}