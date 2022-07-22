package hello.servlet.mvcbasic.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //status-line
//        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setHeader("Content-type", "text/plain;charset=utf-8");
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("my-header", "hello");
        cookie(resp);
        redirectMan(resp);
        resp.getWriter().write("ok man");
    }

    private void redirectMan(HttpServletResponse resp) throws IOException {
        resp.setStatus(HttpServletResponse.SC_FOUND);
        //resp.setHeader("Location", "basic/hello-form.html");
        resp.sendRedirect("/basic/hello-form.html");
    }


    public void content( HttpServletResponse resp){
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
    }



    public void cookie( HttpServletResponse resp){
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);
        resp.addCookie(cookie);
    }
}
