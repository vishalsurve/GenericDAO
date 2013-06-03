package com.em.hibernategenericdao.dao;

import com.em.hibernategenericdao.model.Course;
import com.em.hibernategenericdao.model.Student;
import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import java.util.List;

/**
 *
 * @author Vishal
 */
public interface StudentDAO extends GenericDAO<Student, Integer> {

    public Boolean saveStudentAndCourse(Student student);

    public Student findStudentById(Integer id);

    public List<Student> findStudentByCourse(Course course);

    public Boolean saveStudentAgainstCourse(Student student, Course course);

    public List<Student> listOfStudentAndCourse();

    public List<Student> listOfStudent();
}
