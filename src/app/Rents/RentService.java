package app.Rents;

import app.Masini.Masina;
import app.Users.User;
import com.sun.source.tree.ReturnTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RentService {
    List<Rent> rents=new ArrayList<>();

    public void loadRents(){

        Rent r1=new Rent();
        r1.id=1;
        r1.idMasina=10;
        r1.idUser=2;
        r1.status=Status.COMPLETED;


        Rent r2=new Rent();
        r2.id=2;
        r2.idMasina=1;
        r2.idUser=2;
        r2.status=Status.PROCESSING;

        Rent r3=new Rent();
        r3.id=3;
        r3.idMasina=3;
        r3.idUser=2;
        r3.status=Status.COMPLETED;

        Rent r4=new Rent();
        r4.id=4;
        r4.idMasina=1;
        r4.idUser=2;
        r4.status=Status.PROCESSING;

        Rent r5=new Rent();
        r5.id=5;
        r5.idMasina=5;
        r5.idUser=1;
        r5.status=Status.COMPLETED;

        Rent r6=new Rent();
        r6.id=6;
        r6.idMasina=8;
        r6.idUser=3;
        r6.status=Status.PROCESSING;

        Rent r7=new Rent();
        r7.id=7;
        r7.idMasina=9;
        r7.idUser=2;
        r7.status=Status.COMPLETED;

        Rent r8=new Rent();
        r8.id=1;
        r8.idMasina=2;
        r8.idUser=3;
        r8.status=Status.PROCESSING;



        this.rents.add(r1);
        this.rents.add(r2);
        this.rents.add(r3);
        this.rents.add(r4);
        this.rents.add(r5);
        this.rents.add(r6);
        this.rents.add(r7);
        this.rents.add(r8);



    }



    //getAllRentsByUserId

    public List<Integer> getAllRentsByUserId(int userId){
        List<Integer> carsIds=new ArrayList<>();
        for(int i=0;i<rents.size();i++){
             if(userId==rents.get(i).idUser){
                 carsIds.add(rents.get(i).idMasina);
             }
        }
        return carsIds;

    }
    public List<Integer> masiniLibere() {
        List<Integer> carIds=new ArrayList<>();
        for (int i = 0; i < rents.size(); i++) {
            if (verificareStatusMasina(rents.get(i).idMasina)){
                carIds.add(rents.get(i).id);
            }
        }
        return carIds;
    }

    //todo:CheckCarStatusbyCarId


    public Boolean verificareStatusMasina(int idMasina){
        for(int i=0;i<rents.size();i++){
            if(rents.get(i).idMasina==idMasina){
                if(rents.get(i).status==Status.PROCESSING){
                    return false;
                }
            }
        }
        return true;
    }

    public int ceaMaiInchiriataMasina() {
        int maxCount = 0;
        int ceaMaiInchiriata = -1;

        for (Rent rent1 : rents) {
            int count = 0;
            for (Rent rent2 : rents) {
                if (rent1.idMasina == rent2.idMasina) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                ceaMaiInchiriata = rent1.idMasina;
            }
        }

        return ceaMaiInchiriata;
    }

    public void inchiriereMasini(int idMasina, int userId) {
        Rent r6=new Rent();

        r6.id=1;
        r6.idMasina=idMasina;
        r6.idUser=userId;

        this.rents.add(r6);
    }

    public boolean returnareMasini(int idUser,int idMasina) {
        for(int i=0;i<rents.size();i++){
            if(rents.get(i).idMasina==idMasina&&rents.get(i).idUser==idUser){
                rents.get(i).status=Status.COMPLETED;
                return true;
            }
        }
        return false;
    }
    //todo:functie generare id
}
