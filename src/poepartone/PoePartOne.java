/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poepartone;

import java.util.Scanner;

/**
 *
 * @author Student
 */

public class PoePartOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Registration regSystem = new Registration();

        System.out.println("=== REGISTRATION ===");
        
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Cell Phone Number (+27...): ");
        String cellNumber = scanner.nextLine();

        // Try to register the user and capture the result message
        String regMessage = regSystem.registerUser(username, password, cellNumber, firstName, lastName);
        System.out.println(regMessage);

        // Only ask them to login if registration was successful
        if (regMessage.equals("User successfully registered.")) {
            System.out.println("\n=== LOGIN ===");
            
            System.out.print("Enter Username: ");
            String loginUser = scanner.nextLine();
            
            System.out.print("Enter Password: ");
            String loginPass = scanner.nextLine();

            // Check login and print status
            boolean isSuccess = regSystem.loginUser(loginUser, loginPass);
            System.out.println(regSystem.returnLoginStatus(isSuccess));
        }

        scanner.close();
    }
}