package BasicsProgram;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

@WebServlet("/Simple-Database")
public class SimpleDatabase extends HttpServlet {
    // it doesn't support in JSP Program
    // String url = "jdbc:oracle:thin:@localhost:1521:XE";
    final String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
    final String userName = "system";
    final String password = "nitish";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String obj= "Har Har Mahadev";

        // display the User input data
        out.println("<a>Object: " + obj + "</a>");

        try {
            // Establish the connection
            Connection connection = DriverManager.getConnection(url, userName, password);

            Statement statement = connection.createStatement();

            String query= String.format("INSERT INTO JSPDataBase(obj) VALUES('%s')",obj);
            int rowAffected= statement.executeUpdate(query);
            if(rowAffected>0)
                System.out.println("Save data into database!");

            System.out.println("Successfully Execute This Program");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<br>Error: " + e.getMessage());
        }
    }
}
