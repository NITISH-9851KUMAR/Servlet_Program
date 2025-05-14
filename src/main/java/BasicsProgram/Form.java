package BasicsProgram;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.Part;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/Form")
@MultipartConfig

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
        Part part= request.getPart("image"); // Part is type of file store photo
        String fileName= part.getSubmittedFileName();
        out.println(fileName);

        // JDBC Program

        try{

            Thread.sleep(2000);

            Connection connection= DriverManager.getConnection(url, userName, pass);

            String query= "INSERT INTO form VALUES(?, ?, ?, ?)";
            PreparedStatement pStmt= connection.prepareStatement(query);
            pStmt.setString(1, name);
            pStmt.setString(2, email);
            pStmt.setString(3, password);
            pStmt.setString(4, fileName);

            pStmt.executeUpdate();
            // file upload
            InputStream is= part.getInputStream();
            byte[] data= new byte[is.available()];
            is.read(data);
            String path= request.getRealPath("/")+"image"+ File.separator+fileName;
            out.println(path);
            FileOutputStream fos= new FileOutputStream(path);
            fos.write(data);
            fos.close();
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
