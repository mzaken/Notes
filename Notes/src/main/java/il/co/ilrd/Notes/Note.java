package il.co.ilrd.Notes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int noteId;
	
	private String title;
	
	@ManyToOne
    @JoinColumn(name="user_Id")
	private User user;
	
	@OneToMany(mappedBy = "note")
	private List<Item> items = new ArrayList<>();
	
	public Note() {}
	
	public Note(String title) {
		this.title = title;
	}

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void addItem(Item item) {
		items.add(item);
		item.setNote(this);
	}
}
