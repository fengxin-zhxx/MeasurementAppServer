package dao;

import bean.HistoryItem;
import bean.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelDao {
    public ArrayList<Model> selectModelsByUserId(int userId) throws SQLException {

        ArrayList<Model> res = new ArrayList<>();
        PreparedStatement pre = null;
        Connection conn = DBConnection.getConnection();
        String sql = "select * from models where user_id=?";
        ResultSet rs = null;
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, userId);
            rs = pre.executeQuery();
            while (rs.next()) {
                Model model = new Model();
                model.setModelId(rs.getInt("id"));
                model.setUserId(rs.getInt("user_id"));
                model.setModelName(rs.getString("name"));
                model.setA(rs.getDouble("A"));
                model.setB(rs.getDouble("B"));
                model.setDate(rs.getString("create_time"));
                res.add(model);
            }
            return res;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBConnection.close(rs);
            DBConnection.close(pre);
            DBConnection.close(conn);
        }
        return null;

    }

    //增加记录
    public static boolean addModel(Model model) throws SQLException {
        boolean flag = false;
        Connection conn = DBConnection.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "insert into models (user_id,name,create_time,A,B) values(?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, model.getUserId());
            pst.setString(2, model.getModelName());
            pst.setString(3, model.getDate());
            pst.setString(4, String.valueOf(model.getA()));
            pst.setString(5, String.valueOf(model.getB()));
            pst.execute();
            flag = true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBConnection.close(rs);
            DBConnection.close(pst);
            DBConnection.close(conn);
        }
        return flag;
    }
}
