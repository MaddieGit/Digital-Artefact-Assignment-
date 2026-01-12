import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class MainUtils {

	//USER COLLECTOR 
	private static ArrayList<String> accessLog = new ArrayList<>();
	private static ArrayList<User> userList = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);
	
	
	//WELCOMING THE USER 
	public static void greeting() {
		System.out.println("\n*** Welcome to the User System ***");
	}
	
	//PASSWORD CHECK
	public static boolean passwordCheck(String password) {
		//PASSWORD MUST BE BETWEEN 4 AND 12
		//PASSWORD MUST ALSO CONTAIN DIGITS 
		if(password.length() < 4 || password.length() > 12) {
			System.out.println("Invalid password (minimum 4 and maximum 12 characters)!");
			return false;
		}
		
		//DOES PASSWORD INCLUDE NUMBERS 
		//LOOP THROUGH THE PASSWORD CHARACTERS AND CHECK
		boolean numbers = false;
		boolean upperCase = false;
		
		for(int i = 0; i < password.length(); i++) {
			char c = password.charAt(i); //TO GET THE CHAR AT INDEX I
			
			if(Character.isDigit(c)) {
				numbers = true; //THE NUMBER IS FOUND
			}
			if(Character.isUpperCase(c)) {
				upperCase = true;
			}
			
		}
		if(!numbers) {
			System.out.println("Password doesn not contain numbers!");
			return false;
		}
		if(!upperCase) {
			System.out.println("Password doesn not contain upper-case letters!");
			return false;
		}
		
		return true;
	}
	
	//ADDING THE USER 
	static void addUser() throws IOException {
		
		String name;
		boolean nameCheck;
		
		//COLLECTING USER CREDENTIALS
		do {
			System.out.print("Enter username: ");
			name = scanner.nextLine().toLowerCase();
			
			nameCheck = true;
			
			for (int i = 0; i < userList.size(); i++) {
	            User user = userList.get(i);
	            if(user.get_username().equalsIgnoreCase(name)) {
	            	System.out.println("A user with the same name already exists!");
	            	
	            	nameCheck = false;
	            	break;
	            }
			}
		}while(!nameCheck); //Reprompt for name until its a new username 
		
		String password;
		
		do {
			System.out.println("Enter password: ");
			password = scanner.nextLine();
		
		}while(!passwordCheck(password));
		 
		
        
        System.out.print("Is this user an admin? (yes/no): ");
        String type = scanner.nextLine().toLowerCase();
        
        //USER ROLE VALIDATION 
        if (type.equals("yes")|| type.equals("y")) {
            userList.add(new AdminUser(name, password, true));
            System.out.println("Admin user added: " + name);
        } else {
            userList.add(new User(name, password, true));
            System.out.println("Regular user added: " + name);
        }
        
      //STORING USER FULE
      UsersRecord();
        
	}
	
	//VIEWING THE USER LIST 
	public static void viewUsers() {
        System.out.println("\n*** USER LIST ***");
        
        if (userList.isEmpty()) {
            System.out.println("No users yet.");
        } else {
            for (int user = 0; user < userList.size(); user++) { 
                //System.out.println(user);
                System.out.println(userList.get(user));
            }
        }
    }
	
	//USER SEARCH/NAVIGATION
	public static void searchUser() {
		System.out.println("Enter username to search: ");
		
		String name = scanner.nextLine();
		
		boolean userFound = false;
		
		for (int i = 0; i < userList.size(); i++) {
			User user = userList.get(i);
			
			if(user.get_username().equalsIgnoreCase(name)) {
				System.out.println("Found: "+user);
				userFound = true;
				break;
			}
		}
		
		if(!userFound) {
			System.out.println("User not found!");
		}
	}
	
	//USER SIMULATOR - LOGGING 
	public static void simulateLogin() {
		
		System.out.print("Enter username to log in: ");
        String name = scanner.nextLine().toLowerCase();

        System.out.print("Enter password: ");   // 
        String password = scanner.nextLine().toLowerCase();   // password exists

        boolean found = false;
        
        //CHECKING IF THE USER EXISTS
        for (int i = 0; i < userList.size(); i++) {
            User users = userList.get(i);

            if (users.get_username().equalsIgnoreCase(name) && users.get_password().equalsIgnoreCase(password)) {
                found = true;
                if (users.isRunning()) {
                    System.out.println("Login successful! Welcome " + name);
                    users.printRole();
                } else {
                    System.out.println("User is deactivated. Cannot log in.");
                    accessLog.add("Failed: "+ name);
                }
                break;
            }
        }
        if (!found) {
            System.out.println("User not found.");
        }
		
	}
	
	//DEACTIVATING A USER FROM THE PROGRAM
	public static void deactivateUser() throws IOException {
        System.out.print("Enter Admin username: ");
        String admin = scanner.nextLine();

        System.out.println("Enter Admin password: ");
        String password = scanner.nextLine();

        AdminUser adminUser = null;
        
        //IF THE USER EXISTS CHECK AND REMOVE IF THEIR PASSWORD MATCHES 
        for (User user : userList) {
            if(user instanceof AdminUser && user.get_username().equalsIgnoreCase(admin) 
            && user.get_password().equalsIgnoreCase(password)) {
                adminUser = (AdminUser) user;
                break;
            }
            
        }
        
        if(adminUser == null) {
        	System.out.println("Only admin can remove a user!");
        	return;
        }
        
        System.out.print("Enter username to be removed: ");
        String target = scanner.nextLine().toLowerCase();
        
        if (target.equalsIgnoreCase(adminUser.get_username())) {
        	System.out.println("Admin cannot deactivate themselves!");
        	return;
        }
        
        for(User targetUser : userList) {
        	if (targetUser.get_username().equalsIgnoreCase(target)) {
        		targetUser.isNotRunning();
        		System.out.println("User "+ target+" has been Deactivated!");
        	    
        		UsersRecord();
        		
        		return;
        	}
        }
        System.out.println("User not found.");
    }
	
	
	//STORE USER DATA AND SAVE THEM TO A FILE 
	//throwing ioexception was suggested by the eclipse auto correct
	public static void UsersRecord() throws IOException {
		try(PrintWriter writer = new PrintWriter(new FileWriter("UserRecord.txt"))){
			for(int i = 0; i < userList.size(); i++) {
				User user = userList.get(i);
				
				boolean userRole = user instanceof AdminUser;
				
				writer.println(
						user.get_username() + ","+
						user.get_password() + ","+
						userRole + ","+
						user.isRunning()
						);
			}	
		}
		catch(FileNotFoundException e) {
				System.out.println("File not found: " + e.getMessage());
			}
			catch (ArrayIndexOutOfBoundsException e){
				System.out.println("Invalid input!");
			}
	}
	
	//LOADING USERS FROM THE USER RECORD FILE
	public static void loadUsers() {
		File file = new File("UserRecord.txt");
		
		if(!file.exists()) return;
		
		try(Scanner fileScanner = new Scanner(file)){
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				
				String[] section = line.split(",");
				
				String username = section[0];
				String password = section[1];
				boolean userRole = Boolean.parseBoolean(section[2]);
				boolean isRunning = Boolean.parseBoolean(section[3]);
				
				
				if(userRole) {
					userList.add(new AdminUser(username, password, isRunning));
				}
				else {
					userList.add(new User(username, password, isRunning));
				}
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("The users record file was not found!");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid value found in the uers file!");
		}
		catch(IllegalArgumentException e) {
			System.out.println("Invalid value found in the record!");
		}

	}
	
	//FOR MainUtilsTest TO ACCESS THE USER LIST FROM THIS CLASS
	public static ArrayList<User> getUserList() {
	    return userList;
	}
	
}
