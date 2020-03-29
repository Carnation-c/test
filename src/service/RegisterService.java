package service;

import dao.UserDao;
import dao.UserDaoImpl;
import utils.DBUtils;

import java.sql.SQLException;

public class RegisterService {
    public boolean registerUser(String username,String password){
        UserDao dao = new UserDaoImpl();
        boolean isRegisterSuccess = true;
        try {
            DBUtils.startTransaction();
            dao.registerUser(username,password);
        } catch (SQLException e) {
            isRegisterSuccess = false;
            try {
                DBUtils.rollBack();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                DBUtils.CCR();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isRegisterSuccess;
    }
}
