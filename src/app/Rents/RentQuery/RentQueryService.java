package app.Rents.RentQuery;

import app.Rents.Model.Rent;

import java.util.List;

public interface RentQueryService {
    List<Rent> getAllRents();
    Rent findLastRentByCarId(int id);
    Rent findCarById(int id);
    List<Rent> getAllRentsByCarId(int id);

}
