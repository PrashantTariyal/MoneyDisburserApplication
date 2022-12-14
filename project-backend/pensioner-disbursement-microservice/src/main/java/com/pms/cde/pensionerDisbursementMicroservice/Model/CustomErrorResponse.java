package com.pms.cde.pensionerDisbursementMicroservice.Model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
/*
 * @NoArgsConstructor
 * 
 * @AllArgsConstructor
 */
@EqualsAndHashCode
public class CustomErrorResponse {
	
	
	public CustomErrorResponse() {
		//super();
		// TODO Auto-generated constructor stub
	}
	public CustomErrorResponse(LocalDateTime timestamp, HttpStatus status, String reason, List<String> message) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.reason = reason;
		this.message = message;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public List<String> getMessage() {
		return message;
	}
	public void setMessage(List<String> message) {
		this.message = message;
	}
	private LocalDateTime timestamp;
	private HttpStatus status;
	private String reason;
	private List<String> message;

}
