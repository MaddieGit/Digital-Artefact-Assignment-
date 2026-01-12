import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Testing Adminuser class
 * Testing the basic functionalities including the following:
 * - getters 
 * - setters
 * - if user is active/loggedinto the system
 * - display the role of the admin user and 
 * - toString()
 * */

class AdminUserTest {
	
	AdminUser admin;

	@BeforeEach
	void setUp() throws Exception {
		//CREATING AN ADMIN USER OBJECT
		admin = new AdminUser("admin", "User123", true);
	}
	
	@Test
	void gettersTest() {
		//TEST THE GETTERS RETURN
		assertEquals("admin", admin.get_username());
		assertEquals("User123", admin.get_password());
		assertTrue(admin.isRunning());
	}

	@Test
	void settersTest() {
		//TEST THE SETTERS FOR UPDATING THE USER USERNAME AND PASSWORD
		admin.set_username("Sheldon");
		admin.set_password("Legendary12");
		
		//VERIFYING THE VALUES 
		assertEquals("Sheldon", admin.get_username());
		assertEquals("Legendary12", admin.get_password());
		
	}
	
	@Test
	void isRunningOrNotTest() {
		//TEST IF THE USER IS ACTIVE/LOGGED IN
		assertTrue(admin.isRunning());
		
		//DEACTIVATING THE USER TEST
		admin.isNotRunning();
		assertFalse(admin.isRunning());
	}
	
	@Test
	void printRoleTest() {
		//TESTING IF THE PRINT ROLE FUNCTION ACTUALLY WORKS 
		admin.printRole(); //EXPECTED OUTPUT: admin 
	}
	
	@Test
	void toStringTest() {
		//TEST STRING REPRESENTATION FOR ACTIVE ADMIN
		assertEquals("admin(Loggedin)", admin.toString());
		
		//TEST STRING REPRESENTATION FOR NOT ACTIVE ADMIN
		admin.isNotRunning();
		assertEquals("admin(Not loggedin)", admin.toString());
	}
	
}
