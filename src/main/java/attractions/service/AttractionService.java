package attractions.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import attractions.model.AttractionsBean;
import attractions.model.AttractionsDao;
import attractions.tw.hibernatedemo.util.HibernateUtil;

public class AttractionService implements IAttractionsService{
	
	private SessionFactory factory;
	
	private Session session;
	
	private AttractionsDao attractionsDao;
	
	public AttractionService() {
//		this.attractionsDao = new AttractionsDao(session);
		
		factory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public AttractionsBean findById(int id) {
		AttractionsBean attractions = null;
		session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			attractionsDao = new AttractionsDao(session);
			attractions = attractionsDao.findById(id);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		if(attractions != null) {
			return attractions;
		}
		return null;
	}
	
	@Override
	public List<AttractionsBean> findAll(){
		List<AttractionsBean> attractions = null;
		session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			attractionsDao = new AttractionsDao(session);
			attractions = attractionsDao.findAll();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		if(attractions != null) {
			return attractions;
		}
		return null;
	}
	
	@Override
	public List<AttractionsBean> likeSearch(String search) {
		List<AttractionsBean> attractions = null;
		session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			attractionsDao = new AttractionsDao(session);
			attractions = attractionsDao.likeSearch(search);
			session.getTransaction().commit();
			return attractions;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}
	
	@Override
	public AttractionsBean save(AttractionsBean bean) {
		AttractionsBean attractions = null;
		session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			attractionsDao = new AttractionsDao(session);
			attractions = attractionsDao.save(bean);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		if(attractions != null) {
			return attractions;
		}
		return null;
	}
	
	@Override
	public AttractionsBean updateAttractions(AttractionsBean bean) {
		AttractionsBean attractions = null;
		session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			attractionsDao = new AttractionsDao(session);
			attractions = attractionsDao.updateAttractions(bean);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return attractions;
//		return attractionsDao.updateAttractions(bean);
	}
	
	@Override
	public boolean deleteById(int id) {
		boolean delete = false;
		session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			attractionsDao = new AttractionsDao(session);
			delete = attractionsDao.deleteById(id);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return delete;
	}
}
