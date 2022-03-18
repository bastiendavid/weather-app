package fr.socrates.infrastructure.repository;

import fr.socrates.domain.City;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CityRepository {

    List<City> cities = List.of(
            new City("Grenoble", 45.1885f, 5.7245f),
            new City("London", 51.5072f, 0.1276f),
            new City("Orange", 44.1381f, 4.8075f),
            new City("Berlin", 52.5200f, 13.4050f)
    );

    public Optional<City> findCity(String cityName) {
        return cities.stream().filter((city) -> city.name().equals(cityName)).findFirst();
    }
}
