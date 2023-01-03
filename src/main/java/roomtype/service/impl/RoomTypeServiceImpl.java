package roomtype.service.impl;

import java.sql.Blob;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import roomtype.dao.RoomTypeDao;
import roomtype.dao.impl.RoomTypeDaoImpl;
import roomtype.model.RoomsBean;
import roomtype.service.RoomTypeService;
import roomtype.util.HibernateUtil;

public class RoomTypeServiceImpl implements RoomTypeService {

	private SessionFactory factory;
	private Session session;
	private RoomTypeDao rDao;

	public RoomTypeServiceImpl() {
		factory = HibernateUtil.getSessionFactory();
	}

	@Override
	public List<RoomsBean> findAll() {
		List<RoomsBean> list = null;
		session = factory.getCurrentSession();
		rDao = new RoomTypeDaoImpl(session);
		try {
			session.beginTransaction();
			list = rDao.findAll();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return list;
	}

	@Override
	public List<RoomsBean> findById(String Id) {
		List<RoomsBean> list = null;
		session = factory.getCurrentSession();
		rDao = new RoomTypeDaoImpl(session);
		try {
			session.beginTransaction();
			list = rDao.findById(Id);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return list;
	}

	@Override
	public List<RoomsBean> findAnyMatch(String input) {
		List<RoomsBean> list = null;
		session = factory.getCurrentSession();
		rDao = new RoomTypeDaoImpl(session);
		try {
			session.beginTransaction();
			list = rDao.findAnyMatch(input);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return list;
	}

	@Override
	public List<RoomsBean> findByCapacity(int capacity) {
		List<RoomsBean> list = null;
		session = factory.getCurrentSession();
		rDao = new RoomTypeDaoImpl(session);
		try {
			session.beginTransaction();
			list = rDao.findByCapacity(capacity);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return list;
	}

	@Override
	public List<RoomsBean> findByName(String name) {
		List<RoomsBean> list = null;
		session = factory.getCurrentSession();
		rDao = new RoomTypeDaoImpl(session);
		try {
			session.beginTransaction();
			list = rDao.findByName(name);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return list;
	}

	@Override
	public List<RoomsBean> findByStatus(int status) {
		List<RoomsBean> list = null;
		session = factory.getCurrentSession();
		rDao = new RoomTypeDaoImpl(session);
		try {
			session.beginTransaction();
			list = rDao.findByStatus(status);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return list;
	}

	@Override
	public List<RoomsBean> findByCapacityAndStatus(int capacity, int status) {
		List<RoomsBean> list = null;
		session = factory.getCurrentSession();
		rDao = new RoomTypeDaoImpl(session);
		try {
			session.beginTransaction();
			list = rDao.findByCapacityAndStatus(capacity, status);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return list;
	}

	@Override
	public List<RoomsBean> findByPriceRange(int minPrice, int maxPrice) {
		List<RoomsBean> list = null;
		session = factory.getCurrentSession();
		rDao = new RoomTypeDaoImpl(session);
		try {
			session.beginTransaction();
			list = rDao.findByPriceRange(minPrice, maxPrice);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return list;
	}

	@Override
	public List<RoomsBean> findByMinPrice(int minPrice) {
		List<RoomsBean> list = null;
		session = factory.getCurrentSession();
		rDao = new RoomTypeDaoImpl(session);
		try {
			session.beginTransaction();
			list = rDao.findByMinPrice(minPrice);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return list;
	}

	@Override
	public List<RoomsBean> findByMaxPrice(int maxPrice) {
		List<RoomsBean> list = null;
		session = factory.getCurrentSession();
		rDao = new RoomTypeDaoImpl(session);
		try {
			session.beginTransaction();
			list = rDao.findByMaxPrice(maxPrice);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return list;
	}

	@Override
	public List<RoomsBean> findByCapacityAndPriceRange(int capacity, int minPrice, int maxPrice) {
		List<RoomsBean> list = null;
		session = factory.getCurrentSession();
		rDao = new RoomTypeDaoImpl(session);
		try {
			session.beginTransaction();
			list = rDao.findByCapacityAndPriceRange(capacity, minPrice, maxPrice);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return list;
	}

	@Override
	public List<RoomsBean> findByStatusAndPriceRange(int status, int minPrice, int maxPrice) {
		List<RoomsBean> list = null;
		session = factory.getCurrentSession();
		rDao = new RoomTypeDaoImpl(session);
		try {
			session.beginTransaction();
			list = rDao.findByStatusAndPriceRange(status, minPrice, maxPrice);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return list;
	}

	@Override
	public List<RoomsBean> findByCapacityAndStatusAndPriceRange(int capacity, int status, int minPrice, int maxPrice) {
		List<RoomsBean> list = null;
		session = factory.getCurrentSession();
		rDao = new RoomTypeDaoImpl(session);
		try {
			session.beginTransaction();
			list = rDao.findByCapacityAndStatusAndPriceRange(capacity, status, minPrice, maxPrice);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return list;
	}

	@Override
	public int insertRoomType(RoomsBean bean) {
		session = factory.getCurrentSession();
		rDao = new RoomTypeDaoImpl(session);
		try {
			session.beginTransaction();
			rDao.insertRoomType(bean);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return 0;
		}
		return 1;
	}

	@Override
	public int insertRoomType(String roomId, String name, int status, int capacity, int bed, double size, int price,
			Blob img, String description, String equipment) {
		session = factory.getCurrentSession();
		rDao = new RoomTypeDaoImpl(session);
		try {
			session.beginTransaction();
			rDao.insertRoomType(roomId, name, status, capacity, bed, size, price, img, description, equipment);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return 0;
		}
		return 1;
	}

	@Override
	public int updateStatusById(String id, int status) {
		session = factory.getCurrentSession();
		rDao = new RoomTypeDaoImpl(session);
		try {
			session.beginTransaction();
			rDao.updateStatusById(id, status);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return 0;
		}
		return 1;
	}

	@Override
	public int updateNameById(String id, String name) {
		session = factory.getCurrentSession();
		rDao = new RoomTypeDaoImpl(session);
		try {
			session.beginTransaction();
			rDao.updateNameById(id, name);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return 0;
		}
		return 1;
	}

	@Override
	public int updateFormById(String roomId, String name, int status, int capacity, int bed, double size, int price,
			Blob img, String description, String equipment) {
		session = factory.getCurrentSession();
		rDao = new RoomTypeDaoImpl(session);
		try {
			session.beginTransaction();
			rDao.updateFormById(roomId, name, status, capacity, bed, size, price, img, description, equipment);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return 0;
		}
		return 1;
	}

	@Override
	public int deleteById(String id) {
		session = factory.getCurrentSession();
		rDao = new RoomTypeDaoImpl(session);
		try {
			session.beginTransaction();
			rDao.deleteById(id);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return 0;
		}
		return 1;
	}

	@Override
	public int discount() {
		session = factory.getCurrentSession();
		rDao = new RoomTypeDaoImpl(session);
		rDao.findById("a01"); int priceA01 = 1000;
		int discountPrice = priceA01 /2;		
		
		
		
		
		
		return discountPrice;
	}

}
