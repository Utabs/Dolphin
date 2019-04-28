package ir.dolphin.model.entity;

import ir.dolphin.model.BaseStaticEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Address",schema = "dbo")
@NamedQueries({
		@NamedQuery(name = "Address.findAll", query = "SELECT address FROM Address address"),
		@NamedQuery(name = "Address.getByState", query = "SELECT address FROM Address address where address.state=:state")})
public class Address  implements Serializable,BaseStaticEntity{
	public Address() {
		System.out.println("3333333333333333333333333333333333Address");
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "ID")
	private Long ID;

	@Column(name = "state")
	private String state;


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


}
