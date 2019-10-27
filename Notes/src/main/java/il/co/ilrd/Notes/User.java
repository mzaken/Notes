package il.co.ilrd.Notes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	private String email;

	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<Note> notes = new ArrayList<>();
	
	public User() {}
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void addNote(Note note) {
		notes.add(note);
		note.setUser(this);
	}

	public List<Note> getNotes() {
		return notes;
	}
}
