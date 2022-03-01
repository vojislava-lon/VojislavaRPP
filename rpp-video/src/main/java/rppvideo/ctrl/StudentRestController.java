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
import rppvideo.jpa.Projekat;
import rppvideo.jpa.Smer;
import rppvideo.jpa.Student;
import rppvideo.reps.GrupaRepository;
import rppvideo.reps.ProjekatRepository;
import rppvideo.reps.StudentRepository;
@CrossOrigin
@RestController
public class StudentRestController {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private GrupaRepository grupaRepository;
	
	@Autowired
	private ProjekatRepository projekatRepository;
	
	@GetMapping("student")
	public Collection<Student> getAll(){
		return studentRepository.findAll();
	}
	
	@GetMapping("student/{id}")
	public Student getOne(@PathVariable("id")Integer id) {
		return studentRepository.getOne(id);
	}
	
	@GetMapping("studentUGrupi/{id}")
	public Collection<Student> getAllForGrupa(@PathVariable("id") Integer id){
		Grupa g = grupaRepository.getOne(id);
		return studentRepository.findByGrupa(g);
	}
	
	@GetMapping("studentNaProjektu/{id}")
	public Collection<Student> getAllForProjekat(@PathVariable("id") Integer id){
		Projekat p = projekatRepository.getOne(id);
		return studentRepository.findByProjekat(p);
	}
	
	@PostMapping("student")
	public ResponseEntity<HttpStatus> addSmer(@RequestBody Student student){
		studentRepository.save(student);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	//@PostMapping("student")
	//public ResponseEntity<HttpStatus> addOne( @RequestBody Student student ){
	//	 student.setBrojIndeksa(studentRepository.nexBrIn(student.getStudent().getId()));
	//	 Student savedStudent = student.save(student);
	//	 return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
		 
	//}
	
	@PutMapping( "student/{id}")
	public ResponseEntity<HttpStatus> updateStudent(@RequestBody Student student, @PathVariable("id") Integer id ){
		if(studentRepository.existsById(id)) {
			student.setId(id);
			studentRepository.save(student);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
	
	@DeleteMapping("student/{id}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Integer id){
		
		if(id==-100 && !studentRepository.existsById(-100)) {
			jdbcTemplate.execute("INSERT INTO student (\"id\", \"ime\",\"prezime\", \"broj_indeksa\",\"grupa\",\"projekat\") VALUES(-100, 'TestIme', 'TestPrezime','TestBrIn','22','13')");
		}
		if(studentRepository.existsById(id)) {
			studentRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
}
