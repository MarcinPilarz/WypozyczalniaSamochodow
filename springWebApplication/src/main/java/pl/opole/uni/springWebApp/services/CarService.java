package pl.opole.uni.springWebApp.services;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.opole.uni.springWebApp.models.Car;
import pl.opole.uni.springWebApp.repositories.CarRepository;

@Service
public class CarService {

	
	@Autowired
	private CarRepository carRepo;
	
	public List<Car> getCars(){
		return carRepo.findAll();
	}
}
