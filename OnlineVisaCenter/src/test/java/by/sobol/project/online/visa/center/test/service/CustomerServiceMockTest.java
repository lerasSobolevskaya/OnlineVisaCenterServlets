package by.sobol.project.online.visa.center.test.service;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import by.sobol.visacenter.model.User;
import by.sobol.visacenter.service.UserService;
import by.sobol.visacenter.service.impl.UserServiceImpl;

public class CustomerServiceMockTest {

	private UserService userService;
	private User user;
	private List<User> users;

	@Before
	public void initUserService() {
		userService = mock(UserServiceImpl.class);
		user = mock(User.class);
		users = new ArrayList<>();
	}

	@Test
	public void getAllUsersTest() throws Exception {
		when(userService.getAllUsers()).thenReturn(users);
		userService.getAllUsers();
		verify(userService).getAllUsers();
	}

	@Test
	public void getUserByIdTest() throws Exception {
		when(userService.getUserById(anyInt())).thenReturn(user);
		userService.getUserById(anyInt());
		verify(userService).getUserById(anyInt());
	}

	@Test
	public void updateUserTest() throws Exception {
		userService.updateUser(user);
		verify(userService).updateUser(user);
	}

	@Test
	public void deleteUserTest() throws Exception {
		userService.deleteUser(anyInt());
		verify(userService).deleteUser(anyInt());
	}

	@Test
	public void createUserTest() throws Exception {
		when(userService.addUser(user)).thenReturn(anyString());
		userService.addUser(user);
		verify(userService).addUser(user);
	}
}
