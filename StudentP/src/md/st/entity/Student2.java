package md.st.entity;

import java.util.Date;

import md.st.dao.Identification;
import md.st.entity.annotations.Column;

public class Student2 implements Identification<Integer> {
	private Integer id = null;
	@Column(name = "firstName")
	public String firstName;
	@Column(name = "lastName")
	public String lastName;
	@Column(name = "age")
	public int age;
	@Column(name = "enrolment_date")
	public Date enrolment_date;

	public Integer getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}
	

	private Student2(String firstName, String lastName ){
		this.firstName =firstName;
		this.lastName = lastName;
		
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

	public Date getEnrolment_date() {
		return enrolment_date;
	}

	public void setEnrolment_date(Date enrolment_date) {
		this.enrolment_date = enrolment_date;
	}

	
	@Override
	public String toString(){
		return " id: " + id + "\n" +
	           " firstName: " +firstName + "\n" +
				" lastName: " + lastName + "\n" +
	           " age: " + age + "\n" +
				" enrolmentDate: "+ enrolment_date + "\n\n";
	}



}
