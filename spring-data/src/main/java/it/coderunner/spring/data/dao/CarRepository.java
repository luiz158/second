package it.coderunner.spring.data.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import it.coderunner.spring.data.model.Car;

public interface CarRepository extends CrudRepository<Car, Long>{
	
	Page<Car> findAll(Pageable pageable);

	Page<Car> findByModelContainingAndManufacturerContainingAllIgnoringCase(String manufacturer,
			String model, String prodYear, Pageable pageable);

	Car findByManufacturerAndModelAndProdYearAllIgnoringCase(String manufacturer, String model, String prodYear);
	
	List<Car> findFirst10ByManufacturer(String manufacturer);
	
	@SuppressWarnings("unchecked")
	Car save(Car car);

}
