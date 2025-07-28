package app.Rents.RentComand;
import app.Rents.Model.Rent;
import app.Rents.Status;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentComandServviceImpl implements RentComandService {
    private List<Rent> rents;
    private File file;

    public RentComandServviceImpl() {
        rents = new ArrayList<>();
        file = new File("C:\\mycode\\oop\\incapsulare\\parc-auto\\src\\Rents");
        this.loadRents();
    }

    public void loadRents(){
    try{
        Scanner scanner=new Scanner(file);
        while(scanner.hasNext()){
            String line=scanner.nextLine();
            Rent rent=new Rent(line);
            rents.add(rent);
        }
    }catch (Exception e){
        e.printStackTrace();
    }
    }

    public void afisareInchirieri(){
        for(int i=0;i<rents.size();i++){
            System.out.println(rents.get(i).descriere());
        }
    }

    public String toSaveRents(){
        String text="";
        int i;
        for( i=0;i<rents.size();i++){
            Rent rent=rents.get(i);
            text+=rent.descriere()+"\n";

        }
        return text+rents.get(i).descriere();
    }

    public void saveRents(){
        try {
            FileWriter writer = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.print(toSaveRents());
            printWriter.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    //getAllRentsByUserId

    public List<Integer> getAllRentsByUserId(int userId){
        List<Integer> carsIds=new ArrayList<>();
        for(int i=0;i<rents.size();i++){
             if(userId==rents.get(i).getIdUser()){
                 carsIds.add(rents.get(i).getIdMasina());
             }
        }
        return carsIds;

    }
    public List<Integer> masiniLibere() {
        List<Integer> carIds=new ArrayList<>();
        for (int i = 0; i < rents.size(); i++) {
            if (verificareStatusMasina(rents.get(i).getIdMasina())){
                carIds.add(rents.get(i).getId());
            }
        }
        return carIds;
    }

    //todo:CheckCarStatusbyCarId


    public Boolean verificareStatusMasina(int idMasina){
        for(int i=0;i<rents.size();i++){
            if(rents.get(i).getIdMasina()==idMasina){
                if(rents.get(i).getStatus()== Status.PROCESSING){
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
                if (rent1.getIdMasina() == rent2.getIdMasina()) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                ceaMaiInchiriata = rent1.getIdMasina();
            }
        }

        return ceaMaiInchiriata;
    }

    public void inchiriereMasini(int idMasina, int userId) {
        Rent r6=new Rent();

        r6.setId(1);
        r6.setIdMasina(idMasina);
        r6.setIdUser(userId);
        r6.setStatus(Status.COMPLETED);

        this.rents.add(r6);
    }

    public boolean returnareMasini(int idUser,int idMasina) {
        for(int i=0;i<rents.size();i++){
            if(rents.get(i).getIdMasina()==idMasina&&rents.get(i).getIdUser()==idUser){
                rents.get(i).setStatus(Status.COMPLETED);
                return true;
            }
        }
        return false;
    }

    @Override
    public Rent add(Rent rent) {
        rents.add(rent);
        saveRents();
        return rent;
    }
}
