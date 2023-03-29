package model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    @Column(name = "city_id")
    private int cityId;

    @Column(name = "city_name")
    private String cityName;

    @OneToMany(mappedBy="city", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Employee> employees;


    public City(String cityName) {
        this.cityName = cityName;
    }

    public int getCity_id() {
        return cityId;
    }

//    public void setCity_id(int city_id) {
//        this.cityId = city_id;
//    }
//
//    public String getCity_name() {
//        return cityName;
//    }
//
//    public void setCity_name(String city_name) {
//        this.cityName = city_name;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return cityId == city.cityId && Objects.equals(cityName, city.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, cityName);
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + cityId +
                ", city_name='" + cityName + '\'' +
                '}';
    }
}
