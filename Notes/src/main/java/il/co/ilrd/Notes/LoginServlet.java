package il.co.ilrd.Notes;

import java.io.IOException;
import java.io.Writer;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Path("/login")
public class LoginServlet {
	private UserRepository userRepository;
	private NoteRepository noteRepository;
	private Session session;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String doPost(User user) throws IOException {
		Configuration con = new Configuration().configure("/hibernate.cfg.xml");
		SessionFactory sessionFactory = con.buildSessionFactory();
		session = sessionFactory.openSession();
		userRepository = new UserRepository(session);
		// noteRepository = new NoteRepository(session);

		if (validateUser(user)) {
			// loadNotes(user, response);
			//redirect
			return "Success";
		}

		return "Failure!";
	}

	private boolean validateUser(User user) throws IOException {
		User userInRepo = userRepository.getUserByEmail(user.getEmail()); 
		
		if (userInRepo != null) {
			if (userRepository.validatePassword(userInRepo, user.getPassword())) {
				return true;
			}
		}
		 
		return false;
	}

	private void loadNotes(User user, String password) throws IOException {
		/*
		 * Transaction t = session.beginTransaction(); Note note1 = new Note("note1");
		 * Note note2 = new Note("note2");
		 * 
		 * user.addNote(note1); user.addNote(note2);
		 * 
		 * noteRepository.saveNote(note1); noteRepository.saveNote(note2);
		 * 
		 * t.commit();
		 */
		/*
		 * Writer writer = response.getWriter(); Gson gson = new Gson(); String json =
		 * gson.toJson(user); writer.write(json);
		 */

	}
}
