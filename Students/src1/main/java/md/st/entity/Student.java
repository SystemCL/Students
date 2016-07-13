package md.st.entity;

import java.util.Date;

import md.st.dao.Identified;

public class Student implements Identified<Integer> {

	private Integer id = null;
	public String firstName;
	public String lastName;
	public int age;
	public Date enrolement_date;
	//public Integer group_id;
	
	public Integer getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getEnrolement_date() {
		return enrolement_date;
	}

	public void setEnrolement_date(Date enrolement_date) {
		this.enrolement_date = enrolement_date;
	}

/*	public Integer getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}*/

	
}
