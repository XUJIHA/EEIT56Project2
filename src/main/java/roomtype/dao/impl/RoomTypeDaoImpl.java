package roomtype.dao.impl;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import roomtype.dao.RoomTypeDao;
import roomtype.model.RoomsBean;

public class RoomTypeDaoImpl implements RoomTypeDao {
	private Session session;

	public RoomTypeDaoImpl(Session session) {
		this.session = session;
	}

	@Override
	public List<RoomsBean> findAll() {
		String hql = "from RoomsBean";
		Query<RoomsBean> query = session.createQuery(hql, RoomsBean.class);
		List<RoomsBean> list = query.getResultList();
		return list;
	}

	@Override
	public List<RoomsBean> findById(String Id) {
		String hql = "from RoomsBean where roomId like :id";
		Query<RoomsBean> query = session.createQuery(hql, RoomsBean.class)
										.setParameter("id", "%" + Id + "%");
		List<RoomsBean> list = query.getResultList();
		return list;
	}

	@Override
	public int insertRoomType(RoomsBean bean) {
		int row = 0;
		Serializable save = session.save(bean);
		if (save != null) {
			row = 1;
		}
		return row;
	}

	@Override
	public int insertRoomType(String roomId, String name, int status, int capacity, int bed, double size, int price,
			Blob img, String description, String equipment) {
		RoomsBean bean = new RoomsBean(roomId, name, status, capacity, bed, size, price, img, description, equipment);
		int row = insertRoomType(bean);
		return row;
	}

	@Override
	public List<RoomsBean> findAnyMatch(String input) {
		String hql = "from RoomsBean where roomId like :id or name like :name";
		Query<RoomsBean> query = session.createQuery(hql, RoomsBean.class)
										.setParameter("id", "%" + input + "%")
										.setParameter("name", "%" + input + "%");
		List<RoomsBean> list = query.getResultList();
		return list;
	}

	@Override
	public List<RoomsBean> findByCapacity(int capacity) {
		String hql = "from RoomsBean where capacity = :c";
		Query<RoomsBean> query = session.createQuery(hql, RoomsBean.class)
										.setParameter("c", capacity);
		List<RoomsBean> list = query.getResultList();
		return list;
	}

	@Override
	public List<RoomsBean> findByName(String name) {
		String hql = "from RoomsBean where roomId like :n";
		Query<RoomsBean> query = session.createQuery(hql, RoomsBean.class)
										.setParameter("n", "%" + name + "%");
		List<RoomsBean> list = query.getResultList();
		return list;
	}

	@Override
	public List<RoomsBean> findByStatus(int status) {
		String hql = "from RoomsBean where capacity = :s";
		Query<RoomsBean> query = session.createQuery(hql, RoomsBean.class)
										.setParameter("s", status);
		List<RoomsBean> list = query.getResultList();
		return list;
	}

	@Override
	public List<RoomsBean> findByCapacityAndStatus(int capacity, int status) {
		String hql = "from RoomsBean where capacity = :c and status = :s";
		Query<RoomsBean> query = session.createQuery(hql, RoomsBean.class)
										.setParameter("c", capacity)
										.setParameter("s", status);
		List<RoomsBean> list = query.getResultList();
		return list;
	}

	@Override
	public int updateStatusById(String id, int status) {
		String hql = "update RoomsBean set status = :s where roomId = :id";
		int row = session.createQuery(hql, RoomsBean.class)
						 .setParameter("s", status)
						 .setParameter("id", id)
						 .executeUpdate();
		return row;
	}

	@Override
	public int updateNameById(String id, String name) {
		String hql = "update RoomsBean set name = :n where roomId = :id";
		int row = session.createQuery(hql, RoomsBean.class)
						 .setParameter("n", name)
						 .setParameter("id", id)
						 .executeUpdate();
		return row;
	}

	@Override
	public int updateFormById(String roomId, String name, int status, int capacity, int bed, double size, int price,
							Blob img, String description, String equipment) {
		RoomsBean bean = session.get(RoomsBean.class, roomId);
		bean.setName(name);
		bean.setStatus(status);
		bean.setCapacity(capacity);
		bean.setBed(bed);
		bean.setSize(size);
		bean.setPrice(price);
		bean.setImg(img);
		bean.setDescription(description);
		bean.setEquipment(equipment);
		session.update(bean);
		return 1;
	}

	@Override
	public List<RoomsBean> findByPriceRange(int minPrice, int maxPrice) {
		String hql = "from RoomsBean where price >= :min and price <= :max";
		Query<RoomsBean> query = session.createQuery(hql, RoomsBean.class)
										.setParameter("min", minPrice)
										.setParameter("max", maxPrice);
		List<RoomsBean> list = query.getResultList();
		return list;
	}

	@Override
	public List<RoomsBean> findByMinPrice(int minPrice) {
		String hql = "from RoomsBean where price >= :min";
		Query<RoomsBean> query = session.createQuery(hql, RoomsBean.class)
										.setParameter("min", minPrice);
		List<RoomsBean> list = query.getResultList();
		return list;
	}

	@Override
	public List<RoomsBean> findByMaxPrice(int maxPrice) {
		String hql = "from RoomsBean where price <= :max";
		Query<RoomsBean> query = session.createQuery(hql, RoomsBean.class)
										.setParameter("max", maxPrice);
		List<RoomsBean> list = query.getResultList();
		return list;
	}

	@Override
	public List<RoomsBean> findByCapacityAndPriceRange(int capacity, int minPrice, int maxPrice) {
		String hql = "from RoomsBean where capacity = :c and (price >= :min and price <= :max)";
		Query<RoomsBean> query = session.createQuery(hql, RoomsBean.class)
										.setParameter("c", capacity)
										.setParameter("min", minPrice)
										.setParameter("max", maxPrice);
		List<RoomsBean> list = query.getResultList();
		return list;
	}

	@Override
	public List<RoomsBean> findByStatusAndPriceRange(int status, int minPrice, int maxPrice) {
		String hql = "from RoomsBean where status = :s and (price >= :min and price <= :max)";
		Query<RoomsBean> query = session.createQuery(hql, RoomsBean.class)
										.setParameter("s", status)
										.setParameter("min", minPrice)
										.setParameter("max", maxPrice);
		List<RoomsBean> list = query.getResultList();
		return list;
	}

	@Override
	public List<RoomsBean> findByCapacityAndStatusAndPriceRange(int capacity, int status, int minPrice, int maxPrice) {
		String hql = "from RoomsBean where capacity = :c and status = :s and (price >= :min and price <= :max)";
		Query<RoomsBean> query = session.createQuery(hql, RoomsBean.class)
										.setParameter("c", capacity)
										.setParameter("s", status)
										.setParameter("min", minPrice)
										.setParameter("max", maxPrice);
		List<RoomsBean> list = query.getResultList();
		return list;
	}

	@Override
	public int deleteById(String id) {
		RoomsBean bean = session.get(RoomsBean.class, id);
		session.delete(bean);
		return 1;
	}
}
