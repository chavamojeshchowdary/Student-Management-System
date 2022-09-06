package com.example.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController  //spring mvc Internally uses converters to convert java objects to json
public class StudentController {
	
	
	//localhost:8080/student 
	
	@GetMapping("/student")
	public Student getStudent() {
		
		return new Student("Mojesh","Chava");
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student>students=new ArrayList<>();
		students.add(new Student("Chava","Mojesh"));
		students.add(new Student("De jong","son"));
		return students;
		
	}
	
	//with @PathVariable annotation we bind the request url template path variable to method variable
	//http://localhost:8080/student/mojesh/chava
	@GetMapping("/student/{firstName}/{lastName}")
	public Student studentPathVariable(@PathVariable("firstName") String firstName1,@PathVariable("lastName") String lastName) {
		return new Student(firstName1,lastName);
	}
	
	
	//BUILD REST API TO HANDLE QUERY PARAMETERS
	//http://localhost:8080/student/query?firstName=Mojesh&lastName=Chava
	@GetMapping("/student/query")
	public Student StudentQueryParam(@RequestParam(name="firstName") String firstName, @RequestParam(name="lastName") String lastName) {
		return new Student(firstName,lastName);
	}
	
}
