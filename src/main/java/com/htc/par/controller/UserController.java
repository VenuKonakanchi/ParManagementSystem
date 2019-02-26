package com.htc.par.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.service.UserService;
import com.htc.par.to.UserTO;

/*
 * This controller is for application user services
 */

@RestController
@RequestMapping("/par")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Request handler to get User by user id
	 * @param userId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/users/{userId}")
	public ResponseEntity<UserTO> getUserById(@PathVariable("userId") int userId) throws ResourceNotFoundException {
		return ResponseEntity.ok(userService.getUserById(userId));
	}

	/**
	 * Request handler to get all users 
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/users")
	public ResponseEntity<List<UserTO>> getUsers() throws ResourceNotFoundException {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	/**
	 * Request handler to new active user
	 * @param userTO
	 * @return
	 * @throws ResourceNotCreatedException
	 * @throws ResourceDuplicateException
	 */
	@PostMapping("/users")
	public ResponseEntity<UserTO> createUser(@Valid @RequestBody UserTO userTO)
			throws ResourceNotCreatedException, ResourceDuplicateException {
		return ResponseEntity.created(null).body(userService.createUser(userTO));
	}

	/**
	 * Request handler to update active user 
	 * @param userTO
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws ResourceNotUpdatedException
	 */
	@PutMapping("/users")
	public ResponseEntity<UserTO> updateUser(@Valid @RequestBody UserTO userTO)
			throws ResourceNotFoundException, ResourceNotUpdatedException {
		return ResponseEntity.ok(userService.updateUser(userTO));
	}

	/**
	 * Request handler to delete user
	 * @param userId
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws ResourceNotDeletedException
	 */
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<Boolean> deleteSkill(@PathVariable("userId") int userId)
			throws ResourceNotFoundException, ResourceNotDeletedException {
		return ResponseEntity.ok(userService.deleteUser(userId));
	}
}
