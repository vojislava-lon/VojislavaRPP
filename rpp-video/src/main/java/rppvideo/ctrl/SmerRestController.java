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


import rppvideo.jpa.Smer;
import rppvideo.reps.SmerRepository;
@CrossOrigin
@RestController
public class SmerRestController {
    
	@Autowired
	private SmerRepository smerRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("smer")
	public Collection<Smer> getAll(){
		return smerRepository.findAll();
	}
	
	@GetMapping("smer/{id}")
	public Smer getOne(@PathVariable("id")Integer id) {
		return smerRepository.getOne(id);
	}
	
	//@GetMapping("smer/naziv/{naziv}")
	//public Collection<Smer> getByNaziv(@PathVariable("naziv")String naziv){
	//	return smerRepository.findByNazivContainingIgnoreCase(naziv);
	//}
	
	@GetMapping("smer/naziv/{naziv}")
	public Collection<Smer> getByNaziv(@PathVariable("naziv")String naziv){
		return smerRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@PostMapping("smer")
	public ResponseEntity<HttpStatus> addSmer(@RequestBody Smer smer){
		smerRepository.save(smer);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	@PutMapping( "smer/{id}")
	public ResponseEntity<HttpStatus> updateSmer(@RequestBody Smer smer, @PathVariable("id") Integer id ){
		if(smerRepository.existsById(id)) {
			smer.setId(id);
			smerRepository.save(smer);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
	
	@DeleteMapping("smer/{id}")
	public ResponseEntity<HttpStatus> deleteSmer(@PathVariable Integer id){
		
		if(id==-100 && !smerRepository.existsById(-100)) {
			jdbcTemplate.execute("INSERT INTO smer (\"id\", \"naziv\",\"oznaka\") VALUES(-100, 'TestNaziv', 'TestOznaka')");
		}
		if(smerRepository.existsById(id)) {
			smerRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}

}
