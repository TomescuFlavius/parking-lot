package app.Rents.RentQuery;

import app.Rents.Model.Rent;
import app.Users.Model.User;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentQueryServiceImpl implements RentQueryService {

    private File file;
    private List<Rent> rents;

    public RentQueryServiceImpl(){
        this.file=new File("C:\\mycode\\oop\\incapsulare\\parc-auto\\src\\app\\Rents\\File\\Rents");
        this.rents=new ArrayList<>();
        this.loadRents();
    }

    public void loadRents(){
        try {
            Scanner scanner=new Scanner(file);
            while (scanner.hasNextLine()){
                String line=scanner.nextLine();
                Rent rent=new Rent(line);
                rents.add(rent);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        String text = "";
        int i;
        for (i = 0; i < this.rents.size() - 1; i++) {
            text += rents.get(i).toString() + "\n";
        }
        text += rents.get(i).toString();
        return  text;
    }



    @Override
    public List<Rent> getAllRents() {
        return this.rents;
    }
}
