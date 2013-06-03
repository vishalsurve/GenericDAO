
import com.em.hibernategenericdao.model.College;
import com.em.hibernategenericdao.model.Course;
import com.em.hibernategenericdao.model.Employee;
import com.em.hibernategenericdao.model.Student;
import com.em.hibernategenericdao.service.CollegeService;
import com.em.hibernategenericdao.service.CourseService;
import com.em.hibernategenericdao.service.EmployeeService;
import com.em.hibernategenericdao.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Vishal
 */
public class Testit {

    /**
     * @param args the command line arguments
     */
    static Logger LOGGER = LoggerFactory.getLogger(Testit.class);

//    search.addFilterEqual("yourProperty", YourEnum.YOUR_VALUE);
    
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("com/em/hibernategenericdao/config/Bean.xml");

        EmployeeService employeeService = context.getBean(EmployeeService.class);
        CollegeService collegeService = context.getBean(CollegeService.class);
        StudentService studentService = context.getBean(StudentService.class);
        CourseService courseService = context.getBean(CourseService.class);

        List<Employee> employees = new ArrayList<Employee>();

        Employee employee = new Employee();
        employee.setEmpName("Bhavin");
        employee.setAddress("Ghatkopar");
        employee.setSalary(15000);

        Employee employee1 = new Employee();
        employee1.setEmpName("Bhavin");
        employee1.setAddress("Mumbai");
        employee1.setSalary(18000);

        employees.add(employee);
        employees.add(employee1);
        //
//        LOGGER.info("Employee Save :" + employeeService.saveEmployee(employee));
        //        LOGGER.info("Find Employee By ID :" + employeeService.findEmployee(1));
        //        LOGGER.info("Employee List :" + employeeService.listOfEmployee());
        //        LOGGER.info("Employees Save :" + employeeService.saveMultipleEmployee(employees.toArray(new Employee[employees.size()])));
        //        LOGGER.info("Employee By Name :" + employeeService.findByName("Vishal"));
        //        LOGGER.info("Search Employee :" + employeeService.findByNameandSalary("Santosh", 10000));
        //        LOGGER.info("Employee By Like Properties" + employeeService.getEmployeeByAddressLike("mum%"));
        //        LOGGER.info("Employee AND OR Opration :" + employeeService.serchEmploye("Vishal", "Santosh"));
        //        LOGGER.info("Remove Employee :" + employeeService.removeEmployeeById(5));

        /*--------------------------------- Many To Many Mapping of Student Cource ------------------------------------------*/

        Student student = new Student();
        student.setStudName("Santosh");
        student.setStudAge(25);
        student.setEnrollYear(2013);

        List<Course> courses = new ArrayList<Course>();
        Course course = new Course();
        course.setCourseName("Java");

        Course course1 = new Course();
        course1.setCourseName("C");

        courses.add(course);
        courses.add(course1);

        student.setCourse(courses);

//        LOGGER.info("Save Student And Course :" + studentService.saveStudentAndCourse(student));
//         LOGGER.info("Find Student By ID :" + studentService.findStudentById(1));
//        LOGGER.info("Find Student By Course :" + studentService.findStudentByCourse("C"));
//        LOGGER.info("List of Student :" + studentService.listOfStudent());
//        LOGGER.info("StudentName And CourseName List :" + studentService.listOfStudentAndCourse());


//         LOGGER.info("Course Save :" + courseService.saveCourse(course));
//         LOGGER.info("Course By Id :" + courseService.findCourceById(2));
//         LOGGER.info("Course By Name :" + courseService.findByName("C"));
//        LOGGER.info("List Of CourseS :" + courseService.listOfCourseByStudent(1));

//        LOGGER.info("Add Existing Course To Existing Course :" + studentService.addCourseAgainstStudent(2, "Java")); 

        /*--------------------------------- One To Many Mapping of College Student ------------------------------------------*/

        College college = new College();
        college.setCollegeName("SYMS");
        college.setCollegeGrade("A");

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);

//        LOGGER.info("Save College :" + collegeService.saveCollege(college));
//        LOGGER.info("Find College :" + collegeService.findCollegeByName("BVIT"));
        LOGGER.info("College :" + collegeService.findById(1));
//        LOGGER.info("Add Student in College :" + collegeService.addStudentInCollege("BVIT", 5));
//        LOGGER.info("Find College By Course :" + collegeService.findCollegeByCourse("Maths"));
//        LOGGER.info("Current Year Student from College :" + collegeService.findCurrentYearStudent(1,2013));
    }
}
