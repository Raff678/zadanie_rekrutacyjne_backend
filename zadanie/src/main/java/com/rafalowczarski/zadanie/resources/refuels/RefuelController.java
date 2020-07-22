package com.rafalowczarski.zadanie.resources.refuels;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController	
@RequiredArgsConstructor
class RefuelController {
	
	
	private final RefuelService refuelService;

	@GetMapping("/refuels")
	public ResponseEntity<List<Refuel>> getAllRefuels() {
		List<Refuel> refuels = refuelService.getAllRefuels();
		
		if (refuels == null || refuels.isEmpty()) {
			return new ResponseEntity<List<Refuel>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Refuel>>(refuels, HttpStatus.OK);
	}

	@GetMapping("/refuels/{id}")
	public ResponseEntity<Refuel> getRefuel(@PathVariable @NotNull Long id) {
		Refuel refuel = refuelService.findRefuel(id);
		if (refuel == null) {
			return new ResponseEntity<Refuel>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Refuel>(refuel, HttpStatus.OK);
	}

	@DeleteMapping("/refuels/{id}")
	public void deleteRefuel(@PathVariable @NotNull Long id) {
		refuelService.deleteRefuelById(id);
	}
	

	@PostMapping("/refuels")
	public ResponseEntity<Refuel> createRefuel(@RequestBody @NotNull Refuel refuel) {
		Refuel savedRefuel =  refuelService.createRefuel(refuel);
		
		if (savedRefuel == null) {
			return new ResponseEntity<Refuel>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Refuel>(savedRefuel, HttpStatus.OK);
	}
	
	@PutMapping("/refuels/{id}")
	public ResponseEntity<Refuel> updateRefuel(@RequestBody @NotNull Refuel refuel, @PathVariable @NotNull Long id) {
		Refuel updatedRefuel = refuelService.updateRefuel(refuel, id);

		if(updatedRefuel==null) {
			return new ResponseEntity<Refuel>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Refuel>(updatedRefuel, HttpStatus.OK);
	}
}
