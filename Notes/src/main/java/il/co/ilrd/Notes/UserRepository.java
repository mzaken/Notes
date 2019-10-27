package il.co.ilrd.Notes;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

public class UserRepository {
	private Session session;
	
	public UserRepository(Session session) {
		this.session = session;
	}
	
	public User getUserById(Long id) {
        return session.find(User.class, id);
    }
 
    public User getUserByEmail(String email) {
        TypedQuery<User> q = session.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
        q.setParameter("email", email);
        List<User> userList = q.getResultList();
        
        if(userList.isEmpty()) {
        	return null;
        }
        return userList.get(0);
    }
 
    public User saveUser(User user) {
    	if (user == null) {
    		return null;
    	}
    	
        if (user.getUserId() == null) {
        	session.persist(user);
        } else {
            user = (User)session.merge(user);
        }
        return user;
    }
 
    public void deleteUser(User user) {
        if (session.contains(user)) {
        	session.remove(user);
        } else {
        	session.merge(user);
        }
    }

	public boolean validatePassword(User user, String password) {
		if (user.getPassword().equals(password)) {
			return true;
		}
		
		return false;
	}
}
