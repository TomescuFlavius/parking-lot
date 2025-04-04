package app;
import java.util.Scanner;

import app.Masini.Masina;
import app.Users.User;
import app.Rents.Rent;
import app.Masini.MasinaService;
import app.Rents.RentService;
import app.Users.UserService;
import app.View.ViewUser;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        MasinaService masinaService = new MasinaService();
        UserService userService = new UserService();
        RentService rentService = new RentService();
        Masina masina = new Masina();
        User user = new User();
        Rent rent = new Rent();
        ViewUser viewUser = new ViewUser();

        viewUser.play();




        }
    }
