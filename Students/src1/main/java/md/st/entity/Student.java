package md.st.entity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Date;

import md.st.dao.Identified;

@Entity(tableName = "Student")
public class Student implements Identified<Integer> {

	private Integer id = null;
	@Column(name = "firstName")
	public String firstName;
	@Column(name = "lastName")
	public String lastName;
	public int age;
	public Date enrolment_date;

	
	
	public static <T> void EntAnn(T t){
		Class<T> object = (Class)t;
        Annotation[] annotations = object.getAnnotations();
        for(Annotation annotation1 : annotations){
        	System.out.println(annotation1);
        }
	}
	
	public static <T> void ColAnn(T t){
		Class<T> aClass = (Class)t;
		Field[] field= aClass.getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
        	 Annotation[] annotations2 = field[i].getDeclaredAnnotations();
             for(Annotation annotation1 : annotations2){
             	System.out.println(annotation1);
             }
		}
	}
	
	public static void main(String[] args) {
		
		
		ColAnn(Student.class);
		
		
		/*if (annotation instanceof Entity) {
			Entity entity = (Entity) annotation;
			System.out.println("dbName: " + entity.dbName());
			System.out.println("tableName: " + entity.tableName());
	    }*/	
		
		
            
		
/*		Class<Student> bClass = Student.class;
		Annotation annotation1 = bClass.getAnnotation(Column.class);

		if (annotation1 instanceof Column) {
			Column column = (Column) annotation1;
			System.out.println("name: " + column.name());
			
	    }*/

	}
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

	public Date getEnrolment_date() {
		return enrolment_date;
	}

	public void setEnrolment_date(Date enrolment_date) {
		this.enrolment_date = enrolment_date;
	}
	



/*	public Integer getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}*/

	
}
