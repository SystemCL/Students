package md.st.entity;

import java.util.Date;

import md.st.dao.Identification;
import md.st.entity.annotations.*;

@Entity(tableName = "Course")
public class Course implements Identification<Integer> {
	
	private Integer id = null;
	@Column(name = "nameCourse")
	private String nameCourse;
	@Column(name = "nameProf")
	private String nameProf;
	@Column(name = "startDate")
	private Date startDate;
	@Column(name = "endDate")
	private Date endDate;
	
	public Integer getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public String getNameCourse() {
		return nameCourse;
	}

	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}

	public String getNameProf() {
		return nameProf;
	}

	public void setNameProf(String nameProf) {
		this.nameProf = nameProf;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Course nameCourse(String nameCourse){
		this.nameCourse = nameCourse;
		return this;
	}
	
	public Course nameProf(String nameProf){
		this.nameProf = nameProf;
		return this;
	}
	
	public Course startDate(Date startDate){
		this.startDate = startDate;
		return this;
	}
	
	public Course endDate(Date endDate){
		this.endDate = endDate;
		return this;
	}
	
	public Course build(){
		Course course = new Course();
		course.setNameCourse(nameCourse);
		course.setNameProf(nameProf);
		course.setStartDate(startDate);
		course.setEndDate(endDate);
		return course;
	}

	@Override
	public String toString(){
		return " id: " + id + "\n" +
	           " nameCourse: " + nameCourse+ "\n" +
			   " nameProf: " + nameProf + "\n" +
			   "startDate: "	+  startDate +"\n" +
			   "endDate: " + endDate + "\n\n";
	}
	


}
