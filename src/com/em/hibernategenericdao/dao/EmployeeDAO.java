package com.em.hibernategenericdao.dao;

import com.em.hibernategenericdao.model.Employee;
import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import java.util.List;

/**
 *
 * @author Vishal
 */
public interface EmployeeDAO extends GenericDAO<Employee, Integer> {

    public Employee findByName(String name);

    public List<Employee> findByNameandSalary(String name, Integer salary);

    public List<Employee> getEmployeeByAddressLike(String address);

    public List<Employee> serchEmploye(String name, String name1);
}
