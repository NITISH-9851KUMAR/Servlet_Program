package BasicsProgram;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;


@WebServlet("/URLWriting2")
public class URLWriting2 extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{

        response.setContentType("text/html");
        PrintWriter out= response.getWriter();

        String name= request.getParameter("user");
        out.println("<h1 style='color: red'>Welcome to Servlet 2nd</h1>");
        out.println("<h1>Name: "+name+"</h1>");

    }
}

