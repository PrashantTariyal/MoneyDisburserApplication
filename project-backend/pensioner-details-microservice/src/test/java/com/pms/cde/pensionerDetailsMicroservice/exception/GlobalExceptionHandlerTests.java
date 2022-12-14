package com.pms.cde.pensionerDetailsMicroservice.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pms.cde.pensionerDetailsMicroservice.Exception.AadharNumberNotFoundException;
import com.pms.cde.pensionerDetailsMicroservice.Exception.GlobalExceptionHandler;
import com.pms.cde.pensionerDetailsMicroservice.Model.CustomErrorResponse;



@SpringBootTest(classes = GlobalExceptionHandlerTests.class)
class GlobalExceptionHandlerTests {
	@InjectMocks
	GlobalExceptionHandler globalExceptionHandler;
	@Mock
	CustomErrorResponse customErrorResponse;
	@BeforeEach
	void setUp() {
		customErrorResponse = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND,"Error","test message");
	}
	
	@Test
	void handlesPensionerDetailNotFoundExceptionTest() {
		AadharNumberNotFoundException aadharNumberNotFoundException = new AadharNumberNotFoundException("Pensioner not found");
		globalExceptionHandler.handleAadharNumberNotFoundException(aadharNumberNotFoundException);
		ResponseEntity<?> entity = new ResponseEntity<>(customErrorResponse, HttpStatus.NOT_FOUND);
		assertEquals(404, entity.getStatusCodeValue());
	}
	
	@Test
	void handlesExceptionTest() {
		Exception exception = new Exception("Feign Exception or NumberFormat Exception");
		globalExceptionHandler.handleException(exception);
		ResponseEntity<?> entity = new ResponseEntity<>(customErrorResponse, HttpStatus.BAD_REQUEST);
		assertEquals(400, entity.getStatusCodeValue());
	}
	
}

