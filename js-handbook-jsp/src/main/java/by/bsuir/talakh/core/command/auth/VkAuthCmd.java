package by.bsuir.talakh.core.command.auth;

import by.bsuir.talakh.core.command.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

public class VkAuthCmd implements ICommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResourceBundle rb = ResourceBundle.getBundle("auth");
        String authUri = new StringBuilder(rb.getString("auth.vk.authURI"))
                .append("?").append("client_id=").append(rb.getString("auth.vk.clientId"))
                .append("&").append("display=page")
                .append("&").append("redirect_uri=").append(rb.getString("auth.vk.redirectURI"))
                .append("&").append("scope=").append(rb.getString("auth.vk.scope"))
                .append("&response_type=code&v=").append(rb.getString("auth.vk.version"))
                .toString();
        System.out.println(authUri);
        response.sendRedirect(authUri);
    }
}
