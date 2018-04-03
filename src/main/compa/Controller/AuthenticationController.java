package main.compa.Controller;

import com.google.gson.Gson;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;
import main.compa.App.Container;
import main.compa.App.Controller;
import main.compa.Model.User;
import main.compa.daos.UserDAO;
import org.apache.commons.lang3.RandomStringUtils;

public class AuthenticationController extends Controller {

    private UserDAO userDAO;

    public AuthenticationController(){
        super();
        this.registerRoute(HttpMethod.POST, "/login", this::login, "application/json");
        userDAO = (UserDAO) Container.getInstance().getModelManager().getDAO(User.class);
    }

    private void login(RoutingContext routingContext){
        String login = routingContext.request().getParam("login");
        String password = routingContext.request().getParam("password");
        String token = checkAuth(login, password);
        Object content = token == null ? "error " : token; //TODO DEFINE STRUCTURE OF RETURNED JSON
        routingContext.response().end(new Gson().toJson(content));
    }

    private String checkAuth(String login, String password){
            User user = userDAO.getByLoginAndPassword(login, password);
            if(user == null)
                return null;

            String token =  RandomStringUtils.random(16);
            user.setToken(token);
            return token;
    }
}