package com.commentmanagement.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.commentmanagement.model.*;
import com.commentmanagement.payloads.RegisterRequest;
import com.commentmanagement.config.JwtService;
import com.commentmanagement.exceptions.ResourceNotFoundException;
import com.commentmanagement.payloads.AuthenticationRequest;
import com.commentmanagement.payloads.AuthenticationResponse;
import com.commentmanagement.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

//	public AuthenticationResponse register(RegisterRequest request) {
//
//		var user = User.builder().name(request.getName()).email(request.getEmail())
//				.password(passwordEncoder.encode(request.getPassword())).role(Role.USER).build();
//		userRepository.save(user);
//		var jwtToken = jwtService.generateToken(user);
//		return AuthenticationResponse.builder().token(jwtToken).build();
//	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {

		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
				);
		User user=userRepository.findByEmail(request.getEmail()).orElseThrow();
				String jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}
	
	public User register(RegisterRequest request) {

		var user = User.builder().name(request.getName()).email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword())).role(Role.USER).build();
		//userRepository.save(user);
		//var jwtToken = jwtService.generateToken(user);
		return userRepository.save(user);
				//builder().token(jwtToken).build();
	}


}
