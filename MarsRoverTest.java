//Thoughtworks assignment test
package marsrovertest;

import java.util.Scanner;

/**
 *
 * @author Vini
 */
public class MarsRoverTest {

    public static void main(String[] args) {
        try{
            
        
        String message;
        Plateau plateau=new Plateau();
        Rover rover=new Rover();
        Move move=new Move();
        Scanner scan=new Scanner(System.in);
        do{
            message=scan.nextLine();
            
            if(message.isEmpty())
                System.exit(0);
            
            if(!message.matches("[0-9LRMNESW ]*"))
            {
                System.out.println("The message contains invalid characters!!");
            }
            else if(message.matches("[0-9]+[ ][0-9]+[ ]*"))
            {
                //Set plateau
                plateau.setPlateau(message);
            }
            else if(message.matches("[0-9]+[ ][0-9]+[ ][NESW][ ]*"))
            {
                //Set rover
                if(!plateau.isSet(plateau))
                    System.out.println("Rover cannot be set! Plateau not set!!");
                else
                    rover.setRover(message);
                if(!rover.checkBoundary(plateau))
                {
                    System.out.println("Rover cannot be outside the plateau");
                    rover.direction="";
                }
                
            }
            else if(message.matches("[LRM]+[ ]*"))
            {
                //Set move
                if(plateau.isSet(plateau)&&rover.isSet(rover))
                   move.setMove(message,rover,plateau);
                else
                    System.out.println("Move cannot be performed. Plateau and/or Rover  not initialized");
            }
            else
            {
                System.out.println("The message contains invalid characters!!");
            }
            
        }while(true);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
