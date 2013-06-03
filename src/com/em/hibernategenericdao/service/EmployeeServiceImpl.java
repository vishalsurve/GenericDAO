package com.em.hibernategenericdao.service;

import com.em.hibernategenericdao.dao.EmployeeDAO;
import com.em.hibernategenericdao.model.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vishal
 */
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public Boolean saveEmployee(Employee employee) {

        boolean save = employeeDAO.save(employee);
        return save;
    }

    @Override
    public Employee findEmployee(Integer id) {

        Employee employee = employeeDAO.find(id);
        return employee;
    }

    @Override
    public List<Employee> listOfEmployee() {

        List<Employee> employeeList = employeeDAO.findAll();
        return employeeList;
    }

    @Override
    public boolean[] saveMultipleEmployee(Employee[] employees) {

        boolean[] saveEmployees = employeeDAO.save(employees);
        return saveEmployees;
    }

    @Override
    public Employee findByName(String name) {

        Employee employee = employeeDAO.findByName(name);
        return employee;
    }

    @Override
    public List<Employee> findByNameandSalary(String name, Integer salary) {

        List<Employee> employees = employeeDAO.findByNameandSalary(name, salary);
        return employees;
    }

    @Override
    public List<Employee> getEmployeeByAddressLike(String address) {

        List<Employee> employees = employeeDAO.getEmployeeByAddressLike(address);
        return employees;
    }

    @Override
    public List<Employee> serchEmploye(String name, String name1) {

        List<Employee> employees = employeeDAO.serchEmploye(name, name1);
        return employees;
    }

    @Override
    public Boolean removeEmployeeById(Integer id) {

        Boolean removed = employeeDAO.removeById(id);
        return removed;
    }
}