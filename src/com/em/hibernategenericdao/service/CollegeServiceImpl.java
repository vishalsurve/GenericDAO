package com.em.hibernategenericdao.service;

import com.em.hibernategenericdao.dao.CollegeDAO;
import com.em.hibernategenericdao.dao.CourseDAO;
import com.em.hibernategenericdao.dao.StudentDAO;
import com.em.hibernategenericdao.model.College;
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
public class CollegeServiceImpl implements CollegeService {

    @Resource
    private CollegeDAO collegeDAO;

    @Resource
    private StudentDAO studentDAO;

    @Resource
    private CourseDAO courseDAO;

    @Override
    public College findById(Integer id) {

        College college = collegeDAO.findById(id);
        
        return college;
    }

    @Override
    public Boolean saveCollege(College college) {

        Boolean save = collegeDAO.save(college);
        return save;
    }

    @Override
    public College findCollegeByName(String collegeName) {

        College college = collegeDAO.findCollegeByName(collegeName);
        return college;
    }

    @Override
    public Boolean addStudentInCollege(String collegeName, Integer StudId) {

        College college = collegeDAO.findCollegeByName(collegeName);
        Student student = studentDAO.find(StudId);
        Boolean save = collegeDAO.addStudentInCollege(student, college);
        return save;
    }

    @Override
    public List<College> findCollegeByCourse(String courseName) {

        List<College> collegeName = collegeDAO.findCollegeByStudent(courseName);
        return collegeName;
    }

    @Override
    public List<Student> findCurrentYearStudent(Integer collegeId,Integer year) {

        List<Student> students = collegeDAO.findCurrentYearStudent(collegeId,year);
        return students;
    }
}
