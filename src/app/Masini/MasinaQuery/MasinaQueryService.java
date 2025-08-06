package app.Masini.MasinaQuery;

import app.Masini.Model.Masina;

import java.util.List;

public interface MasinaQueryService{
    List<Masina> getAllMasini();
    Masina getMasiniByid(int id);
    List<Masina>getAllMasiniByIds(List<Integer> carIds);

}
