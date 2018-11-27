package com.incidents.services.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incidents.entities.MyUser;
import com.incidents.exceptions.UsernameInUseException;
import com.incidents.exceptions.EntityAlreadyExistsException;
import com.incidents.exceptions.EntityNotFoundException;
import com.incidents.exceptions.OldPasswordNotMatchException;
import com.incidents.exceptions.ServiceException;
import com.incidents.repositories.UserDAO;
import com.incidents.services.Users;

@Service("Users")
public class UsersImpl implements Users {
	
	private static Logger log = LoggerFactory.getLogger(UsersImpl.class);

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional
	@Override
	public MyUser addUser(String username, String email, String firstName, String lastName, String password, String phone, String imagePath) throws EntityAlreadyExistsException {

		MyUser user = userDAO.findByUsername(username);
		if (user != null)
			throw new EntityAlreadyExistsException();

		List<MyUser> users = userDAO.findByEmail(email);
		if (users != null && users.size() != 0) {
			throw new EntityAlreadyExistsException();
		}
		
		
		user = new MyUser();
		user.setUsername(username);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		user.setPhone(phone);
		user.setImagePath(imagePath);
		userDAO.save(user);
		
		return user;
	}
	
	@Override
	public List<MyUser> findAllUsers() {
		log.debug("START findAllUsers");
		return userDAO.findAll();
	}

	@Transactional
	@Override
	public MyUser findById(long id) throws EntityNotFoundException {
		MyUser user = userDAO.findById(id);
	if (user == null)
		throw new EntityNotFoundException();
	else
		return user;
		
	}

	@Override
    @Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUser myUser = this.userDAO.findByUsername(username);
		
		if (myUser == null) {
            throw new UsernameNotFoundException(username);
        }
		
		return new User(myUser.getUsername(), myUser.getPassword(), emptyList());
	}
	
	@Override
	public MyUser updateUser(String username, String firstName, String lastName,
			String email, String phone) throws EntityNotFoundException{
		log.info("START updateUser");
		MyUser user = userDAO.findByUsername(username);
		if (user == null)
			throw new EntityNotFoundException();
		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPhone(phone);
		userDAO.saveAndFlush(user);
		return user;
	}

	@Override
	@Transactional
	public MyUser changePassword(String username, String oldPlainPassword, String newHashedPassword) throws ServiceException{
		MyUser user = userDAO.findByUsername(username);
		if (user == null)
			throw new EntityNotFoundException();
		
		if (!bCryptPasswordEncoder.matches(oldPlainPassword, user.getPassword()))
		{
			throw new OldPasswordNotMatchException();
		}
		user.setPassword(newHashedPassword);
		return user;
	}
	
	@Override
	public MyUser findByUsername(String username) throws EntityNotFoundException {
		MyUser user = userDAO.findByUsername(username);
		
		if (user == null)
			throw new EntityNotFoundException();
	
		return user;
	}

	@Override
	public List<MyUser> findAllUsersLike(String like) {
		List<MyUser> l;
		l = userDAO.findByEmailContaining(like);
		l.addAll(userDAO.findByFirstNameContaining(like));
		l.addAll(userDAO.findByLastNameContaining(like));
		List<Long> ids = (List<Long>) l.stream().map(x -> x.getId()).distinct().collect(Collectors.toList());
		l.clear();
		for (Long id : ids) {
			l.add(userDAO.findById(id));
		}
		
		return l;
	}
	
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

	@Override
	@Transactional
	public MyUser changeUsername(String username, String newUsername) throws ServiceException {
		MyUser user = userDAO.findByUsername(username);
		if (user == null)
			throw new EntityNotFoundException();
		
		MyUser someone = userDAO.findByUsername(newUsername);
		
		if (someone != null)
			throw new UsernameInUseException();

		user.setUsername(newUsername);

		return user;
	}

}
