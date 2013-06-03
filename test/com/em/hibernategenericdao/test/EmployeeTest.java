package com.em.hibernategenericdao.test;

import static org.junit.Assert.*;
import com.em.hibernategenericdao.model.Employee;
import com.em.hibernategenericdao.service.EmployeeService;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
public class EmployeeTest {

    static ApplicationContext context;

    static EmployeeService employeeService;

    Logger LOGGER = LoggerFactory.getLogger(EmployeeTest.class);

    public EmployeeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        employeeService = context.getBean(EmployeeService.class);
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
    public void hello() {
        String a = "vishal";
        Assert.assertEquals(a, "vishal");
    }

    @Test
    public void testGetEmployee() {

        Integer id = 1;
        Employee employee = employeeService.findEmployee(1);
        Integer empId = employee.getEmpId();
        assertEquals(id, empId);
        LOGGER.info("Test Employee :" + employee);
    }

    @Test
    public void testRemoveEmployeeById() {

        Employee employee = employeeService.findByName("Bhavin");
        Integer id = employee.getEmpId();

        LOGGER.info("Employee :" + employee);

        employeeService.removeEmployeeById(id);
        assertNull(employeeService.findEmployee(id));
    }

    @AfterClass
    public static void tearDownClass() {
    }
}