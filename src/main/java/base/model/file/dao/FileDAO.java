package base.model.file.dao;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import base.model.file.File;
 
@Repository
public class FileDAO {
    @Autowired
    private SessionFactory sessionFactory;
     
    public FileDAO() {
    }
 
    public FileDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    @Transactional
    public void save(File file) {
        sessionFactory.getCurrentSession().save(file);
    }
    
    @Transactional
    public File get(long id) {
        return (File) sessionFactory.getCurrentSession().get(File.class, id);
    }
}