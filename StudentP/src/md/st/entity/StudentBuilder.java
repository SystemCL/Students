package md.st.entity;

import java.io.Serializable;
import java.util.Date;

import md.st.dao.Identification;
import md.st.entity.Student1.Builder;
import md.st.entity.annotations.Column;

public class StudentBuilder implements Identification<Integer> {
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
	
	public StudentBuilder firstName(String firstName){
		this.firstName = firstName;
		return this;
	}
	
	public StudentBuilder lastName(String lastName){
		this.lastName = lastName;
		return this;
	}
	
	public StudentBuilder age(int age){
		this.age = age;
		return this;	
	}
	
	public StudentBuilder enrolment_date(Date enrolment_date){
		this.enrolment_date = enrolment_date;
		return this;
	}
	
	public Student build(){
		Student student = new Student();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setAge(age);
		student.setEnrolment_date(enrolment_date);
		return student;
		
	}
 
}
