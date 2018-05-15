package by.bsuir.talakh.core.command;

import by.bsuir.talakh.core.JspPagePath;
import by.bsuir.talakh.core.ServiceFactory;
import by.bsuir.talakh.js_object.JsObjectService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteJsObjectCmd implements ICommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsObjectService jsObjectService = ServiceFactory.getInstance().getJsObjectService();
        jsObjectService.deleteJsObject(request);
        response.sendRedirect(JspPagePath.INDEX);
    }
}
