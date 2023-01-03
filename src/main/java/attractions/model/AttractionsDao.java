package attractions.model;

import java.util.List;
//import java.util.Vector;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.Session;
//import org.hibernate.query.Query;
import org.hibernate.query.Query;

public class AttractionsDao implements IAttractionsDao{
	
	private Session session;
	
	public AttractionsDao(Session session) {
		this.session = session;
	}
	@Override
	public AttractionsBean findById(int id) {
		
		String hql = "from AttractionsBean a where a.attractionsId = :id";
		
		try {
			AttractionsBean result = session.createQuery(hql, AttractionsBean.class)
					.setParameter("id", id)
					.getSingleResult();
			return result;
		}catch(NoResultException | NonUniqueResultException e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public List<AttractionsBean> findAll() {
		
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
		}
	}

	@Override
	public List<AttractionsBean> likeSearch(String search) {
		
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
			return resultList;
	}
	
	@Override
	public AttractionsBean save(AttractionsBean bean) {
		AttractionsBean abean = new AttractionsBean();
		abean.setName(bean.getName());
		abean.setAddress(bean.getAddress());
		abean.setServiceHour(bean.getServiceHour());
		abean.setServiceHour2(bean.getServiceHour2());
		abean.setIntroduction(bean.getIntroduction());
		abean.setPhone(bean.getPhone());
		abean.setImage1(bean.getImage1());
		abean.setFileName(bean.getFileName());
		session.save(abean);
		return abean;
	}
	
	@Override
	public AttractionsBean updateAttractions(AttractionsBean bean) {
		//Session session = factory.getCurrentSession();
		
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
		session.update(abean);
		return abean;
		
		}
	
	@Override
	public boolean deleteById(int id) {
		//Session session = factory.getCurrentSession();
		AttractionsBean aBean = session.get(AttractionsBean.class, id);
		if(aBean != null) {
			session.delete(aBean);
			return true;
		}else {
			return false;
		}
	}
}
