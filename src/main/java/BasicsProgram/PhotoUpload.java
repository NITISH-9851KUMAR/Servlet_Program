package BasicsProgram;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.http.Part;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/photo-upload")
@MultipartConfig

public class PhotoUpload extends HttpServlet {

    private static String url= "jdbc:oracle:thin:@127.0.0.1:1521:XE";
    private static String userName= "system";
    private static String pass= "nitish";

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        response.setContentType("text/html");
        PrintWriter out= response.getWriter();

        String name= request.getParameter("name");
        String email= request.getParameter("email");
        String password= request.getParameter("pass");
        Part part= request.getPart("fileInput"); // Part type of Statement store file type input
        String fileName= part.getSubmittedFileName(); // get the file name through part object


        try{

            Thread.sleep(2000);

            // JDBC Program
            Connection connection= DriverManager.getConnection(url, userName, pass);

            String query= "INSERT INTO form VALUES(?, ?, ?, ?)";
            PreparedStatement pStmt= connection.prepareStatement(query);
            pStmt.setString(1, name);
            pStmt.setString(2, email);
            pStmt.setString(3, password);
            pStmt.setString(4, fileName);

            pStmt.executeUpdate();
            pStmt.close();

            // File store in drive
            String path= request.getRealPath("/")+"image"+File.separator+fileName;

            InputStream stream = part.getInputStream();
            FileOutputStream fos = new FileOutputStream(path);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = stream.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            fos.close();
            stream.close();

            out.println("success"); // send respond to the AJAX
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
