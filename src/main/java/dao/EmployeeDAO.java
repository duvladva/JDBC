package dao;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {

    void create(Employee employee);

    Employee readById(int id);

    List<Employee> readAll();

    void updateById(Employee employee);

    void deleteById(Employee employee);
    Employee findEmployeeById(int id);


}
