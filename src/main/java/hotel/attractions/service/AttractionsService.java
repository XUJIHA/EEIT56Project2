package hotel.attractions.service;

import java.util.List;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hotel.attractions.model.AttractionsBean;
import hotel.attractions.model.AttractionsDao;

@Service
@Transactional
public class AttractionsService {
//public class AttractionsService implements IAttractionsService{
	
//	private SessionFactory factory;
//	
//	private Session session;
	
	@Autowired
	private AttractionsDao aDao;
	
//	public AttractionService() {
//		this.attractionsDao = new AttractionsDao(session);
		
//		factory = HibernateUtil.getSessionFactory();
//	}
	
//	@Override
	public AttractionsBean findById(int id) {
//		AttractionsBean attractions = null;
//		session = factory.getCurrentSession();
//		try {
//			session.beginTransaction();
//			attractionsDao = new AttractionsDao(session);
//			attractions = attractionsDao.findById(id);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		if(attractions != null) {
//			return attractions;
//		}
//		return null;
		return aDao.findById(id);
	}
	
//	@Override
	public List<AttractionsBean> findAll(){
//		List<AttractionsBean> attractions = null;
//		session = factory.getCurrentSession();
//		try {
//			session.beginTransaction();
//			attractionsDao = new AttractionsDao(session);
//			attractions = attractionsDao.findAll();
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		if(attractions != null) {
//			return attractions;
//		}
//		return null;
		return aDao.findAll();
	}
	
//	@Override
	public List<AttractionsBean> likeSearch(String search) {
//		List<AttractionsBean> attractions = null;
//		session = factory.getCurrentSession();
//		try {
//			session.beginTransaction();
//			attractionsDao = new AttractionsDao(session);
//			attractions = attractionsDao.likeSearch(search);
//			session.getTransaction().commit();
//			return attractions;
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		return null;
		return aDao.likeSearch(search);
	}
	
//	@Override
	public AttractionsBean save(AttractionsBean bean) {
//		AttractionsBean attractions = null;
//		session = factory.getCurrentSession();
//		try {
//			session.beginTransaction();
//			attractionsDao = new AttractionsDao(session);
//			attractions = attractionsDao.save(bean);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		if(attractions != null) {
//			return attractions;
//		}
//		return null;
		return aDao.save(bean);
	}
	
//	@Override
	public AttractionsBean updateAttractions(AttractionsBean bean) {
//		AttractionsBean attractions = null;
//		session = factory.getCurrentSession();
//		try {
//			session.beginTransaction();
//			attractionsDao = new AttractionsDao(session);
//			attractions = attractionsDao.updateAttractions(bean);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		return attractions;
		return aDao.updateAttractions(bean);
	}
	
//	@Override
	public boolean deleteById(int id) {
//		boolean delete = false;
//		session = factory.getCurrentSession();
//		try {
//			session.beginTransaction();
//			attractionsDao = new AttractionsDao(session);
//			delete = attractionsDao.deleteById(id);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		return delete;
		return aDao.deleteById(id);
	}
}
