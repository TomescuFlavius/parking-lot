package app;


import app.View.View;
import app.View.ViewUserImpl;
import app.masini.model.Masina;

public class Main {
    public static void main(String[] args) {


        View view=new ViewUserImpl();
        view.play();



//        RentQueryService rentQueryService =RentQueryServiceSingleton.getInstance();
//        RentComandService rentComandService =RentComandServiceSingleton.getInstance();
//        int id = 2;
//        Rent rent = rentQueryService.findLastRentByCarId(id);
//        rentComandService.retur(rent.getId());
//        System.out.println("Masina returnata de userul: ");

        }
    }
