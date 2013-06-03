package com.em.hibernategenericdao.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;

/**
 *
 * @author Vishal
 */
@Entity
@Table(name = "college")
//@FilterDef(name = "enrollYear", parameters =
//        @ParamDef(name = "YearFilter", type = "integer"))
@FilterDef(name = "enrollYear", defaultCondition = "enroll_year = 2013")
public class College {

    public static final String enrollYear = "enrollYear";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "college_id")
    private Integer collegeId;

    @Column(name = "college_name")
    private String collegeName;

    @Column(name = "college_grade")
    private String collegeGrade;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "college_student",
            joinColumns =
            @JoinColumn(name = "COLLEGE_ID"),
            inverseJoinColumns =
            @JoinColumn(name = "STUDENT_ID"))
    @Fetch(value = FetchMode.SUBSELECT)
//    @Filter(name = "enrollYear", condition = "enroll_year= :YearFilter")
    @Filter(name = "enrollYear")
    private List<Student> students;

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeGrade() {
        return collegeGrade;
    }

    public void setCollegeGrade(String collegeGrade) {
        this.collegeGrade = collegeGrade;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "College{" + "collegeId=" + collegeId + ", collegeName=" + collegeName + ", collegeGrade=" + collegeGrade + ", students=" + students + '}';
    }
}
