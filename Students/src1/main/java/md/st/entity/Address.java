package md.st.entity;

import md.st.dao.Identified;

public class Address implements Identified<Integer> {
	private Integer id = null;
	public String nameAddress;
	public String nrPhone;
	
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
