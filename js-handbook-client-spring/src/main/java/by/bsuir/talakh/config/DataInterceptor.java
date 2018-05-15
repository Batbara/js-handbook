package by.bsuir.talakh.config;

import by.bsuir.talakh.entity.JsObject;
import by.bsuir.talakh.entity.Method;
import by.bsuir.talakh.entity.Operator;
import by.bsuir.talakh.repository.JsObjectRepository;
import by.bsuir.talakh.repository.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class DataInterceptor implements HandlerInterceptor {
    @Autowired
    private JsObjectRepository jsObjectRepository;

    @Autowired
    private OperatorRepository operatorRepository;


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            List<JsObject> jsObjects = jsObjectRepository.takeAll();
            modelAndView.addObject("jsObjectList", jsObjects);
            modelAndView.addObject("newMethod", new Method());
            modelAndView.addObject("newOperator", new Operator());
            modelAndView.addObject("newJsObject", new JsObject());
            List<Operator> operators = operatorRepository.takeAll();
            modelAndView.addObject("operatorList", operators);
        }

    }
}
