package com.commentmanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commentmanagement.model.User;
import com.commentmanagement.payloads.AuthenticationRequest;
import com.commentmanagement.payloads.AuthenticationResponse;
import com.commentmanagement.payloads.RegisterRequest;
import com.commentmanagement.service.impl.AuthenticationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationService authenticationService;

//	@PostMapping("/register")
//	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
//		return ResponseEntity.ok(authenticationService.register(request));
//	}

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@Valid @RequestBody AuthenticationRequest request) {
		return ResponseEntity.ok(authenticationService.authenticate(request));
	}

	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
		return ResponseEntity.ok(authenticationService.register(request));
	}
	
}
