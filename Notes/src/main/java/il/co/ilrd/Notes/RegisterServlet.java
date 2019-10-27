package il.co.ilrd.Notes;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Path("/register")
public class RegisterServlet {
	private UserRepository userRepository;
	private Session session;

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response register(@FormParam("email") String email, @FormParam("pass") String password) throws URISyntaxException {
		Configuration con = new Configuration().configure("/hibernate.cfg.xml");
		SessionFactory sessionFactory = con.buildSessionFactory(); 
		session = sessionFactory.openSession();
		userRepository = new UserRepository(session);
		User user = userRepository.getUserByEmail(email);
		
		if (user != null) { 
			return null; 
		}
		
		Transaction t = session.beginTransaction(); 
		userRepository.saveUser(new	User(email, password)); 
		t.commit();

		return Response.temporaryRedirect(new URI("login.html")).build();
	}
}
