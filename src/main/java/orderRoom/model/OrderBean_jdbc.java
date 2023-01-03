
//package orderRoom.model;
//
//import java.io.Serializable;
//import java.util.Date;
//import java.util.LinkedHashSet;
//import java.util.Set;
//
//public class OrderBean implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	Integer orderid;
//	String username;
//	Date orderdate;
//	Date checkindate;
//	Date checkoutdate;
//	String roomname;
//	Integer roomprice;
//	String cancelTag;
//
//	public OrderBean() {
//
//	}
//
//	public OrderBean(Integer orderid, String username, Date orderdate, Date checkindate, Date checkoutdate,
//			String roomname, Integer roomprice, String cancelTag) {
//
//		this.orderid = orderid;
//		this.username = username;
//		this.orderdate = orderdate;
//		this.checkindate = checkindate;
//		this.checkoutdate = checkoutdate;
//		this.roomname = roomname;
//		this.roomprice = roomprice;
//		this.cancelTag = cancelTag;
//
//	}
//
//	public OrderBean(String username, Date orderdate, Date checkindate, Date checkoutdate, String roomname,
//			Integer roomprice, String cancelTag) {
//
//		this.username = username;
//		this.orderdate = orderdate;
//		this.checkindate = checkindate;
//		this.checkoutdate = checkoutdate;
//		this.roomname = roomname;
//		this.roomprice = roomprice;
//		this.cancelTag = cancelTag;
//
//	}
//
//	public String getCancelTag() {
//		return cancelTag;
//	}
//
//	public void setCancelTag(String cancelTag) {
//		this.cancelTag = cancelTag;
//	}
//
//	public String getRoomname() {
//		return roomname;
//	}
//
//	public void setRoomname(String roomname) {
//		this.roomname = roomname;
//	}
//
//	public Integer getRoomprice() {
//		return roomprice;
//	}
//
//	public void setRoomprice(Integer roomprice) {
//		this.roomprice = roomprice;
//	}
//
//	public Integer getOrderid() {
//		return orderid;
//	}
//
//	public void setOrderid(Integer orderid) {
//		this.orderid = orderid;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public Date getOrderdate() {
//		return orderdate;
//	}
//
//	public void setOrderdate(Date orderdate) {
//		this.orderdate = orderdate;
//	}
//
//	public Date getCheckindate() {
//		return checkindate;
//	}
//
//	public void setCheckindate(Date checkindate) {
//		this.checkindate = checkindate;
//	}
//
//	public Date getCheckoutdate() {
//		return checkoutdate;
//	}
//
//	public void setCheckoutdate(Date checkoutdate) {
//		this.checkoutdate = checkoutdate;
//	}
//
//}
