package service;

import bean.HistoryItem;
import bean.User;
import dao.HistoryItemDao;
import dao.UserDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/History")
public class GetHistory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        JSONObject jsonObject = JsonUtil.getJSONFromRequest(req);
//        if (jsonObject == null) {
//            return;
//        }

//        try{
//            Integer id = Integer.parseInt((String) jsonObject.get("id"));
//            if(id == null) return;
//        }catch (Exception e){
//            return;
//        }

        resp.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));

        JSONArray jsonArray;
        try {
            ArrayList<HistoryItem> historyItems = HistoryItemDao.selectHistoryItemsByUserId(id);
            if (historyItems != null) {
                jsonArray = JSONArray.fromObject(historyItems);
            } else {
                jsonArray = JSONArray.fromObject(new ArrayList<HistoryItem>());
            }
            JsonUtil.putJSONArrayInResponse(resp, jsonArray);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
