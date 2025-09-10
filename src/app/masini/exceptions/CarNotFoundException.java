package app.masini.exceptions;


import static app.system.constants.ExceptionsMessages.CAR_NOT_FOUND_EXCEPTION;

public class CarNotFoundException  extends Exception{

    public  CarNotFoundException(){
        super(CAR_NOT_FOUND_EXCEPTION);
    }
}
