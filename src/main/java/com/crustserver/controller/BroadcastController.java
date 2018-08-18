package com.crustserver.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crustserver.service.BroadcastService;

@RestController
public class BroadcastController {
	
	@Autowired
	private BroadcastService broadcastService;
	
    @PostMapping(value="/broadcast/mail")
    public void getAllUsers(@PathParam("subject") String subject, 
    						@PathParam("recipient") String recipient,
    						@RequestBody String content) {
        this.broadcastService.sendEmail(subject, recipient, content);
    }

}
