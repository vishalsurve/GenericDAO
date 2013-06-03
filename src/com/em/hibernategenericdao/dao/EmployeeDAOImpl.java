package com.em.hibernategenericdao.dao;

import com.em.hibernategenericdao.model.Employee;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;
import java.util.List;

/**
 *
 * @author Vishal
 */
public class EmployeeDAOImpl extends GenericDAOImpl<Employee, Integer> implements EmployeeDAO {

    @Override
    public Boolean saveEmployee(Employee employee) {

        boolean save = save(employee);
        return save;
    }

    @Override
    public Employee findEmployee(Integer id) {

        Employee employee = find(id);
        return employee;
    }

    @Override
    public List<Employee> listOfEmployee() {

        List<Employee> employeeList = findAll();
        return employeeList;
    }

    @Override
    public boolean[] saveMultipleEmployee(Employee[] employees) {

        boolean[] saveEmployees = save(employees);
        return saveEmployees;
    }

    @Override
    public Employee findByName(String name) {

        Search search = new Search(Employee.class);
//        Filter filter = new Filter();
//        filter.setProperty("empName");
//        filter.setOperator(Filter.OP_EQUAL);
//        filter.setValue("Vishal");
//        Search addFilter = search.addFilter(filter);
        search.addFilterEqual("empName", name);
        Employee employee = searchUnique(search);
        return employee;
    }

    @Override
    public List<Employee> findByNameandSalary(String name, Integer salary) {

        Search search = new Search(Employee.class);
        search.addFilterEqual("empName", name).addFilterGreaterThan("salary", salary).addSortAsc("address");
        List<Employee> employees = search(search);
        return employees;
    }

    @Override
    public List<Employee> getEmployeeByAddressLike(String address) {

        Search search = new Search(Employee.class);
        search.addFilterLike("address", address);
        List<Employee> employees = search(search);
        return employees;
    }

    @Override
    public List<Employee> serchEmploye(String name, String name1) {

        Search search = new Search(Employee.class);
//        search.addFilterIn("empName", name,name1);
        search.addFilterOr(Filter.equal("empName", name), Filter.equal("empName", name1));
        List<Employee> employees = search(search);
        return employees;
    }

    @Override
    public Boolean removeEmployeeById(Integer id) {

        boolean removed = removeById(id);
        return removed;
    }
}
