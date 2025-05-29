package complete_login_form;
//DAO - data access object cls in which all crud operations are taken place and this is separate frm other clses to manage 
//manipulation and retrieving the data

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
	private static final String url = "jdbc:mysql://localhost:3306/login_form";
	private static final String name = "root";
	private static final String password = "Kartik@000";
		
	public static Connection connectDB() {
		Connection con = null;
		//connecting driver class
		try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e) {
        	System.out.println(e.getMessage());
        }
		try {
			//creating con instance which holds connection
        	con = DriverManager.getConnection(url,name,password);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//adding user data(creating)
	public static int addUser(emp employee)throws SQLException{
		int result = 0;
		try {
			Connection connect = EmpDao.connectDB();
			
			String query = "insert into user(name,password,email,course) values(?,?,?,?)";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setString(1, employee.getName());
			pstmt.setString(2, employee.getPass());
			pstmt.setString(3, employee.getMail());
			pstmt.setString(4, employee.getCourse());
			
			result = pstmt.executeUpdate();
			connect.close();
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		return result; 	
	}
	
	//delete user data(delete)
		public static int deleteUser(int id) {
	        int result = 0;
	        try {
	        	 Connection connect = EmpDao.connectDB();
	             PreparedStatement pstmt  = connect.prepareStatement("delete from user where id =?");
	             pstmt.setInt(1, id);
	             result = pstmt.executeUpdate();
	             connect.close();
	        } catch(Exception exc) {
	        	exc.printStackTrace();
	        }    
	        return result;
	    }
	
		//view user data(read)
				public static List<emp> getAllEmployees(){ 
					List<emp> list=new ArrayList<emp>(); 
				try{ 
					Connection con=EmpDao.connectDB(); 
					String query = "select * from user";
					PreparedStatement pstmt = con.prepareStatement(query);
					ResultSet rs=pstmt.executeQuery(); 
				while(rs.next()){ 
					emp e = new emp(); 
					e.setId(rs.getInt(1)); 
					e.setName(rs.getString(2)); 
					e.setPass(rs.getString(3));  
					e.setMail(rs.getString(4)); 
					e.setCourse(rs.getString(5)); 
					list.add(e); 
				} 
					con.close(); 
				}catch(Exception e){
					e.printStackTrace();
					} 
				return list; 
				}
				
			//updating user data(update)
			public static int updateUser(emp employee){
				int result = 0;
				try {
					Connection connect = EmpDao.connectDB();
					
					String query = "update user set name=?,password=?,email=?,course=? where id=?";
					PreparedStatement pstmt = connect.prepareStatement(query);
					pstmt.setString(1, employee.getName());
					pstmt.setString(2, employee.getPass());
					pstmt.setString(3, employee.getMail());
					pstmt.setString(4, employee.getCourse());
					pstmt.setInt(5,employee.getId()); 
		
					result = pstmt.executeUpdate();
					connect.close();
				}catch(Exception exc) {
					exc.printStackTrace();
				}
				return result; 	
			}
			
			//Get Employee Details by Id
			public static emp getEmployeeById(int id){ 
			emp e=new emp(); 
			try{ 
			Connection con=EmpDao.connectDB(); 
			PreparedStatement ps=con.prepareStatement("select * from user where id=?"); 
			ps.setInt(1,id); 
			ResultSet rs=ps.executeQuery(); 
			if(rs.next()){ 
			e.setId(rs.getInt(1)); 
			e.setName(rs.getString(2)); 
			e.setPass(rs.getString(3)); 
			e.setMail(rs.getString(4)); 
			e.setCourse(rs.getString(5)); 
			} 
			con.close(); 
			}catch(Exception ex){ex.printStackTrace();} 
			return e; 
			}
}