package BasicsProgram;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;


@WebServlet("/servlet2")

public class SessionTracking2 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        proceed(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        proceed(request, response);

    }

    void proceed(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{


        response.setContentType("text/html");
        PrintWriter out= response.getWriter();

        // Getting all the cookies....

        Cookie[] cookies= request.getCookies();
        boolean flag= false;
        String name= "";

        if(cookies == null) {
                out.println("<a href=\"Session_Tracking.html\"> Home Page </a>");
            out.println("");
            return;
        }
        else{
            for(Cookie c: cookies){
                if(("user_name").equals(c.getName())){
                    name= c.getValue();
                    flag= true;
                }
            }
        }

        if(flag){
            out.println("<h1>Name: "+name+"</h1>");
            out.println("<a href=\"Session_Tracking.html\"> Home Page </a>");
        }else
            out.println("<h1>New User go to home page and submit you name");

    }
}
