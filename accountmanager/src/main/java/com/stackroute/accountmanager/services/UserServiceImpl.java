package com.stackroute.accountmanager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.accountmanager.domain.User;
import com.stackroute.accountmanager.exception.UserAlreadyExistsException;
import com.stackroute.accountmanager.exception.UserNotFoundException;
import com.stackroute.accountmanager.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	
	private final UserRepository userRepo;

	@Autowired
	public UserServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public boolean saveUser(User user) throws UserAlreadyExistsException, UserNotFoundException {
		Optional<User> usr = userRepo.findById(user.getUserId());
		if (usr.isPresent()) {
			throw new UserAlreadyExistsException("User with Id already exists");
		}
		userRepo.save(user);
		return true;
	}

	@Override
	public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepo.findByUserIdAndPassword(userId, password);
		if(user==null)
		{
			throw new UserNotFoundException("UserId and Password mismatch");
		}
		return user;
	}

}
