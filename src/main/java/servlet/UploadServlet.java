package servlet;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("index.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 创建配置工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 2. 根据配置工厂创建解析请求中文件上传内容的解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 3. 判断当前请求是不是多段提交
        if (!upload.isMultipartContent(request)) {
            throw new RuntimeException("不是多段提交！");
        }

        try {
            // 4. 解析request对象，将已经分割过的内容放进了List
            List<FileItem> list = upload.parseRequest(request);
            if (list != null) {
                for (FileItem fileItem : list) {
                    // 判断当前段是普通字段还是文件,这个方法是判断普通段
                    if (fileItem.isFormField()) {
                        // 获得name属性对应的值,这里是username
                        String fname = fileItem.getFieldName();
                        // 获得键对应的值
                        String value = fileItem.getString("utf-8");
                        System.out.println(fname + "=>" + value);
                        // 否则就是文件了
                    } else {

                        // 获得文件上传段中，文件的流
                        InputStream in = fileItem.getInputStream();

                        // 使用用户上传的文件名来保存文件的话，文件名可能重复。
                        // 所以保存文件之前，要保证文件名不会重复。使用UUID生成随机字符串
                        String fileName = UUID.randomUUID().toString();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("/yyyy/MM/dd/");
                        String datePath = simpleDateFormat.format(new Date()); // 解析成    /2017/04/15/  的样子, 注意这是三个文件夹
                        String wholePath = "WEB-INF/upload" + datePath;
                        // 字节输出流，用以保存文件，也不需要后缀名，因为我们只是保存用户的数据，不需要查看他们的数据。待用户想下载的时候，再加上后缀名
                        File dir = new File(wholePath);
                        System.out.println(dir.getAbsolutePath());
                        if (!dir.exists()) {
                            dir.mkdirs();
                        }
                        FileOutputStream fos = new FileOutputStream(wholePath + fileName);
                        // 将输入流复制到输出流中
                        IOUtils.copy(in, fos);
                        fos.close();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
