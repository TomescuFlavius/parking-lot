package app.masini.service.intefaces;

import app.masini.exceptions.CarNotFoundException;
import app.masini.model.Masina;

import java.util.List;

public interface MasinaQueryService{
    List<Masina> getAllMasini();
    Masina getMasiniByid(int id) throws CarNotFoundException;
    List<Masina>getAllMasiniByIds(List<Integer> carIds);

}
