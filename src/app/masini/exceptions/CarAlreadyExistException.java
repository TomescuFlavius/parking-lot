package app.masini.exceptions;

import static app.system.constants.ExceptionsMessages.CAR_ALREADY_EXIST_EXCEPTION;

public class CarAlreadyExistException extends Exception {
    public CarAlreadyExistException() {
        super(CAR_ALREADY_EXIST_EXCEPTION);
    }
}
