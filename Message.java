package marsrovertest;

/**
 *
 * @author Vini
 */
public class Message {
    
    
   public String[] parseMessage(String message)
   {
       String[] parsedMessage=message.split(" ");
       return parsedMessage;
   }
   
   public String[] ParseMoveMessage(String message)
   {
       String[] parsedMessage=message.split("");
       return parsedMessage;
   }
}
