package complete_login_form;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class deleteServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
        int id = Integer.parseInt(req.getParameter("id"));         
        //the delete method is invoked on user with the specified id
            	EmpDao.deleteUser(id);
                //it sent the current user to different url- readServlet
            	res.sendRedirect("readServlet");
        }
}	
