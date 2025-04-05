package app.View;

import app.Masini.Masina;
import app.Masini.MasinaService;
import app.Rents.Rent;
import app.Rents.RentService;
import app.Rents.Status;
import app.Users.User;
import app.Users.UserService;

import java.security.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewUser {
    public MasinaService masinaService=new MasinaService();
    public RentService rentService=new RentService();
    public User user= new User();
    public Scanner scanner=new Scanner(System.in);

    public void meniu(){
        System.out.println("1->istoric Client");
        System.out.println("2->Masini libere");
        System.out.println("3->returnare Masina");
        System.out.println("4->cea mai inchiriata masina");
        System.out.println("5->sterge masina");
        System.out.println("6->Inchiriere masina");
        System.out.println("7->Returnare masina");

    }


    public void play(){
        boolean running=true;
         user.id=1;
         this.masinaService.loadMasini();
         this.rentService.loadRents();
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
                     this.meniu();
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

    //todo:
    //afisare istoric client

    public void istoricClient() {
        System.out.println("Id ul pentru verificare istoric:");
        int id = Integer.parseInt(scanner.nextLine());
        user.id=id;
        List<Integer> carsIds = this.rentService.getAllRentsByUserId(user.id);
        List<Masina> cars = this.masinaService.getMasini(carsIds);
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).descriere());
        }
        //todo:afisare masinile
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
        this.rentService.inchiriereMasini(id, user.id);
        System.out.println("Masina inchiriata pentru userul: " + user.id);
    }
    public void returnareMasina() {
        System.out.println("Introduceti id ul masinii pe care vreti sa o returnati:");
        int id = Integer.parseInt(scanner.nextLine());
        this.rentService.returnareMasini(user.id, id);
        System.out.println("Masina returnata de userul: " + user.id);
    }
    }

