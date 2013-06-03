package com.em.hibernategenericdao.dao;

import com.em.hibernategenericdao.model.College;
import com.em.hibernategenericdao.model.Student;
import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import java.util.List;

/**
 *
 * @author Vishal
 */
public interface CollegeDAO extends GenericDAO<College, Integer> {

    public Boolean saveCollege(College college);

    public College findCollegeByName(String collegeName);

    public Boolean addStudentInCollege(Student student, College college);

    public List<College> findCollegeByStudent(String courseName);

    public List<Student> findCurrentYearStudent(Integer collegeId, Integer year);

    public College findById(Integer id);
}
