package complete_login_form;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class editSErvlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter(); 
		String sid=request.getParameter("id"); 
		int id=Integer.parseInt(sid); 
		String name=request.getParameter("name"); 
		String password=request.getParameter("password"); 
		String email=request.getParameter("email"); 
		String course=request.getParameter("course"); 
		emp e=new emp(); 
		e.setId(id); 
		e.setName(name); 
		e.setPass(password); 
		e.setMail(email); 
		e.setCourse(course); 
		int status=EmpDao.updateUser(e); 
		if(status>0){ 
			request.getSession().setAttribute("message", "Data Updated Successfully!");
		response.sendRedirect("readServlet"); 
		}else{ 
		out.println("Sorry! unable to update record"); 
		} 
}
	}