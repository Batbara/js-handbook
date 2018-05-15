package by.bsuir.talakh.core.command.auth;

import by.bsuir.talakh.core.command.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

public class GoogleAuthCmd implements ICommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResourceBundle rb = ResourceBundle.getBundle("auth");
        String authUri = new StringBuilder(rb.getString("auth.google.authURI"))
                .append("?").append("client_id=").append(rb.getString("auth.google.clientId"))
                .append("&").append("redirect_uri=").append(rb.getString("auth.google.redirectURI"))
                .append("&").append("response_type=code").append("&").append("access_type=offline")
                .append("&").append("scope=").append(rb.getString("auth.google.scope"))
                .toString();
        response.sendRedirect(authUri);
    }
}
