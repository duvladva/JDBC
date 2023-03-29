package dao;

import model.City;
import model.Employee;
import java.util.List;

public interface CityDAO {
    // Добавление объекта
    void create(City city);
    // Получение объекта по id
    City readById(int city_id);
    // Получение всех объектов
    List<City> readAll();
    // Изменение объекта по id
    void updateCity(City city);
    // Удаление объекта по id
    void delete(City city);

    Employee findEmployeeById(int id);
}
