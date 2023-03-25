package model;

import java.util.Objects;

public class City {

    private int cityId;
    private String cityName;

    public City(int city_id, String city_name) {
        this.cityId = city_id;
        this.cityName = city_name;
    }

    public int getCity_id() {
        return cityId;
    }

    public void setCity_id(int city_id) {
        this.cityId = city_id;
    }

    public String getCity_name() {
        return cityName;
    }

    public void setCity_name(String city_name) {
        this.cityName = city_name;
    }

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
