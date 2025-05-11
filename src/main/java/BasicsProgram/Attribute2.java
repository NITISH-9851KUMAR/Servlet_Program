package BasicsProgram;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/s2")
public class Attribute2 extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

        response.setContentType("text/html");
        PrintWriter out= response.getWriter();

        // It is parameter so we need to store in always String
        String n1= request.getParameter("n1");
        String n2= request.getParameter("n2");

        int a= Integer.parseInt(n1);
        int b= Integer.parseInt(n2);

        // It is attribute which is set by the s2 caller program
        int sum= (int)request.getAttribute("sum");

        out.println("<h2>Sum: "+sum+"</h2>");
        out.println("<h2>Mul: "+(a*b)+"</h2>");

    }
}
