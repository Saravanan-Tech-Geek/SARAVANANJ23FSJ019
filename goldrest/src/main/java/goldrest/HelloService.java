package goldrest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/myservice")
public class HelloService {

	@GET
	public void met() {
		System.out.println("say hello method called...");
	}
	
	@Path("/met2")
	@GET
	public void met2() {
		System.out.println("say hello met2 called...");
	}
	
	@Path("/met3/{myparam}")
	@GET
	public void met3(@PathParam("myparam") String p) {
		System.out.println("say hello met3 called..." + p);
	}
	
	@Path("/met4/{myparam}/{secondparam}")
	@GET
	public void met4(@PathParam("myparam") String p, @PathParam("secondparam") String p2) {
		System.out.println("say hello met4 called..." + p+ ":" + p2);
	}
}