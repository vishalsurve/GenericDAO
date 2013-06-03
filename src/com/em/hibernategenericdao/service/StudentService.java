package com.em.hibernategenericdao.service;

import com.em.hibernategenericdao.model.Student;
import java.util.List;

/**
 *
 * @author Vishal
 */
public interface StudentService {

    public Boolean saveStudentAndCourse(Student student);

    public Student findStudentById(Integer id);

    public List<Student> findStudentByCourse(String course);

    public Boolean addCourseAgainstStudent(Integer StudId, String courseName);

    public List<Student> listOfStudentAndCourse();

    public List<Student> listOfStudent();
}
