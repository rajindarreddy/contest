package com.homework.contestservices.callexternalrest.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.homework.contestservices.callexternalrest.domain.UserPost;

@Service
public class UserPostsServiceImpl implements UserPostsService {
	RestTemplate restTemplate;
	ObjectMapper mapper;

	public UserPostsServiceImpl() {
		restTemplate = new RestTemplate();
		mapper = new ObjectMapper();
	}

	@SuppressWarnings("unchecked")
	public List<UserPost> getUserPosts() throws JsonParseException, JsonMappingException, IOException {
		List<UserPost> userPosts = null;
		final String uri = "https://jsonplaceholder.typicode.com/posts";
		try {
			String result = restTemplate.getForObject(uri, String.class);
			System.out.println(result);
			userPosts = mapper.readValue(result, ArrayList.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userPosts;
	}
}