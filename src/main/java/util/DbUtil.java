package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import dao.DBConnection;

public class DbUtil {


    private static Connection getConnection() throws SQLException {
        return DBConnection.getConnection();
    }
    //这里只用了查询操作
    public static ResultSet query(String querySql) throws SQLException {
        Statement stateMent = (Statement) getConnection().createStatement();
        return stateMent.executeQuery(querySql);
    }

}