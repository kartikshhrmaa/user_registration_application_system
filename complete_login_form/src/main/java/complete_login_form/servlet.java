package complete_login_form;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class servlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String uname = req.getParameter("username");
		String upass = req.getParameter("userpassword");
		String umail = req.getParameter("usermail");
		String ucourse = req.getParameter("usercourse");
		
		//AddUSer method, it collects users' information and adds it to the database,
		
		// Instances of emp class
		emp fruk = new emp();
		// set the parameters gotten to the 'uname'
		fruk.setName(uname); 
		fruk.setPass(upass); 
		fruk.setMail(umail);
		fruk.setCourse(ucourse); 
		
		int status = 0;
        try {
        	// static method add the values stored in the
            // fruk object to the database
        	status = EmpDao.addUser(fruk);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        //if name and other col are empty it show some error without registering
        if (uname == null || uname.trim().isEmpty() ||
        	    upass == null || upass.trim().isEmpty() ||
        	    umail == null || umail.trim().isEmpty()) {
        	    out.println("<html><body bgcolor='red' ><h1>EMPTY INPUT DETECTED</h1></body></html>");
        	    out.println("<p>Please fill all fields!</p>");
        	    return;
       	}
     // check if the values correspond to the one specified
        if(status>0) {        	
        	out.print("<html><body>"
        	        + "<div style='position: absolute; top: 80%; left: 50%;"
        	        + "transform: translate(-50%, -50%); text-align: center;'>"
        	        + "<p style='color: white; font-weight: bold;'>Your record saved successfully!</p>"
        	        + "</div>"
        	        + "</body></html>");

        	//for showing result to the index.html page use below,
        	req.getRequestDispatcher("NewFile.jsp").include(req, res); 
        }else{ 
        	out.println("Sorry! unable to save record"); 
        } 
        out.close(); 
        
        
	}
}

