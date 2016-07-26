package md.st.university.dao.daos;

import java.util.List;

import md.st.university.dao.GenericDao1;
import md.st.university.entity.Student;


public interface StudentDao extends GenericDao1 {
	
	List<Student> getAllStudents();
	List<Student> getAllStudentsByGroupName(String nameGroup);
	List<Student> getAllStudentsByCourseName(String nameCourse);
	Student getStudentByNameAddress(String nameAddress);
	Student getStudentById(Integer id);
	

}
