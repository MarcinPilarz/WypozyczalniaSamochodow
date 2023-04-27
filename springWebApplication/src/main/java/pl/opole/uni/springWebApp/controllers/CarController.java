
package pl.opole.uni.springWebApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.opole.uni.springWebApp.models.Car;
import pl.opole.uni.springWebApp.services.CarService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CarController {

	@Autowired
	private CarService carService;
	
	
	@GetMapping(value="/cars")
	public List<Car> getCars()
	{
		return carService.getCars();
	}
	
	@GetMapping("/")
    public String index() {
       return "index";
   }
}
//fgdfgdfgdgjhjbhjbhj

