package com.example.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;




@Component
public class StudentConverter {
	
	public StudentDto entityToDto(Student student) {
		StudentDto dto = new StudentDto();
		dto.setId(student.getId());
		dto.setName(student.getName());
		dto.setUsername(student.getUsername());
		dto.setPassword(student.getPassword());
		
		return dto;
		
	}
	
	public List<StudentDto> entityToDto(List<Student> student) {
		
		return student.stream()
				.map(x -> entityToDto(x))
				.collect(Collectors.toList());
		
	}	
	
	
	public Student DtoToEntity(StudentDto dto) {
		Student st = new Student();
		st.setId(dto.getId());
		st.setName(dto.getName());
		st.setUsername(dto.getUsername());
		st.setPassword(dto.getPassword());
		
		return st;	
		
	}
	
	public List<Student> DtoToEntity(List<StudentDto> dto) {
		
		return dto.stream()
				.map(x -> DtoToEntity(x))
				.collect(Collectors.toList());	
		
	}
	
	

}

