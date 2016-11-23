package marsrovertest;

/**
 *
 * @author Vini
 */
public class Rover {
    int xCoordinate,yCoordinate;
    String direction;
    Message message=new Message();
        
    public void setRover(String msg)
    {
        String[] roverParameters=message.parseMessage(msg);
        xCoordinate=Integer.parseInt(roverParameters[0]);
        yCoordinate=Integer.parseInt(roverParameters[1]);
        direction= roverParameters[2];
    }
    
    public Boolean isSet(Rover rover)
    {
        
        if(!rover.direction.isEmpty())
            return true;
        return false;
    }
    public Boolean checkBoundary(Plateau plateau)
    {
        if(xCoordinate>plateau.xCoordinate||yCoordinate>plateau.yCoordinate||yCoordinate<0||xCoordinate<0)
            return false;
        return true;
    }
    
    public Rover getRover()
    {
        Rover rover=new Rover();
        rover.direction=this.direction;
        rover.xCoordinate=this.xCoordinate;
        rover.yCoordinate=this.yCoordinate;
        return rover;
    }
    
    public int getRoverXCoordinate()
    {
        return xCoordinate;
    }
    public int getRoverYCoordinate()
    {
        return yCoordinate;
    }
    public String getRoverDirection()
    {
        return direction;
    }
    public void resetRover(Rover rover)
    {
        xCoordinate=rover.xCoordinate;
        yCoordinate=rover.yCoordinate;
        direction=rover.direction;
    }
    
    public void displayRover(Rover rover)
    {
        System.out.println(rover.xCoordinate+" "+rover.yCoordinate+" "+rover.direction);
    }

}
