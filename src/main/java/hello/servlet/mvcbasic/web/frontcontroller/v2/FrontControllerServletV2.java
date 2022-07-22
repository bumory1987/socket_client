package hello.servlet.mvcbasic.web.frontcontroller.v2;

import hello.servlet.mvcbasic.web.frontcontroller.MyView;
import hello.servlet.mvcbasic.web.frontcontroller.v2.impl.MemberFormControllerV2;
import hello.servlet.mvcbasic.web.frontcontroller.v2.impl.MemberListControllerV2;
import hello.servlet.mvcbasic.web.frontcontroller.v2.impl.MemberSaveControllerV2;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name= "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
@Slf4j
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String , ControllerV2> ControllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        ControllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        ControllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        ControllerMap.put("/front-controller/v2/members", new MemberListControllerV2());

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("here");
        ControllerV2 select = ControllerMap.get(req.getRequestURI());
        if(select ==  null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        MyView myView = select.process(req, resp);
        myView.render(req, resp);

    }


}
