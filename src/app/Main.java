package app;


import app.Masini.MasinaComand.MasinaComandServiceImpl;
import app.Rents.Model.Rent;
import app.Rents.RentComand.RentComandService;
import app.Rents.RentComand.RentComandServiceSingleton;
import app.Rents.RentComand.RentComandServviceImpl;
import app.Rents.RentQuery.RentQueryService;
import app.Rents.RentQuery.RentQueryServiceImpl;
import app.Rents.RentQuery.RentQueryServiceSingleton;
import app.Rents.Status;
import app.Users.UserComand.UserComandServiceImpl;
import app.View.View;
import app.View.ViewUserImpl;

import java.io.FilterOutputStream;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {


        RentQueryService rentQueryService =RentQueryServiceSingleton.getInstance();
        View view=new ViewUserImpl();
        view.play();
        }
    }
