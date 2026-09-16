/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poepartone;

/**
 *
 * @author Student
 */
import org.junit.Test;
import static org.junit.Assert.*;
public class RegistrationTest {


    Registration reg = new Registration();
    login log = new login();

 
    @Test
    public void testUsernameCorrectlyFormatted() {
        assertTrue("Username 'kyl_1' should be valid", reg.checkUserName("kyl_1"));
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        assertFalse("Username 'kyle!!!!!!!' should be invalid", reg.checkUserName("kyle!!!!!!!"));
    }

    // --- TESTING checkPasswordComplexity ---
    @Test
    public void testPasswordMeetsComplexity() {
        assertTrue("Password 'Ch&&sec@ke99!' should be valid", reg.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        assertFalse("Password 'password' should be invalid", reg.checkPasswordComplexity("password"));
    }

    // --- TESTING checkCellPhoneNumber ---
    @Test
    public void testCellPhoneCorrectlyFormatted() {
        assertTrue("Cell '+27838968976' should be valid", reg.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        assertFalse("Cell '08966553' should be invalid", reg.checkCellPhoneNumber("08966553"));
    }

    // --- TESTING registerUser ---
    @Test
    public void testRegisterUserSuccess() {
        String response = reg.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertEquals("User successfully registered.", response);
    }

    @Test
    public void testRegisterUserBadUsername() {
        String response = reg.registerUser("kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertEquals("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.", response);
    }

    // --- TESTING loginUser and returnLoginStatus ---
    @Test
    public void testLoginSuccessful() {
        // 1. Register the user first so the system knows their details
        reg.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        // 2. Test the login method
        assertTrue("Login should succeed with correct details", log.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailed() {
        // 1. Register the user first
        reg.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        // 2. Test with the wrong password
        assertFalse("Login should fail with wrong password", log.loginUser("kyl_1", "WrongPass123!"));
    }

    @Test
    public void testReturnLoginStatusSuccess() {
        reg.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        // Test the success message string
        assertEquals("Welcome Kyle, Smith it is great to see you again.", log.returnLoginStatus(true));
    }

    @Test
    public void testReturnLoginStatusFailed() {
        // Test the failure message string
        assertEquals("Username or password incorrect, please try again.", log.returnLoginStatus(false));
    }
}