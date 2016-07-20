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

	protected void setId(Integer id) {
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
	

	public Address nameAddress(String nameAddress){
		this.nameAddress = nameAddress;
		return this;
	}
	
	public Address nrPhone(String nrPhone){
		this.nrPhone = nrPhone;
		return this;
	}
	
	public Address build(){
		Address address = new Address();
		address.setNameAddress(nameAddress);
		address.setNrPhone(nrPhone);
		return address;
	}

	
	@Override
	public String toString(){
		return " id: " + id + "\n" +
	           " nameAddress: " + nameAddress+ "\n" +
				" nrPhone: " + nrPhone + "\n\n";
	}
}
