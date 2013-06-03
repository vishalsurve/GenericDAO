package com.em.hibernategenericdao.dao;

import com.em.hibernategenericdao.model.Course;
import com.em.hibernategenericdao.model.Student;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;
import java.util.List;

/**
 *
 * @author Vishal
 */
public class StudentDAOImpl extends GenericDAOImpl<Student, Integer> implements StudentDAO {

    @Override
    public Boolean saveStudentAndCourse(Student student) {

        boolean save = save(student);

        return save;
    }

    @Override
    public Student findStudentById(Integer id) {

        Student student = find(id);
        return student;
    }

    @Override
    public List<Student> findStudentByCourse(Course course) {

        Search search = new Search(Student.class);
//                search.addField("studName");
        search.addFilterSome("course", Filter.equal("courseId", course.getCourseId()));
        List<Student> students = search(search);

//        search.addFetch("course");
//        search.addField("course.courseName");
//        List<Student> students = search(search);
        return students;
    }

    @Override
    public Boolean saveStudentAgainstCourse(Student student, Course course) {

        List<Course> course1 = student.getCourse();
        course1.add(course);
        student.setCourse(course1);

        Boolean save = save(student);
        return save;
    }

    @Override
    public List<Student> listOfStudentAndCourse() {

        Search search = new Search(Student.class);
        search.addField("studName");
//        search.addField("studAge");
        search.addField("course.courseName", "course");
        search.setResultMode(Search.RESULT_LIST);
//        search.setDistinct(true);
        search.addSortAsc("studName");
        List<Student> student = search(search);

        return student;
    }

    @Override
    public List<Student> listOfStudent() {

//        List<Student> studentList = findAll();
        Search search = new Search(Student.class);
        search.addField("studName");
        List<Student> studentList = search(search);
        return studentList;
    }
}
