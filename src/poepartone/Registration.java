/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poepartone;

/**
 *
 * @author Student
 */
public class Registration {// start of class
    

    // These are the variables that will hold the user's data
    public String userName;
    public String passWord;
    public String cellPhone;
    public String firstName;
    public String lastName;

    /**
     * Checks if username contains an underscore and is no more than 5 characters long.
     */
    public boolean checkUserName(String username) {
        // Requirement: Contains "_" AND length <= 5
        return username.contains("_") && username.length() <= 5;
    }

    /**
     * Checks password complexity.
     * Requirements: At least 8 chars, 1 capital, 1 number, 1 special character.
     */
    public boolean checkPasswordComplexity(String password) {
        // We use a single return statement combining all requirements
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&  // Contains capital letter
               password.matches(".*[0-9].*") &&  // Contains number
               password.matches(".*[^a-zA-Z0-9].*"); // Contains special character
    }

    /**
     * Checks if the cell phone number starts with +27 and has 9 digits after it.
     */
    public boolean checkCellPhoneNumber(String cellphone) {
        // Regex: Starts with +27, followed by exactly 9 digits.
        String regex = "^\\+27[0-9]{9}$";
        return cellphone.matches(regex);
    }

    /**
     * Registers the user based on the checks and returns the appropriate message.
     */
    public String registerUser(String username, String password, String cellphone, String fName, String lName) {
        // 1. Check Username
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        
        // 2. Check Password
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        
        // 3. Check Cell Phone
        if (!checkCellPhoneNumber(cellphone)) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }

        // 4. If all checks pass, save the data to the class variables and return success
        this.userName = username;
        this.passWord = password;
        this.cellPhone = cellphone;
        this.firstName = fName;
        this.lastName = lName;
        
        return "User successfully registered.";
    }

    /**
     * Verifies login details.
     */
    public boolean loginUser(String name, String password) {
        // Ensures someone has actually registered first, then checks if the details match
        if (this.userName != null && this.passWord != null) {
            return name.equals(this.userName) && password.equals(this.passWord);
        }
        return false;
    }

    /**
     * Returns the final login status message.
     */
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