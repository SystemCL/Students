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

	


}
