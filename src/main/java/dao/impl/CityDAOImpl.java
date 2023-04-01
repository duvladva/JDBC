package dao.impl;

import config.HibernateSessionFactoryUtil;
import dao.CityDAO;
import model.City;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CityDAOImpl implements CityDAO {

    @Override
    public void create(City city) {

        // Создание объекта сессии и её открытие
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction(); // создание транзакции
            session.save(city); // метод save создает новую запись
            transaction.commit(); // сохранение изменений
        }
    }

    @Override
    public City readById(int cityId) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            City city = session.get(City.class, cityId);
            transaction.commit();
            return city;
        }
    }

    @Override
    public List<City> readAll() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            List<City> cities = session.createQuery("FROM City", City.class).getResultList();
            transaction.commit();

            return cities;
        }
    }

    @Override
    public void updateCity(City city) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(City city) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }



}
