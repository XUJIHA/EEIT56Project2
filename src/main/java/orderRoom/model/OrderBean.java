package orderRoom.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class OrderBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ID")
	private Integer orderid;

	@Column(name = "ORDER_DATE")
	private Date orderdate;

	@Column(name = "CHECKIN_DATE")
	private Date checkindate;

	@Column(name = "CHECKOUT_DATE")
	private Date checkoutdate;

	@Column(name = "CANCELTAG")
	private Integer canceltag;

//		@OneToOne(cascade = CascadeType.ALL)
//		@JoinColumn(name = "fk_user_name")
	@Column(name = "USER_NAME")
	private String username;

//		@OneToOne(cascade = CascadeType.ALL)
//		@JoinColumn(name = "fk_room_name")
	@Column(name = "ROOM_NAME")
	private String roomname;

//		@OneToOne(cascade = CascadeType.ALL)
//		@JoinColumn(name = "fk_room_price")
	@Column(name = "ROOM_PRICE")
	private int roomprice;

	public OrderBean() {
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public Date getCheckindate() {
		return checkindate;
	}

	public void setCheckindate(Date checkindate) {
		this.checkindate = checkindate;
	}

	public Date getCheckoutdate() {
		return checkoutdate;
	}

	public void setCheckoutdate(Date checkoutdate) {
		this.checkoutdate = checkoutdate;
	}

	public Integer getCanceltag() {
		return canceltag;
	}

	public void setCanceltag(Integer canceltag) {
		this.canceltag = canceltag;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public int getRoomprice() {
		return roomprice;
	}

	public void setRoomprice(int roomprice) {
		this.roomprice = roomprice;
	}

}
