package md.st.entity;

import java.util.Date;

import md.st.dao.Identification;
import md.st.entity.annotations.Column;

public class Student1 implements Identification<Integer> {
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
	

	private Student1(Builder builder){
		this.id = builder.id;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.enrolment_date = builder.enrolment_date;
		
	}
	
	public static class Builder {
		public Integer id = null;
		public String firstName;
		public String lastName;
		public int age;
		public Date enrolment_date;

		
		public Builder id(Integer id){
			this.id = id;
			return this;
		}
		
		public Builder firstName(String firstName){
			this.firstName = firstName;
			return this;
		}
		
		public Builder lastName(String lastName){
			this.lastName = lastName;
			return this;
		}
		
		public Builder age(int age){
			this.age = age;
			return this;
			
		}
		
		public Builder enrolment_date(Date enrolment_date){
			this.enrolment_date = enrolment_date;
			return this;
			
		}
		
		public Student1 build(){
			return new Student1(this);
		}
		
		
	}
	
	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public Date getEnrolment_date() {
		return enrolment_date;
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
