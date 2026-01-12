## PSEUDOCODE

#** Please note that even though the program is based on this pseudocode the program has been modified since so this only shows mostly the foundation of the program and how it was designed!
BEGIN
    CREATE a method - greeting
    OUTPUT "*** Welcome to the user access and security audit control system ***"

    IMPORT Scanner class
    IMPORT ArrayList class

    CREATE a user class
        INITIALISE three private variables 
        String name
        boolean isTrue
        String password

        CREATE a user method 
            PARAMETERS String username, String password and boolean isTrue

            ASSiGN The parameters
                this.username = username
                this.password = password
                this.isTrue = isTrue

        CREATE getters and setters (encapsulation)
            getters
                -> get_username()
                -> get_password()
                -> isRunning()
            setters
                -> set_username()
                -> set_password()
                -> isNotRunning() //When deacticated 
        OVERRIDING
            CREATE a method - printRole
            to display if the user is running (active)

        WHILE LOOP
        INITIALISE a boolean to make sure the loop stops
            CREATE a menu method
                DISPLAY menu
                    1. ADD user -> a method
                    2. LOGIN as a user -> a method 
                    3. VIEW the user list who is active -> a method
                    4. DEACTIVATE user (REMOVE) -> a method
                    5. EXIT -> a method
	CREATE a class
	
	    CREATE a method AdminUser
	        PARAMETERS String username, String password, boolean isRunning
	        SUPER -> username, password, isRunning
	
	    OVERRIDING - to override printRole (polymorphism)
	    to display if the user is admin user
	
	CREATE a class MAIN
	    CREATE private classes and array lists
	        ArrayList String accessLod
	        ArratList User   userList
	        Scanner scanner 

    The greeting method will be here 

    Using SWITCH and CASE based on the user's choice 
    METHODS CREATE to be called by the menu (the while loop options)
        Get userChoice and based on their choice call one of the methods


        CREATE addUser() method
            INPUT username 
            ASSIGNED username to name 
            using the toLowerCase method make it lowercase to make sure it wont affect comparisons

            INPUT password
            ASSIGNED password and use the toLowerCase method

            INPUT if user admin(yes/no)
            ASSIGN type use the toLowerCase method
        
        CREATE viewUsers() method
            OUTPUT "*** USER LIST ***"

            CONDITIONAL STATEMENTS (if/else)
            IF userList empty (using the isEmpty method)
                OUTPUT "No user found"
            ELSE 
                FOR LOOP 
                    Int user = 0; user < userlist.size(); user++
                    OUTPUT userList getting each "user" from the array list

        CREATE simulateLogin() method
        INPUT username
        ASSIGNED username and use the toLowerCase method

        INPUT password
        ASSIGNED password and use the toLowerCase method

        boolean found = false //credential existance checking
        
        CHECK IF the password exists 

        FOR LOOP
        	Int i = 0 while i is less than the userList array's size increase i 
        		for each user in the userList 
        		
        		check IF the name, password is found in the userList 
        			IF found = true
        			isRunning for user = true 
        				OUPUT "User login successful!"
        		ELSE 
        			OUTPUT "user cannot login!"
        		
        		ENDIF
        	ENDFOR
        	IF found == false
        		OUTPUT "User not found!"
			ENDIF
			
			
		CREATE deactivateUser() method 
			INPUT admin name
			INPUT admin password
			
			FOR each user in userList array check 
				IF a user matches the username and password 
				IF user also an admin user 
					the user is approved
				ENDIF
				
				ENDFOR
        	IF user entered does not match an admin user
        		OUTPUT "Only admin can remove a user!" 
        		return
        		ENDIF
        	
        	IF user was found as an admin
        		INPUT username to be deactivated:
        		ASSIGN it to a variable called target
        		
        		IF target is found an admin user 
        			OUTPUT "Admin cannot be deactivated!"
        			ENDIF
        		
        		IF user is a regular user
        		FOR user in userList 
        			IF user that matches target is loggedin, deactivate them
        			OUTPUT "User has been deactivated!"
        			
        			UPDATE UserRecord file
        			
        			return
        			ENDIF
        		ENDFOR
        		
        		IF anything else 
        			OUTPUT "User not found!"
        		ENDIF
	
	//STORE USER DATA AND SAVE THEM TO A FILE 
		CREATE A METHO UsersRecord() TO SAVE THE txt FILE TO STORE THE USER CREDENTiAL
		TRY:
			OPEN a file called "UserRecord.txt"
			
			FOR each user in userList 
				SET an index at a user 
				
				CHECK if user is an admin 
				
				WRITE to the file
					user credentials 
			ENDFOR
			
			CATCH 
				FileNotFoundException
					OUTPUT file not found error message
				ArrayIndexOutOfBoundsException
					OUTPUT invalid input error message 
			END
			
			CREATE A METHOD loadUsers()
				 CREATE a file named UserRecord.txt
				 IF file does not exist 
				 	method stop
				 	
				 TRY:
				 	opening the file to read
				 	WHILE the file has another line
				 		READ it
				 		SPLIT each line using command into four credentials 
				 		username Str
				 		password Str
				 		userRole bool
				 		and isRunning bool
				 		
				 	IF userRole is true
				 		CREATE ann AdminUser using the data 
				 		ADD the user to the list
				 	ELSE
				 		CREATE a user using the data 
				 		ADD it to the userList
				 	ENDIF
				 ENDWHILE

			CATCH 
				FileNotFoundException
					OUTPUT file not found error message
				ArrayIndexOutOfBoundsException
					OUTPUT invalid input error message
				IlligalArgumentException
					OUTPUT invalid record data error message 
					END

DISPLAY Main menu display options:

    IF userChoice == 1:
        Call addUser()
    ELSE IF userChoice == 2:
        Call simulateLogin()
    ELSE IF userChoice == 3:
        Call viewSecurityAudit()
    ELSE IF userChoice == 4:
        Call deactivateUser()
    ELSE IF userChoice == 5:
        BREAK
    ELSE:
        Print "Invalid choice, please try again"

END WHILE

Print "Goodbye!"
Program End



