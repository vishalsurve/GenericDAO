package com.em.hibernategenericdao.service;

import com.em.hibernategenericdao.model.Course;
import java.util.List;

/**
 *
 * @author Vishal
 */
public interface CourseService {

    public Boolean saveCourse(Course course);

    public Course findByName(String Name);

    public Course findCourceById(Integer id);

    public List<Course> listOfCourseByStudent(Integer studId);
}
