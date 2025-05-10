package BasicsProgram;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Dispatcher")

public class RequestDispatcherClass extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

        response.setContentType("text/html");
        PrintWriter out= response.getWriter();

        String fullName= request.getParameter("name");
        String email= request.getParameter("email");
        String phone= request.getParameter("phone");
        String gender= request.getParameter("gender");
        String branch= request.getParameter("branch");
        String checked= request.getParameter("checked");

        if(checked==null){
            out.println("<h2 style=\"color: red; text-align:center;\">Terms & Condition is not Accept</h2>");
            out.println();
            // if condition is not checked then again show to form
            // for this get the object of form file using RequestDispatcher
            RequestDispatcher rd= request.getRequestDispatcher("RequestDispatcher.html");
            // after getting the object of RequestDispatcher.html file, show on web using include
            rd.include(request, response);

        }
        else{
            out.println("<p> Name: " + fullName + "</p>");
            out.println("<p> Email: " + email + "</p>");
            out.println("<p> Phone: " + phone + "</p>");
            out.println("<p> Gender: " + gender + "</p>");
            out.println("<p> Branch: " + branch + "</p>");

            RequestDispatcher rd1= request.getRequestDispatcher("successfully");
//            rd1.forward(request, response);  // when we will use forward then only rd1 will execute
//            Other line of else condition will not execute
            rd1.include(request, response);
        }





    }
}
