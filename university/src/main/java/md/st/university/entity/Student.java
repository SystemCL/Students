package md.st.university.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import md.st.university.dao.Identification;



@Entity(name = "student")
public class Student implements Identification<Integer> {
	@Id 
	@Column(name = "id")
	private Integer id;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "age")
	private int age;
	@Column(name = "enrolment_date")
	private Date enrolment_date;

        /*
		 * if (annotation instanceof Entity) { Entity entity = (Entity)
		 * annotation; System.out.println("dbName: " + entity.dbName());
		 * System.out.println("tableName: " + entity.tableName()); }
		 */

		/*
		 * Class<Student> bClass = Student.class; Annotation annotation1 =
		 * bClass.getAnnotation(Column.class);
		 * 
		 * if (annotation1 instanceof Column) { Column column = (Column)
		 * annotation1; System.out.println("name: " + column.name());
		 * 
		 * }
		 */


	// public Integer group_id;

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
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

	public Date getEnrolment_date() {
		return enrolment_date;
	}

	public void setEnrolment_date(Date enrolment_date) {
		this.enrolment_date = enrolment_date;
	}

	public Student firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public Student lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public Student age(int age) {
		this.age = age;
		return this;
	}

	public Student enrolment_date(Date enrolment_date){
		this.enrolment_date = enrolment_date;
		return this;
	}
	
	
	public Student build() {
		Student student = new Student();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setAge(age);
		student.setEnrolment_date(enrolment_date);
		return student;

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
