package DisplaySouvenir.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="souvenir")
public class souvenirBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "souvenir_id")
	private Integer souvenir_id;
	@Column(name = "souvenir_no")
	private String souvenir_no;
	@Column(name = "souvenir_name")
	private String souvenir_name;
	@Column(name = "souvenir_pic")
	private Blob souvenir_pic;
	@Column(name = "fileName")
	private String fileName;
	@Column(name = "souvenir_des")
	private String souvenir_des;
	@Column(name = "souvenir_price")
	private double souvenir_price;
	@Column(name = "souvenir_num")
	private String souvenir_num;
	public souvenirBean(Integer souvenir_id, String souvenir_no, String souvenir_name, Blob souvenir_pic,
			String fileName, String souvenir_des, double souvenir_price, String souvenir_num) {
		super();
		this.souvenir_id = souvenir_id;
		this.souvenir_no = souvenir_no;
		this.souvenir_name = souvenir_name;
		this.souvenir_pic = souvenir_pic;
		this.fileName = fileName;
		this.souvenir_des = souvenir_des;
		this.souvenir_price = souvenir_price;
		this.souvenir_num = souvenir_num;
	}
	public souvenirBean() {
		
	}
	public souvenirBean(String souvenir_no, String souvenir_name, Blob souvenir_pic,
			String fileName, String souvenir_des, double souvenir_price, String souvenir_num) {
		super();
		
		this.souvenir_no = souvenir_no;
		this.souvenir_name = souvenir_name;
		this.souvenir_pic = souvenir_pic;
		this.fileName = fileName;
		this.souvenir_des = souvenir_des;
		this.souvenir_price = souvenir_price;
		this.souvenir_num = souvenir_num;
	}
	public souvenirBean(String souvenir_name2, String souvenir_no2, double souvenir_price2, String souvenir_des2,
			String souvenir_num2, Blob blob, String fileName2, Integer souvenir_id2) {
		// TODO Auto-generated constructor stub
	}
	public Integer getSouvenir_id() {
		return souvenir_id;
	}
	public void setSouvenir_id(Integer souvenir_id) {
		this.souvenir_id = souvenir_id;
	}
	public String getSouvenir_no() {
		return souvenir_no;
	}
	public void setSouvenir_no(String souvenir_no) {
		this.souvenir_no = souvenir_no;
	}
	public String getSouvenir_name() {
		return souvenir_name;
	}
	public void setSouvenir_name(String souvenir_name) {
		this.souvenir_name = souvenir_name;
	}
	public Blob getSouvenir_pic() {
		return souvenir_pic;
	}
	public void setSouvenir_pic(Blob souvenir_pic) {
		this.souvenir_pic = souvenir_pic;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getSouvenir_des() {
		return souvenir_des;
	}
	public void setSouvenir_des(String souvenir_des) {
		this.souvenir_des = souvenir_des;
	}
//	private String priceStr = null;
//
//	public String getPriceStr() {
//		return priceStr;
//	}

//	public void setPriceStr(String priceStr) {
//		this.priceStr = priceStr;
//	}
	public double getSouvenir_price() {
		return souvenir_price;
	}
	public void setSouvenir_price(double souvenir_price) {
		this.souvenir_price = souvenir_price;
	}
	public String getSouvenir_num() {
		return souvenir_num;
	}
	public void setSouvenir_num(String souvenir_num) {
		this.souvenir_num = souvenir_num;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("souvenirBean [souvenir_id=");
		builder.append(souvenir_id);
		builder.append(", souvenir_no=");
		builder.append(souvenir_no);
		builder.append(", souvenir_name=");
		builder.append(souvenir_name);
		builder.append(", souvenir_pic=");
		builder.append(souvenir_pic);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", souvenir_des=");
		builder.append(souvenir_des);
		builder.append(", souvenir_price=");
		builder.append(souvenir_price);
		builder.append(", souvenir_num=");
		builder.append(souvenir_num);
		builder.append("]");
		return builder.toString();
	}
	
	
}

