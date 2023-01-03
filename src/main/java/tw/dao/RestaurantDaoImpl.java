package tw.dao;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import tw.hibernatedemo.model.Arrange;
import tw.hibernatedemo.model.Restaurant;
import tw.hibernatedemo.util.HibernateUtil;

public class RestaurantDaoImpl implements RestaurantDao {

	private SessionFactory factory;

	public RestaurantDaoImpl() {
		this.factory = HibernateUtil.getSessionFactory();
	}

	// 確認餐廳是否存在
	public boolean checkRes(int id) {
		Session session = factory.openSession();
		Restaurant res1 = null;
		try {
			session.beginTransaction();
			res1 = session.get(Restaurant.class, id);
			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		if (res1 == null) {
			return true;
		} else {
			return false;
		}

	}

	// 新增餐廳
	public void AddRestautant(Restaurant resBean) {
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			session.save(resBean);
			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			session.getTransaction().rollback();
			;

		}
	}

	// 刪除餐廳
	public void DeleteRestaurant(Integer id) {
		Session session = factory.getCurrentSession();
		Restaurant res1 = null;
		try {

			session.beginTransaction();
			// new 餐廳
			res1 = session.get(Restaurant.class, id);
			if (res1 != null) {
				session.delete(res1);
				session.getTransaction().commit();
				System.out.println("成功");
			}

		} catch (Exception e) {
			session.getTransaction().rollback();

			System.out.println("我找不到資料欸");
		}

		session.close();
	}

	// 修改餐廳Beam
	public void RewriteRestaurant(Restaurant resBean) {
		Session session = factory.getCurrentSession();
		Restaurant res1 = null;
		try {
			session.beginTransaction();
			res1 = session.get(Restaurant.class, resBean.getRestaurantid());
			if (res1 != null) {
				res1.setRestaurantaddress(resBean.getRestaurantaddress());
				res1.setRestaurantdes(resBean.getRestaurantdes());
				res1.setRestaurantname(resBean.getRestaurantname());
				res1.setRestaurantphone(resBean.getRestaurantphone());
				res1.setRestaurantprice(resBean.getRestaurantprice());
				res1.setRestaurantseat(resBean.getRestaurantseat());
				res1.setRestauranttype(resBean.getRestauranttype());
				session.getTransaction().commit();
			}
		}

		catch (Exception e) {
			System.out.println("已經有了");
			session.getTransaction().rollback();
			;

		}

		session.close();
	}

	// ID查詢資料
	public List<Restaurant> SearchRestaurant(int id) {
		Session session = factory.openSession();
		List<Restaurant> ress = null;
		try {
			session.beginTransaction();
			Restaurant res1 = session.get(Restaurant.class, id);
			ress = new ArrayList<Restaurant>();
			ress.add(res1);
			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();

		}
		session.close();
		return ress;

	}

	// 查詢 全部 資料
	public List<Restaurant> selectAll() {
		Session session = factory.openSession();
		List<Restaurant> result = null;
		try {
			session.beginTransaction();

			Query<Restaurant> query = session.createQuery("from Restaurant", Restaurant.class);

//	    	query.list();
			result = query.getResultList();
			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();

		}
		session.close();

		return result;
	}

	// 查詢 地址 資料
	public List<Restaurant> SearchResAddress(String resturantaddress) {
		Session session = factory.openSession();
		List<Restaurant> result = null;
		try {
			session.beginTransaction();

			String hql = "from Restaurant where restaurantaddress like :address";

			Query<Restaurant> query = session.createQuery(hql, Restaurant.class).setParameter("address",
					"%" + resturantaddress + "%");

//	    	query.list();
			session.getTransaction().commit();

			result = query.getResultList();

		} catch (Exception e) {
			session.getTransaction().rollback();

		}
		session.close();

		return result;
	}

	// 查詢 名子 資料
	public List<Restaurant> SearchResName(String resturantname) {
		Session session = factory.openSession();
		List<Restaurant> result = null;

		try {
			session.beginTransaction();

			String hql = "from Restaurant where restaurantname like :name";
//	    	query.list();
			Query<Restaurant> query = session.createQuery(hql, Restaurant.class).setParameter("name",
					"%" + resturantname + "%");
			session.getTransaction().commit();

			result = query.getResultList();

		} catch (Exception e) {
			session.getTransaction().rollback();

		}
		session.close();

		return result;
	}

	// 查詢 種類 資料
	public List<Restaurant> SearchResType(String resturanttype) {
		Session session = factory.openSession();
		List<Restaurant> result = null;
		try {
			session.beginTransaction();

			String hql = "from Restaurant where restauranttype like :type";
			Query<Restaurant> query = session.createQuery(hql, Restaurant.class).setParameter("type",
					"%" + resturanttype + "%");
			result = query.getResultList();
			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();

		}

		session.close();
		return result;
	}

	// 增加訂單資料
	public void AddArrange(Arrange arr) {
		Session session = factory.openSession();
		Restaurant res1 = null;
		try {
			session.beginTransaction();

			res1 = session.get(Restaurant.class, arr.getRestaurantid());
			if (res1 != null) {
				session.save(arr);
				session.getTransaction().commit();

			}

		} catch (Exception e) {
			session.getTransaction().rollback();

			System.out.println("找不到餐廳");
		}
		session.close();

	}

	// 刪除訂單資料
	public void DeleteArrange(int id) {
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			// new 餐廳
			Arrange arr1 = session.get(Arrange.class, id);

			if (arr1 != null) {
				session.delete(arr1);
				session.getTransaction().commit();
				System.out.println("成功");
			}

		} catch (Exception e) {
			System.out.println("我找不到資料欸");
			session.getTransaction().rollback();

		}
		session.close();
	}

	// 修改訂單資料
	public void RewriteArrange(Arrange arrBean) {
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			Arrange arr1 = session.get(Arrange.class, arrBean.getArrangenumber());
			if (arr1 != null) {

				arr1.setArrangenumber(arrBean.getArrangenumber());
				arr1.setArrangename(arrBean.getArrangename());
				arr1.setArrangephone(arrBean.getArrangephone());
				arr1.setPeople(arrBean.getPeople());
				arr1.setDay(arrBean.getDay());
				arr1.setEattime(arrBean.getEattime());
				arr1.setRestaurantid(arrBean.getRestaurantid());
				session.getTransaction().commit();
			}

		} catch (Exception e) {
			session.getTransaction().rollback();

			System.out.println("已經有了");
		}
		session.close();
	}

	// 查詢 全部 訂單
	public List<Arrange> selectArrange() {
		Session session = factory.openSession();
		List<Arrange> arranges = null;
		try {
			session.beginTransaction();
			Query<Arrange> query = session.createQuery("from Arrange", Arrange.class);
			arranges = query.getResultList();
			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();

		}
		session.close();

		return arranges;
	}

	// 查詢 姓名 訂單
	public List<Arrange> selectArrangeName(String name) {
		Session session = factory.openSession();
		List<Arrange> result = null;
		try {
			session.beginTransaction();
			String hql = "from Arrange where arrangename like :n";
			Query<Arrange> query = session.createQuery(hql, Arrange.class).setParameter("n", "%" + name + "%");
			result = query.getResultList();
			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();

		}
		session.close();
		return result;
	}

	// 查詢 餐廳ID 訂單
	public List<Arrange> selectArrangeResid(int resid) {
		Session session = factory.openSession();
		List<Arrange> result = null;
		try {
			session.beginTransaction();
			String hql = "from Arrange where restaurantid like :n";
			String res = String.valueOf(resid);
			Query<Arrange> query = session.createQuery(hql, Arrange.class).setParameter("n", resid);
			result = query.getResultList();
			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();

		}
		session.close();

		return result;
	}

	// 查詢 電話 訂單
	public List<Arrange> selectArrangePhone(String phone) {
		Session session = factory.openSession();
		List<Arrange> result = null;
		try {
			session.beginTransaction();
			String hql = "from Arrange where arrangephone like :n";
			Query<Arrange> query = session.createQuery(hql, Arrange.class).setParameter("n", "%" + phone + "%");
			result = query.getResultList();
			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();

		}
		session.close();

		return result;
	}

	// 確認訂單是否存在
	public boolean checkArr(int id) {
		Session session = factory.openSession();
		Arrange res1 = null;
		try {
			session.beginTransaction();
			res1 = session.get(Arrange.class, id);
			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();

		}
		session.close();
		System.out.println(res1);
		if (res1 == null) {
			return true;
		} else {
			return false;
		}
	}
	// 查詢 確認餐廳ID 訂單
	public boolean checkArrangeResid(int resid) {
		Session session = factory.openSession();
		List<Arrange> result = null;
		try {
			session.beginTransaction();
			String hql = "from Arrange where restaurantid like :n";
			String res = String.valueOf(resid);
			Query<Arrange> query = session.createQuery(hql, Arrange.class).setParameter("n", resid);
			result = query.getResultList();
			session.getTransaction().commit();
			System.out.println(123);
			System.out.println(result);
		} catch (Exception e) {
			session.getTransaction().rollback();

		}
		session.close();
		if(result.isEmpty()) {
			
			return false;
		}

		return true;
	}
}
