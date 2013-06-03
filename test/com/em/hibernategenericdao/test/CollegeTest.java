package com.em.hibernategenericdao.test;

import static org.junit.Assert.*;
import com.em.hibernategenericdao.model.College;
import com.em.hibernategenericdao.model.Student;
import com.em.hibernategenericdao.service.CollegeService;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author em06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CollegeTest {

    static ApplicationContext context;

    static CollegeService collegeService;

    Logger LOGGER = LoggerFactory.getLogger(EmployeeTest.class);

    public CollegeTest() {
    }

    @BeforeClass
    public static void setUpClass() {

        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        collegeService = context.getBean(CollegeService.class);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    @Ignore
    public void testfindCurrentYearStudent() {

        List<Student> students = collegeService.findCurrentYearStudent(1, 2012);
//        Assert.assertEquals(students.size(), 2);
        assertNotNull(students);
    }

    @Test
    public void testCollegeFind() {

        College college = collegeService.findById(1);
        LOGGER.info("College :" + college);
        assertNotNull(college);
        assertEquals(college.getStudents().size(), 2);
        LOGGER.info("College :" + college.getStudents().size());
    }

    @AfterClass
    public static void tearDownClass() {
    }
}