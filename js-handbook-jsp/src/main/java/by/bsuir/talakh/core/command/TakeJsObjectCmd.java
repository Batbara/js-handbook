package by.bsuir.talakh.core.command;

import by.bsuir.talakh.core.JspPagePath;
import by.bsuir.talakh.core.JspParameter;
import by.bsuir.talakh.core.ServiceFactory;
import by.bsuir.talakh.js_object.JsObject;
import by.bsuir.talakh.js_object.JsObjectService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TakeJsObjectCmd implements ICommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter(JspParameter.ID);

        JsObjectService jsObjectService = ServiceFactory.getInstance().getJsObjectService();
        JsObject jsObject = jsObjectService.takeJsObject(id);
        request.setAttribute(JspParameter.JS_OBJECT, jsObject);
        request.getRequestDispatcher(JspPagePath.JS_OBJECT_JSP).forward(request, response);
    }
}
