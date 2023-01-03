package DisplaySouvenir.service;

import java.util.List;

import DisplaySouvenir.model.souvenirBean;

public interface souvenirService {
	void deleteById(int souvenir_id);

	// 依bookId來查詢單筆記錄
//	List <souvenirBean> findById(int souvenir_id);
	souvenirBean findById(int souvenir_id);
	
//		// 新增一筆記錄
//	void save(souvenirBean bean);
	souvenirBean save(souvenirBean bean);

	//void updateSouvenir(souvenirBean bean, long sizeInBytes) ;
	int updateSouvenir(souvenirBean bean, long sizeInBytes) ;
//	int updateSouvenir(souvenirBean bean) ;
//	int updateSouvenir(Integer souvenir_id, String souvenir_no, String souvenir_name, Blob souvenir_pic,
//			String fileName, String souvenir_des, double souvenir_price, String souvenir_num);
	int getTotalPages();
//	List<souvenirBean> findByAll();
	List<souvenirBean> findByAll();

}
