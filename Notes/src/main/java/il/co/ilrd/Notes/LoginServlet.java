package il.co.ilrd.Notes;

import java.io.IOException;
import java.io.Writer;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

@Path("/login")
public class LoginServlet {
	private UserRepository userRepository;
	private NoteRepository noteRepository;
	private Session session;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void doPost() {
		Configuration con = new Configuration().configure("/hibernate.cfg.xml");
		SessionFactory sessionFactory = con.buildSessionFactory(); 
		session = sessionFactory.openSession();
		userRepository = new UserRepository(session);
		noteRepository = new NoteRepository(session);
		User user = null;
		
		/*
		 * if ((user = validateUser(request)) != null) { loadNotes(user, response); }
		 */
		
	}
	
	private void validateUser(String email) throws JsonSyntaxException, JsonIOException, IOException {
		/*
		 * User fromJson = new Gson().fromJson(request.getReader(), User.class); User
		 * user = userRepository.getUserByEmail(fromJson.getEmail());
		 * 
		 * if (user != null) { if (userRepository.validatePassword(user,
		 * fromJson.getPassword())){ return user; } }
		 * 
		 * return null;
		 */
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
