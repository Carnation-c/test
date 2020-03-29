package service;

import dao.SportDao;
import utils.DBUtils;

import java.sql.SQLException;

public class SportService {
    public boolean sportAppointment(String username,String sport){
        SportDao sportDao = new SportDao();
        boolean isSuccess = true;
        try {
            DBUtils.startTransaction();
            sportDao.SportUser(username, sport);
        } catch (SQLException e) {
            isSuccess = false;
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
        return isSuccess;
    }
}
