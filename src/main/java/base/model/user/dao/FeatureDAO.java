package base.model.user.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import base.core.spring.ApplicationContextProvider;
import base.model.user.Feature;

@Repository("featureDAO")
public class FeatureDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public static FeatureDAO getInstance(){
		return (FeatureDAO) ApplicationContextProvider.getApplicationContext().getBean("featureDAO");
	}
	
	@Transactional
    public Feature save(Feature feature) {
        sessionFactory.getCurrentSession().save(feature);
        return feature;
    }
	
	@Transactional
    public Feature update(Feature feature) {
        sessionFactory.getCurrentSession().update(feature);
        return feature;
    }
	
	@Transactional
    public Feature delete(String uid) {
		Feature feature = getByUid(uid);
        sessionFactory.getCurrentSession().delete(feature);
        return feature;
    }
	
	@Transactional
    public Feature getByUid(String uid) {
        return (Feature) sessionFactory.getCurrentSession().createCriteria(Feature.class).add(Restrictions.eq("uid", uid)).uniqueResult();
    }
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Feature> list(){
		return sessionFactory.getCurrentSession().createCriteria(Feature.class).list();
	}
	
	@Transactional
	public Feature createNew(){
		return (Feature) sessionFactory.getCurrentSession().save(new Feature());
	}

}
