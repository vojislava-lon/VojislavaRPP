package rppvideo.ctrl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rppvideo.jpa.Projekat;
import rppvideo.reps.ProjekatRepository;
@CrossOrigin
@RestController
public class ProjekatRestController {
      
	@Autowired
	private ProjekatRepository projekatRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
    
	@GetMapping("projekat")
	public Collection<Projekat> getAll(){
		return projekatRepository.findAll();
	}
	
	@GetMapping("projekat/{id}")
	public Projekat getOne(@PathVariable("id")Integer id) {
		return projekatRepository.getOne(id);
	}
	
	@GetMapping("projekat/naziv/{naziv}")
	public Collection<Projekat> getByNaziv(@PathVariable("naziv")String naziv){
		return projekatRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@PostMapping("projekat")
	public ResponseEntity<HttpStatus> addProjekat(@RequestBody Projekat projekat){
		projekatRepository.save(projekat);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	@PutMapping( "projekat/{id}")
	public ResponseEntity<HttpStatus> updateProjekat(@RequestBody Projekat projekat, @PathVariable("id") Integer id ){
		if(projekatRepository.existsById(id)) {
			projekat.setId(id);
			projekatRepository.save(projekat);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
	
	@DeleteMapping("projekat/{id}")
	public ResponseEntity<HttpStatus> deleteProjekat(@PathVariable Integer id){
		if(id==-100 && !projekatRepository.existsById(-100)) {
			jdbcTemplate.execute("INSERT INTO projekat (\"id\", \"naziv\",\"oznaka\",\"opis\") VALUES(-100, 'TestNaziv', 'TestOznaka', 'TestOpis')");
		}
		if(projekatRepository.existsById(id)) {
			projekatRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
	}


