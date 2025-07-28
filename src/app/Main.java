package app;


import app.Masini.MasinaComand.MasinaComandServiceImpl;
import app.Rents.RentComand.RentComandServviceImpl;
import app.Users.UserComand.UserComandServiceImpl;
import app.View.ViewUserImpl;

public class Main {
    public static void main(String[] args) {

        RentComandServviceImpl rentService = new RentComandServviceImpl();
        UserComandServiceImpl userService = new UserComandServiceImpl();
        MasinaComandServiceImpl masinaService = new MasinaComandServiceImpl();
        ViewUserImpl viewUser = new ViewUserImpl();
        viewUser.play();


        }
    }
