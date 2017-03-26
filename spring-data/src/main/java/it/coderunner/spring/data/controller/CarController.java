package it.coderunner.spring.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import it.coderunner.spring.data.model.Car;
import it.coderunner.spring.data.service.CarService;

@Controller
public class CarController {

	@Autowired
	private CarService carService;

	@GetMapping("/get/car/{manufacturer}/{model}/{prodYear}")
	public @ResponseBody ResponseEntity<String> getByModelAndManufacturer(@PathVariable String manufacturer,
			@PathVariable String model, @PathVariable String prodYear) {
		Car car = carService.findByManufacturerAndModelAndProdYearAllIgnoringCase(manufacturer, model, prodYear);
		return car != null ? new ResponseEntity<String>("GET Response : " + car, HttpStatus.OK)
				: new ResponseEntity<String>("No car found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/save/car/{manufacturer}/{model}/{prodYear}")
	public @ResponseBody ResponseEntity<String> saveCar(@PathVariable String manufacturer, @PathVariable String model, @PathVariable String prodYear) {
		Car car = carService.save(new Car(manufacturer, model, prodYear));
		return car != null ? new ResponseEntity<String>("GET Response : " + car, HttpStatus.OK)
				: new ResponseEntity<String>("Problem with saving", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/get/top10Cars/{manufacturer}")
	public @ResponseBody ResponseEntity<String> getTop10cars(@PathVariable String manufacturer) {
		List<Car> cars = carService.findFirst10ByManufacturer(manufacturer);
		cars.stream().forEach(System.out::println);
		return cars != null && !cars.isEmpty()
				? new ResponseEntity<String>("GET Response : " + cars, HttpStatus.OK)
				: new ResponseEntity<String>("No car found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/get/allCars/{page}/{size}")
	public @ResponseBody Page<Car> getTop10cars(@PathVariable Integer page, @PathVariable Integer size) {
		return carService.findAll(new PageRequest(page, size));
	}

}
