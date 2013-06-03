package com.em.hibernategenericdao.dao;

import com.em.hibernategenericdao.model.Course;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.googlecode.genericdao.search.Search;

/**
 *
 * @author Vishal
 */
public class CourseDAOImpl extends GenericDAOImpl<Course, Integer> implements CourseDAO {

    @Override
    public Boolean saveCourse(Course course) {

        boolean save = save(course);
        return save;
    }

    @Override
    public Course findByName(String Name) {

        Search search = new Search(Course.class);
        search.addFilterEqual("courseName", Name);
        Course course = searchUnique(search);
        return course;
    }

    @Override
    public Course findCourseById(Integer id) {

        Course course = find(id);
        return course;
    }
}
