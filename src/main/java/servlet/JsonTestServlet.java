package servlet;

import util.DbUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/JsonTestServlet")
public class JsonTestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public JsonTestServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JSONObject json = JsonUtil.getJSONFromRequest(request);
        if(json != null)System.out.println("JSON BODY: " + json.toString());
        else System.out.println("JSON BODY IS NULL");

        String sql = "select * from test";

        JSONArray jsonArray = new JSONArray(); //json数组
        try {
            ResultSet result = DbUtil.query(sql);
            while (result.next()) {
                JSONObject jObject = new JSONObject();  //json临时对象
                jObject.put("id", result.getInt(1));
                jObject.put("name", result.getString(2));
                jObject.put("password", result.getString(3));
                jsonArray.add(jObject);   //将封装好的json对象放入json数组
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String jsondata = jsonArray.toString();  //将json数组转换成字符串，供下面返回给android端使用
        System.out.println(jsondata);  //本地测试用

        response.getWriter().append(jsondata).flush();
    }
}
