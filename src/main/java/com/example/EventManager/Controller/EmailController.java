package com.example.EventManager.Controller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EventManager.Repository.UserRepo;
import com.example.EventManager.Service.EmailService;

@RequestMapping("/mail")
@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepo userRepo;


    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendEmail(@RequestBody Map<String, String> payload) {
    String email = payload.get("email");

    if (email == null || email.isEmpty()) {
    return ResponseEntity.badRequest().body("Email is missing");
    }

    try {
    emailService.sendEmail(
    email,
    "Account created successfully!",
    "Welcome. Continue your journey... Thank you!"
    );
    return ResponseEntity.ok("Email sent to " + email);
    } catch (Exception e) {
    e.printStackTrace();
    return ResponseEntity.internalServerError().body("Failed to send email");
    }
    }
}

