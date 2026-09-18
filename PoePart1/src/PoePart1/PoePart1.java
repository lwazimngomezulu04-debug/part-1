/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poepart1;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class PoePart1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Login register = new Login();
        Scanner scan = new Scanner(System.in);
        
        //Username input and checker
        System.out.println("Please enter the username:");
        String name = scan.nextLine();
        
        if(register.checkUserName(name)){
            System.out.println("Username captured successfully");
        }else{
            System.out.println("Invalid username");
        }
        
        System.out.println("Enter pasword");
        String password = scan.nextLine();
        
        if(register.checkPasswordComplexity(password)){
            
            System.out.println("Password caption successfully");
        }else{
    
           System.out.println("Invalid password");
        
        System.out.println("Enter cellphone:");
        String cellphone = scan.nextLine();
        
        System.out.println(register.regitrationUser(name, password, cellphone));
        
        if(!register.regitrationUser(name, password, cellphone)) {
            return;
        }
        
        System.out.println("\n===== Login =====");
        
        System.out.println("Please enter the username to login:");
        String userName = scan.nextLine();
        
        System.out.println("Please enter the password to login:");
        String loginpassword = scan.nextLine();
        
        System.out.println("Please enter the cellphone to login:");
        String logincellphone = scan.nextLine();
        
        if (name.equals(userName) && password.equals(loginpassword) && cellphone.equals(logincellphone)){
            System.out.println("welcome" + userName);
        }
        }
    }
}    
