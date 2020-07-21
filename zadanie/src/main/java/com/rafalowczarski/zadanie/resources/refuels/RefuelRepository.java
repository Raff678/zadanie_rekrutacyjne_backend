package com.rafalowczarski.zadanie.resources.refuels;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RefuelRepository extends JpaRepository<Refuel, Long>{

}