package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ErrorResponse;
import com.example.demo.converter.StudentConverter;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepo;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/user")

//security only for this controller 

public class StudentController {

		private static final String TAG="User";
	@Autowired
	StudentRepo studentrepo;

	@Autowired
	StudentConverter stdconverter;

	
	
	@SecurityRequirement(name = "Star Health Authentication")
	@Operation(tags = TAG, description = "Find all users from record", responses = {
			@ApiResponse(description = "Success", responseCode = "200OK"),
			@ApiResponse(description = "Not Found", responseCode = "404") })
	@GetMapping("/findAll")
	@Tag(name="v1",description = " version v1")
	public List<StudentDto> findAll() {
		List<Student> findAll = studentrepo.findAll();
		return stdconverter.entityToDto(findAll);
	}
	
	


	@SecurityRequirement(name = "Star Health Authentication")
	@Operation(tags = TAG, description = "Find users from record by using ID")
//	responses = {
//			@ApiResponse(description = "Success", responseCode = "200Ok"),
//			@ApiResponse(description = "Not Found", responseCode = "404") }
	@ApiResponses(value = {
			@ApiResponse( description = "Internal Server Error", responseCode = "500",  content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse( description = "Page Not Found", responseCode = "404",  content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse( description = "Success", responseCode = "200",  content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
	})
	@Tag(name="v1",description = " version v1")
	@Deprecated
	@GetMapping("/find/{ID}/")
	public StudentDto findByID(@PathVariable(value = "ID") Long id) {
		Student orElse = studentrepo.findById(id).orElse(null);
		return stdconverter.entityToDto(orElse);
	}
	
	
	//new version
	@SecurityRequirement(name = "APIKeyAuth")
	@Operation(tags = TAG, description = "Find users from record by using ID")
	@ApiResponses(value = {
			@ApiResponse( description = "Internal Server Error", responseCode = "500",  content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse( description = "Page Not Found", responseCode = "404",  content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse( description = "Success", responseCode = "200",  content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
	})
	@Tag(name="v2",description = " version v2")
	@GetMapping("/find/v2/{ID}")
	public StudentDto findByIDv2(@PathVariable(value = "ID") Long id) {
		Student orElse = studentrepo.findById(id).orElse(null);
		return stdconverter.entityToDto(orElse);
	}
	
	
	
	
	

	@Operation(tags = TAG, description = "Save the data of users in record") 
	@ApiResponses(value = {
			@ApiResponse( description = "Internal Server Error", responseCode = "500",  content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse( description = "Page Not Found", responseCode = "404",  content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse( description = "Success", responseCode = "200",  content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
	})
	@Tag(name="v1",description = " version v1")
	@Deprecated
	@PostMapping(path = "/save")
	public StudentDto save(@RequestBody StudentDto dto) {

		Student student = stdconverter.DtoToEntity(dto);
		student = studentrepo.save(student);

		return stdconverter.entityToDto(student);
	}
	
	
		//new API
		
		
		@Operation(tags = TAG, description = "Save the data of users in record") 
		@ApiResponses(value = {
				@ApiResponse( description = "Internal Server Error", responseCode = "500",  content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
				@ApiResponse( description = "Page Not Found", responseCode = "404",  content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
				@ApiResponse( description = "Success", responseCode = "200",  content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
		})
		@Tag(name="v2",description = " version v2")
		@PostMapping(path = "/save/v2")
		public StudentDto savev2( @RequestBody StudentDto dto) {

			Student student = stdconverter.DtoToEntity(dto);
			student = studentrepo.save(student);

			return stdconverter.entityToDto(student);	
		
	}
}
