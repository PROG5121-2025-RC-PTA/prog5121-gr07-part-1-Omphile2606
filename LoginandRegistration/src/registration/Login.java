/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registration;
 
/**
 *
 * @author RC_Student_lab
 */
public class Login {
    private String storedUsername;
    private String storedPassword;
    private String storedCell;

    //setters and getters
    public String getStoredUsername() {
        return storedUsername;
    }

    public void setStoredUsername(String storedUsername) {
        this.storedUsername = storedUsername;
    }

    public String getStoredPassword() {
        return storedPassword;
    }

    public void setStoredPassword(String storedPassword) {
        this.storedPassword = storedPassword;
    }

    public String getStoredCell() {
        return storedCell;
    }

    public void setStoredCell(String storedCell) {
        this.storedCell = storedCell;
    }

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        String regex = "^(?=.[A-Z])(?=.[0-9])(?=.[!@#$%^&()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).{8,}$";
        return password.matches(regex);
    }
    
    public boolean checkCellPhoneNumber(String cell) {
        String regex = "^\\+27\\d{9}$";
        return cell.matches(regex);
    }

    public String registerUser(String username, String password, String cell) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(cell)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        storedUsername = username;
        storedPassword = password;
        storedCell = cell;
        return "User successfully registered.";
    }

    public boolean loginUser(String inputUsername, String inputPassword) {
        return inputUsername.equals(storedUsername) && inputPassword.equals(storedPassword);
    }

    public String returnLoginStatus(String firstName, String lastName, String inputUsername, String inputPassword) {
        if (loginUser(inputUsername, inputPassword)) {
            return "A successful login";
        } else {
            return "A failed login.";
 }

    }

    public String checkUsername(String kyl_1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  

