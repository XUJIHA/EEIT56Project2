package DisplaySouvenir.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import DisplaySouvenir.dao.souvenirDao;
import DisplaySouvenir.dao.impl.souvenirDaoImpl_Jdbc;
import DisplaySouvenir.model.souvenirBean;
import DisplaySouvenir.service.souvenirService;
import DisplaySouvenir.util.HibernateUtil;




public class souvenirServiceImpl implements souvenirService {
	
	private SessionFactory factory;
	private Session session;
	private souvenirDao souvenirDao;

	public souvenirServiceImpl() {
		factory = HibernateUtil.getSessionFactory();
	}


	public souvenirBean findById(int souvenir_id) {
		session = factory.getCurrentSession();
		souvenirDao = new souvenirDaoImpl_Jdbc(session);
		try {
			session.beginTransaction();
			souvenirBean sBean = souvenirDao.findById(souvenir_id);
			session.getTransaction().commit();
			return sBean;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}
	@Override
	public List<souvenirBean> findByAll() {
		List<souvenirBean> list = null;
		session = factory.getCurrentSession();
		souvenirDao = new souvenirDaoImpl_Jdbc(session);
		try {
			session.beginTransaction();
			list = souvenirDao.findByAll();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return list;
	}


	@Override
	public void deleteById(int souvenir_id) {
		session = factory.getCurrentSession();
		souvenirDao = new souvenirDaoImpl_Jdbc(session);
		try {
			session.beginTransaction();
			souvenirDao.deleteById(souvenir_id);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return;
	}


	@Override
	public souvenirBean save(souvenirBean bean) {
		session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			souvenirDao = new souvenirDaoImpl_Jdbc(session);
			souvenirDao.save(bean);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return bean;
	}


//	@Override
//	public int updateSouvenir(souvenirBean bean, long sizeInBytes) {
//		session = factory.getCurrentSession();
//		souvenirDao = new souvenirDaoImpl_Jdbc(session);
//		try {
//			session.beginTransaction();
//			souvenirDao.updateSouvenir(bean, sizeInBytes);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//			return 0;
//		}
//		return 1;
//	}


//	@Override
//	public int updateSouvenir(Integer souvenir_id, String souvenir_no, String souvenir_name, Blob souvenir_pic,
//			String fileName, String souvenir_des, double souvenir_price, String souvenir_num) {
//		session = factory.getCurrentSession();
//		souvenirDao = new souvenirDaoImpl_Jdbc(session);
//		try {
//			session.beginTransaction();
//			souvenirDao.updateSouvenir(souvenir_id, souvenir_no, souvenir_name, souvenir_pic, fileName, souvenir_des, souvenir_price, souvenir_num);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//			return 0;
//		}
//		return 1;
//	}
	@Override
	public int updateSouvenir(souvenirBean bean, long sizeInBytes) {
		session = factory.getCurrentSession();
		souvenirDao = new souvenirDaoImpl_Jdbc(session);
		try {
			session.beginTransaction();
			if (sizeInBytes == -1) { // 不修改圖片
				souvenirDao.updateSouvenir(bean);
			}else {
				souvenirDao.updateSouvenir(bean,sizeInBytes);
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return 0;
		}
		return 1;
	}
//	public int updateSouvenir(souvenirBean bean) {
////		session = factory.getCurrentSession();
////		souvenirDao = new souvenirDaoImpl_Jdbc(session);
//		try {
////			session.beginTransaction();
//			souvenirDao.updateSouvenir(bean);
////			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
////			session.getTransaction().rollback();
//			return 0;
//		}
//		return 1;
//	}


	@Override
	public int getTotalPages() {
		session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			souvenirDao.getTotalPages();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return souvenirDao.getTotalPages();
		 
	}


	


	



	

}
