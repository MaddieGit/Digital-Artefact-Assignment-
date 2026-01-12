// ***---- USER MANAGEMENT SYSTEM ----***
/*
 * ->This is a user login and management system 
 * ->Can be used by admin and regular users
 * ->User records are recorded in a text file 
 * */

import java.io.IOException;
import java.util.Scanner;


//****** MAIN PROGRAM *******
public class Main {
	
    //MAIN MENU 
    public static void menu() throws IOException {
        boolean running = true;

        
        Scanner scanner = new Scanner(System.in);
        
        //DISPLAYING THE MENU OPTIONS UNTIL THE USER EXITS THE SYSTEM
        while (running) {
            System.out.println("""
                    
                    --- Main Menu ---
                    1) Add New User
                    2) View Users
                    3) Search  User
                    4) Login Simulation
                    5) Deactivate User
                    6) Exit
                    """);

            System.out.print("Choose an option: ");
            int choice;
    

            //USER INPUT VALIDATION USING TRY CATCH ERROR 
             try {
                 choice = Integer.parseInt(scanner.nextLine());
             } catch (NumberFormatException e) {
            	 //IF THE ENTERS OTHER THAN THE CHOICES OR
            	 //IF IT IS NOT A DIGIT THEY WILL BE PROMPTED TO REENTER
                System.out.println("Invalid number please reenter: ");
                continue;
             }


             //METHODS TO BE CALLED BASED ON THE USER INPUT 
            switch (choice) {
                case 1 -> MainUtils.addUser();
                case 2 -> MainUtils.viewUsers();
                case 3 -> MainUtils.searchUser();
                case 4 -> MainUtils.simulateLogin();
                case 5 -> MainUtils.deactivateUser();
                case 6 -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Try again.");
                
            }
            
        }
        scanner.close();
    }

    
    //****** MAIN PROGRAM STARTER *******
    public static void main(String[] args) throws IOException {
    	MainUtils.loadUsers(); //LOADING EXISTING SAVED USERS FROM UseRecords.txt
        MainUtils.greeting(); //WELCOMING THE USER 
        menu(); //DISPLAYING MENU LOOP
    }
}



