package web.service;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for LoginService class.
 */
public class LoginServiceUnitTest {

	@Test
	public void testValidLogin() {
		assertTrue(LoginService.login("admin", "1234", "2000-01-01"));
	}

	@Test
	public void testInvalidUsername() {
		assertFalse(LoginService.login("wronguser", "1234", "2000-01-01"));
	}

	@Test
	public void testInvalidPassword() {
		assertFalse(LoginService.login("admin", "wrongpass", "2000-01-01"));
	}

	@Test
	public void testInvalidDOB() {
		assertFalse(LoginService.login("admin", "1234", "1990-01-01"));
	}

	@Test
	public void testEmptyFields() {
		assertFalse(LoginService.login("", "", ""));
	}

	@Test
	public void testNullFields() {
		assertFalse(LoginService.login(null, null, null));
	}
}