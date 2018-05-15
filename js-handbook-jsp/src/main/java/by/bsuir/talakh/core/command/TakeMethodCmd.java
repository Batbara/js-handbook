package by.bsuir.talakh.core.command;

import by.bsuir.talakh.core.JspPagePath;
import by.bsuir.talakh.core.JspParameter;
import by.bsuir.talakh.core.ServiceFactory;
import by.bsuir.talakh.js_method.Method;
import by.bsuir.talakh.js_method.MethodService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TakeMethodCmd implements ICommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter(JspParameter.ID);

        MethodService methodService = ServiceFactory.getInstance().getMethodService();
        Method method = methodService.takeMethod(id);
        request.setAttribute(JspParameter.METHOD, method);
        request.getRequestDispatcher(JspPagePath.METHOD_JSP).forward(request, response);
    }
}
