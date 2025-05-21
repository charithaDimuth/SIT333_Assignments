package web.service;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for RegistrationService.
 */
public class RegistrationServiceUnitTest {

    @Test
    public void testValidInput() {
        assertTrue(RegistrationService.register("Charitha", "Dimuth", "charitha@example.com", "1995-05-21"));
    }

    @Test
    public void testEmptyFirstName() {
        assertTrue(RegistrationService.register("", "Charitha", "charithan@example.com", "1995-05-21"));
    }

    @Test
    public void testEmptyEmail() {
        assertTrue(RegistrationService.register("Charitha", "Dimuth", "", "1995-05-21"));
    }

    @Test
    public void testNullInputs() {
        assertTrue(RegistrationService.register(null, null, null, null));
    }

    @Test
    public void testLongEmail() {
        String longEmail = "averyverylongemailaddress@exampledomainwithlongnametotest.com";
        assertTrue(RegistrationService.register("Test", "User", longEmail, "1980-01-01"));
    }
}