package web.service;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for LoginService class.
 */
public class LoginServiceUnitTest {
	
	@Test
	public void testPing() {
	    System.out.println("JUnit is working!");
	}

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
	
	@Test
	public void testPartialMatchUsernameCorrectOnly() {
	    assertFalse(LoginService.login("admin", "wrong", "wrong"));
	}

	@Test
	public void testPartialMatchPasswordCorrectOnly() {
	    assertFalse(LoginService.login("wrong", "1234", "wrong"));
	}

	@Test
	public void testPartialMatchDOBCorrectOnly() {
	    assertFalse(LoginService.login("wrong", "wrong", "2000-01-01"));
	}
}