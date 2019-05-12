package ir.dolphin.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Book",schema = "dbo")
 public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "ID")
	private Long ID;

	@Column(name = "state")
	private String state;

	@Column(name = "city")
	private String city;

	@Column(name = "street")
	private String street;

	@Column(name = "plaque")
	private String plaque;

	@Column(name = "zip_code")
	private String zipCode;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPlaque() {
		return plaque;
	}

	public void setPlaque(String plaque) {
		this.plaque = plaque;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
