package dao;

public class UserDTO { // Data transfer object
	public UserDTO() {
		
	}
	@Override
	public String toString() {
		return "UserDTO [uid=" + uid + ", uname=" + uname + ", upass=" + upass + ", salary=" + salary + ", flag=" + flag
				+ "]";
	}
	private int uid;
	private String uname,upass;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public UserDTO(int uid, String uname, String upass, int salary, int flag) {
		this.uid = uid;
		this.uname = uname;
		this.upass = upass;
		this.salary = salary;
		this.flag = flag;
	}
	private int salary,flag;
}
