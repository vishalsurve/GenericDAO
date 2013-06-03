/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Vishal
 */
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stud_id")
    private Integer studId;

    @Column(name = "stud_name")
    private String studName;

    @Column(name = "stud_age")
    private Integer studAge;

    @Column(name = "enroll_year")
    private Integer enrollYear;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "student_course", joinColumns = {
        @JoinColumn(name = "STUDENT_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "COURSE_ID")})
    private List<Course> course;

    public Integer getStudId() {
        return studId;
    }

    public void setStudId(Integer studId) {
        this.studId = studId;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public Integer getStudAge() {
        return studAge;
    }

    public void setStudAge(Integer studAge) {
        this.studAge = studAge;
    }

    public Integer getEnrollYear() {
        return enrollYear;
    }

    public void setEnrollYear(Integer enrollYear) {
        this.enrollYear = enrollYear;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" + "studId=" + studId + ", studName=" + studName + ", studAge=" + studAge + ", enrollYear=" + enrollYear + ", course=" + course + '}';
    }
}
