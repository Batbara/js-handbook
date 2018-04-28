package by.bsuir.talakh.core.command;

import by.bsuir.talakh.core.JspPagePath;
import by.bsuir.talakh.core.JspParameter;
import by.bsuir.talakh.core.ServiceFactory;
import by.bsuir.talakh.js_operator.Operator;
import by.bsuir.talakh.js_operator.OperatorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TakeOperatorCmd implements ICommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter(JspParameter.ID);

        OperatorService operatorService = ServiceFactory.getInstance().getOperatorService();
        Operator operator = operatorService.takeOperator(id);
        request.setAttribute(JspParameter.OPERATOR, operator);
        request.getRequestDispatcher(JspPagePath.OPERATOR_JSP).forward(request, response);
    }
}
