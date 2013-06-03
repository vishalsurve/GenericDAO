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
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseDAO courseDAO;

    @Resource
    private StudentDAO studentDAO;

    @Override
    public Boolean saveCourse(Course course) {

        Boolean save = courseDAO.save(course);
        return save;
    }

    @Override
    public Course findByName(String Name) {

        Course course = courseDAO.findByName(Name);
        return course;
    }

    @Override
    public Course findCourceById(Integer id) {

        Course course = courseDAO.find(id);
        return course;
    }

    @Override
    public List<Course> listOfCourseByStudent(Integer studId) {
        
        Student student = studentDAO.find(studId);
        return null;
    }
}
