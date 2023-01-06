package hotel.attractions.model;

import java.util.List;
//import java.util.Vector;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
//public class AttractionsDao implements IAttractionsDao{
public class AttractionsDao {
	
	@Autowired
	private SessionFactory factory;
//	private Session session;
	
//	public AttractionsDao(Session session) {
//		this.session = session;
//	}
//	@Override
	public AttractionsBean findById(int id) {
		Session session = factory.openSession();
		
		String hql = "from AttractionsBean a where a.attractionsId = :id";
		
		try {
			AttractionsBean result = session.createQuery(hql, AttractionsBean.class)
					.setParameter("id", id)
					.getSingleResult();
			return result;
		}catch(NoResultException | NonUniqueResultException e){
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
		
	}
	
//	@Override
	public List<AttractionsBean> findAll() {
		Session session = factory.openSession();
		
		String hql = "from AttractionsBean";
		
		try {
			List<AttractionsBean> result = session.createQuery(hql, AttractionsBean.class)
					.getResultList();
//			for (AttractionsBean attractionsBean : result) {
//			System.out.println(attractionsBean);
//			}
			return result;
		}catch(NoResultException | NonUniqueResultException e){
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
	}

//	@Override
	public List<AttractionsBean> likeSearch(String search) {
		Session session = factory.openSession();
		
		String hql = "from AttractionsBean where name like :n or address like :a or introduction like :i or phone like :p";
//			System.out.println("search"+search);
		Query<AttractionsBean> query = session.createQuery(hql, AttractionsBean.class)
				.setParameter("n", "%" + search + "%")
				.setParameter("a", "%" + search + "%")
				.setParameter("i", "%" + search + "%")
				.setParameter("p", "%" + search + "%");
//			System.out.println("query" + query);
		List<AttractionsBean> resultList = query.getResultList();
//			System.out.println("resultList" + resultList);
//			for (AttractionsBean attractions : resultList) {
//				System.out.println(attractions);
//			}
		session.close();
		return resultList;
	}
	
//	@Override
	public AttractionsBean save(AttractionsBean bean) {
		Session session = factory.openSession();
		
		AttractionsBean abean = new AttractionsBean();
		abean.setName(bean.getName());
		abean.setAddress(bean.getAddress());
		abean.setServiceHour(bean.getServiceHour());
		abean.setServiceHour2(bean.getServiceHour2());
		abean.setIntroduction(bean.getIntroduction());
		abean.setPhone(bean.getPhone());
		abean.setImage1(bean.getImage1());
		abean.setFileName(bean.getFileName());
		
		if(abean != null) {
			session.save(abean);
		}

		session.close();
		
		return abean;
	}
	
//	@Override
	public AttractionsBean updateAttractions(AttractionsBean bean) {
		Session session = factory.openSession();
		
		AttractionsBean abean = session.get(AttractionsBean.class, bean.getAttractionsId());
		if(abean != null) {
			abean.setName(bean.getName());
			abean.setAddress(bean.getAddress());
			abean.setServiceHour(bean.getServiceHour());
			abean.setServiceHour2(bean.getServiceHour2());
			abean.setIntroduction(bean.getIntroduction());
			abean.setPhone(bean.getPhone());
			abean.setImage1(bean.getImage1());
			abean.setFileName(bean.getFileName());
		}
//		session.update(abean);
		
		session.close();
		
		return abean;
		
		}
	
//	@Override
	public boolean deleteById(int id) {
		Session session = factory.openSession();
		
		AttractionsBean aBean = session.get(AttractionsBean.class, id);
		
		if(aBean != null) {
			session.delete(aBean);
			
			session.close();
			
			return true;
		}else {
			session.close();
			
			return false;
		}
	}
}
