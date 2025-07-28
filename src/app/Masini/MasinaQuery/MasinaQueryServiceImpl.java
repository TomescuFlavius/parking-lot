package app.Masini.MasinaQuery;


import app.Masini.Model.Masina;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MasinaQueryServiceImpl implements MasinaQueryService {

    private File file;
    private List<Masina> masini;

    public MasinaQueryServiceImpl(){
        this.file=new File("C:\\mycode\\oop\\incapsulare\\parc-auto\\src\\app\\Masini\\File\\Masini");
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
}
