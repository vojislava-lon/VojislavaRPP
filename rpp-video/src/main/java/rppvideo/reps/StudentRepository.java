package rppvideo.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rppvideo.jpa.Grupa;
import rppvideo.jpa.Projekat;
import rppvideo.jpa.Student;



public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	Collection<Student> findByImeContainingIgnoreCase (Student ime);
	//Collection<Student> findByStudent(Student student);
	Collection<Student> findByGrupa (Grupa grupa);
	Collection<Student> findByProjekat (Projekat projekat);
	
	//@Query(value = "select coalesce(max(broj_indeksa)+1,1) from student")
	//Integer nexBrIn(Integer studentId);

}
