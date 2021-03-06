package by.bsuir.talakh.core;

import by.bsuir.talakh.core.command.CommandProvider;
import by.bsuir.talakh.core.command.ICommand;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;

public class FrontController extends javax.servlet.http.HttpServlet {
    @Override
    public void init() {
        BasicConfigurator.configure();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String commandName = request.getParameter(JspParameter.COMMAND);

        ICommand command = CommandProvider.getInstance().getCommand(commandName);
        if(command != null) {
            command.execute(request, response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        doPost(request,response);
    }
}
