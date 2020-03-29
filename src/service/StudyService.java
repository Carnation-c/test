package service;

import dao.SportDao;
import dao.StudyDao;
import utils.DBUtils;

import java.sql.SQLException;

public class StudyService {
    public boolean studyAppointment(String username,String study){
        StudyDao studyDao = new StudyDao();
        boolean isSuccess = true;
        try {
            DBUtils.startTransaction();
            studyDao.StudyUser(username, study);
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
