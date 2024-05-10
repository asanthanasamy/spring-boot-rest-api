package com.asanthanasamy.students.repository;

import com.asanthanasamy.students.entity.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByNameIgnoreCaseOrStudentClassIgnoreCase(String name, String studentClass);

}
