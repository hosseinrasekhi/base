package base.model.user.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import base.core.spring.ApplicationContextProvider;
import base.model.user.User;

@Repository("userDAO")
public class UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public static UserDAO getInstance(){
		return (UserDAO) ApplicationContextProvider.getApplicationContext().getBean("userDAO");
	}
	
	@Transactional
    public User save(User user) {
        sessionFactory.getCurrentSession().save(user);
        return user;
    }
	
	@Transactional
    public User update(User user) {
        sessionFactory.getCurrentSession().update(user);
        return user;
    }
	
	@Transactional
    public User delete(int id) {
		User user = getById(id);
        sessionFactory.getCurrentSession().delete(user);
        return user;
    }
	
	@Transactional
    public User getById(int id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> list(){
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}
	
	@Transactional
	public User createNew(){
		return (User) sessionFactory.getCurrentSession().save(new User());
	}
	

}
