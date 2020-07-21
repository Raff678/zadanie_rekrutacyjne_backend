package com.rafalowczarski.zadanie.resources.refuels;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@Service
public class RefuelService {

	@Autowired
	RefuelRepository refuelRepository;

	public Refuel findRefuel(long id) {
		Optional<Refuel> refuelOptional = refuelRepository.findById(id);

		if (!refuelOptional.isPresent())
			throw new EntityNotFoundException("id-" + id);

		return refuelOptional.get();
	}
	
	public List<Refuel> getAllRefuels() {
		return refuelRepository.findAll();
	}
	
	public ResponseEntity<Object> createRefuel(Refuel refuel) {
		Refuel savedRefuel = refuelRepository.save(refuel);
		
		return ResponseEntity.noContent().build();
	}
	
	public ResponseEntity<Object> updateRefuel(Refuel refuel, long id) {

		Optional<Refuel> refuelOptional = refuelRepository.findById(id);

		if (!refuelOptional.isPresent())
			return ResponseEntity.notFound().build();
		
		refuelRepository.save(refuel);

		return ResponseEntity.noContent().build();
	}

	public void deleteRefuelById(long id) {
		refuelRepository.deleteById(id);
	}


}
