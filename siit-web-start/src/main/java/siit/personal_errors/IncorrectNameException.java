package siit.personal_errors;

public class IncorrectNameException extends Exception{
    public IncorrectNameException(String errorMessage){
        super(errorMessage);
    }
}
