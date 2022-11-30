package service;

import bean.Model;
import dao.ModelDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONBuilder;
import net.sf.json.util.JSONUtils;
import util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/GetModels")
public class GetModels extends HttpServlet {
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
//        String id = (String) jsonObject.get("uid");
//        if (id == null) return;

        resp.setContentType("text/html;charset=GBK");
        String id = req.getParameter("uid");

        ModelDao modelDao = new ModelDao();
        try {
            ArrayList<Model> res = modelDao.selectModelsByUserId(Integer.parseInt(id));
            JSONArray resJSON = JSONArray.fromObject(res);
            System.out.println(resJSON.toString());
            JsonUtil.putJSONArrayInResponse(resp, resJSON);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
