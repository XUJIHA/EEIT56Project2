package orderRoom.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import orderRoom.model.OrderBean;
import orderRoom.model.OrderDetailsBean;


public class OrderDao {
	private Session session;

	public OrderDao(Session session) {
		this.session = session;
	}

	public OrderBean InsertOrder(OrderBean obean) {
		if (obean != null) {
			session.save(obean);
			return obean;
		}

		return null;
	}

	public OrderDetailsBean InsertOrderDetails(OrderDetailsBean odbean) {
		if (odbean != null) {
			session.save(odbean);
			return odbean;
		}

		return null;
	}

	public List<OrderBean> searchOrder() {
		String hql = "from OrderBean o WHERE o.canceltag is null";

		List<OrderBean> result = session.createQuery(hql, OrderBean.class).getResultList();

		return result;
	}

//	public List<OrderDetailsBean> searchOrderDetails() {
//		Session session = factory.getCurrentSession();
//		Query<OrderDetailsBean> query = session.createQuery("from OrderDetailsBean", OrderDetailsBean.class);
//
////    	query.list();
//		List<OrderDetailsBean> result = query.getResultList();
//
//		return result;
//	}

	public OrderBean findByIdforOrder(int id) {
		return session.get(OrderBean.class, id);

	}

	public OrderDetailsBean findByIdforDetails(int id) {
		return session.get(OrderDetailsBean.class, id);
	}

	public int CancelOrder(int orderid) {
		OrderBean obean = session.get(OrderBean.class, orderid);

		if (obean != null) {
			obean.setCanceltag(1);

		}

		return 1;
	}

	public int modifyOrderDetails(int detailid, OrderDetailsBean odb) {
		OrderDetailsBean odbean = session.get(OrderDetailsBean.class, detailid);

		if (odbean != null) {
			odbean.setUseremail(odb.getUseremail());
			odbean.setUserphone(odb.getUserphone());
			odbean.setAdults(odb.getAdults());
			odbean.setCompany(odb.getCompany());
			odbean.setChildren(odb.getChildren());
			odbean.setNotes(odb.getNotes());
		}

		return 1;
	}

	public int modifyOrder(int orderid, OrderBean ob) {
		OrderBean orderbean = session.get(OrderBean.class, orderid);
		
			orderbean.setUsername(ob.getUsername());
			orderbean.setCheckindate(ob.getCheckindate());
			orderbean.setCheckoutdate(ob.getCheckoutdate());
			orderbean.setRoomname(ob.getRoomname());
			orderbean.setRoomprice(ob.getRoomprice());
	

		return 1;
	}
}
