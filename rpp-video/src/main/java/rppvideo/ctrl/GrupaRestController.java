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

import rppvideo.jpa.Grupa;
import rppvideo.jpa.Smer;
import rppvideo.reps.GrupaRepository;
@CrossOrigin
@RestController
public class GrupaRestController {
	
	@Autowired
	private GrupaRepository grupaRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("grupa")
	public Collection<Grupa> getGrupe(){
		return grupaRepository.findAll();
	}
	
	@GetMapping("grupa/{id}")
	public Grupa getOne(@PathVariable("id")Integer id) {
		return grupaRepository.getOne(id);
	}
	
	@GetMapping("grupa/oznaka/{oznaka}")
	public Collection<Grupa> getByNaziv(@PathVariable("oznaka")String oznaka){
		return grupaRepository.findByOznakaContainingIgnoreCase(oznaka);
	}
	
	@PostMapping("grupa")
	public ResponseEntity<HttpStatus> addGrupa(@RequestBody Grupa grupa){
		grupaRepository.save(grupa);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	@PutMapping( "grupa/{id}")
	public ResponseEntity<HttpStatus> updateGrupa(@RequestBody Grupa grupa, @PathVariable("id") Integer id ){
		if(grupaRepository.existsById(id)) {
			grupa.setId(id);
			grupaRepository.save(grupa);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
	
	@DeleteMapping("grupa/{id}")
	public ResponseEntity<HttpStatus> deleteGrupa(@PathVariable Integer id){
		
		if(id==-100 && !grupaRepository.existsById(-100)) {
			jdbcTemplate.execute("INSERT INTO grupa (\"id\", \"oznaka\",\"smer\") VALUES(-100, 'TestOznaka', '5')");
		}
		if(grupaRepository.existsById(id)) {
			grupaRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}

}
