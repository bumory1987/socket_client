package hello.servlet.mvcbasic.basic.response;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseHtmlServlet" , urlPatterns = "/response-html" )
public class ResponseHtmlServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write("<html>");
        resp.getWriter().write("<body>");
        resp.getWriter().write("<div>");
        resp.getWriter().write("안녕? 친구여");
        resp.getWriter().write("</div>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</html>");

    }
}


