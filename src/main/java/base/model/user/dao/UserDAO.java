package base.model.user.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import base.core.spring.ApplicationContextProvider;

@Repository("userDAO")
public class UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public static UserDAO getInstance(){
		return (UserDAO) ApplicationContextProvider.getApplicationContext().getBean("userDAO");
	}

}
