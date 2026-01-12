//****** MAIN CLASS STORING USER CREDENTIALS *******

/*
 * A USER CLASS TO REPRESENT A USER
 * STORES THE FOLLOWING USER CREDENTIALS:
 * - username
 * - password
 * - user login status 
 * */
public class User implements UserActions{

	//VARIABLES FOR STORING USER INFO
	String username;
	String password;
	boolean isTrue;
	
	
	//A CONSTRUCTOR FOR A NEW USER OBJECT AND STORING USER INFO
	public User(String username, String password, boolean isTrue){
		this.username = username;
		this.password = password;
		this.isTrue = isTrue; //true= logged in active, false= logged out not active
		
	}
	
	//GETTERS AND SETTERS FOR USER CREDENTIALS 
	public String get_username() {
		return username; 
	}
	
	public void set_username(String username) {
		this.username = username;
	}
	
	public String get_password() {
		return password;
	}
	
	public void set_password(String password) {
		this.password = password;
	}
	
	@Override 
	public boolean isRunning() {
		return isTrue;
	}
	
	@Override
	public void isNotRunning() {
		this.isTrue = false;
	}

	@Override
	public void printRole() {
		System.out.println(username + "is a regular user.");
	}
	
	@Override
	public String toString() {
		return username + (isTrue ? "(Loggedin)" : "(Not loggedin)");
	}
}
