package complete_login_form;
// A model class called emp, which is a simple POJO class(plain old java object);

public class emp {
	private int id;
	private String name,password,email,course;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return password;
	}
	public void setPass(String password) {
		this.password = password;
	}
	public String getMail() {
		return email;
	}
	public void setMail(String email) {
		this.email = email;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
}
