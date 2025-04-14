/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registration;
import java.util.Scanner;
/**
 *
 * @author RC_Student_lab
 */
public class Registration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
Scanner scanner = new Scanner (System.in);
       Login login = new Login();

        System.out.println("=== Register New Account ===");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter cell phone number (e.g., +27831234567): ");
        String cell = scanner.nextLine();

        String registrationMessage = login.registerUser(username, password, cell);
        System.out.println(registrationMessage);

        if (!registrationMessage.equals("User successfully registered.")) {
            System.out.println("Registration failed. Exiting.");
            return;
        }

        System.out.println("\n=== Login ===");

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter username: ");
        String loginUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = scanner.nextLine();

        String loginStatus = login.returnLoginStatus(firstName, lastName, loginUsername, loginPassword);
        System.out.println(loginStatus);

    }
    
}
