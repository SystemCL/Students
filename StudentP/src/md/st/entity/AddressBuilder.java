package md.st.entity;

import md.st.dao.Identification;
import md.st.entity.annotations.Column;

public class AddressBuilder implements Identification<Integer> {

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
	
	public String getNrPhone() {
		return nrPhone;
	}

	public AddressBuilder nameAddress(String nameAddress){
		this.nameAddress = nameAddress;
		return this;
	}
	
	public AddressBuilder nrPhone(String nrPhone){
		this.nrPhone = nrPhone;
		return this;
	}
	
	public Address build(){
		Address address = new Address();
		address.setNameAddress(nameAddress);
		address.setNrPhone(nrPhone);
		return address;
	}
	
	
	

}
