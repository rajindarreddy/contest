package com.homework.contestservices.callexternalrest.controllers;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.homework.contestservices.callexternalrest.domain.UserPost;
import com.homework.contestservices.callexternalrest.services.UserPostsService;
	


@RestController
public class SpringRestTemplateController {
	
	@Autowired
	private UserPostsService userPostsService;
	
	@GetMapping(path="/resttemplate")
	public List<UserPost> getUserPosts() throws JsonParseException, JsonMappingException, IOException {
		return userPostsService.getUserPosts();
	}
}
