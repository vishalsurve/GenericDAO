package com.em.hibernategenericdao.service;

import com.em.hibernategenericdao.model.College;
import com.em.hibernategenericdao.model.Student;
import java.util.List;

/**
 *
 * @author Vishal
 */
public interface CollegeService {

    public College findById(Integer id);

    public Boolean saveCollege(College college);

    public College findCollegeByName(String collegeName);

    public Boolean addStudentInCollege(String collegeName, Integer StudId);

    public List<College> findCollegeByCourse(String courseName);

    public List<Student> findCurrentYearStudent(Integer collegeId, Integer year);
}
