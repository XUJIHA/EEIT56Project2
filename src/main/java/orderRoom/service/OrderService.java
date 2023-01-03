package orderRoom.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import orderRoom.dao.OrderDao;
import orderRoom.model.OrderBean;
import orderRoom.model.OrderDetailsBean;
import orderRoom.util.HibernateUtil;


public class OrderService {
	private SessionFactory factory;
	private Session session;
	private OrderDao orderDao;

	public OrderService() {
		factory = HibernateUtil.getSessionFactory();
	}

	public OrderBean InsertOrder(OrderBean obean) {
		session = factory.getCurrentSession();
		orderDao = new OrderDao(session);
		try {
			session.beginTransaction();
			orderDao.InsertOrder(obean);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return null;
	}

	public OrderDetailsBean InsertOrderDetails(OrderDetailsBean odbean) {
		session = factory.getCurrentSession();
		orderDao = new OrderDao(session);
		try {
			session.beginTransaction();
			orderDao.InsertOrderDetails(odbean);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return null;
	}

	public List<OrderBean> searchOrder() {
		List<OrderBean> result = null;
		session = factory.getCurrentSession();
		orderDao = new OrderDao(session);
		try {
			session.beginTransaction();
			result = orderDao.searchOrder();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return result;
	}

	public OrderBean findByIdforOrder(int id) {

		session = factory.getCurrentSession();
		OrderBean orderbean = null;
		orderDao = new OrderDao(session);
		try {
			session.beginTransaction();
			orderbean = orderDao.findByIdforOrder(id);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return orderbean;
	}

	public OrderDetailsBean findByIdforDetails(int id) {
		session = factory.getCurrentSession();
		OrderDetailsBean orderdetailsbean = null;
		orderDao = new OrderDao(session);
		try {
			session.beginTransaction();
			orderdetailsbean = orderDao.findByIdforDetails(id);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return orderdetailsbean;

	}

	public int CancelOrder(int orderid) {
		session = factory.getCurrentSession();
		orderDao = new OrderDao(session);
		try {
			session.beginTransaction();
			orderDao.CancelOrder(orderid);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return 0;
		}
		return 1;
	}

	public int modifyOrderDetails(int detailid, OrderDetailsBean odb) {
		session = factory.getCurrentSession();
		orderDao = new OrderDao(session);
		try {
			session.beginTransaction();
			orderDao.modifyOrderDetails(detailid, odb);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return 0;
		}

		return 1;
	}

	public int modifyOrder(int orderid, OrderBean ob) {

		session = factory.getCurrentSession();
		orderDao = new OrderDao(session);
		try {
			session.beginTransaction();
			orderDao.modifyOrder(orderid, ob);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return 0;
		}
		return 1;
	}
}
