
//CHILD CLASS OF A USER FOR A USER WITH ADMIN ROLE
public class AdminUser extends User {

	//ADMIN USER INFO COLLECTOR AND STORING 
	public AdminUser(String username, String password, boolean isRunning) {
		super(username, password, isRunning);
	}
	
	//DISPLAY ADMIN USER ROLE 
	@Override 
	public void printRole() {
		System.out.println(get_username() + "is an admin user.");
	}
}
