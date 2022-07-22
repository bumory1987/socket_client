package hello.servlet.web.frontcontroller;


import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {
    Boolean supports(Object handler);

    ModelView handle(HttpServletRequest request, HttpServletResponse response , Object handler) throws ServletException, IOException;

}
