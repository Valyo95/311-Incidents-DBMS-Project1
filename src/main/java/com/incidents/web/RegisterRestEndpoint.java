package com.incidents.web;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.incidents.entities.MyUser;
import com.incidents.exceptions.EntityAlreadyExistsException;
import com.incidents.services.Users;
import com.incidents.web.dto.RegisterRequest;
import com.incidents.web.dto.UserResponse;

@RestController
public class RegisterRestEndpoint {
	
	@Autowired
	private Users userService;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	private static final String USER_PICS_FOLDER = "src/main/resources/dynamic/userPictures/";
	
	@RequestMapping(value = "/register/uploadUserPic", method = RequestMethod.POST, consumes = {
            "multipart/form-data", MediaType.APPLICATION_JSON_VALUE })
	public UserResponse uploadUserPicture(@RequestPart("file") MultipartFile file, @RequestPart("username") String username) {

		UserResponse response = new UserResponse();
		response.setUsername(username);
		
        try {
        	
    	    File directory = new File(USER_PICS_FOLDER);
    	    	if (! directory.exists()){
    	    		directory.mkdir();
    	    	}

            byte[] bytes = file.getBytes();
            String pathStr = USER_PICS_FOLDER + username + "_" + file.getOriginalFilename();
            Path path = Paths.get(pathStr);
            Files.write(path, bytes);//Files.write overwrites the file if it already exists
            response.setMessage(pathStr);
            return response;

        } catch (IOException e) {
            e.printStackTrace();
            response.setMessage("Error uploading file");
            return response;
        }
        

    }
	
	@RequestMapping(value = "/register/addUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public UserResponse addUser(@RequestBody RegisterRequest request) throws EntityAlreadyExistsException {		
		UserResponse registerResponse = new UserResponse();
		registerResponse.setUsername(request.getUsername());

			try	{
				userService.addUser(request.getUsername(), request.getEmail(), request.getFirstName(),
						request.getLastName(), bCryptPasswordEncoder.encode( request.getPassword()), request.getPhone(), request.getImagePath());
				registerResponse.setMessage("Successfully registered user");
			}
			catch (EntityAlreadyExistsException e) {
				return null;
			}
			
		return registerResponse;
	}
}
