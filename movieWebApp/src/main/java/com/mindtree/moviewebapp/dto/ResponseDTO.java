package com.mindtree.moviewebapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDTO {

	private String message;
	private int status;
	private Object data;
	private Boolean success;
}
