import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import registration.Login;

public class LoginTest {

    private Login login;

    @BeforeEach
    public void setUp() {
        login = new Login();
    }

    // --- Username tests ---

    @Test
    public void testUsernameCorrectlyFormatted_ReturnsTrue() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testUsernameIncorrectlyFormatted_ReturnsFalse() {
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }

    @Test
    public void testUsernameIncorrectlyFormatted_Message() {
        String message = login.registerUser("kyle!!!!!!", "Ch&&sec@ke99!", "+27831234567");
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.", message);
    }

    // --- Password tests ---

    @Test
    public void testPasswordMeetsComplexity_ReturnsTrue() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexity_ReturnsFalse() {
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testPasswordIncorrectlyFormatted_Message() {
        String message = login.registerUser("kyl_1", "password", "+27831234567");
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", message);
    }

    // --- Cell phone number tests ---

    @Test
    public void testValidCellPhoneNumber_ReturnsTrue() {
        assertTrue(login.checkCellPhoneNumber("+27831234567"));
    }

    @Test
    public void testInvalidCellPhoneNumber_ReturnsFalse() {
        assertFalse(login.checkCellPhoneNumber("0831234567"));
    }

    @Test
    public void testInvalidCellPhoneNumber_Message() {
        String message = login.registerUser("kyl_1", "Ch&&sec@ke99!", "0831234567");
        assertEquals("Cell phone number incorrectly formatted or does not contain international code.", message);
    }

    // --- Full registration and login flow ---

    @Test
    public void testUserSuccessfullyRegistered() {
        String message = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27831234567");
        assertEquals("User successfully registered.", message);
    }

    @Test
    public void testLoginSuccessful_ReturnsTrue() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27831234567");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailed_ReturnsFalse() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27831234567");
        assertFalse(login.loginUser("kyl_1", "wrongpass"));
    }

    @Test
    public void testReturnLoginStatus_Success() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27831234567");
        String status = login.returnLoginStatus("John", "Doe", "kyl_1", "Ch&&sec@ke99!");
        assertEquals("Welcome John, Doe it is great to see you again.", status);
    }

    @Test
    public void testReturnLoginStatus_Failure() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27831234567");
        String status = login.returnLoginStatus("John", "Doe", "kyl_1", "wrongpass");
        assertEquals("Username or password incorrect, please try again.", status);
    }
}