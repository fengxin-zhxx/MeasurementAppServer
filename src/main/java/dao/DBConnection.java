package dao;

import java.sql.*;

public class DBConnection {
    // 获得连接
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/AndroidServer";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url, "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }


    // 关闭连接
    public static void close(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
            conn = null;
        }
    }

    // 关闭结果集
    public static void close(ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
            rs = null;
        }
    }

    public static void close(PreparedStatement pst) throws SQLException {
        if (pst != null) {
            pst.close();
            pst = null;
        }
    }
}
