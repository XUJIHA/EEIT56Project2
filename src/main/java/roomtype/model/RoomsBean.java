package roomtype.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roomType")
public class RoomsBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "room_id")
	private String roomId;
	@Column(name = "name")
	private String name;
	@Column(name = "status")
	private int status;
	@Column(name = "capacity")
	private int capacity;
	@Column(name = "bed")
	private int bed;
	@Column(name = "size")
	private double size;
	@Column(name = "price")
	private int price;
	@Column(name = "image")
	private Blob img;
	@Column(name = "description")
	private String description;
	@Column(name = "equipment")
	private String equipment;

	public RoomsBean() {

	}

	public RoomsBean(String roomId, String name, int status, int capacity, int bed, double size, int price, Blob img,
			String description, String equipment) {
		super();
		this.roomId = roomId;
		this.name = name;
		this.status = status;
		this.capacity = capacity;
		this.bed = bed;
		this.size = size;
		this.price = price;
		this.img = img;
		this.description = description;
		this.equipment = equipment;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getBed() {
		return bed;
	}

	public void setBed(int bed) {
		this.bed = bed;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Blob getImg() {
		return img;
	}

	public void setImg(Blob img) {
		this.img = img;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	@Override
	public String toString() {
		return "RoomsBean [roomId=" + roomId + ", name=" + name + ", status=" + status + ", capacity=" + capacity
				+ ", bed=" + bed + ", size=" + size + ", price=" + price + ", img=" + img + ", description="
				+ description + ", equipment=" + equipment + "]";
	}

}
