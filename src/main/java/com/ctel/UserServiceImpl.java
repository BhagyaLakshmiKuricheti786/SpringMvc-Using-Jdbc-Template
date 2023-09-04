package com.ctel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private final UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public User getUserByPhone(String phone) {
		return userDao.getUserByPhone(phone);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(String phone) {
		userDao.deleteUser(phone);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
}
