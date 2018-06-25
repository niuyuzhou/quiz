package dao;

import entity.User;

public class UserHardCodeRepository implements UserRepository {
    @Override
    public User getUserById(long id) {
        return new User(id, "TOM");
    }
}
