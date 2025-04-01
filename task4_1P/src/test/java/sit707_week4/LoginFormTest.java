package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

public class LoginFormTest 
{
    @Test
    public void testStudentIdentity() {
        String studentId = "s225094448";
        Assert.assertNotNull("Student ID is null", studentId);
        Assert.assertEquals("s225094448", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Charitha Dimuth Wickramanayake";
        Assert.assertNotNull("Student name is null", studentName);
        Assert.assertEquals("Charitha Dimuth Wickramanayake", studentName);
    }

    @Test
    public void test_TC1_EmptyUsernameEmptyPassword() {
        LoginStatus result = LoginForm.login("", "");
        Assert.assertFalse(result.isLoginSuccess());
        Assert.assertEquals("Empty Username", result.getErrorMsg());
    }

    @Test
    public void test_TC2_EmptyUsernameWrongPassword() {
        LoginStatus result = LoginForm.login("", "wrong");
        Assert.assertFalse(result.isLoginSuccess());
        Assert.assertEquals("Empty Username", result.getErrorMsg());
    }

    @Test
    public void test_TC3_EmptyUsernameCorrectPassword() {
        LoginStatus result = LoginForm.login("", "admin123");
        Assert.assertFalse(result.isLoginSuccess());
        Assert.assertEquals("Empty Username", result.getErrorMsg());
    }

    @Test
    public void test_TC4_WrongUsernameEmptyPassword() {
        LoginStatus result = LoginForm.login("wrong", "");
        Assert.assertFalse(result.isLoginSuccess());
        Assert.assertEquals("Empty Password", result.getErrorMsg());
    }

    @Test
    public void test_TC5_WrongUsernameWrongPassword() {
        LoginStatus result = LoginForm.login("wrong", "wrong");
        Assert.assertFalse(result.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", result.getErrorMsg());
    }

    @Test
    public void test_TC6_WrongUsernameCorrectPassword() {
        LoginStatus result = LoginForm.login("wrong", "admin123");
        Assert.assertFalse(result.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", result.getErrorMsg());
    }

    @Test
    public void test_TC7_CorrectUsernameEmptyPassword() {
        LoginStatus result = LoginForm.login("admin", "");
        Assert.assertFalse(result.isLoginSuccess());
        Assert.assertEquals("Empty Password", result.getErrorMsg());
    }

    @Test
    public void test_TC8_CorrectUsernameWrongPassword() {
        LoginStatus result = LoginForm.login("admin", "wrong");
        Assert.assertFalse(result.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", result.getErrorMsg());
    }

    @Test
    public void test_TC9_CorrectUsernameCorrectPassword() {
        LoginStatus result = LoginForm.login("admin", "admin123");
        Assert.assertTrue(result.isLoginSuccess());
        Assert.assertEquals("123456", result.getErrorMsg());
    }

    @Test
    public void test_TC10_CodeValidationWrong() {
        LoginForm.login("admin", "admin123");
        Assert.assertFalse(LoginForm.validateCode("wrong"));
    }

    @Test
    public void test_TC11_CodeValidationCorrect() {
        LoginStatus result = LoginForm.login("admin", "admin123");
        Assert.assertTrue(LoginForm.validateCode(result.getErrorMsg()));
    }
}