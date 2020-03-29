package dao;

import org.apache.commons.dbutils.QueryRunner;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class SportDao {
    public void SportUser(String username,String sport) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = DBUtils.getCurrentConnection();
        String sql = "insert into sportappointment values(?,?)";
        queryRunner.update(connection,sql,username,sport);
    }
}
