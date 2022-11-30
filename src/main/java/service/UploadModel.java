package service;

import bean.Model;
import dao.ModelDao;
import net.sf.json.JSONObject;
import util.JsonUtil;
import util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/UploadModel")
public class UploadModel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject jsonObject = JsonUtil.getJSONFromRequest(req);
        System.out.println(jsonObject);
        if (jsonObject == null) {
            return;
        }
        Model model = Model.fromJSON(jsonObject);
        try {
            boolean flag = ModelDao.addModel(model);
            if(flag) System.out.println("add model succ " + model.getModelName());
            else System.out.println("add model failed.");
            System.out.println(StringUtil.getEncoding(model.getModelName()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
