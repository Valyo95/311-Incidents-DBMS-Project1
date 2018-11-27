package com.incidents.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.util.Pair;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.incidents.entities.MyUser;
import com.incidents.exceptions.UsernameInUseException;
import com.incidents.exceptions.EntityNotFoundException;
import com.incidents.exceptions.OldPasswordNotMatchException;
import com.incidents.exceptions.ServiceException;
import com.incidents.repositories.UserDAO;
import com.incidents.services.Users;
import com.incidents.web.dto.BooleanMessage;
import com.incidents.web.dto.ChangePasswordInfo;
import com.incidents.web.dto.ChangePasswordRequest;
import com.incidents.web.dto.RegisterRequest;
import com.incidents.web.dto.UpdateRequest;
import com.incidents.web.dto.UserInfo;
import com.incidents.web.dto.UserResponse;
import com.incidents.web.dto.UsernameRequest;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
public class UsersRestEndpoint {

  @Autowired
  private Users userService;

  @Autowired
  private UserDAO userDAO;
  
  @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

  SecurityContextHolder securityContextHolder;

  public UsersRestEndpoint() {
  }
  
  @RequestMapping(value = "/getUsernameAndPic", method = RequestMethod.POST)
  public UserResponse isLoggedIn(Principal principal) {
    UserResponse response = new UserResponse();
    MyUser user;

    if (principal != null) {
      try {
        user = userService.findByUsername(principal.getName());
        response.setUsername(user.getUsername());
        response.setImgPath(user.getImagePath().replaceAll("src/main/resources/dynamic", ""));
        response.setType(user.getType());
        response.setUserId(user.getId());
        return response;
      } catch (EntityNotFoundException e) {
        response.setUsername("");
        response.setImgPath("");
        response.setType("Anonymous");
        response.setUserId(new Long(-1));
        return response;
      }
    } else {
      response.setImgPath("");
      response.setType("Anonymous");
      return response;
    }

  }

  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public void logout(HttpServletRequest request, HttpServletResponse response) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null) {
      new SecurityContextLogoutHandler().logout(request, response, auth);
    }
  }

  @RequestMapping(value = "/getProfile", method = RequestMethod.GET)
  public UserInfo getProfile(Principal principal) {
    UserInfo response = new UserInfo();
    MyUser user;

    if (principal != null) {
      String username = principal.getName();
      if (username != null) {
        try {
          user = userService.findByUsername(username);
          response.setUsername(user.getUsername());
          response.setEmail(user.getEmail());
          response.setFirstName(user.getFirstName());
          response.setLastName(user.getLastName());
          response.setPhone(user.getPhone());
        } catch (EntityNotFoundException e) {
          e.printStackTrace();
        }
      }
    }
    return response;
  }

  @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
  public UserInfo updateUser(Principal principal, @RequestBody UpdateRequest request) {
    UserInfo response = new UserInfo();
    MyUser user;
    if (principal != null) {
      String username = principal.getName();

      if (username != null) {
        try {

          user = userService.updateUser(username, request.getFirstName(), request.getLastName(),
              request.getEmail(), request.getPhone());
        } catch (EntityNotFoundException e) {
          e.printStackTrace();
        }
      }
    }
    return response;
  }
  
  @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
  public ChangePasswordInfo changePassword(Principal principal, @RequestBody ChangePasswordRequest request) {
    ChangePasswordInfo response = new ChangePasswordInfo();
    if (principal != null) {
      String username = principal.getName();

      if (username != null) {
        try {
          userService.changePassword(username, request.getOldPassword(), bCryptPasswordEncoder.encode( request.getNewPassword()));
        } catch (EntityNotFoundException e) {
          e.printStackTrace();
        } catch (OldPasswordNotMatchException e) {
          response.setStatus("Old password not matching");
        } catch (ServiceException e) {
          response.setStatus("Unknown exception");
        }
      }
    }
    
    if (response.getStatus() == null) {
      response.setStatus("Successfully changed password");
    }
    
    return response;
  }
  
  @RequestMapping(value = "/changeUsername", method = RequestMethod.POST)
  public ChangePasswordInfo changeUsername(Principal principal, @RequestParam("newUsername") String newUsername) {
    ChangePasswordInfo response = new ChangePasswordInfo();
    if (principal != null) {
      String username = principal.getName();

      if (username != null) {
        try {
          userService.changeUsername(username, newUsername);
        } catch (EntityNotFoundException e) {
          e.printStackTrace();
        } catch (UsernameInUseException e) {
          response.setStatus("Username in use");
        } catch (ServiceException e) {
          response.setStatus("Unknown exception");
        }
      }
    }
    
    if (response.getStatus() == null) {
      response.setStatus("Successfully changed username");
    }
    
    return response;
  }

  @RequestMapping(value = "/isUsernameTaken", method = RequestMethod.POST)
  public BooleanMessage isUsernameTaken(@RequestBody UsernameRequest usernameRequest) {
    BooleanMessage message = new BooleanMessage();

    try {
      userService.findByUsername(usernameRequest.getUsername());
    } catch (EntityNotFoundException e) {
      message.setMessage(false);
      return message;
    }
    message.setMessage(true);
    return message;
  }
}
