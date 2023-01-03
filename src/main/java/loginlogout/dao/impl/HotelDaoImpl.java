package loginlogout.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.Session;
import org.hibernate.query.Query;

import loginlogout.dao.HotelDao;
import loginlogout.model.hotelBean;


public class HotelDaoImpl implements HotelDao{
	private Session session;

	public HotelDaoImpl(Session session) {
		this.session = session;
	}
	// 新增
	@Override
	public void addhotel(String uSER_NAME, String uSER_PASSWORD, String uSER_EMAIL, String uSER_PHONE, String uSER_IDENTITY,
	String uSER_BIRTHDAY, String uSER_REGISTRATION){

		hotelBean hotelBean = new hotelBean(uSER_NAME, uSER_PASSWORD, uSER_EMAIL, uSER_PHONE, uSER_IDENTITY,
				uSER_BIRTHDAY, uSER_REGISTRATION);
		session.save(hotelBean);
	}

	// 透過id拿資料
	@Override
	public List<hotelBean> findById(int USER_ID) {
		String hql = "from hotelBean where USER_ID=:USER_ID";
		Query<hotelBean> query = session.createQuery(hql, hotelBean.class).setParameter("USER_ID", USER_ID);
		List<hotelBean> classlist = query.getResultList();
		return classlist;
	}

	// 刪除
	@Override
	public void deleteById(int USER_ID) {
		hotelBean hb = session.get(hotelBean.class, USER_ID);
		session.delete(hb);
	}

	// 修改
	@Override
	public void updatehotel(int USER_ID, String USER_NAME, String USER_PASSWORD, String USER_IDENTITY,
			String USER_EMAIL, String USER_PHONE, String USER_BIRTHDAY, String USER_REGISTRATION){
		hotelBean hb = session.get(hotelBean.class, USER_ID);

		if (hb != null) {
			hb.setUSER_NAME(USER_NAME);
			hb.setUSER_PASSWORD(USER_PASSWORD);
			hb.setUSER_IDENTITY(USER_IDENTITY);
			hb.setUSER_EMAIL(USER_EMAIL);
			hb.setUSER_PHONE(USER_PHONE);
			hb.setUSER_BIRTHDAY(USER_BIRTHDAY);
			hb.setUSER_REGISTRATION(USER_REGISTRATION);
		}
	}

	// 查詢全部
	@Override
	public List<hotelBean> selecthotel(){
		String hql = "from hotelBean";
		Query<hotelBean> query = session.createQuery(hql, hotelBean.class);

		List<hotelBean> classlist = query.getResultList();
		for (hotelBean hb : classlist) {
			System.out.println(hb);
		}
		return classlist;
	}

	// 查詢帳號密碼
	@Override
	public hotelBean loginhotel(String USER_EMAIL, String USER_PASSWORD){
		String hql = "from hotelBean c where c.USER_EMAIL=:USER_EMAIL and c.USER_PASSWORD=:USER_PASSWORD";

		try {
			hotelBean result = session.createQuery(hql, hotelBean.class).setParameter("USER_EMAIL", USER_EMAIL)
					.setParameter("USER_PASSWORD", USER_PASSWORD).getSingleResult();

			return result;
		} catch (NoResultException | NonUniqueResultException e) {
			e.printStackTrace();
			return null;
		}

	}
}
