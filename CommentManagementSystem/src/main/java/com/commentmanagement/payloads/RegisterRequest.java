package com.commentmanagement.payloads;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
	
	@NotNull(message = "Plesae Enter Valid Name")
	private String name;
	@NotNull(message = "please enter valid Email")
	private String email;
	@NotNull(message = "please enter strong password")
	private String password;

}
