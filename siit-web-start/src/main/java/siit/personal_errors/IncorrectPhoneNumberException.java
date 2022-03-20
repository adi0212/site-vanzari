package siit.personal_errors;

public class IncorrectPhoneNumberException extends Exception{
    public IncorrectPhoneNumberException (String errorText){
        super(errorText);
    }
}
