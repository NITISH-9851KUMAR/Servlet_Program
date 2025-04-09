/** There are total Three class which is generally used in JSP Program
 * Servlet Interface
 * GenericServlet Class
 * HttpServlet Class
 * But HttpServlet class is frequently used in JSP program due to HTTP-based web apps
 * HttpServlet has more method but some commonly method that is frequently used in Program
 * */
package BasicsServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/HttpServlet-Class")
public class HttpServletClass extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        response.setContentType("text/html");
        PrintWriter out= response.getWriter();

        out.println("<a>HttpServlet Class</a>");

    }
}

