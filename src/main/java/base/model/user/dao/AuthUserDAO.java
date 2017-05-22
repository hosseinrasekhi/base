package base.model.user.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import base.core.spring.ApplicationContextProvider;
import base.model.user.AuthUser;

@Repository("authUserDAO")
public class AuthUserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public static AuthUserDAO getInstance(){
		return (AuthUserDAO) ApplicationContextProvider.getApplicationContext().getBean("authUserDAO");
	}
	
	@Transactional
    public AuthUser save(AuthUser authUser) {
        sessionFactory.getCurrentSession().save(authUser);
        return authUser;
    }
	
	@Transactional
    public AuthUser update(AuthUser authUser) {
        sessionFactory.getCurrentSession().update(authUser);
        return authUser;
    }
	
	@Transactional
    public AuthUser delete(String uid) {
		AuthUser authUser = getByUid(uid);
        sessionFactory.getCurrentSession().delete(authUser);
        return authUser;
    }
	
	@Transactional
    public AuthUser getByUid(String uid) {
        return (AuthUser) sessionFactory.getCurrentSession().createCriteria(AuthUser.class).add(Restrictions.eq("uid", uid)).uniqueResult();
    }
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<AuthUser> list(){
		return sessionFactory.getCurrentSession().createCriteria(AuthUser.class).list();
	}
	
	@Transactional
	public AuthUser createNew(){
		return (AuthUser) sessionFactory.getCurrentSession().save(new AuthUser());
	}
	

}
