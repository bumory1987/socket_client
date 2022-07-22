package hello.servlet.mvcbasic.basic;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name= "helloServlet", urlPatterns = "/hello")
@Slf4j
public class HelloServlet extends HttpServlet {



    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("Hello Friend!");
//        System.out.println("request = " + request);
//        System.out.println("response = " + response);

        log.info("username = {}", request.getParameter("username"));
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello "+request.getParameter("username"));
    }
}
