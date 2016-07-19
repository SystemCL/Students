package md.st.entity;


import md.st.entity.annotations.*;
import md.st.dao.Identification;

@Entity(tableName = "Address")
public class Address implements Identification<Integer> {
	@Column(name = "id")
	private Integer id = null;
	@Column(name = "nameAddress")
	private String nameAddress;
	@Column(name = "nrPhone")
	private String nrPhone;
	
	public Integer getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}
	
	public String getNameAddress() {
		return nameAddress;
	}

	public void setNameAddress(String nameAddress) {
		this.nameAddress = nameAddress;
	}

	public String getNrPhone() {
		return nrPhone;
	}

	public void setNrPhone(String nrPhone) {
		this.nrPhone = nrPhone;
	}

}
