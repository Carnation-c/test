package dao;

import org.apache.commons.dbutils.QueryRunner;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class StudyDao {
    public void StudyUser(String username,String study) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = DBUtils.getCurrentConnection();
        String sql = "insert into studyappointment values(?,?)";
        queryRunner.update(connection,sql,username,study);
    }
}
