package goldrest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/myservice4")
public class MyService4 {
	
	@GET
	@Path("/setUserQuery")
	public void setUser(
			@QueryParam("uid") int uid,
			@QueryParam("uname") String uname,
			@QueryParam("upass") String upass,
			@QueryParam("sal") int sal
			) {
		User user = new User(uid,uname,upass,sal);
		System.out.println("user set using query param" + user);
		
	}
	
	@POST
	@Path("/setUserForm")
	public void setUserForm(
			@FormParam("uid") int uid,
			@FormParam("uname") String uname,
			@FormParam("upass") String upass,
			@FormParam("salary") int sal
			) {
		User user = new User(uid,uname,upass,sal);
		System.out.println("user set using query param" + user);
		
	}
}
