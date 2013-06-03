package com.em.hibernategenericdao.service;

import com.em.hibernategenericdao.model.Employee;
import java.util.List;

/**
 *
 * @author Vishal
 */
public interface EmployeeService {

    public Boolean saveEmployee(Employee employee);

    public Employee findEmployee(Integer i);

    public List<Employee> listOfEmployee();

    public boolean[] saveMultipleEmployee(Employee[] toArray);

    public Employee findByName(String name);

    public List<Employee> findByNameandSalary(String name, Integer salary);

    public List<Employee> getEmployeeByAddressLike(String address);

    public List<Employee> serchEmploye(String name, String name1);

    public Boolean removeEmployeeById(Integer i);
}
