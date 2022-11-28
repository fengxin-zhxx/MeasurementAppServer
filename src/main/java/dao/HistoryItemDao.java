package dao;

import bean.HistoryItem;
import bean.Model;
import bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoryItemDao {

    //按userId查询
    public static ArrayList<HistoryItem> selectHistoryItemsByUserId(int userId) throws SQLException {

        ArrayList<HistoryItem> res = new ArrayList<>();
        PreparedStatement pre = null;
        Connection conn = DBConnection.getConnection();
        String sql = "select * from history_items where user_id=?";
        ResultSet rs = null;
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, userId);
            rs = pre.executeQuery();
            while (rs.next()) {
                HistoryItem historyItem = new HistoryItem();
                historyItem.setItemId(rs.getInt("id"));
                historyItem.setUserId(rs.getInt("user_id"));
                historyItem.setItemName(rs.getString("name"));
                historyItem.setDate(rs.getString("date"));
                historyItem.setResult(rs.getString("result"));
                res.add(historyItem);
            }
            return  res;

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
    public static boolean addHistoryItem(HistoryItem historyItem) throws SQLException {
        boolean flag = false;
        Connection conn = DBConnection.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "insert into history_items (user_id,name,date,result) values(?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,historyItem.getUserId());
            pst.setString(2,historyItem.getItemName());
            pst.setString(3,historyItem.getDate());
            pst.setString(4,historyItem.getResult());
            pst.execute();
            flag=true;
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBConnection.close(rs);
            DBConnection.close(pst);
            DBConnection.close(conn);
        }
        return flag;
    }
}

