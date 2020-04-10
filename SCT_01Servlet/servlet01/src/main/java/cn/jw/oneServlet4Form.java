
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "oneServlet4Form",urlPatterns = "/oneServlet4Form")
public class oneServlet4Form extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();	 
        out.print("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"utf-8\"/>\n" +
                "<title>Servlet获取学生表单信息</title>\n" +
                "</head>\n");
        out.print("<body>\n");
        out.print("<h1>表单提交信息</h1>\n");
        String formstr = "<p>学号:" + request.getParameter("id") + "</p>\n";
        formstr += "<p>姓名:" + request.getParameter("name")+ "</p>\n";
        formstr += "<p>生日:" + request.getParameter("birthday")+ "</p>\n";
        formstr += "<p>性别:" + (request.getParameter("sex").equals("1") ? "男":"女")+ "</p>\n";
        String[] play = request.getParameterValues("play");
        formstr +="<p>爱好:";
        if (play != null && play.length > 0) {
            //遍历取值
            for (int i = 0; i < play.length; i++) {
                //System.out.println(play[i]);
                // 打印 out.println(play[i]);
                formstr +=play[i]+"  ";
            }
        }
        formstr +="</p>\n";

        out.print(formstr);
        out.print("</body>\n");
        out.print("</html>\n");
        out.close();
    }
}
