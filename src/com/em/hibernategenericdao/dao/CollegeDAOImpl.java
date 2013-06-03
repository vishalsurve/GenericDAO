package com.em.hibernategenericdao.dao;

import com.em.hibernategenericdao.model.College;
import com.em.hibernategenericdao.model.Student;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;
import java.util.List;

/**
 *
 * @author Vishal
 */
public class CollegeDAOImpl extends GenericDAOImpl<College, Integer> implements CollegeDAO {

    @Override
    public Boolean saveCollege(College college) {

        Boolean save = save(college);
        return save;
    }

    @Override
    public College findById(Integer collegeId) {

//        Session session = getSession();
        org.hibernate.Filter filter = getSession().enableFilter("enrollYear");
//        filter.setParameter("YearFilter", 2013);
//        College college = (College) session.get(College.class, collegeId);
//        Search search = new Search(College.class);
//        search.addFilterEqual("collegeId", collegeId);
//        College college = searchUnique(search);
        College college = find(collegeId);
        return college;
    }

    @Override
    public College findCollegeByName(String collegeName) {

        Search search = new Search(College.class);
        search.addFilterEqual("collegeName", collegeName);
        College college = searchUnique(search);
        return college;
    }

    @Override
    public Boolean addStudentInCollege(Student student, College college) {

        List<Student> student1 = college.getStudents();
        student1.add(student);

        college.setStudents(student1);
        Boolean save = save(college);
        return save;
    }

    @Override
    public List<College> findCollegeByStudent(String courseName) {

        Search search = new Search(College.class);

        search.addFilterEqual("students.course.courseName", courseName);
        search.addField("collegeName");
        search.setDistinct(true);
        List<College> collegeName = search(search);
        return collegeName;
    }

    @Override
    public List<Student> findCurrentYearStudent(Integer collegeId, Integer year) {

        Search search = new Search(College.class);
//        Calendar calendar = new GregorianCalendar();
//        Integer year = calendar.get(Calendar.YEAR);

        search.addFilterAnd(Filter.equal("students.enrollYear", year), Filter.equal("collegeId", collegeId));
        search.addField("students.studName");
        List<Student> students = search(search);
        return students;
    }
}
