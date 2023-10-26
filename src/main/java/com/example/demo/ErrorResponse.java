package com.example.demo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "ErrorResponse")
public class ErrorResponse {
	private String status;
	private String errorCode;
	private String errorMessage;
	

}
