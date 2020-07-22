package com.rafalowczarski.zadanie.resources.refuels;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class RefuelService {

	private final RefuelRepository refuelRepository;

	Refuel findRefuel(Long id) {
		Optional<Refuel> refuelOptional = refuelRepository.findById(id);

		if (!refuelOptional.isPresent())
		{
			return null;
		}
		
		return refuelOptional.get();
	}
	
	List<Refuel> getAllRefuels() {
		return refuelRepository.findAll();
	}
	
	Refuel createRefuel(Refuel refuel) {
		return refuelRepository.save(refuel);
	}
	
	Refuel updateRefuel(Refuel refuel, Long id) {
		Optional<Refuel> refuelOptional = refuelRepository.findById(id);

		if (!refuelOptional.isPresent())
		{
			return null;
		}
		
		refuelRepository.save(refuel);

		return refuel;
	}

	void deleteRefuelById(Long id) {
		refuelRepository.deleteById(id);
	}


}
