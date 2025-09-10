package app.masini.service;




import app.masini.exceptions.CarNotFoundException;
import app.masini.model.Masina;
import app.masini.service.intefaces.MasinaQueryService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MasinaQueryServiceImpl implements MasinaQueryService {

    private File file;
    private List<Masina> masini;

    public MasinaQueryServiceImpl(){
        this.file=new File("C:\\mycode\\oop\\incapsulare\\parc-auto\\src\\app\\masini\\data\\Masini");
        this.masini=new ArrayList<>();
        this.loadMasini();
    }

    public void loadMasini(){
        try {
            Scanner scanner=new Scanner(file);
            while (scanner.hasNextLine()){
                String line=scanner.nextLine();
                Masina masina=new Masina(line);
                masini.add(masina);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        String text = "";
        int i;
        for (i = 0; i < this.masini.size() - 1; i++) {
            text += masini.get(i).toString() + "\n";
        }
        text += masini.get(i).toString();
        return  text;
    }


    @Override
    public List<Masina> getAllMasini() {
        return this.masini;
    }


    @Override
    public Masina getMasiniByid(int id) throws CarNotFoundException {
            for(int i=0;i<masini.size();i++){
                if(id==masini.get(i).getId()) {
                    return masini.get(i);
                }
            }
        throw  new CarNotFoundException();
    }




    @Override
    public List<Masina> getAllMasiniByIds(List<Integer> carIds) {
        List<Masina> masiniCautate= new ArrayList<>();
        for (int i=0;i<carIds.size();i++){
            Masina masina= new Masina(carIds.get(i));
            int index=masini.indexOf(masina);
            if(index>=0){
                masiniCautate.add(masini.get(index));
            }
        }
        return masiniCautate;
    }


}
