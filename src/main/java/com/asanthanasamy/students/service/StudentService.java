package com.asanthanasamy.students.service;

import java.util.List;

import com.asanthanasamy.students.entity.Student;


public interface StudentService {
	
	public List<Student> listAllStudent(String name, String studentClass);

    public Student saveStudent(Student student);

    public Student updateStudent(Student student, Integer id);
    
    public Student getStudent(Integer id);

    public boolean deleteStudent(Integer id);

}
