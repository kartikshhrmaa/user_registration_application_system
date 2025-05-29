package complete_login_form;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class editServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			
			response.setContentType("text/html"); 
			PrintWriter out=response.getWriter(); 
			
			out.println("<html><body bgcolor='cyan'><center><h1 style='margin-top:10rem;'>Update Employee</h1></center></html></body>"); 
			
			String sid=request.getParameter("id"); 
			
			int id=Integer.parseInt(sid);  
			
			emp e=EmpDao.getEmployeeById(id); 
			//center align
			out.println("<html><body bgcolor='cyan'><center>");
			
			out.print("<form action='editSErvlet2' method='post'>"); 
			out.print("<table>"); 
			out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>"); 
			out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>"); 
			out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getPass()+"'/></td></tr>"); 
			out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getMail()+"'/></td></tr>"); 
			out.print("<tr><td>Course:</td><td>"); 
			out.print("<select name='course' style='width:150px'>"); 
			out.print("<option>dataAnalysis</option>"); 
			out.print("<option>dataScientist</option>"); 
			out.print("<option>javaDeveloper</option>"); 
			out.print("</select>"); 
			out.print("</td></tr>"); 
			out.print("<tr><td><td colspan='2'><input type='submit'style='border:none; border-radius:10px; padding:10px 20px;"
					+ " font-size:0.8rem; margin-top:20px;font-weight: 600; background-color: #4f46e5; color: #ffffff;"
					+ " text-decoration: none; cursor:pointer; box-shadow: box-shadow: 0 4px 14px rgba(79, 70, 229, 0.3);;'"
					+ " value='Save & Update '/></td></td></tr>"); 
			out.print("</table>"); 
			out.print("</form>"); 
			out.println("</center></html></body>");
			out.close(); 

}
	}