package com.em.hibernategenericdao.dao;

import com.em.hibernategenericdao.model.Course;
import com.googlecode.genericdao.dao.hibernate.GenericDAO;

/**
 *
 * @author Vishal
 */
public interface CourseDAO extends GenericDAO<Course, Integer> {

    public Boolean saveCourse(Course course);

    public Course findByName(String Name);

    public Course findCourseById(Integer id);
}
