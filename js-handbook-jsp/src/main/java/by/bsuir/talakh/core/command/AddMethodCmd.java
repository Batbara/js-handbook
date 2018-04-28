package by.bsuir.talakh.core.command;

import by.bsuir.talakh.core.ServiceFactory;
import by.bsuir.talakh.js_method.MethodService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddMethodCmd implements ICommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        MethodService methodService = ServiceFactory.getInstance().getMethodService();
        int id = methodService.addMethod(request);
        response.sendRedirect("/js?command=take_method&id=" + id);
    }
}
