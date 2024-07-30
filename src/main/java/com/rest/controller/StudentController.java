package com.rest.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Student;
import com.rest.repo.StudentRepo;

@RestController
public class StudentController {

	@Autowired
	private StudentRepo repo;
	
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student std,Model m) {
		return repo.save(std);
	}
	@DeleteMapping("/delete/{sid}")
	public void deleteStudent(@PathVariable Integer sid,Model m) {
		repo.deleteById(sid);
	}
	
	//Display 1 Record
	
	@GetMapping("/get/{sid}")
	public Student getOne(@PathVariable Integer  sid) {
		Student s12= repo.findById(sid).get();
		return s12;
	}
	
	//Display All Records
	
	@GetMapping("/getAll")
	public List<Student> getAll(){
		return (List<Student>) repo.findAll();
	}
	
	//Update Record
	
	@PutMapping("/update/{sid}")
	public Student updateStudent(@RequestBody Student std,@PathVariable Integer sid) {
		Optional<Student> optional=repo.findById(sid);
		Student s1=optional.get();
		s1.setStdName(std.getStdName());
		s1.setCourse(std.getCourse());
		s1.setFee(std.getFee());
		return repo.save(s1);
	}
	
}
