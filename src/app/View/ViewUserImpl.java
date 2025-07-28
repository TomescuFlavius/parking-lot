package app.View;

import app.Masini.Model.Masina;
import app.Masini.MasinaComand.MasinaComandServiceImpl;
import app.Rents.RentComand.RentComandServviceImpl;
import app.Users.Model.User;
import app.Users.UserComand.UserComandService;
import app.Users.UserComand.UserComandServiceSingleton;
import app.Users.UserQuery.UserQueryService;
import app.Users.UserQuery.UserQueryServiceSingleton;

import java.util.List;
import java.util.Scanner;

public class ViewUserImpl implements View{
    private MasinaComandServiceImpl masinaService;
    private RentComandServviceImpl rentService;
    private User user;
    private Scanner scanner;

    private UserComandService userComandService;
    private UserQueryService userQueryService;


    public ViewUserImpl(){
        this.user=new User();
        this.scanner=new Scanner(System.in);
        this.rentService=new RentComandServviceImpl();
        this.masinaService=new MasinaComandServiceImpl();

       this.userComandService= UserComandServiceSingleton.getInstance();
       this.userQueryService= UserQueryServiceSingleton.getInstance();

        this.play();
    }
    public void meniu(){
        System.out.println("1->istoric Client");
        System.out.println("2->Masini libere");
        System.out.println("3->returnare Masina");
        System.out.println("4->cea mai inchiriata masina");
        System.out.println("5->sterge masina");
        System.out.println("6->Inchiriere masina");
        System.out.println("7->Returnare masina");

    }

@Override
    public void play(){
        boolean running=true;

         while(running) {
             meniu();
             int alegere = Integer.parseInt(scanner.nextLine());
             switch (alegere) {
                 case 1:
                     this.istoricClient();
                     break;
                 case 2:
                     this.masiniLibere();
                     break;
                 case 3:
                     this.returnareMasina();
                     break;
                 case 4:
                     this.ceaMaiInchiriataMasina();
                     break;
                 case 5:
                     this.stergeMasina();
                     break;
                 case 6:
                     this.inchiriereMasina();
                     break;
                 case 7:
                     this.returnareMasina();
                     break;
                 default:
                     System.out.println("invalid choice");
             }

         }
     }

    //todo: afisare istoric client

    public void istoricClient() {
        System.out.println("Id ul pentru verificare istoric:");
        int id = Integer.parseInt(scanner.nextLine());
        user.setId(id);
        List<Integer> carsIds = this.rentService.getAllRentsByUserId(user.getId());
        List<Masina> cars = this.masinaService.getMasini(carsIds);
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).descriere());
        }
    }

    //todo: inchiriere masina retunare masina

    public void disponibilitateMasina() {
        System.out.println("Introduceti id ul masini pentru inchiriere:");
        int id = Integer.parseInt(scanner.nextLine());
        this.rentService.verificareStatusMasina(id);
    }
    public void masiniLibere() {
        System.out.println("Masinile disponibile:");
    List<Masina> masinas = this.masinaService.getMasini(this.rentService.masiniLibere());
      for (Masina masina : masinas) {
          System.out.println(masina.descriere());
      }
    }



    //todo:statistica cea mai inchiriata masina

    public void ceaMaiInchiriataMasina(){

        System.out.println("Cea mai inchiriata masina:");
        this.masinaService.getMasiniById(rentService.ceaMaiInchiriataMasina());
    }
    //todo: stergere masina
    public void stergeMasina(){
        System.out.println("Introduceti id ul masinii pe care vreti sa o stergeti");
        int id = Integer.parseInt(scanner.nextLine());
        masinaService.steregereMasina(id);
        masinaService.afisareMasini();
    }
    public void inchiriereMasina(){
        System.out.println("Introduceti id ul masinii pe care vreti sa o inchiriati:");
        int id = Integer.parseInt(scanner.nextLine());
        this.rentService.inchiriereMasini(id, user.getId());
        System.out.println("Masina inchiriata pentru userul: " + user.getId());
    }
    public void returnareMasina() {
        System.out.println("Introduceti id ul masinii pe care vreti sa o returnati:");
        int id = Integer.parseInt(scanner.nextLine());
        this.rentService.returnareMasini(user.getId(), id);
        System.out.println("Masina returnata de userul: " + user.getId());
    }
    }

