package marsrovertest;

/**
 *
 * @author Vini
 */
public class Move {
    Message message=new Message();
    Rover rover=new Rover();
    Plateau plateau=new Plateau();
    public void setMove(String msg,Rover rover,Plateau plateau)
    {
        Rover previousPosition=new Rover();
        previousPosition.direction=rover.direction;
        previousPosition.xCoordinate=rover.xCoordinate;
        previousPosition.yCoordinate=rover.yCoordinate;
        String[] moveList=message.ParseMoveMessage(msg);
        for(String value:moveList)
        {
            switch(value)
            {
                case "L":rover=moveLeft(rover);
                    break;
                case "M":rover=moveForward(rover);
                    break;
                case "R":rover=moveRight(rover);
                     break;
            }
        }
        
        if(!rover.checkBoundary(plateau))
        {
            System.out.println("Rover has moved outside the bounds of the plateau. Rover reset to the last valid position");
            rover.resetRover(previousPosition);
        }
        else
            rover.displayRover(rover);
    }
    
    public Rover moveLeft(Rover rover)
    {
        switch(rover.direction)
        {
            case "N":rover.direction="W";
                break;
            case "S":rover.direction="E";
                break;
            case "E":rover.direction="N";
                break;
            case "W":rover.direction="S";
                break;    
        }
        return rover;
    }
    public Rover moveRight(Rover rover)
    {
        switch(rover.direction)
        {
            case "N":rover.direction="E";
                break;
            case "S":rover.direction="W";
                break;
            case "E":rover.direction="S";
                break;
            case "W":rover.direction="N";
                break;    
        }
        return rover;       
    }
    public Rover moveForward(Rover rover)
    {
        switch(rover.direction)
        {
            case "N":rover.yCoordinate++;
                break;
            case "S":rover.yCoordinate--;
                break;
            case "E":rover.xCoordinate++;
                break;
            case "W":rover.xCoordinate--;
                break;    
        }
        return rover; 
    }
}
