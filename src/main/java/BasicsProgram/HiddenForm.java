package BasicsProgram;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/HiddeForm1")
public class HiddenForm extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{

        response.setContentType("text/html");
        PrintWriter out= response.getWriter();

        String name= request.getParameter("user-name");

        out.println("<h1 style='color: green'>Welcome to First Servlet</h1>");

        // hidden form filling coding
        out.println("" +
                "<form action='HiddenForm2'>" +
                "<input type='hidden' name= 'user-name' value='"+name+"'>" +
                "<button type='submit'>Go 2nd Servlet</button>" +
                "</form>");


    }
}
