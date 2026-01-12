import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Testing User class
 * Testing the basic functionalities including the following:
 * - getters 
 * - setters
 * - if user is active/loggedinto the system
 * - display the role of the user and 
 * - toString()
 * */

class UserTest {

	User user;

	@BeforeEach
	void setUp() throws Exception {
		//CREATING A USER OBJECT
		user = new User("Maddie", "Passwer123", true);
	}
	
	@Test
	void gettersTest() {
		//TEST THE GETTERS OUTPUT
		assertEquals("Maddie", user.get_username());
		assertEquals("Passwer123", user.get_password());
		assertTrue(user.isRunning());
	}

	@Test
	void settersTest() {
		//TEST THE SETTERS FOR UPDATING THE USER USERNAME AND PASSWORD
		user.set_username("Sheldon");
		user.set_password("Legendary12");
		
		//APPROVING UPDATING VALUES
		assertEquals("Sheldon", user.get_username());
		assertEquals("Legendary12", user.get_password());
		
	}
	
	@Test
	void isRunningTest() {
		//TEST IF THE USER IS ACTIVE/LOGGED IN
		assertTrue(user.isRunning());
		
		//DEACTIVATING THE USER TEST
		user.isNotRunning();
		assertFalse(user.isRunning());
	}
	
	@Test
	void printRoleTest() {
		//TESTING IF THE PRINT ROLE FUNCTION ACTUALLY WORKS 
		user.printRole(); //EXPECTED OUTPUT: Maddie 
	}
	
	@Test
	void toStringTest() {
		//TEST STRING REPRESENTATION
		assertEquals("Maddie(Loggedin)", user.toString());
		
		//AFTER DEACTIVATES VERIFYING STRING REPRESENTATION
		user.isNotRunning();
		assertEquals("Maddie(Not loggedin)", user.toString());
	}

}
