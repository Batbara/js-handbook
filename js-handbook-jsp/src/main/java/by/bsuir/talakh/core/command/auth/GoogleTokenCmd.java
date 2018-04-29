package by.bsuir.talakh.core.command.auth;

import by.bsuir.talakh.core.JspPagePath;
import by.bsuir.talakh.core.JspParameter;
import by.bsuir.talakh.core.User;
import by.bsuir.talakh.core.command.ICommand;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.json.JSONTokener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class GoogleTokenCmd implements ICommand {
    private Logger LOGGER = org.apache.log4j.Logger.getLogger(GoogleTokenCmd.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = request.getParameter(JspParameter.CODE);

        ResourceBundle rb = ResourceBundle.getBundle("auth");
        HttpClient httpClient = HttpClients.createDefault();

        HttpPost post = new HttpPost(rb.getString("auth.google.tokenURI"));
        String parameters = new StringBuilder("code=")
                .append(code)
                .append("&").append("grant_type=authorization_code")
                .append("&").append("client_id=").append(rb.getString("auth.google.clientId"))
                .append("&").append("client_secret=").append(rb.getString("auth.google.secret"))
                .append("&").append("redirect_uri=").append(rb.getString("auth.google.redirectURI"))
                .toString();
        post.setEntity(new StringEntity(parameters, ContentType.create("application/x-www-form-urlencoded")));

        HttpEntity entity = httpClient.execute(post).getEntity();
        InputStream responseStream = entity.getContent();

        JSONObject jsonObject = new JSONObject(new JSONTokener(new InputStreamReader(responseStream)));
        if (!jsonObject.has("access_token")) {
            LOGGER.info(jsonObject);
            response.sendRedirect(JspPagePath.INDEX);
            return;
        }
        String accessToken = jsonObject.getString("access_token");
        HttpGet get = new HttpGet(rb.getString("auth.google.userInfo") + "?alt=json&access_token=" + accessToken);
        InputStream userEntity = httpClient.execute(get).getEntity().getContent();
        JSONObject userJson = new JSONObject(new JSONTokener(new InputStreamReader(userEntity)));

        String name = userJson.getString("name");
        User user = new User();
        user.setFullName(name);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        response.sendRedirect(JspPagePath.INDEX);
    }
}
