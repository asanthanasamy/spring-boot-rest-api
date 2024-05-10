package com.asanthanasamy.students.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.asanthanasamy.students.entity.Student;
import com.asanthanasamy.students.repository.StudentRepository;
import com.asanthanasamy.students.service.StudentService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repository;

	@Override
	public List<Student> listAllStudent(String name, String studentClass) {
		if (name != null || studentClass != null) {
			return repository.findByNameIgnoreCaseOrStudentClassIgnoreCase(name, studentClass);
		} else {
			return repository.findAll(Sort.by("id"));
		}
	}

	@Override
	public Student saveStudent(Student student) {
		return repository.save(student);
	}

	@Override
	public Student getStudent(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Student updateStudent(Student student, Integer id) {
		Student result = repository.findById(id).orElse(null);
		if (result != null) {
			return repository.save(student);
		}
		return null;
	}

	@Override
	public boolean deleteStudent(Integer id) {
		Student result = repository.findById(id).orElse(null);
		if (result != null) {
			repository.deleteById(id);
			return true;
		}
		return false;

	}

}
