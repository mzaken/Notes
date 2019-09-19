package il.co.ilrd.Notes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

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
	@Produces(MediaType.TEXT_PLAIN)
    public String register(@FormParam("email") String email, @FormParam("pass") String password) {
		//User user = userRepository.getUserByEmail(email);
		
		/*
		 * if (user != null) { return false; }
		 * 
		 * Transaction t = session.beginTransaction(); userRepository.saveUser(new
		 * User(email, password)); t.commit();
		 */
		
		return email + " " +  password;
	
    }
	
	protected void doPost(String email, String pass) {
		/*
		 * Configuration con = new Configuration().configure("/hibernate.cfg.xml");
		 * SessionFactory sessionFactory = con.buildSessionFactory(); session =
		 * sessionFactory.openSession(); 
		 * userRepository = new UserRepository(session);
		 * 
		 * if(register(request)) {
		 * response.sendRedirect(request.getContextPath()+"/login.html"); } else {
		 * response.getWriter().println("user already exist"); }
		 */
		
		
	}
	
	private boolean register(HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		User user = userRepository.getUserByEmail(email);
		
		if (user != null) {
			return false;
		}
		
		Transaction t = session.beginTransaction();
		userRepository.saveUser(new User(email, password));
		t.commit();
		
		return true;
	}
}
