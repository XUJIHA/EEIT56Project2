package tw.hibernatedemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ARRANGE")
public class Arrange {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ARRANGE_NUMBER")
	private Integer arrangenumber;
	public Arrange(Integer arrangenumber, String arrangename, String arrangephone, Integer people, String day,
			String eattime, int restaurantid) {
		super();
		this.arrangenumber = arrangenumber;
		this.arrangename = arrangename;
		this.arrangephone = arrangephone;
		this.people = people;
		this.day = day;
		this.eattime = eattime;
		this.restaurantid = restaurantid;
	}

	@Column(name = "ARRANGE_NAME")
	private String arrangename;
	@Column(name = "ARRANGE_PHONE")
	private String arrangephone;
	@Column(name = "PEOPLE")
	private Integer people;
	@Column(name = "DAY")
	private String day;
	@Column(name = "EAT_TIME")
	private String eattime;
	
	@Column(name ="fk_RESTAURANT_Id")
	
	private int restaurantid;
	
	
	
	public Arrange() {
	}
	
	public Arrange( String arrangename, String arrangephone, Integer people, String day,
			String eattime, int restaurantid) {
		this.arrangename = arrangename;
		this.arrangephone = arrangephone;
		this.people = people;
		this.day = day;
		this.eattime = eattime;
		this.restaurantid = restaurantid;
	}

	public Integer getArrangenumber() {
		return arrangenumber;
	}

	public void setArrangenumber(Integer arrangenumber) {
		this.arrangenumber = arrangenumber;
	}

	public String getArrangename() {
		return arrangename;
	}

	public void setArrangename(String arrangename) {
		this.arrangename = arrangename;
	}

	public String getArrangephone() {
		return arrangephone;
	}

	public void setArrangephone(String arrangephone) {
		this.arrangephone = arrangephone;
	}

	public Integer getPeople() {
		return people;
	}

	public void setPeople(Integer people) {
		this.people = people;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getEattime() {
		return eattime;
	}

	public void setEattime(String eattime) {
		this.eattime = eattime;
	}

	public int getRestaurantid() {
		return restaurantid;
	}

	public Arrange(String arrangename, String arrangephone, Integer people, String day, String eattime,
			Restaurant restaurant) {
		super();
		this.arrangename = arrangename;
		this.arrangephone = arrangephone;
		this.people = people;
		this.day = day;
		this.eattime = eattime;
	}

	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}



}
