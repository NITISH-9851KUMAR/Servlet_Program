package BasicsProgram;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.*;

@WebServlet(urlPatterns = "/Student-Registration-form")
public class StudentForm extends HttpServlet{

    final String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
    final String userName = "system";
    final String password = "nitish";

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        response.setContentType("text/html");
        PrintWriter out= response.getWriter();

        String fullName= request.getParameter("name");
        String email= request.getParameter("email");
        String phone= request.getParameter("phone");
        String gender= request.getParameter("gender");
        String branch= request.getParameter("branch");
        String dob= request.getParameter("dob");

        System.out.println(fullName);
        System.out.println(email);
        System.out.println(phone);
        System.out.println(gender);
        System.out.println(branch);
        System.out.println(dob);


        // Use JDBC Program to Store data Into "student_form" Table
        Connection conn;
        PreparedStatement pStmt;

        try{

            // Create a connection
            conn= DriverManager.getConnection(url, userName, password);
            // Query
            String query= "INSERT INTO student_form(name,email,phone,gender,branch,dob) VALUES(?, ?, ?, ?, ?, ?)";
            // Create a Statement
            pStmt= conn.prepareStatement(query);

            // Set the value
            pStmt.setString(1, fullName);
            pStmt.setString(2, email);
            pStmt.setString(3, phone);
            pStmt.setString(4, gender);
            pStmt.setString(5, branch);
            pStmt.setString(6, dob);

            // execute sql Query
            pStmt.executeUpdate();
            conn.close(); // close the connection
            pStmt.close(); // close the statement

            out.println("<html>");
            out.println("<head>");
            out.println("<style>");
            out.println(".success-message {");
            out.println("    color: green;");
            out.println("    font-size: 22px;");
            out.println("    font-weight: bold;");
            out.println("    text-align: center;");
            out.println("    margin-top: 50px;");
            out.println("    font-family: Arial, sans-serif;");
            out.println("    background-color: #e8f5e9;");
            out.println("    padding: 20px;");
            out.println("    border-radius: 10px;");
            out.println("    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"success-message\">Form Successfully Submitted!</div>");
            out.println("</body>");
            out.println("</html>");

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}
