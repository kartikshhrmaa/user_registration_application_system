package complete_login_form;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class readServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	res.setContentType("text/html"); 
	PrintWriter out=res.getWriter(); 
	out.println("<html><body bgcolor='lightgreen'></body></html>"); 
	
	//message after updating something
	HttpSession session = req.getSession(false); // Don't create if doesn't exist
    if (session != null && session.getAttribute("message") != null) {
        String message = (String) session.getAttribute("message");
        out.println("<p style='color: blue; font-weight: bold;'>" + message + "</p>");
        session.removeAttribute("message"); // Clear after displaying
    }
    
	out.println("<a href='index.html' color='black'>Add New Employee</a>"); 
	out.println("<h1>Employees List</h1>"); 

        List<emp> list = EmpDao.getAllEmployees();
        out.print("<table border='1' width='100%'>");
        out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Course</th><th>Edit</th><th>Delete</th></tr>");

        for (emp employee : list) {
            out.print("<tr><td>" + employee.getId() + "</td><td>" + employee.getName() + "</td><td>" + employee.getPass()
                    + "</td><td>" + employee.getMail() + "</td><td>" + employee.getCourse()
                    + "</td><td><a href='editServlet?id=" + employee.getId() + "'>edit</a></td>"
                    + "<td><a href='deleteServlet?id=" + employee.getId() + "'>delete</a></td></tr>");
        }

        out.print("</table>");
        out.close();
 		}
	}