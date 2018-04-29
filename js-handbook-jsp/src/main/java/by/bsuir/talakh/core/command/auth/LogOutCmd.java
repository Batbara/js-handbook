package by.bsuir.talakh.core.command.auth;

import by.bsuir.talakh.core.JspPagePath;
import by.bsuir.talakh.core.command.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogOutCmd implements ICommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(JspPagePath.INDEX);
    }
}
