package app.View;

import app.masini.exceptions.CarAlreadyExistException;
import app.masini.exceptions.CarNotFoundException;
import app.masini.service.MasinaQueryServiceImpl;
import app.masini.service.intefaces.MasinaComandService;
import app.masini.service.MasinaComandServiceSingleton;
import app.masini.service.intefaces.MasinaQueryService;
import app.masini.service.MasinaQueryServiceSingleton;
import app.masini.model.Masina;
import app.Rents.Model.Rent;
import app.Rents.RentComand.RentComandService;
import app.Rents.RentComand.RentComandServiceSingleton;
import app.Rents.RentQuery.RentQueryService;
import app.Rents.RentQuery.RentQueryServiceSingleton;
import app.Rents.Status;
import app.Users.Model.User;
import app.Users.UserComand.UserComandService;
import app.Users.UserComand.UserComandServiceSingleton;
import app.Users.UserQuery.UserQueryService;
import app.Users.UserQuery.UserQueryServiceSingleton;
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
        System.out.println("2->Adauga masina noua");
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
                case 2:
                    this.adaugareMasina();
                    break;
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
        try{
        Masina masina = masinaQueryService.getMasiniByid(id);
        masinaCommandService.stergereMasina(masina);
        }catch (CarNotFoundException e){
            System.out.println(e.getMessage());
        }

    }


    public void inchiriereMasina() {
        System.out.println("Introduceti id ul masinii pe care vreti sa o inchiriati:");
        int id = Integer.parseInt(scanner.nextLine());
        Rent lastRent = rentQueryService.findLastRentByCarId(id);
        Rent rent = new Rent(this.user.getId(), id);

        if(lastRent==null){
            rentComandService.add(rent);
            rent.setStatus(Status.PROCESSING);
            System.out.println("Masina inchiriata de user-ul:" + user.getId());
        }
        else
        if (lastRent.getStatus() == Status.COMPLETED && lastRent!=null) {
            rent = this.rentComandService.add(rent);
            System.out.println("Inchirirea sa realizat cu id " + rent.getId());

        }

        else if(lastRent.getStatus()==Status.PROCESSING)
        {
            System.out.println("Nu poate fi inchiriata");
        }

    }

    public void returnareMasina() {
        System.out.println("Introduceti id ul masinii pe care vreti sa o returnati:");
        int id = Integer.parseInt(scanner.nextLine());
        Rent rent = rentQueryService.findLastRentByCarId(id);
        rentComandService.retur(rent.getId());
        System.out.println("Masina returnata de userul: " + user.getId());
    }

    public void adaugareMasina() {
        Masina masina=new Masina();
        System.out.println("Introduceti marca");
        String marca= scanner.nextLine();

        System.out.println("Introduceti modelul");
        String model =scanner.nextLine();

        System.out.println("Introduceti culoarea");
        String culoare=scanner.nextLine();

        System.out.println("Introduceti pret initial");
        int pretInitial=Integer.parseInt(scanner.nextLine());

        System.out.println("Introduceti pret inchiriere");
        int pretInchiriere=Integer.parseInt(scanner.nextLine());

        System.out.println("Introduceti an fabricare");
        int anFabricare=Integer.parseInt(scanner.nextLine());

        System.out.println("Introduceti rulata(true/false)");
        boolean isRulata=Boolean.parseBoolean(scanner.nextLine());

        System.out.println("Introduceti nr kilometrii");
        int km=Integer.parseInt(scanner.nextLine());

        Masina.builder()
                .marca(marca)
                .model(model)
                .culoare(culoare)
                .pretInitial(pretInitial)
                .pretInchiriere(pretInchiriere)
                .anFabricare(anFabricare)
                .rulata(isRulata)
                .kilometrii(km).build();

        try{
            masinaCommandService.add(masina);
        } catch (CarAlreadyExistException e) {

            System.out.println(e.getMessage());
        }

    }
}