package app.View;

import app.Masini.MasinaComand.MasinaComandService;
import app.Masini.MasinaComand.MasinaComandServiceImpl;
import app.Masini.MasinaComand.MasinaComandServiceSingleton;
import app.Masini.MasinaQuery.MasinaQueryService;
import app.Masini.MasinaQuery.MasinaQueryServiceImpl;
import app.Masini.MasinaQuery.MasinaQueryServiceSingleton;
import app.Masini.Model.Masina;
import app.Rents.Model.Rent;
import app.Rents.RentComand.RentComandService;
import app.Rents.RentComand.RentComandServiceSingleton;
import app.Rents.RentComand.RentComandServviceImpl;
import app.Rents.RentQuery.RentQueryService;
import app.Rents.RentQuery.RentQueryServiceImpl;
import app.Rents.RentQuery.RentQueryServiceSingleton;
import app.Rents.Status;
import app.Users.Model.User;
import app.Users.UserComand.UserComandService;
import app.Users.UserComand.UserComandServiceSingleton;
import app.Users.UserQuery.UserQueryService;
import app.Users.UserQuery.UserQueryServiceSingleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewUserImpl implements View {
    private MasinaComandService masinaCommandService;
    private RentComandService rentComandService;
    private User user;
    private Scanner scanner;
    private MasinaQueryService masinaQueryService;
    private RentQueryService rentQueryService;

    private UserComandService userComandService;
    private UserQueryService userQueryService;


    public ViewUserImpl() {
        this.user = new User();
        this.scanner = new Scanner(System.in);

        this.rentQueryService= RentQueryServiceSingleton.getInstance();
        this.rentComandService= RentComandServiceSingleton.getInstance();
        this.masinaCommandService = MasinaComandServiceSingleton.getInstance();
        this.userComandService = UserComandServiceSingleton.getInstance();
        this.userQueryService = UserQueryServiceSingleton.getInstance();
        this.masinaQueryService = MasinaQueryServiceSingleton.getInstance();

        this.play();
    }

    public void meniu() {
        System.out.println("2->istoric Client");
        System.out.println("3->Masini libere");
        System.out.println("4->sterge masina");
        System.out.println("5->Inchiriere masina");
        System.out.println("6->Returnare masina");

    }

    @Override
    public void play() {

        boolean running = true;

        while (running) {
            meniu();
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 3:
                    this.masiniLibere();
                    break;
                case 4:
                    this.stergeMasina();
                    break;
                case 5:
                    this.inchiriereMasina();
                    break;
                case 6:
                    this.returnareMasina();
                    break;
            }
        }

    }


    //@Override
//    public void play(){
//        boolean running=true;
//
//         while(running) {
//             meniu();
//             int alegere = Integer.parseInt(scanner.nextLine());
//             switch (alegere) {
//                 case 2:
//                     this.istoricClient();
//                     break;
//                 case 3:
//                     this.masiniLibere();
//                     break;
//                 case 4:
//                     this.stergeMasina();
//                     break;
//                 case 5:
//                     this.inchiriereMasina();
//                     break;
//                 case 6:
//                     this.returnareMasina();
//                     break;
//                 default:
//                     System.out.println("invalid choice");
//             }
//
//         }
//     }
//
//    //todo: afisare istoric client
//
//    public void istoricClient() {
//        System.out.println("Id ul pentru verificare istoric:");
//        int id = Integer.parseInt(scanner.nextLine());
//        user.setId(id);
//        List<Integer> carsIds = this.rentService.getAllRentsByUserId(user.getId());
//        List<Masina> cars = this.masinaService.getMasini(carsIds);
//        for (int i = 0; i < cars.size(); i++) {
//            System.out.println(cars.get(i).descriere());
//        }
//    }
//
//    //todo: inchiriere masina retunare masina
//
//    public void disponibilitateMasina() {
//        System.out.println("Introduceti id ul masini pentru inchiriere:");
//        int id = Integer.parseInt(scanner.nextLine());
//        this.rentService.verificareStatusMasina(id);
//    }
    public void masiniLibere() {
        System.out.println("Masinile disponibile:");

        List<Masina> masini=this.masinaQueryService.getAllMasini();

        for (Masina m: masini){

             Rent rent=this.rentQueryService.findLastRentByCarId(m.getId());
             if(rent!=null&&rent.getStatus().equals(Status.COMPLETED)){

                 System.out.println(m);
             }else if(rent==null){
                 System.out.println(m);
             }
        }
    }


    public void stergeMasina() {
        System.out.println("Introduceti id ul masinii pe care vreti sa o stergeti");
        int id = Integer.parseInt(scanner.nextLine());
        Masina masina = masinaQueryService.getMasiniByid(id);
        masinaCommandService.stergereMasina(masina);
    }


    public void inchiriereMasina() {
        System.out.println("Introduceti id ul masinii pe care vreti sa o inchiriati:");
        int id = Integer.parseInt(scanner.nextLine());
        Rent lastRent = rentQueryService.findLastRentByCarId(id);
        Rent rent = new Rent(this.user.getId(), id);

        if(lastRent==null){
            rentComandService.add(rent);
            rent.setStatus(Status.PROCESSING);

        }
        else
        if (lastRent.getStatus() == Status.COMPLETED&& lastRent!=null) {
            rent = this.rentComandService.add(rent);
            System.out.println("Inchirirea sa realizat cu id " + rent.getId());
        }
        else if(lastRent.getStatus()==Status.PROCESSING)
        {
            System.out.println("Nu poate fi inchiriata");
        }
        System.out.println("Masina inchiriata pentru userul: " + user.getId());

    }


    public void returnareMasina() {
        System.out.println("Introduceti id ul masinii pe care vreti sa o returnati:");
        int id = Integer.parseInt(scanner.nextLine());
        Rent rent = rentQueryService.findLastRentByCarId(id);
        rentComandService.retur(rent);
        System.out.println("Masina returnata de userul: " + user.getId());
    }
}