package com.security.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.multiDB.a.dao.UserRepository;
import com.multiDB.a.entity.AppUser;
import com.security.model.LoginRequest;
import com.security.model.LoginResponse;
import com.security.service.TokenService;
@RestController
public class DemoController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private TokenService tokenService;
	
	 @PostMapping("/auth/login")
	    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
	        LoginResponse res = tokenService.createToken(request);
	        return ResponseEntity.ok(res);
	    }

	@PostMapping("/users")
	public ResponseEntity<Void> createUser(@RequestBody AppUser user) {
		userRepository.insert(user);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/users")
	public ResponseEntity<List<AppUser>> getAllUsers() {
		var users = userRepository.findAll();
		return ResponseEntity.ok(users);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<AppUser> getUser(@PathVariable String id) {
		var user = userRepository.findById(id);
		return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
	}
	
	@PostMapping("/auth/refresh-token")
    public ResponseEntity<Map<String, String>> refreshAccessToken(@RequestBody Map<String, String> request) {
        String refreshToken = request.get("refreshToken");
        String accessToken = tokenService.refreshAccessToken(refreshToken);
        Map<String, String> res = Map.of("accessToken", accessToken);

        return ResponseEntity.ok(res);
    }
}