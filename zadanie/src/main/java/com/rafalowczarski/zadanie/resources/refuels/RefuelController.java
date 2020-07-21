package com.rafalowczarski.zadanie.resources.refuels;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefuelController {
	

	@Autowired
	RefuelService refuelService;

	@GetMapping("/refuels")
	private List<Refuel> getAllRefuels() {
		return refuelService.getAllRefuels();
	}

	@GetMapping("/refuels/{id}")
	private Refuel getRefuel(@PathVariable long id) {
		return refuelService.findRefuel(id);
	}

	@DeleteMapping("/refuels/{id}")
	private void deleteRefuel(@PathVariable long id) {
		refuelService.deleteRefuelById(id);
	}
	

	@PostMapping("/refuels")
	private ResponseEntity<Object> createRefuel(@RequestBody Refuel refuel) {
		return refuelService.createRefuel(refuel);
	}
	
	@PutMapping("/refuels/{id}")
	private ResponseEntity<Object> updateRefuel(@RequestBody Refuel refuel, @PathVariable long id) {

		return refuelService.updateRefuel(refuel, id);
	}
}
