package by.bsuir.talakh.core.command;

import by.bsuir.talakh.core.JspPagePath;
import by.bsuir.talakh.core.ServiceFactory;
import by.bsuir.talakh.js_method.MethodService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteMethodCmd implements ICommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MethodService methodService = ServiceFactory.getInstance().getMethodService();
        methodService.deleteMethod(request);
        response.sendRedirect(JspPagePath.INDEX);
    }
}
