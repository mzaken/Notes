package il.co.ilrd.Notes;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Path("notes")
public class NoteResource {
	private NoteRepository noteRepository;
	private UserRepository userRepository;
	private Session session;
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Note> getNotes(@PathParam("email") String email) {
    	Configuration con = new Configuration().configure("/hibernate.cfg.xml");
		SessionFactory sessionFactory = con.buildSessionFactory();
		session = sessionFactory.openSession();
    	noteRepository = new NoteRepository(session);
    	userRepository = new UserRepository(session);
		
    	User user = userRepository.getUserByEmail(email);
    	List<Note> temp = new ArrayList<>();
    	for (Note n: user.getNotes()) {
    		System.out.println(n.getTitle());
    		temp.add(n);
    	}
    	
        return temp;
    }
    
}
