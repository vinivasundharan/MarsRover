# MarsRover
Introduction
------------

<p>Controlling the rover on the Mars Plateua based on the inputs</p>

# Executing the project##
<P>

 1. Import the project into a Java IDE (Instructions for Netbeans 8.1) from Zip.
 2. Select the zip file from the location.
 3. Add library : hamcrest-library-1.3.jar (for Testing) (Right click on folder libraries in the project explorer; add library : Hamcrest 1.3 or download the jar and add the jar file)
 4. Right click on the project name MarsRoverTest in the project explorer and Select clean and build.
 5. Right click on the project name again and Run.
</p>
 
## Working with the project ##
  On the output window, enter the string to be executed. 
  
<p>The project reads the following input strings.</p>

> "5 5" : Plateau upper boundary
> "3 4 N" : Rover initial Position
> "LMLMLMMLM" : Commands

 Expand the folder TestPackages>>defaultpackages. Right click on the file TestCases.java and Run File. The tests are executed and the output corresponding to few tests are printed on the output console (Netbeans IDE 8.1)

## Modules Explained##

 1.  **Class :  Rover** 
   *xCoordinate* - The x co-ordinate the of the rover position 
   *yCoordinate* - The y co-ordinate the of the rover
   *direction* - The direction to which the rover is facing

  1.1 *checkBoundary* - To check if the rover is within the plateau. Checks during initialization and also after the move is performed.
  1.2 *displayRover* - To display the current position of the rover
  1.3 *getRover* - To retrieve the values of the rover object
  1.4 *getXCoordinate* -  Returns the X-Coordinate value
  1.5 *getYCoordinate* - Returns the Y Coordinate value
  1.6 *isSet* - Returns true if the object is not null
  1.7 *resetRover* - Resets the rover value to its previous valid position      
  1.8 *setRover* - Sets the value of the rover based on the message input
       
 2.  **Class : Plateau** 
   *xCoordinate* - x Co-ordinate of the top right corner of the plateau  
   *yCoordinate* -  y Co-ordinate of the top right corner of the plateau
   
    2.1 *getPlateauXCoordinate* -  returns the x Co-ordinate of the top right corner of the plateau
    2.2 *getPlateauYCoordinate* -  returns the y Co-ordinate of the top right corner of the plateau
    2.3 *isSet* - Returns true if the Plateau object is not null

 3. **Class :  Message**
    3.1 *parseMessage* - Returns a string array after splitting the input message based on a single space. The format of the message for
   setting the Rover and plateau is assumed to be separated by spaces.
    3.2 *ParseMoveMessage* - Returns a string array after splitting the input string into single character string. The format of the command
   for movement is assumed to be separated with no spaces.
   
 4. **Class :  Move**
     4.1 *moveForward*: Moves the rover one point forward. The movement of the rover is based on the current direction it is pointing towards. For instance if the current direction of the rover is North, the yCoordinate is incremented to move one step forward. Similarly all the cases are evaluated in a switch statement. The value of the rover is returned after the move operation.
     4.2 *moveRight*, *moveLeft* : Turns the rover right or left respectively. For instance if the rover is facing north, one move right is turning the rover to face East. 
     4.3 *setMove* : This function decodes the command from the user and performs the move and turn operations on the rover. It also saves the current position of the rover before executing the user command so as    to reset the rover when it has moved out of the boundary.
   
 5. **MarsRoverTest Main** 
 It reads the user inputs inside a do while. Inorder to exit the execution, the user has to input double enter. The validity of the message is checked using regular expressions. 
   
   > **[0-9LRMNESW ]*** : Check if the message contains only valid characters (numbers, space, L,R,M,N,E,S,W)
   > 
   > **[0-9]+[ ][0-9]+[ ]*** : Check if the message corresponds to plateau coordinates. The plateau initializing message is supposed to contain two numbers separated  by spaces. At the end of the string any number of spaces are ignored, so as to bypass any additional spaces added by the user by mistake.
   > 
   > **[0-9]+[ ][0-9]+[ ][NESW][ ]*** : Check if the message corresponds to rover position. The rover position is of the format two numbers followed by  a character representing the direction the rover is pointing to. At the end of the message any additional spaces are ignored and considered a valid input message. 
   > 
   > **[LRM]+[ ]*** : A valid command message should not contain only characters representing left turn, right turn or move forward and so only characters L,R and M separated by no spaces. Any spaces at the end of the message string are ignored.
   
 6. **TestCases**
   
    6.1 *testMoveForward* : Checks if the rover moves forward according to the rover direction
    6.2 *testMoveLeft*, *testMoveRight* :  Checks if the rover turns left and right respectively based on the conditions.
    6.3 *testPlateauInitialization* : Tests if the setPlateau decodes the string message correctly and sets the plateau object with the right values
    6.4 *testRoverInitialization* : Tests if the setRover decodes the message correctly and sets the rover position and direction correctly. 
    6.5 *testRoverWithinBound* : Tests if the function to check if the rover is within the plateau returns the right value.
    6.6 *testInputPattern1*, *testInputPattern2* : Tests the input given in the screening test against the given output. 
    6.7 *testInputPattern3* : Tests if the rover is set back to the previous position when it goes beyond the plateau after a command is
   executed.

## Testing the Project ##
The project has been developed in a test driven development approach and to the best of my knowledge all the modules were tested during the course of development. The test file has different tests that tests various functionalities including the testing of the input given for the screening test.

*Limitation : the main file component could not be tested to validate the input message. This was performed manually on the console.*

The project has been tested to various test inputs and the following outputs were produced. 

**Test 1**

     5 5
     3 4 N
     LMLM
     2 3 S

**Test 2**

    3 4 N
    Rover cannot be set! Plateau not set!!
    

**Test 3**

    LMLMLMLM
    Move cannot be performed. Plateau and/or Rover  not initialized

**Test 4**

    WESWW
    The message contains invalid characters!!
    56N
    The message contains invalid characters!!
    ABCD
    The message contains invalid characters!!
    56
    The message contains invalid characters!!

**Test 5**

    5 5
    3 4 N
    MMMMMMM
    Rover has moved outside the bounds of the plateau. Rover reset to the last valid position
   
Future works
------------

  - Modularize the project better. 
  - Handle the input string without spaces when the co-ordinates are single digit numbers. 
  - Add functions to validate the different input strings.
  - Resetting the rover to the last moved valid position rather than to the position it started. 
  - Using character to read Direction to improve efficiency.
   
----------

 **<h4>Author**
   
       Vini Vasundharan
       E-mail : vinivasundharan2011@gmail.com
       Tel. No: 017641773083
