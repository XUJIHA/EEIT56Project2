package loginlogout.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class hotelBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private Integer USER_ID;	//使用者id

	@Column(name = "USER_NAME")
	private String USER_NAME;		//使用者姓名

	@Column(name = "USER_PASSWORD")
	private String USER_PASSWORD;	//使用者密碼
	
	@Column(name = "USER_EMAIL")
	private String USER_EMAIL;	//使用者EMAIL
	
	@Column(name = "USER_PHONE")
	private String USER_PHONE;    //使用者電話號碼
	
	@Column(name = "USER_IDENTITY")
	private String USER_IDENTITY;      //使用者身分證字號
	
	@Column(name = "USER_BIRTHDAY")
	private String USER_BIRTHDAY;      //使用者生日
	
	@Column(name = "USER_REGISTRATION")
	private String USER_REGISTRATION;  //使用者日期
	
	
	public hotelBean() {	
	}

	
	
	public hotelBean(String uSER_NAME, String uSER_PASSWORD, String uSER_EMAIL, String uSER_PHONE, String uSER_IDENTITY,
			String uSER_BIRTHDAY, String uSER_REGISTRATION) {
		USER_NAME = uSER_NAME;
		USER_PASSWORD = uSER_PASSWORD;
		USER_EMAIL = uSER_EMAIL;
		USER_PHONE = uSER_PHONE;
		USER_IDENTITY = uSER_IDENTITY;
		USER_BIRTHDAY = uSER_BIRTHDAY;
		USER_REGISTRATION = uSER_REGISTRATION;
	}



	public Integer getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(Integer uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	
	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}

	public void setUSER_EMAIL(String uSER_EMAIL) {
		USER_EMAIL = uSER_EMAIL;
	}

	public String getUSER_PASSWORD() {
		return USER_PASSWORD;
	}

	public void setUSER_PASSWORD(String uSER_PASSWORD) {
		USER_PASSWORD = uSER_PASSWORD;
	}



	public String getUSER_PHONE() {
		return USER_PHONE;
	}

	public void setUSER_PHONE(String uSER_PHONE) {
		USER_PHONE = uSER_PHONE;
	}

	public String getUSER_IDENTITY() {
		return USER_IDENTITY;
	}

	public void setUSER_IDENTITY(String uSER_IDENTITY) {
		USER_IDENTITY = uSER_IDENTITY;
	}

	public String getUSER_BIRTHDAY() {
		return USER_BIRTHDAY;
	}

	public void setUSER_BIRTHDAY(String uSER_BIRTHDAY) {
		USER_BIRTHDAY = uSER_BIRTHDAY;
	}

	public String getUSER_REGISTRATION() {
		return USER_REGISTRATION;
	}

	public void setUSER_REGISTRATION(String uSER_REGISTRATION) {
		USER_REGISTRATION = uSER_REGISTRATION;
	}



	@Override
	public String toString() {
		return "hotelBean [USER_ID=" + USER_ID + ", USER_NAME=" + USER_NAME + ", USER_PASSWORD=" + USER_PASSWORD
				+ ", USER_EMAIL=" + USER_EMAIL + ", USER_PHONE=" + USER_PHONE + ", USER_IDENTITY=" + USER_IDENTITY
				+ ", USER_BIRTHDAY=" + USER_BIRTHDAY + ", USER_REGISTRATION=" + USER_REGISTRATION + "]";
	}

	
	
	
	
	


	
}
