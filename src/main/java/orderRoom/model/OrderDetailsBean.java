package orderRoom.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERDETAILS")
public class OrderDetailsBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DETAIL_ID")
	private Integer detailid;

	@Column(name = "ADULTS")
	private Integer adults;

	@Column(name = "CHILDREN")
	private Integer children;

	@Column(name = "COMPANY")
	private String company;

	@Column(name = "NOTES")
	private String notes;

//		@OneToOne(cascade = CascadeType.ALL)
//		@JoinColumn(name = "fk_user_email")
	@Column(name = "USER_EMAIL")
	private String useremail;

//		@OneToOne(cascade = CascadeType.ALL)
//		@JoinColumn(name = "fk_user_phone")
	@Column(name = "USER_PHONE")
	private String userphone;

	public OrderDetailsBean() {
	}

	public Integer getDetailid() {
		return detailid;
	}

	public void setDetailid(Integer detailid) {
		this.detailid = detailid;
	}

	public Integer getAdults() {
		return adults;
	}

	public void setAdults(Integer adults) {
		this.adults = adults;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

}
