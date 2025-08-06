package app.Rents.RentComand;
import app.Masini.Model.Masina;
import app.Rents.Model.Rent;
import app.Rents.RentQuery.RentQueryService;
import app.Rents.Status;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RentComandServviceImpl implements RentComandService {
    private List<Rent> rents;
    private File file;

    public RentComandServviceImpl() {
        rents = new ArrayList<>();
        file = new File("C:\\mycode\\oop\\incapsulare\\parc-auto\\src\\app\\Rents\\File\\Rents");
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
            System.out.println(rents.get(i).toString());
        }
    }

    public String toSaveRents(){
        String text="";
        int i;
        for( i=0;i<rents.size()-1;i++){
            Rent rent=rents.get(i);
            text+=rent.toString()+"\n";

        }
        return text+rents.get(i).toString();
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



    public int randomId(){
        int id= new Random().nextInt(10000);
        for(Rent rent:rents){
            if (rent.getId()==id){
                rent.setId(new Random().nextInt(10000));
            }
        }
        return id;

    }



    @Override
    public Rent add(Rent rent) {
        rent.setId(randomId());
        rents.add(rent);
        saveRents();
        return rent;
    }

    @Override
    public Rent retur(Rent rent) {
        rent.setReturnare(LocalDate.now());
        rent.setStatus(Status.COMPLETED);
        saveRents();
        return rent;
    }


}
