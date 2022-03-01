package rppvideo.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;


import rppvideo.jpa.Smer;

public interface SmerRepository extends JpaRepository<Smer, Integer> {

	Collection<Smer> findByNazivContainingIgnoreCase(String naziv);
	
	

	

	

	

}
