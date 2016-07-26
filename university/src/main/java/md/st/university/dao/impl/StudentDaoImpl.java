package md.st.university.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import md.st.university.dao.daos.StudentDao;
import md.st.university.entity.Student;

@SuppressWarnings({ "unchecked", "deprecation" })
public class StudentDaoImpl extends GenericDaoImpl implements StudentDao {

	public List<Student> getAllStudents() {

		return (List<Student>) getHibernateTemplate().find("from student");
	}

	public List<Student> getAllStudentsByGroupName(String nameGroup) {

		@SuppressWarnings("rawtypes")
		List studentsGroup = getSessionFactory().getCurrentSession()
				.createQuery(
						"from student where group_student in " + "(Select id from group where nameGroup like :nameGroup ")
				.setString("nameGroup", nameGroup).list();

		return studentsGroup;
	}

	public List<Student> getAllStudentsByCourseName(String nameCourse) {

		@SuppressWarnings("rawtypes")
		List studentsCourse = getSessionFactory().getCurrentSession()
				.createQuery("from student where id in "
						+ "(Select course_id from student_course where student_id = (Select id from course where nameCourse like :nameCourse))")
				.setString("nameCourse", nameCourse).list();

		return studentsCourse;
	}

	public Student getStudentByNameAddress(String nameAddress) {

		return (Student) getSessionFactory().getCurrentSession()
				.createQuery(
						"from student where address_id =" + "(Select id from address where nameAddress like :nameAddress)")
				.setString("nameAddress", nameAddress);
	}

	public Student getStudentById(Integer id) {

		return get(Student.class, id);

	}

}
