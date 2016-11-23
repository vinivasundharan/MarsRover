package marsrovertest;

/**
 *
 * @author Vini
 */
public class Plateau {
    int xCoordinate;
    int yCoordinate;
    Message message=new Message();
       
    public void setPlateau(String msg)
    {
        String[] coordinateList= message.parseMessage(msg);
        xCoordinate=Integer.parseInt(coordinateList[0]);
        yCoordinate=Integer.parseInt(coordinateList[1]);
    }
    
    public Boolean isSet(Plateau plateau)
    {
        
        if(plateau.xCoordinate==0||plateau.yCoordinate==0)
            return false;
        return true;
    }
        
    public int getPlateauXCoordinate()
    {
        return xCoordinate;
    }
    public int getPlateauYCoordinate()
    {
        return yCoordinate;
    }
}
