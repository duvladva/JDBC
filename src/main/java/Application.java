import java.sql.*;
public class Application {
    public static void main(String[] args) throws SQLException {

        // Создаем переменные с данными для подключения к базе
        final String user = "postgres";
        final String password = "Vov@dv@2002";
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        // Создаем соединение с базой с помощью Connection
        // Формируем запрос к базе с помощью PreparedStatement
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)")) {
            // Подставляем значение вместо wildcard
            statement.setInt(1, 2);

            // Делаем запрос к базе и результат кладем в resultSet
            final ResultSet resultSet = statement.executeQuery();

            // Методом next проверяем есть ли следующий элемент в resultSet
            // и одновременно переходим к нему, если таковой есть
            while (resultSet.next()) {

                // С помощью методов getInt и getString получаем данные из resultSet
                String id = "id: " + resultSet.getInt("id");
                String first_name = "first_name: " + resultSet.getString("first_name");
                String last_name = "last_name: " + resultSet.getString("last_name");
                String gender = "gender: " + resultSet.getString("gender");
                String age = "age: " + resultSet.getInt("age");
                String city_id = "city_id: " + resultSet.getInt("city_id");

                // Выводим данные в консоль
                System.out.println(id);
                System.out.println(first_name);
                System.out.println(last_name);
                System.out.println(gender);
                System.out.println(age);
                System.out.println(city_id);
            }
        }
    }
}

