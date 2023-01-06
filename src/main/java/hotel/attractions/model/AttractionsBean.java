package hotel.attractions.model;

import java.io.Serializable;
//import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity @Table(name="attractions")
@Component
public class AttractionsBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ATTRACTIONS_ID")
	private int attractionsId;
	
//	private int userId;
	@Column(name = "ATTRACTIONS_NAME")
	private String name;
	
	@Column(name = "ATTRACTIONS_ADDRESS")
	private String address;
	
	@Column(name = "SERVICE_HOUR")
	private String serviceHour;
	
	@Column(name = "SERVICE_HOUR2")
	private String serviceHour2;
	
	@Column(name = "ATTRACTIONS_INTRODUCTION")
	private String introduction;
	
	@Column(name = "ATTRACTIONS_PHONE")
	private String phone;
	
	@Column(name = "ATTRACTIONS_IMAGE")
//	private Blob image1;
	private byte[] image1;
	
	@Column(name = "IMAGENAME")
	private String fileName;
	
	public AttractionsBean() {
	}
	
//	public AttractionsBean(int attractionsId, int userId, String name, String address, String serviceHour, String serviceHour2,
//			String introduction, String phone, Blob image1, String fileName) {
//		super();
//		this.attractionsId = attractionsId;
////		this.userId = userId;
//		this.name = name;
//		this.address = address;
//		this.serviceHour = serviceHour;
//		this.serviceHour2 = serviceHour2;
//		this.introduction = introduction;
//		this.phone = phone;
//		this.image1 = image1;
//		this.fileName = fileName;
//	}
	
	public AttractionsBean(int attractionsId, String name, String address, String serviceHour, String serviceHour2,
		String introduction, String phone, byte[] image1, String fileName) {
		this.attractionsId = attractionsId;
		this.name = name;
		this.address = address;
		this.serviceHour = serviceHour;
		this.serviceHour2 = serviceHour2;
		this.introduction = introduction;
		this.phone = phone;
		this.image1 = image1;
		this.fileName = fileName;
	}

	public AttractionsBean(String name, String address, String serviceHour, String serviceHour2, String introduction, String phone,
			byte[] image1, String fileName) {
		super();
		this.name = name;
		this.address = address;
		this.serviceHour = serviceHour;
		this.serviceHour2 = serviceHour2;
		this.introduction = introduction;
		this.phone = phone;
		this.image1 = image1;
		this.fileName = fileName;
	}
	public int getAttractionsId() {
		return attractionsId;
	}
	public void setAttractionsId(int attractionsId) {
		this.attractionsId = attractionsId;
	}
//	public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getServiceHour() {
		return serviceHour;
	}
	public void setServiceHour(String serviceHour) {
		this.serviceHour = serviceHour;
	}
	public String getServiceHour2() {
		return serviceHour2;
	}
	public void setServiceHour2(String serviceHour2) {
		this.serviceHour2 = serviceHour2;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
//	public Blob getImage1() {
//		return image1;
//	}
//	public void setImage1(Blob image1) {
//		this.image1 = image1;
//	}
	public byte[] getImage1() {
		return image1;
	}

	public void setImage1(byte[] image1) {
		this.image1 = image1;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "attractionsBean [attractionsId=" + attractionsId + ", name=" + name
				+ ", address=" + address + ", serviceHour=" + serviceHour + ", serviceHour2=" + serviceHour2 + ", introduction=" + introduction
				+ ", phone=" + phone + ", image1=" + image1 + ", fileName=" + fileName + "]";
	}

}
