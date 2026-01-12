import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList; 
import org.junit.jupiter.api.Test;

/*
 * TESTS PASSWORD AND ADDING USERS MANUALLY*/
class MainUtilsTest {
	
	@Test
	void passwordCheckTest() {
		//VALID PASSWORD CHECK
		assertTrue(MainUtils.passwordCheck("Abc1"));
		
		//PASSWORD WITH NO NUMBERS: INVALID
		assertFalse(MainUtils.passwordCheck("Abcd"));
		
		//MISSING WITH NO UPPERCASE: INVALID
		assertFalse(MainUtils.passwordCheck("absc1"));
		
		//TOO SHORT: INVALID
		assertFalse(MainUtils.passwordCheck("A1"));
		
		//TOO LONG
		assertFalse(MainUtils.passwordCheck("JFJKEKJEWLTRJOTKP12"));
		
	}
	
	@Test
	void manualAddUserList() {
		//ADD A NEW USER MANUALLY
		User user = new User("Maddie", "Pswrd12", true);
		
		//ADD THE USER TO THE LIST
		MainUtils.getUserList().add(user);
		
		//CHECKING THE USER HAS THE CORRECT CREDENTIALS AND IS ADDED
		ArrayList<User> list = MainUtils.getUserList();
		assertEquals(1, list.size()); //CHECK THE LIST HAS 1 USER
		assertEquals("Maddie", list.get(0).get_username()); //CHECK THE ADDED USER USERNAME
		assertTrue(list.get(0).isRunning()); //CHECK THE USER IS ACTIVE/LOGIN
	}

}
