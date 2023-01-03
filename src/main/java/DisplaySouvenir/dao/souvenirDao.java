package DisplaySouvenir.dao;

import java.util.List;

import DisplaySouvenir.model.souvenirBean;

public interface souvenirDao {
	// 依bookId來刪除單筆記錄
//	void deleteById(int souvenir_id);
	void deleteById(int souvenir_id);

	// 依bookId來查詢單筆記錄
//	List <souvenirBean> findById(int souvenir_id);
	souvenirBean findById(int souvenir_id);
	
//		// 新增一筆記錄
//	void save(souvenirBean bean);
	souvenirBean save(souvenirBean bean);

	int updateSouvenir(souvenirBean bean) ;
	int updateSouvenir(souvenirBean bean, long sizeInBytes) ;
//	int updateSouvenir(Integer souvenir_id, String souvenir_no, String souvenir_name, Blob souvenir_pic,
//			String fileName, String souvenir_des, double souvenir_price, String souvenir_num);
	
//	List<souvenirBean> findByAll();
	List<souvenirBean> findByAll();

	int getTotalPages();

//		Map<Integer, souvenirBean> getPageSouvenir(int pageNo);
		long getRecordCounts();
//	int getTotalPages();
		
		
		
}

