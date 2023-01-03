package tw.hibernatedemo.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Restaurant")
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RESTAURANT_Id")
	private Integer restaurantid;


	@Column(name="Restaurant_NAME")
	private String restaurantname;
	@Column(name="Restaurant_DES")
	private String restaurantdes;
	@Column(name="Restaurant_TYPE")
	private String restauranttype;
	@Column(name="Restaurant_Price")
	private Integer restaurantprice;
	@Column(name="Restaurant_ADDRESS")
	private String restaurantaddress;
	@Column(name="Restaurant_PHONE")
	private String restaurantphone;
	@Column(name="Restaurant_SEAT")
	private Integer restaurantseat;
	
	
	public Restaurant() {
		// TODO Auto-generated constructor stub
	}
	
	public Restaurant(Integer restaurantid, String restaurantname, String restaurantdes, String restauranttype,
			Integer restaurantprice, String restaurantaddress, String restaurantphone, Integer restaurantseat) {
		super();
		this.restaurantid = restaurantid;
		this.restaurantname = restaurantname;
		this.restaurantdes = restaurantdes;
		this.restauranttype = restauranttype;
		this.restaurantprice = restaurantprice;
		this.restaurantaddress = restaurantaddress;
		this.restaurantphone = restaurantphone;
		this.restaurantseat = restaurantseat;
	}

	public Restaurant(String restaurantname, String restaurantdes, String restauranttype,
			Integer restaurantprice, String restaurantaddress, String restaurantphone, Integer restaurantseat) {
		this.restaurantname = restaurantname;
		this.restaurantdes = restaurantdes;
		this.restauranttype = restauranttype;
		this.restaurantprice = restaurantprice;
		this.restaurantaddress = restaurantaddress;
		this.restaurantphone = restaurantphone;
		this.restaurantseat = restaurantseat;
	}

	public Integer getRestaurantid() {
		return restaurantid;
	}

	public void setRestaurantid(Integer restaurantid) {
		this.restaurantid = restaurantid;
	}

	public String getRestaurantname() {
		return restaurantname;
	}

	public void setRestaurantname(String restaurantname) {
		this.restaurantname = restaurantname;
	}

	public String getRestaurantdes() {
		return restaurantdes;
	}

	public void setRestaurantdes(String restaurantdes) {
		this.restaurantdes = restaurantdes;
	}

	public String getRestauranttype() {
		return restauranttype;
	}

	public void setRestauranttype(String restauranttype) {
		this.restauranttype = restauranttype;
	}

	public Integer getRestaurantprice() {
		return restaurantprice;
	}

	public void setRestaurantprice(Integer restaurantprice) {
		this.restaurantprice = restaurantprice;
	}

	public String getRestaurantaddress() {
		return restaurantaddress;
	}

	public void setRestaurantaddress(String restaurantaddress) {
		this.restaurantaddress = restaurantaddress;
	}

	public String getRestaurantphone() {
		return restaurantphone;
	}

	public void setRestaurantphone(String restaurantphone) {
		this.restaurantphone = restaurantphone;
	}

	public Integer getRestaurantseat() {
		return restaurantseat;
	}

	public void setRestaurantseat(Integer restaurantseat) {
		this.restaurantseat = restaurantseat;
	}


	

}
