/** A GenericServlet is Abstract class which has more method but one is abstract method "service"
 * a program must override this method if they inherit this Abstract class. */
package BasicsServlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GenericServlet-Class")
public class GenericServletClass extends GenericServlet{
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {

        System.out.println("This is servlet Using Generic Servlet....");
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();

        out.println("<h1>Main Hu Generic Servlet</h1>");
        out.println("<h1>Main Service method dwara implement hota hu.</h1>");

    }
}
