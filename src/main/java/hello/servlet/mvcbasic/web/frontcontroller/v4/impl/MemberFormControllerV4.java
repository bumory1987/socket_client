package hello.servlet.mvcbasic.web.frontcontroller.v4.impl;

import hello.servlet.mvcbasic.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4 {
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> Model) {
        return "new-form";
    }
}
