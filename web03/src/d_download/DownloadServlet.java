package d_download;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获得要下载的文件名
        String filename = request.getParameter("filename");
        // filename乱码处理
//        filename = new String(filename.getBytes("ISO8859-1"), "UTF-8");

        // 2./download/filename
        //   创建文件对应的输入流
        String path = this.getServletContext().getRealPath("/download/"+filename);
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(path));
        // 3.1 告诉客户端响应的文件类型, 通过后缀名获得文件类型
//        this.getServletContext().getMimeType(filename);
        response.setContentType(this.getServletContext().getMimeType(filename));
        // 浏览器响应头不支持中文, 需要处理filename
        String agent = request.getHeader("user-agent");
        String newName = DownLoadUtils.getFileName(agent, filename);
        // 3.2 设置响应头, 告诉客户端文件是以附件形式打开 - 下载
        response.setHeader("Content-Disposition","attachment;filename="+newName);
        // 3.获得响应对应的输出流
        OutputStream out = response.getOutputStream();
        // 4.复制文件
        byte[] bs = new byte[1024];
        int len;
        while((len = in.read(bs)) != -1) {
            out.write(bs, 0, len);
        }
        in.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
