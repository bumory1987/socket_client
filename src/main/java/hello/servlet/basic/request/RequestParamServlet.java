package hello.servlet.basic.request;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;


@WebServlet(name= "requestParamServlet" , urlPatterns = "/request-param")
@Slf4j
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Enumeration<String> parameterNames = request.getParameterNames();
//        parameterNames.asIterator().forEachRemaining(pm->{
//           log.info("param = {}" , pm);
//           log.info("request = {}",  request.getParameter(pm));
//        });

        
        //복구 parameter
        String[] usernames = request.getParameterValues("username");
        Arrays.stream(usernames).forEach(item ->{
            log.info("username ={}", item);
        });

        response.getWriter().write("Ok");
    }
}
