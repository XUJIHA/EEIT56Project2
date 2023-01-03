package loginlogout.service;

import java.util.List;

import loginlogout.model.hotelBean;

public interface LoginService {

	// 查詢帳號密碼
	public hotelBean loginhotel(String USER_EMAIL, String USER_PASSWORD);

	// 新增
	public void addhotel(String USER_NAME, String USER_PASSWORD, String USER_EMAIL ,String USER_PHONE,String USER_IDENTITY,
			 String USER_BIRTHDAY, String USER_REGISTRATION);

	// 透過id拿資料
	public List<hotelBean> findById(int USER_ID);

	// 刪除
	public void deleteById(int USER_ID);

	// 修改
	public void updatehotel(int USER_ID, String USER_NAME, String USER_PASSWORD, String USER_IDENTITY,
			String USER_EMAIL, String USER_PHONE, String USER_BIRTHDAY, String USER_REGISTRATION);

	// 查詢全部
	public List<hotelBean> selecthotel();

}
