package rppvideo.reps;

import java.util.Collection;


import org.springframework.data.jpa.repository.JpaRepository;

import rppvideo.jpa.Grupa;


public interface GrupaRepository extends JpaRepository<Grupa, Integer> {

	//Collection<Grupa> findByOznakaContainingIgnoreCase(String oznaka);
     //Collection<Grupa> findByOznakaContainingIgnoreCase(String naziv);

	Collection<Grupa> findByOznakaContainingIgnoreCase(String oznaka);

	

	
}
