package com.asanthanasamy.students.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asanthanasamy.students.entity.Student;
import com.asanthanasamy.students.service.StudentService;

@RestController
@RequestMapping("api/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	Logger logger = LoggerFactory.getLogger(StudentController.class);

	@GetMapping("")
	public ResponseEntity<?> getAllStudents(@RequestParam(required = false, name = "name") String name,
			@RequestParam(required = false, name = "studentClass") String studentClass) {
		try {
			return new ResponseEntity<List<Student>>(studentService.listAllStudent(name, studentClass), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.toString());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable Integer id) {
		try {
			Student student = studentService.getStudent(id);
			if (student != null) {
				return new ResponseEntity<Student>(student, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Student Not Found", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error(e.toString());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("")
	public ResponseEntity<?> createStudent(@RequestBody Student student) {
		try {
			return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error(e.toString());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateStudent(@RequestBody Student student, @PathVariable Integer id) {
		try {
			Student result = studentService.updateStudent(student, id);
			if (result != null) {
				return new ResponseEntity<Student>(result, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Student Not Found", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error(e.toString());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
		try {
			boolean isStudentDeleted = studentService.deleteStudent(id);
			if (isStudentDeleted) {
				return new ResponseEntity<>("Student Record Deleted", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Student Not Found", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error(e.toString());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
