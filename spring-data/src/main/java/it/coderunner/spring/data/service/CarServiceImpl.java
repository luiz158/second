package it.coderunner.spring.data.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.coderunner.spring.data.dao.CarRepository;
import it.coderunner.spring.data.model.Car;

@Service
public class CarServiceImpl implements CarService{

	private static final long serialVersionUID = -5212497294563141450L;
	
	@Resource
	private CarRepository carRepository;


	@Override
	public Page<Car> findAll(Pageable pageable) {
		return carRepository.findAll(pageable);
	}

	@Override
	public Car findByManufacturerAndModelAndProdYearAllIgnoringCase(String manufacturer, String model, String prodYear) {
		return carRepository.findByManufacturerAndModelAndProdYearAllIgnoringCase(manufacturer, model, prodYear);
	}

	@Override
	public Car save(Car car) {
		return carRepository.save(car);
	}

	@Override
	public List<Car> findFirst10ByManufacturer(String manufacturer) {
		return carRepository.findFirst10ByManufacturer(manufacturer);
	}
	
	@Override
	public List<Car> findByProdYearGreaterThan(String prodYear) {
		return carRepository.findByProdYearGreaterThan(prodYear);
	}

}
