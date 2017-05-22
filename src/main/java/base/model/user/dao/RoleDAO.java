package base.model.user.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import base.core.spring.ApplicationContextProvider;
import base.model.user.Role;

@Repository("roleDAO")
public class RoleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public static RoleDAO getInstance(){
		return (RoleDAO) ApplicationContextProvider.getApplicationContext().getBean("roleDAO");
	}
	
	@Transactional
    public Role save(Role role) {
        sessionFactory.getCurrentSession().save(role);
        return role;
    }
	
	@Transactional
    public Role update(Role role) {
        sessionFactory.getCurrentSession().update(role);
        return role;
    }
	
	@Transactional
    public Role delete(String uid) {
		Role role = getByUid(uid);
        sessionFactory.getCurrentSession().delete(role);
        return role;
    }
	
	@Transactional
    public Role getByUid(String uid) {
        return (Role) sessionFactory.getCurrentSession().createCriteria(Role.class).add(Restrictions.eq("uid", uid)).uniqueResult();
    }
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Role> list(){
		return sessionFactory.getCurrentSession().createCriteria(Role.class).list();
	}
	
	@Transactional
	public Role createNew(){
		return (Role) sessionFactory.getCurrentSession().save(new Role());
	}
	

}
