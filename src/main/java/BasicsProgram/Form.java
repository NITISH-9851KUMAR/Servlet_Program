package BasicsProgram;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/Form")

public class Form extends HttpServlet {

    private static String url= "jdbc:oracle:thin:@127.0.0.1:1521:XE";
    private static String userName= "system";
    private static String pass= "nitish";

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        response.setContentType("text/html");
        PrintWriter out= response.getWriter();

        String name= request.getParameter("user_name");
        String email= request.getParameter("email");
        String password= request.getParameter("password");

        // JDBC Program

        try{

            Thread.sleep(2000);

            Connection connection= DriverManager.getConnection(url, userName, pass);

            String query= "INSERT INTO form VALUES(?, ?, ?)";
            PreparedStatement pStmt= connection.prepareStatement(query);
            pStmt.setString(1, name);
            pStmt.setString(2, email);
            pStmt.setString(3, password);

            pStmt.executeUpdate();

            out.println("done");
//            System.out.println("Data Successfully save to the Database");
////
//            RequestDispatcher rd= request.getRequestDispatcher("Signup.jsp");
//            rd.include(request, response);

        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
