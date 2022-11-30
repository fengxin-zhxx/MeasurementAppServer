package dao;

import bean.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    //删除用户
    public boolean deleteUser(User user) throws SQLException {
        boolean bool = false;
        PreparedStatement pre = null;
        Connection conn = DBConnection.getConnection();
        String sql = "delete from users where user_id=?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, user.getUserId());
            pre.execute();
            bool = true;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } finally {

            DBConnection.close(pre);
            DBConnection.close(conn);
        }
        return bool;
    }

    //根据email查询
    public User selectUserByUsername(String username) throws SQLException {
        User u = null;
        PreparedStatement pre = null;
        Connection conn = DBConnection.getConnection();
        String sql = "select * from users where name=?";
        ResultSet rs = null;
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, username);
            rs = pre.executeQuery();
            while (rs.next()) {
                u = new User();
                u.setUserId(rs.getInt("id"));
                u.setUserName(rs.getString("name"));
                u.setUserPasswd(rs.getString("password"));
                u.setUserEmail(rs.getString("email"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } finally {
            DBConnection.close(rs);
            DBConnection.close(pre);
            DBConnection.close(conn);
        }
        return u;

    }
    //查询

    public User selectUser(User user) throws SQLException {
        User u = null;
        PreparedStatement pre = null;
        Connection conn = DBConnection.getConnection();
        String sql = "select * from users where user_id=?";
        ResultSet rs = null;
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, user.getUserId());
            rs = pre.executeQuery();
            while (rs.next()) {
                u = new User();
                u.setUserId(rs.getInt("id"));
                u.setUserName(rs.getString("name"));
                u.setUserPasswd(rs.getString("password"));
                u.setUserEmail(rs.getString("email"));

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } finally {
            DBConnection.close(rs);
            DBConnection.close(pre);
            DBConnection.close(conn);
        }
        return u;

    }

    //查询所有的会员
    public List<User> selectAllUser() throws SQLException {
        List<User> list = new ArrayList<User>();
        PreparedStatement pre = null;
        Connection conn = DBConnection.getConnection();
        String sql = "select * from users";
        ResultSet rs = null;
        try {
            pre = conn.prepareStatement(sql);

            rs = pre.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUserId(rs.getInt("id"));
                u.setUserName(rs.getString("name"));
                u.setUserPasswd(rs.getString("password"));
                u.setUserEmail(rs.getString("email"));
                list.add(u);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } finally {
            DBConnection.close(rs);
            DBConnection.close(pre);
            DBConnection.close(conn);
        }
        return list;

    }

    //检查用户邮箱密码
    public User login(User user) throws SQLException {
        User u = null;
        PreparedStatement pre = null;
        Connection conn = DBConnection.getConnection();
        String sql = "select * from users where email=?";
        ResultSet rs = null;
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, user.getUserEmail());
            rs = pre.executeQuery();
            if (!rs.next()) {
                String regisSQL = "insert into users (email,name,password) values(?,?,?)";
                PreparedStatement pre2 = null;
                pre2 = conn.prepareStatement(regisSQL);
                pre2.setString(1, user.getUserEmail());
                pre2.setString(2, user.getUserEmail());
                pre2.setString(3, user.getUserPasswd());
                pre2.execute();
            }
            String sql2 = "select * from users where email=? and password=?";
            PreparedStatement pre2 = conn.prepareStatement(sql2);
            pre2.setString(1, user.getUserEmail());
            pre2.setString(2, user.getUserPasswd());

            ResultSet rs2 = pre2.executeQuery();
            while (rs2.next()) {
                String pwd = rs2.getString("password");
                if (pwd.equals(user.getUserPasswd())) {
                    u = new User();
                    u.setUserId(rs2.getInt("id"));
                    u.setUserName(rs2.getString("name"));
                    u.setUserPasswd(rs2.getString("password"));
                    u.setUserEmail(rs2.getString("email"));
                }
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } finally {
            DBConnection.close(rs);
            DBConnection.close(pre);
            DBConnection.close(conn);
        }
        return u;

    }
}
