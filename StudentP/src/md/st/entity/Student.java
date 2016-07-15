package md.st.entity;

import java.util.Date;

import md.st.entity.annotations.*;

@Entity(tableName = "Student")
public class Student {
	@Column(name = "id")
	private Integer id;
	@Column(name = "firstName")
	public String firstName;
	@Column(name = "lastName")
	public String lastName;
	@Column(name = "age")
	public int age;
	@Column(name = "enrolment_date")
	public Date enrolment_date;

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
