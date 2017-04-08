package it.coderunner.spring.data.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.coderunner.spring.data.model.Car;

public interface CarService extends Serializable{

	Car findByManufacturerAndModelAndProdYearAllIgnoringCase(String manufacturer, String model, String prodYear);

	Car save(Car car);
	
	List<Car> findFirst10ByManufacturer(String manufacturer);
	
	List<Car> findByProdYearGreaterThan(String prodYear);
	
	Page<Car> findAll(Pageable pageable);

}
