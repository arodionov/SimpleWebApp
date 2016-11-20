package ua.edu.ucu.webapp.command;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.edu.ucu.webapp.WebCommand;

public class AdditionWebCommand implements WebCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String val1 = emptyOrVal(request.getParameter("val1"));
        String val2 = emptyOrVal(request.getParameter("val2"));

        Integer result = calculate(val1, val2);

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hello UCU</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='add' method='POST'>");
            out.println("<input type='text' name='val1' required='true' value='" + val1 + "' />");
            out.println(" + ");
            out.println("<input type='text' name='val2' required='true' value='" + val2 + "' />");
            out.println("<input type='submit' value='=' />");
            if (result != null) {
                out.println(result);
            }
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    String emptyOrVal(String parameter) {
        return parameter == null ? "" : parameter;
    }

    Integer calculate(String val1, String val2) {
        Integer result;
        try {
            int x = Integer.valueOf(val1);
            int y = Integer.valueOf(val2);
            result = x + y;
        } catch (NumberFormatException e) {
            result = null;
        }
        return result;
    }

}
