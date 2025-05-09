package BasicsProgram;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/successfully")
public class SuccessfullyServlet extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{

        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        out.println("<h2>Successfully Data Saved to the Database!</h2>");

    }
}
