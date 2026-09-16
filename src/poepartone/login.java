/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poepartone;

/**
 *
 * @author Student
 */
public class login extends Registration{
    

  
    public boolean loginUser(String name, String password) {
        // Because this class extends Registration, it can use the 'userName' 
        // and 'passWord' variables saved during registration.
        if (this.userName != null && this.passWord != null) {
            return name.equals(this.userName) && password.equals(this.passWord);
        }
        return false;
    }

  
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            // Requirement: "Welcome <user first name>, <user last name> it is great to see you again."
            return "Welcome " + this.firstName + ", " + this.lastName + " it is great to see you again.";
        } else {
            // Requirement: "Username or password incorrect, please try again."
            return "Username or password incorrect, please try again.";
        }
    }
}