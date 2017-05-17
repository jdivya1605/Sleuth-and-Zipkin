package com.car;

import com.car.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car,String> {

    public List<Car> findByMakeInAndYearIn(String make, String year);
}
