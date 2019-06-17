package com.stackroute.accountmanager.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.accountmanager.exception.UserAlreadyExistsException;
import com.stackroute.accountmanager.exception.UserNotFoundException;
import com.stackroute.accountmanager.domain.User;
import com.stackroute.accountmanager.repositories.UserRepository;
import com.stackroute.accountmanager.services.UserServiceImpl;

public class UserServiceTest {
	
	@Mock
	private UserRepository repository;
	
	private User user;
	
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	Optional<User> options;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		user = new User("J.Wright", "John", "Wright", "password", new Date());
		options = Optional.of(user);
	}
	
	@Test
	public void testSaveUserSuccess() throws UserAlreadyExistsException, UserNotFoundException {
		
		when(repository.save(user)).thenReturn(user);
		boolean flag = userServiceImpl.saveUser(user);
		assertEquals("Cannot register user", true, flag);
		verify(repository, times(1)).save(user);
	}
	
	@Test(expected = UserAlreadyExistsException.class)
	public void testSaveUserFailure() throws UserAlreadyExistsException, UserNotFoundException {
		
		when(repository.findById(user.getUserId())).thenReturn(options);
		when(repository.save(user)).thenReturn(user);
		boolean flag = userServiceImpl.saveUser(user);
		
	}
	
	@Test
	public void testValidateSuccess() throws UserNotFoundException {
		
		when(repository.findByUserIdAndPassword(user.getUserId(), user.getPassword())).thenReturn(user);
		User userResult = userServiceImpl.findByUserIdAndPassword(user.getUserId(), user.getPassword());
		assertNotNull(userResult);
		assertEquals("J.Wright", userResult.getUserId());
		verify(repository, times(1)).findByUserIdAndPassword(user.getUserId(), user.getPassword());
		
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testValidateFailure() throws UserNotFoundException {
		
		when(repository.findById("dummy")).thenReturn(null);
		userServiceImpl.findByUserIdAndPassword(user.getUserId(), user.getPassword());
		
	}

}
