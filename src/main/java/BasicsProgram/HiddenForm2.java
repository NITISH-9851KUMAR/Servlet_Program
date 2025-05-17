package BasicsProgram;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/HiddenForm2")
public class HiddenForm2 extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{

        response.setContentType("text/html");
        PrintWriter out= response.getWriter();

        out.println("<h1 style='color: green'>Welcome to Second Servlet</h1>");
        String name= request.getParameter("user-name");
        out.println("<h1>Name: "+name+"</h1>");

    }
}
