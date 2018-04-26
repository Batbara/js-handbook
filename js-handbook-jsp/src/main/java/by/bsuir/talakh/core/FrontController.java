package by.bsuir.talakh.core;

import java.io.IOException;

public class FrontController extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String commandName = request.getParameter(TextConstant.COMMAND);

        ICommand command = CommandProvider.getInstance().getCommand(commandName);
        if(command != null) {
            command.execute(request, response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        doPost(request,response);
    }
}
