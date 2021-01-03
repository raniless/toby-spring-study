package springbook.learningtest.spring.web.controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public abstract class SimpleController implements Controller {
    private String[] requiredParams; // 필수 파라미터를 정의한다. 이 파라미터만 control() 메소드로 전달된다.
    private String viewName;

    public void setRequiredParams(String[] requiredParams) {
        this.requiredParams = requiredParams;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    @Override
    final public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //뷰 이름 프로퍼티가 지정되지 않았으면 예외를 발생시킨다.
        if(viewName == null) {
            throw new IllegalStateException();
        }

        //필요한 파라미터를 가져와 Map에 담는다. 존재하지 않으면 예외를 발생시킨다.
        Map<String, String> params = new HashMap<>();
        for(String param : requiredParams) {
            String value = request.getParameter(param);
            if(value == null) {
                throw new IllegalStateException();
            }
            params.put(param ,value);
        }

        //모델용 Map을 미리 만들어서 전달해 준다.
        Map<String, Object> model = new HashMap<>();
        //개별 컨트롤러가 구현할 메소드를 호출한다.
        control(params, model);

        //Controller 인터페이스의 정의에 따라 ModelAndView 타입의 결과를 돌려준다.
        return new ModelAndView(viewName, model);
    }

    //서브클래스가 구현할 실제 컨트롤러 로직을 담을 메소드
    public abstract void control(Map<String, String> params, Map<String, Object> model) throws Exception;
}