package app.Masini;

public class Masina {
   public int id;
   public String marca;
   public String model;
   public String culoare;
   public int pretInitial;
   public int pretInchiriere;
   public int anFabricare;
   public boolean rulata;
   public int kilometrii;


   public String descriere() {
      String text = "";
      text +="Id : " + this.id + "\n";
      text +="Marca : " + this.marca + "\n";
      text +="Model : " + this.model + "\n";
      text +="Culoare : " + this.culoare + "\n";
      text +="Pret initial : " + this.pretInitial + "\n";
      text +="Pret inchiriere : " + this.pretInchiriere + "\n";
      text +="An fabricare : " + this.anFabricare + "\n";
      text +="Rulata/Nu : " + this.rulata + "\n";
      text +="Nr. de kilometrii : " + this.kilometrii + "\n";
   return text;
   }

}


