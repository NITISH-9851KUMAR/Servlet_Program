/** A Servlet is an interface which has total five abstract method a program must override these all method
 * void init(ServletConfig config){}
 * void service(ServletRequest request, ServletResponse response){}
 * void destroy()
 * ServletConfig getServletConfig(){}
 * String getServletInfo(){}
 */
package BasicsServlet;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/Servlet-Interface")
public class ServletInterface implements Servlet{

    //Life cycle method
    ServletConfig config;

    // Life cycle Method
    public void init(ServletConfig config){
        this.config= config;
        System.out.println("Init Method is called");
        System.out.println("Creating object:....");
    }

    // Life cycle Method
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException{
        System.out.println("Servicing.............");
        System.out.println("Servicing Method is starts.......");

        //set Content type
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        out.println("<a>Created Servlet Using Servlet Interface</a> <br> ");
        out.println("<a>Date: "+new Date().toString().toString());
    }

    // Life cycle Method
    public void destroy(){
        System.out.println("going to destroy servlet object..");
    }

    //Non Life cycle Method
    public ServletConfig getServletConfig(){
        return config;
    }

    //Non Life cycle Method
    public String getServletInfo(){
        return "This Servlet created by me!";
    }

}

