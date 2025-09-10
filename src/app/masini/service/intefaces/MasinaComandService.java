package app.masini.service.intefaces;

import app.masini.exceptions.CarAlreadyExistException;
import app.masini.exceptions.CarNotFoundException;
import app.masini.model.Masina;

public interface MasinaComandService{
        Masina add(Masina masina) throws CarAlreadyExistException;
        Masina stergereMasina(Masina masina) throws CarNotFoundException;

}
