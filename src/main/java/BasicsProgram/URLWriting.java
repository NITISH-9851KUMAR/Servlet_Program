package BasicsProgram;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

@WebServlet("/URLWriting")
public class URLWriting extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{

        response.setContentType("text/html");
        PrintWriter out= response.getWriter();

        out.println("<h1 style='color: green'>Welcome to First Servlet</h1>");
        String name= request.getParameter("user-name");
        out.println("<h1>Name: "+name+"</h1>");
        out.println("<a href='URLWriting2?user="+name+"'>Go to Second Servlet</a>");


    }
}
