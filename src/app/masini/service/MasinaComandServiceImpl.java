package app.masini.service;

import app.Rents.Model.Rent;
import app.masini.exceptions.CarAlreadyExistException;
import app.masini.exceptions.CarNotFoundException;
import app.masini.model.Masina;
import app.masini.service.intefaces.MasinaComandService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MasinaComandServiceImpl implements MasinaComandService {

    private List<Masina> masini;
    private File file;

    public MasinaComandServiceImpl() {
         masini=new ArrayList<>();
         this.file=new File("C:\\mycode\\oop\\incapsulare\\parc-auto\\src\\app\\masini\\data\\Masini");
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

    public String toString(){
        String text="";
        int i;
        for( i=0;i<masini.size()-1;i++){
            Masina masina=masini.get(i);
            text+=masina.toString()+"\n";

        }
        return text+masini.get(i).toString();
    }

    public void saveMasini() {
            try(PrintWriter writer= new PrintWriter(new FileWriter(file))) {
                writer.print(this);
            }catch (IOException e)
            {
                e.printStackTrace();
            }
    }



    @Override
    public Masina add(Masina masina) throws CarAlreadyExistException {
        for (Masina masina1:masini){
            if (masina1.getMarca().equals(masina.getMarca())&&masina1.getModel().equals(masina.getModel())){
                throw new CarAlreadyExistException();
            }
        }
        masina.setId(generateId());
        masini.add(masina);
        saveMasini();
        return masina;
    }


    private Masina getMasinaById(int id) {
        for (Masina masina:masini){
            if(id==masina.getId()){
                return masina;
            }
        }return null;
    }

    private int randomId(){
        //todo:functie ce verifica daca exista deja o masina cu id respectiv
        Random random=new Random();
        int id=random.nextInt(100)+1;

        return id;
    }

    private int generateId(){
      int id=randomId();
      while (getMasinaById(id)!=null){
          id=randomId();
      }
      return id;
    }

    @Override
    public Masina stergereMasina(Masina masina) throws CarNotFoundException {
        if(!masini.contains(masina)){
            throw new CarNotFoundException();
        }
        masini.remove(masina);
        saveMasini();
        return masina;
    }


}

