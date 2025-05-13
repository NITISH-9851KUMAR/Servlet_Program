package BasicsProgram;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;


@WebServlet("/servlet1")
public class SessionTracking1 extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{

        response.setContentType("text/html");
        PrintWriter out= response.getWriter();

        String name= request.getParameter("Name");

        out.println("<h1>Name: "+name+"</h1>");
        out.println("<h1>Welcome to Servlet One</h1>");
        out.println("<h1> <a href='servlet2'>Go to Servlet2</a>\n</h1>");

//        Cookie c= new Cookie("user_name", name);
//        response.addCookie(c);

    }
}
