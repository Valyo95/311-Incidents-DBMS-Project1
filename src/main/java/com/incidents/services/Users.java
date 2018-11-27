package com.incidents.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.incidents.entities.MyUser;
import com.incidents.exceptions.EntityAlreadyExistsException;
import com.incidents.exceptions.EntityNotFoundException;
import com.incidents.exceptions.ServiceException;

public interface Users extends UserDetailsService {
	public MyUser addUser(String username, String email, String firstName, String lastName,
			String password, String phone, String imagePath) throws EntityAlreadyExistsException;
	public List<MyUser> findAllUsers();
	public MyUser findById(long id) throws EntityNotFoundException;
	public MyUser findByUsername(String username) throws EntityNotFoundException;

	public MyUser updateUser(String username, String firstName, String lastName,
			String email, String phone) throws EntityNotFoundException;
	
	public MyUser changePassword(String username, String oldPlainPassword, String newHashedPassword)
			throws ServiceException;
	
	public MyUser changeUsername(String username, String newUsername) throws ServiceException;

	public List<MyUser> findAllUsersLike(String like);
}
