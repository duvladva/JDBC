import dao.EmployeeDAO;
import dao.impl.EmployeeDAOImpl;
import model.Employee;

import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {

        // Создаем переменные с данными для подключения к базе
//        final String user = "postgres";
//        final String password = "Vov@dv@2002";
//        final String url = "jdbc:postgresql://localhost:5432/skypro";
//         Создаем соединение с базой с помощью Connection
//         Формируем запрос к базе с помощью PreparedStatement
//        try (final Connection connection = DriverManager.getConnection(url, user, password);
//             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)")) {
//             Подставляем значение вместо wildcard
//            statement.setInt(1, 2);
//
//             Делаем запрос к базе и результат кладем в resultSet
//            final ResultSet resultSet = statement.executeQuery();
//
//             Методом next проверяем есть ли следующий элемент в resultSet
//             и одновременно переходим к нему, если таковой есть
//            while (resultSet.next()) {
//
//                 С помощью методов getInt и getString получаем данные из resultSet
//                String id = "id: " + resultSet.getInt("id");
//                String firstName = "first_name: " + resultSet.getString("first_name");
//                String lastName = "last_name: " + resultSet.getString("last_name");
//                String gender = "gender: " + resultSet.getString("gender");
//                String age = "age: " + resultSet.getInt("age");
//                String cityId = "city_id: " + resultSet.getInt("city_id");
//
//                 Выводим данные в консоль
//                System.out.println(id);
//                System.out.println(firstName);
//                System.out.println(lastName);
//                System.out.println(gender);
//                System.out.println(age);
//                System.out.println(cityId);

        // Создаем объект класса DAO
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee employee1 = new Employee(3,"Дмитрий", "Дмитриев", "муж", 33, 3);
//
//        // Создаем объект
        employeeDAO.create(employee1);
//
//        // Получаем объект по id
        System.out.println(employeeDAO.readById(1));
//
//        // Получаем полный список объектов и выводим в консоль
        List<Employee> list1 = employeeDAO.readAll();
        for (Employee person : list1) {
            System.out.println(person);
        }
//
//        // Создаем новый объект (запись) и вставляем ее в таблицу employee
        Employee employee3 = new Employee(3, "Григорий", "Григорьев",
                "муж", 43, 1);
        employeeDAO.updateById(employee3);

        /// Получаем полный список объектов и выводим в консоль
        List<Employee> list2 = employeeDAO.readAll();
        for (Employee person : list2) {
            System.out.println(person);
        }
//
//        // Удаляем записи из таблицы employee запись с id=5
        Employee employee5 = employeeDAO.readById(5);
        employeeDAO.deleteById(employee5);
    }
}


