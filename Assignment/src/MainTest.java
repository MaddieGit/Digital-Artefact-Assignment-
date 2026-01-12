import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {
	
	/*
	 * BASIC NON-FUNCTIONALITY BUT OUTPUT TEST
	 * ONLY TO VERFY THE MAIN METHOD RUNS WITHOUT THROWING EXCEPTIONS
	 * ONLY CONTAINS INTERACTIVE MENUS*/
	
	@Test
	void mainRunTest() {
		//MAKING SURE main() METHOD RUNS
		assertDoesNotThrow(() -> Main.main(new String[] {}));
	}

}
