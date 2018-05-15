package by.bsuir.talakh.core.command;

import by.bsuir.talakh.core.ServiceFactory;
import by.bsuir.talakh.js_operator.OperatorService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddOperatorCmd implements ICommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        OperatorService operatorService = ServiceFactory.getInstance().getOperatorService();
        int id = operatorService.addOperator(request);
        response.sendRedirect("/js?command=take_operator&id=" + id);

    }
}
