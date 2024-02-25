package goldrest;

public class User {
	private int uid;
	private String uname;
	private String upass;
	private int sal;
	public User() {
	}
	public User(int uid, String uname, String upass, int sal) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upass = upass;
		this.sal = sal;
	}
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
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upass=" + upass + ", sal=" + sal + "]";
	}
	
	
}
