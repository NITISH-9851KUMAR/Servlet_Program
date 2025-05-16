package BasicsProgram;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/Form2")
@MultipartConfig
public class AjaxClass extends HttpServlet {

    private static String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
    private static String userName = "system";
    private static String pass = "nitish";

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String user = request.getParameter("user-name");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");

        try {
            Thread.sleep(2000);

            // Save data to database
            Connection connection = DriverManager.getConnection(url, userName, pass);
            String query = "INSERT INTO form VALUES(?, ?, ?)";
            PreparedStatement pStmt = connection.prepareStatement(query);
            pStmt.setString(1, user);
            pStmt.setString(2, email);
            pStmt.setString(3, password);

//            pStmt.executeUpdate();
            connection.close();

            out.print("success"); // send response back to AJAX

        } catch (Exception e) {
            e.printStackTrace();
            out.print("error");
        }
    }
}
