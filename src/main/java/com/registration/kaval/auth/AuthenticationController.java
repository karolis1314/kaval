package com.registration.kaval.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) throws IllegalStateException{
        try {
            return ResponseEntity.ok(service.register(request));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(409).body(new AuthenticationResponse(e.getMessage()));
        }
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) throws IllegalStateException{
        try {
            return ResponseEntity.ok(service.authenticate(request));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(404).body(new AuthenticationResponse(e.getMessage()));
        }
    }


}
