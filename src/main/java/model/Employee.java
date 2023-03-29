package model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City cityId;


//    public Employee() {
//    }


//    public Employee(int id, String first_name, String last_name, String gender, int age, City city_id) {
//        this.id = id;
//        this.firstName = first_name;
//        this.lastName = last_name;
//        this.gender = gender;
//        this.age = age;
//        this.cityId = city_id;
//    }

    public Employee(String first_name, String last_name, String gender, int age, City city_id) {
        this.firstName = first_name;
        this.lastName = last_name;
        this.gender = gender;
        this.age = age;
        this.cityId = city_id;
    }


//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getFirst_name() {
//        return firstName;
//    }
//
//    public void setFirst_name(String first_name) {
//        this.firstName = first_name;
//    }
//
//    public String getLast_name() {
//        return lastName;
//    }
//
//    public void setLast_name(String last_name) {
//        this.lastName = last_name;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public int getCity_id() {
//        return cityId;
//    }
//
//    public void setCity_id(int city_id) {
//        this.cityId = city_id;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && age == employee.age && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(gender, employee.gender) && Objects.equals(cityId, employee.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, gender, age, cityId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", city_id=" + cityId +
                '}';
    }
}
