package goldrest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/myservice3")
public class MyService3 {
	
	@Path("/getUser")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser() {
		User user = new User(100,"ramu","secret",1000);
		return user;
	}
	
	@Path("/getUsers")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		User user1 = new User(100,"ramu","secret",1000);
		User user2 = new User(200,"somu","secret",2000);
		User user3 = new User(300,"dhamu","secret",3000);
		List<User> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		return users;
	}
	
	@PUT
	@Path("/setUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public void setUser(User user) {
		System.out.println("user set "+ user);
	}
	
	@PUT
	@Path("/setUsers")
	@Consumes(MediaType.APPLICATION_JSON)
	public void setUser(List users) {
		System.out.println("user set "+ users);
	}
}
