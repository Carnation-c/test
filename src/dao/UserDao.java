package dao;

import domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public List<User> findAll();
    User findUserByUsernameAndPassword(String username, String password);
    public void registerUser(String username,String password) throws SQLException;
}
