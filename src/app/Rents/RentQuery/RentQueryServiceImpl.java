package app.Rents.RentQuery;

import app.Rents.Model.Rent;


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

    @Override
    public Rent findLastRentByCarId(int id) {
        List<Rent>rents=this.getAllRentsByCarId(id);

        return rents.size()>0?rents.getLast():null;
    }

    @Override
    public Rent findCarById(int id) {
        for (Rent rent:rents){
            if (rent.getId()==id){
                return rent;
            }
        }
        return null;
    }

    @Override
    public List<Rent> getAllRentsByCarId(int carId) {
        List<Rent> filteredRents=new ArrayList<>();

        for(Rent r:rents){
            if(r.getIdMasina()==carId){
                filteredRents.add(r);
            }
        }

        for(int i=0;i<filteredRents.size();i++){
            for (int j=i+1;j<filteredRents.size()-1;j++){
                if (filteredRents.get(i).getInchiriere().compareTo(filteredRents.get(j).getInchiriere())<0){
                    Rent temp=filteredRents.get(i);
                    filteredRents.set(i,filteredRents.get(j));
                    filteredRents.set(j,temp);
                }
            }
        }
        return filteredRents;
    }


}
