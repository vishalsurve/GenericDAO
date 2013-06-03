package com.em.hibernategenericdao.service;

import com.em.hibernategenericdao.dao.CourseDAO;
import com.em.hibernategenericdao.dao.StudentDAO;
import com.em.hibernategenericdao.model.Course;
import com.em.hibernategenericdao.model.Student;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vishal
 */
@Transactional(propagation = Propagation.REQUIRED)
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDAO studentDAO;

    @Resource
    private CourseDAO courseDAO;

    @Override
    public Boolean saveStudentAndCourse(Student student) {

        Boolean saveStudent = studentDAO.saveStudentAndCourse(student);
        return saveStudent;
    }

    @Override
    public Student findStudentById(Integer id) {

        Student student = studentDAO.findStudentById(id);
        return student;
    }

    @Override
    public List<Student> findStudentByCourse(String courseName) {

        Course course1 = courseDAO.findByName(courseName);
        List<Student> students = studentDAO.findStudentByCourse(course1);
        return students;
    }

    @Override
    public Boolean addCourseAgainstStudent(Integer studId, String courseName) {

        Student student = studentDAO.findStudentById(studId);
        Course course = courseDAO.findByName(courseName);
        Boolean save = studentDAO.saveStudentAgainstCourse(student, course);
        return save;
    }

    @Override
    public List<Student> listOfStudentAndCourse() {

        List<Student> students = studentDAO.listOfStudentAndCourse();
        return students;
    }

    @Override
    public List<Student> listOfStudent() {

        List<Student> studentList = studentDAO.listOfStudent();
        return studentList;
    }
}
