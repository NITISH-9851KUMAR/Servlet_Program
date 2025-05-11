package BasicsProgram;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;

@WebServlet("/s1")
public class Attribute1 extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out= response.getWriter();

        String s1= request.getParameter("n1");
        String s2= request.getParameter("n2");

        int n1= Integer.parseInt(s1);
        int n2= Integer.parseInt(s2);

        int sum= n1+n2;

        // We can not print this
//        out.println("<h2> Sum: "+sum+"</h2>");

        // Set the attribute to another servlet using this servlet
        // "sum" is name that is recognized as attribute ,sum is value
        request.setAttribute("sum", sum);

        // Store s2 link in RequestDispatcher Interface
        RequestDispatcher rd= request.getRequestDispatcher("s2");

        rd.forward(request, response);
    }
}
