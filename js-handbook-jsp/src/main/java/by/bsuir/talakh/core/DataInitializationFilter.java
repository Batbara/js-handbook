package by.bsuir.talakh.core;

import by.bsuir.talakh.js_method.Method;
import by.bsuir.talakh.js_method.MethodService;
import by.bsuir.talakh.js_object.JsObject;
import by.bsuir.talakh.js_object.JsObjectService;
import by.bsuir.talakh.js_operator.Operator;
import by.bsuir.talakh.js_operator.OperatorService;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.List;

public class DataInitializationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        JsObjectService jsObjectService = ServiceFactory.getInstance().getJsObjectService();
        MethodService methodService = ServiceFactory.getInstance().getMethodService();
        List<JsObject> objects = jsObjectService.takeJsObjectList();
        for (JsObject jsObject : objects) {
            List<Method> methods = methodService.takeMethodList(jsObject);
            jsObject.setMethodList(methods);
        }
        servletRequest.setAttribute(JspParameter.JS_OBJECT_LIST, objects);

        OperatorService operatorService = ServiceFactory.getInstance().getOperatorService();
        List<Operator> operatorList = operatorService.takeOperatorList();
        servletRequest.setAttribute(JspParameter.OPERATOR_LIST, operatorList);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
