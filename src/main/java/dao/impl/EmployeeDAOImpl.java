package dao.impl;

import config.HibernateSessionFactoryUtil;
import dao.EmployeeDAO;

import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
//    private Connection connection;
//    public EmployeeDAOImpl(Connection connection) throws SQLException{
//        this.connection = connection;
//    }

    @Override
    public void create(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee readById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            transaction.commit();
            return employee;
        }
    }

    @Override
    public List<Employee> readAll() {

        try ( Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Employee> employees = session.createQuery("FROM Employee", Employee.class).list();
            transaction.commit();
            return  employees;
        }
    }

    @Override
    public void updateById(Employee employee) {
        try ( Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Employee employee) {
        try ( Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
