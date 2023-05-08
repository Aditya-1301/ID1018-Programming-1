package EU3;

public class NotValidFieldException extends Exception{
    public NotValidFieldException(){
        super("Invalid Field Exception");
    }
    public NotValidFieldException(String message){
        super(message);
    }
}
