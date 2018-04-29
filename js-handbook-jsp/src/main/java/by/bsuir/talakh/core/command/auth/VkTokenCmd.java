package by.bsuir.talakh.core.command.auth;

import by.bsuir.talakh.core.AuthException;
import by.bsuir.talakh.core.JspPagePath;
import by.bsuir.talakh.core.JspParameter;
import by.bsuir.talakh.core.User;
import by.bsuir.talakh.core.command.ICommand;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ResourceBundle;

public class VkTokenCmd implements ICommand {
    private Logger LOGGER = Logger.getLogger(VkTokenCmd.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = request.getParameter(JspParameter.CODE);
        HttpClient httpClient = HttpClients.createDefault();

        URI uri = buildUri(code);
        HttpGet get = new HttpGet(uri);
        InputStream responseStream = httpClient.execute(get).getEntity().getContent();
        JSONObject jsonObject = new JSONObject(new JSONTokener(new InputStreamReader(responseStream)));
        if (!jsonObject.has("access_token")) {
            response.sendRedirect(JspPagePath.INDEX);
            return;
        }
        String accessToken = jsonObject.getString("access_token");
        int id = jsonObject.getInt("user_id");
     /*   User user = new User();
        user.setAccessToken(accessToken);
        user.setName("lol");
        user.setSurname("kek");*/
        User user = takeUserInfo(httpClient, id);
        //user.setAccessToken(accessToken);

        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        response.sendRedirect(JspPagePath.INDEX);
    }

    private User takeUserInfo(HttpClient httpClient, int id) throws IOException {
        ResourceBundle rb = ResourceBundle.getBundle("auth");
        try {
            URI uri = new URIBuilder()
                    .setScheme("https")
                    .setHost("api.vk.com")
                    .setPath("method/users.get")
                    .addParameter("user_ids", Integer.toString(id))
                    .addParameter("v", rb.getString("auth.vk.version"))
                    .build();
            HttpGet get = new HttpGet(uri);
            InputStream responseStream = httpClient.execute(get).getEntity().getContent();
            JSONObject jsonObject = new JSONObject(new JSONTokener(new InputStreamReader(responseStream)));
            if (jsonObject.has("error")) {
                System.out.println(jsonObject.toString());
                return new User();
            }
            User user = new User();
            JSONArray response = jsonObject.getJSONArray("response");
            for (int entry = 0; entry < response.length(); entry++) {
                JSONObject object = response.getJSONObject(entry);
                if (object.has("first_name")) {
                    user.setName(decode(object.getString("first_name")));
                }
                if (object.has("last_name")) {
                    user.setSurname(decode(object.getString("last_name")));
                }
            }
            return user;
        } catch (URISyntaxException e) {
            throw new AuthException("Cannot build uri", e);
        }
    }

    private URI buildUri(String code) {
        ResourceBundle rb = ResourceBundle.getBundle("auth");
        try {
            return new URIBuilder()
                    .setScheme("https")
                    .setHost("oauth.vk.com")
                    .setPath("access_token")
                    .addParameter("client_id", rb.getString("auth.vk.clientId"))
                    .addParameter("client_secret", rb.getString("auth.vk.secret"))
                    .addParameter("redirect_uri", rb.getString("auth.vk.redirectURI"))
                    .addParameter("code", code)
                    .build();
        } catch (URISyntaxException e) {
            throw new AuthException("Error while building uri", e);
        }
    }

    private String decode(String encoded) {
        try {
            return new String(encoded.getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return encoded;
        }
    }
}
