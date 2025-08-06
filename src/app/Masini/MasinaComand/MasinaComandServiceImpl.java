package app.Masini.MasinaComand;

import app.Masini.Model.Masina;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MasinaComandServiceImpl implements MasinaComandService{

    private List<Masina> masini;
    private File file;

    public MasinaComandServiceImpl() {
         masini=new ArrayList<>();
         this.file=new File("C:\\mycode\\oop\\incapsulare\\parc-auto\\src\\app\\Masini\\File\\Masini");
         this.loadMasini();

    }

    public void loadMasini() {

        try {
            Scanner sc=new Scanner(file);
            while(sc.hasNextLine()) {
                String line=sc.nextLine();
                Masina masina=new Masina(line);
                masini.add(masina);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }


    }


    //todo: functie ce primeste ca paremtru o lista de ids si returneaza o lista cu ctoate masinile ce
    //au id in lista

    public List <Masina>  getMasini (List<Integer> idsCars) {


        List<Masina> masiniFiltrate = new ArrayList<>();
        for(int i=0;i<masini.size();i++){
            if(idsCars.contains(masini.get(i).getId())){
                masiniFiltrate.add(masini.get(i));
            }
        }
        return masiniFiltrate;
    }

    public void afisareMasini(){
        for(int i=0;i<masini.size();i++){
            System.out.println(this.masini.get(i).toString());
        }
    }

    public String toSaveMasini(){
        String result="";
        int i=0;
        for(Masina masina:masini){
            result+=masini.get(i).toString()+"\n";
        }
        return result+masini.get(i).toString();
    }

    public void saveMasini() {
        try {
            FileWriter writer = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.print(toSaveMasini());
            printWriter.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }



    @Override
    public Masina add(Masina masina) {
        masini.add(masina);
        saveMasini();
        return masina;
    }

    @Override
    public Masina stergereMasina(Masina masina) {
        masini.remove(masina);
        saveMasini();
        return masina;
    }


}

