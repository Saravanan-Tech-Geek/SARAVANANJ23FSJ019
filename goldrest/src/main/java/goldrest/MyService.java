package goldrest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/service")
public class MyService {

	@Context
	HttpServletRequest httpServletRequest;

	@Context
	HttpServletResponse httpServletResponse;

	@GET
	public void met() {
		System.out.println("request" + httpServletRequest);
		System.out.println("response" + httpServletResponse);
	}

	@Path("/setName/{name}")
	@GET
	public void setName(@PathParam("name") String name) {
		HttpSession session = httpServletRequest.getSession();
		session.setAttribute("name", name);
		System.out.println("name set: "+ name);
	}
	
	@Path("/getName")
	@GET
	public Response getName() {
		HttpSession session = httpServletRequest.getSession();
		String dname = session.getAttribute("name").toString();
		System.out.println("get name: "+ dname);
		try {
			//ServletOutputStream out = httpServletResponse.getOutputStream();
			//out.print("<h1>"+dname+"</h1>");
			return Response.status(200).entity(dname).build();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
