package by.bsuir.talakh.core.command;

import by.bsuir.talakh.core.JspParameter;
import by.bsuir.talakh.core.ServiceFactory;
import by.bsuir.talakh.js_object.JsObjectService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateJsObjectCmd implements ICommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsObjectService jsObjectService = ServiceFactory.getInstance().getJsObjectService();
        jsObjectService.updateJsObject(request);
        response.sendRedirect("/js?command=take_js_object&id=" + request.getParameter(JspParameter.ID));
    }
}
