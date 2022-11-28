package util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class JsonUtil {
    public static JSONObject getJSONFromRequest(HttpServletRequest request) throws IOException {
        BufferedReader reader = request.getReader();
        StringBuilder builder = new StringBuilder();
        String line = reader.readLine();
        while (line != null) {
            builder.append(line);
            line = reader.readLine();
        }
        reader.close();

        String reqBody = builder.toString();

        try {
            JSONObject json = JSONObject.fromObject(reqBody);
            return json;
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return null;
    }
    public static void putJSONInResponse(HttpServletResponse response, JSONObject jsonObject) throws IOException {
        response.getWriter().append(jsonObject.toString()).flush();
    }
    public static void putJSONArrayInResponse(HttpServletResponse response, JSONArray jsonArray) throws IOException {
        response.getWriter().append(jsonArray.toString()).flush();
    }


}
