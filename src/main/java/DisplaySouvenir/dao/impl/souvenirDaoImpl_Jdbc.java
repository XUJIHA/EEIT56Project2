package DisplaySouvenir.dao.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import  DisplaySouvenir.dao.souvenirDao;
import  DisplaySouvenir.model.souvenirBean;

public class souvenirDaoImpl_Jdbc implements souvenirDao {
	private Session session;
	public static final int recordsPerPage = 3; // 預設值：每頁三筆
	private int totalPages = -1;
	
	public souvenirDaoImpl_Jdbc() {
		
	}
	public souvenirDaoImpl_Jdbc(Session session) {
		this.session = session;
	}
	//showAll
	@Override
	public List<souvenirBean> findByAll() {
		
		String hql = "from souvenirBean";
		Query<souvenirBean> query = session.createQuery(hql,souvenirBean.class);
		List<souvenirBean> list =query.getResultList();
		
		return list;
	}
	//deleteById
	@Override
	public void deleteById(int souvenir_id) {
		souvenirBean bean = session.get(souvenirBean.class, souvenir_id);
		session.delete(bean);
		return;
		
	}
	//findById
	@Override
	public souvenirBean findById(int souvenir_id) {
//		String hql = "from souvenirBean where souvenir_id like :id";
		return  session.get(souvenirBean.class, souvenir_id);
	}
	//insert into DB
	@Override
	public souvenirBean save(souvenirBean bean) {
		session.save(bean);
		return bean;
	}
	//update all 
	@Override
	public int updateSouvenir(souvenirBean bean, long sizeInBytes) {
		Integer souvenir_id = bean.getSouvenir_id();
		souvenirBean sBean = session.get(souvenirBean.class,souvenir_id);
		if (sizeInBytes == -1) { // 不修改圖片
			updateSouvenir(bean);
		}
		sBean.setSouvenir_name(bean.getSouvenir_name());
		sBean.setSouvenir_no(bean.getSouvenir_no());
		sBean.setSouvenir_price(bean.getSouvenir_price());
		sBean.setSouvenir_des(bean.getSouvenir_des());
		sBean.setSouvenir_num(bean.getSouvenir_num());
		sBean.setSouvenir_pic(bean.getSouvenir_pic());
		sBean.setFileName(bean.getFileName());
		session.update(sBean);
		return 1;
	}
	//update all expect pic
	public int updateSouvenir(souvenirBean bean) {
		Integer souvenir_id = bean.getSouvenir_id();
		souvenirBean sBean = session.get(souvenirBean.class,souvenir_id);
		
		sBean.setSouvenir_name(bean.getSouvenir_name());
		sBean.setSouvenir_no(bean.getSouvenir_no());
		sBean.setSouvenir_price(bean.getSouvenir_price());
		sBean.setSouvenir_des(bean.getSouvenir_des());
		sBean.setSouvenir_num(bean.getSouvenir_num());
		session.update(sBean);
		return 1;
	}
	/*
	//update all except pic
	public int updateSouvenir(Integer souvenir_id, String souvenir_no, String souvenir_name, 
			String fileName, String souvenir_des, double souvenir_price, String souvenir_num) {
		souvenirBean sBean = session.get(souvenirBean.class,souvenir_id);
		sBean.setSouvenir_no(souvenir_no);
		sBean.setSouvenir_name(souvenir_name);
		sBean.setFileName(fileName);
		sBean.setSouvenir_des(souvenir_des);
		sBean.setSouvenir_price(souvenir_price);
		sBean.setSouvenir_num(souvenir_num);
		session.update(sBean);
		
		return 1;
		
	}
	//update All
	public int updateSouvenir(Integer souvenir_id, String souvenir_no, String souvenir_name, Blob souvenir_pic,
			String fileName, String souvenir_des, double souvenir_price, String souvenir_num) {
		souvenirBean sBean = session.get(souvenirBean.class,souvenir_id);
		sBean.setSouvenir_no(souvenir_no);
		sBean.setSouvenir_name(souvenir_name);
		sBean.setSouvenir_pic(souvenir_pic);
		sBean.setFileName(fileName);
		sBean.setSouvenir_des(souvenir_des);
		sBean.setSouvenir_price(souvenir_price);
		sBean.setSouvenir_num(souvenir_num);
		session.update(sBean);
		
		return 1;
		
	}
	*/
	@Override
	public int getTotalPages() {
		// 注意下一列敘述的每一個型態轉換
		totalPages = (int) (Math.ceil(getRecordCounts() / (double) recordsPerPage));
		return totalPages;
	}
	@Override
	public long getRecordCounts() {
		// TODO Auto-generated method stub
		return 0;
	}
//	@Override
//	public Map<Integer, souvenirBean> getPageSouvenir(int pageNo) {
////		log.info("新增伴手禮之顯示伴手禮功能之Dao，讀取一頁商品資料之 pageNo=" + pageNo);
//		Map<Integer, souvenirBean> map = new LinkedHashMap<>();
//		String hql = "from souvenirBean";
//		try (
//				Connection connection = ds.getConnection(); 
//				PreparedStatement ps = connection.prepareStatement(sql);
//			) {
//				try (
//					ResultSet rs = ps.executeQuery();
//				) {
//					// 只要還有紀錄未取出，rs.next()會傳回true
//					// 迴圈內將逐筆取出ResultSet內的紀錄
//					while (rs.next()) {
//						// 準備一個新的BookBean，將ResultSet內的一筆紀錄移植到BookBean內
//						souvenirBean bean = new souvenirBean();    	
//						bean.setSouvenir_id(rs.getInt("souvenir_id"));		
//						bean.setSouvenir_name(rs.getString("souvenir_name"));
//						bean.setSouvenir_no(rs.getString("souvenir_no"));
//						bean.setSouvenir_des(rs.getString("souvenir_des"));
//						bean.setSouvenir_price(rs.getDouble("souvenir_price"));
//						bean.setSouvenir_num(rs.getString("souvenir_num"));
//						bean.setSouvenir_pic(rs.getBlob("souvenir_pic"));
//						bean.setFileName(rs.getString("filename"));
//						// 最後將BookBean物件放入大的容器內
//						map.put(rs.getInt("souvenir_id"), bean);
//					}
//				}
//			} catch (SQLException ex) {
//				ex.printStackTrace();
//				throw new RuntimeException("BookDaoImpl_Jdbc()#getPageBooks()發生例外: " 
//											+ ex.getMessage());
//			}
//		return map;
	
	
		
//	}

}