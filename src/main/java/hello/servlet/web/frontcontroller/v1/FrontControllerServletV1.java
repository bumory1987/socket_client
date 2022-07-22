package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.impl.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.impl.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.impl.MemberSaveControllerV1;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet(name= "frontControllerServletV1" , urlPatterns = "/front-controller/v1/*")
@Slf4j
public class FrontControllerServletV1 extends HttpServlet {
    private Map<String , ControllerV1> ControllerMap = new HashMap<>();

    public FrontControllerServletV1() {
        ControllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        ControllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        ControllerMap.put("/front-controller/v1/members", new MemberListControllerV1());

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("start application without problem");
        ControllerV1 select = ControllerMap.get(req.getRequestURI());
        if(select == null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        select.process(req, resp);
    }
}
