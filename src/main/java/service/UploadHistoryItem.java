package service;

import bean.HistoryItem;
import dao.HistoryItemDao;
import net.sf.json.JSONObject;
import util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/UploadHistoryItem")
public class UploadHistoryItem extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject jsonObject = JsonUtil.getJSONFromRequest(req);

        if (jsonObject == null) {
            return;
        }
        HistoryItem historyItem = HistoryItem.fromJSON(jsonObject);

        try {
            boolean flag = HistoryItemDao.addHistoryItem(historyItem);
            if (flag) System.out.println("add historyItem succ " + jsonObject);
            else System.out.println("add historyItem failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
