package com.homework.contestservices.callexternalrest.services;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.homework.contestservices.callexternalrest.domain.UserPost;

public interface UserPostsService {
	public List<UserPost> getUserPosts() throws JsonParseException, JsonMappingException, IOException ;
}

