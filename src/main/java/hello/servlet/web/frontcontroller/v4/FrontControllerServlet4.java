package hello.servlet.web.frontcontroller.v4;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlet.web.frontcontroller.v4.impl.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.v4.impl.MemberListControllerV4;
import hello.servlet.web.frontcontroller.v4.impl.MemberSaveControllerV4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


@WebServlet(name = "frontControllerServlet4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServlet4 extends HttpServlet {


    private HashMap<String, ControllerV4> ControllerMap = new HashMap<>();

    public FrontControllerServlet4() {
        ControllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        ControllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        ControllerMap.put("/front-controller/v4/members", new MemberListControllerV4());

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ControllerV4 select = ControllerMap.get(request.getRequestURI());
        if(select == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> Model = new HashMap<>();
        String viewName = select.process(paramMap, Model);

        MyView view = viewResolver(viewName);

        view.render(Model, request, response);

    }


    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }


    private Map<String, String> createParamMap(HttpServletRequest req) {
        Map<String, String> paramMap = new HashMap<>();
        req.getParameterNames().asIterator().forEachRemaining(paramName->{
            paramMap.put(paramName, req.getParameter(paramName));
        });
        return paramMap;
    }

}
