package ua.edu.ucu.webapp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.edu.ucu.webapp.command.*;

/**
 *
 * @author Andrii_Rodionov
 */
@WebServlet(name = "WebAppServlet", urlPatterns = {"/ucu/*"})
public class WebAppServlet extends HttpServlet {
    
    private final Map<String, WebCommand> commandsMap = new HashMap<>();
    {        
        commandsMap.put("/hello", new HelloWebCommand());
        commandsMap.put("/add", new AdditionWebCommand());
    }

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        WebCommand webCommand = getWebCommand(request);
        if (webCommand != null) {
            webCommand.execute(request, response);
        }
    }

    private WebCommand getWebCommand(HttpServletRequest request) {
        String url = request.getRequestURI();
        String webCommandName = getWebCommandName(url);
        WebCommand webCommand = getWebCommandByName(webCommandName);
        return webCommand;
    }

    private String getWebCommandName(String url) {
        return url.substring(url.lastIndexOf("/"));
    }

    private WebCommand getWebCommandByName(String webCommandName) {
        return commandsMap.get(webCommandName);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
