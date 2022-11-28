package service;

import bean.User;
import dao.UserDao;
import net.sf.json.JSONObject;
import util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {
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

        UserDao dao = new UserDao();
        User u = new User();
        u.setUserEmail((String) jsonObject.get("email"));
        u.setUserPasswd((String) jsonObject.get("password"));
        JSONObject retJsonObject = new JSONObject();
        try {
            User user = dao.login(u);
            if (user != null) {
                //成功
                System.out.println("succ");
                retJsonObject.put("flag", "1");
                retJsonObject.put("uid", user.getUserId());
                retJsonObject.put("userName", user.getUserName());
                retJsonObject.put("userEmail", user.getUserEmail());

                retJsonObject.put("message", "successfully login.");
                System.out.println(retJsonObject.toString());
                JsonUtil.putJSONInResponse(resp, retJsonObject);
            } else {
                //失败
                System.out.println("fail");
                retJsonObject.put("flag", "0");
                retJsonObject.put("message", "login failed. please check your email and password.");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }
}
