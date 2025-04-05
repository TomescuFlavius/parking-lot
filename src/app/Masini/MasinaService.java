package app.Masini;

import java.util.ArrayList;
import java.util.List;

public class MasinaService {
    List<Masina> masini= new ArrayList<>();
    public void loadMasini() {


        for(int i=1;i<=10;i++){
            Masina m = new Masina();
                m.id=i;
                m.marca="Marca"+i;
                m.model="Model"+i;
                m.culoare=(i%2==0)?"Rosu":"Albastru";
                m.pretInitial=10000+i*500;
                m.pretInchiriere=100+i*10;
                m.anFabricare=2000+(i%24);
                m.rulata=(i%2==0);
                m.kilometrii=10000+i*1500;
                masini.add(m);
        }

    }


    //todo: functie ce primeste ca paremtru o lista de ids si returneaza o lista cu ctoate masinile ce
    //au id in lista

    public List<Masina> getMasini (List<Integer> idsCars) {


        List<Masina> masiniFiltrate = new ArrayList<>();
        for(int i=0;i<masini.size();i++){
            if(idsCars.contains(masini.get(i).id)){
                masiniFiltrate.add(masini.get(i));
            }
        }
        return masiniFiltrate;
    }

    public void afisareMasini(){
        for(Masina m : masini){
            System.out.println(m.descriere());
        }
    }
    public void steregereMasina(int id){
        for (int i=0;i<masini.size();i++) {
            if(id==masini.get(i).id) {
                masini.remove(i);
            }
        }
    }
    public void getMasiniById(int id){
        for(int i=0;i<masini.size();i++){
            if(id==masini.get(i).id) {
                System.out.println(masini.get(i).descriere());
            }
        }
    }


}

