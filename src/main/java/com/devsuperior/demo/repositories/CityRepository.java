package com.devsuperior.demo.repositories;

import com.devsuperior.demo.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query(nativeQuery = true, value = "Select * from tb_city order by name asc ")
    List<City> findCityAndSortByName();
}
