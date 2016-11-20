package ua.edu.ucu.webapp.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.edu.ucu.webapp.WebCommand;

public class HelloWebCommand implements WebCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hello UCU</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<b>" + new Date() + "</b></br>");
            out.println("<b> Hello " + request.getParameter("name") + "</b>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
