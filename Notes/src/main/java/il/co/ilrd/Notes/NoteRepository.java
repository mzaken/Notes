package il.co.ilrd.Notes;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

public class NoteRepository {
	private Session session;

	public NoteRepository(Session session) {
		this.session = session;
	}
	
	public Note getNote(int id) {
        return session.find(Note.class, id);
    }
 
    public Note getNoteByTitle(String title) {
        TypedQuery<Note> q = session.createQuery("SELECT n FROM Note n WHERE n.title = :title", Note.class);
        q.setParameter("title", title);
        return q.getSingleResult();
    }
 
    public Note saveNote(Note note) {
        if (note.getNoteId() == 0) {
        	session.persist(note);
        } else {
            note = (Note)session.merge(note);
        }
        return note;
    }
 
    public void deleteNote(Note note) {
        if (session.contains(note)) {
        	session.remove(note);
        } else {
        	session.merge(note);
        }
    }
}
