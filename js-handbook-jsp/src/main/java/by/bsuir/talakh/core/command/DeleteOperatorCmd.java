package by.bsuir.talakh.core.command;

import by.bsuir.talakh.core.JspPagePath;
import by.bsuir.talakh.core.ServiceFactory;
import by.bsuir.talakh.js_operator.OperatorService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteOperatorCmd implements ICommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        OperatorService operatorService = ServiceFactory.getInstance().getOperatorService();
        operatorService.deleteOperator(request);
        response.sendRedirect(JspPagePath.INDEX);
    }
}
