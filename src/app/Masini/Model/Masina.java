package app.Masini.Model;

public class Masina implements Comparable<Masina>{
   private int id;
   private String marca;
   private String model;
   private String culoare;
   private int pretInitial;
   private int pretInchiriere;
   private int anFabricare;
   private boolean rulata;
   private int kilometrii;

   public Masina(){
       this.id=0;
       this.marca="";
       this.model="";
       this.culoare="";
       this.pretInitial=0;
       this.pretInchiriere=0;
       this.anFabricare=0;
       this.rulata=false;
       this.kilometrii=0;
   }

   public Masina(int id, String marca, String model, String culoare, int pretInitial, int pretInchiriere, int anFabricare, boolean rulata, int kilometrii) {
      this.id = id;
      this.marca = marca;
      this.model = model;
      this.culoare = culoare;
      this.pretInitial = pretInitial;
      this.pretInchiriere = pretInchiriere;
      this.anFabricare = anFabricare;
      this.rulata = rulata;
      this.kilometrii = kilometrii;
   }

   public Masina(String text){
      text.split(",");
      this.id = Integer.parseInt(text.split(",")[0]);
      this.marca = text.split(",")[1];
      this.model = text.split(",")[2];
      this.culoare = text.split(",")[3];
      this.pretInitial = Integer.parseInt(text.split(",")[4]);
      this.pretInchiriere = Integer.parseInt(text.split(",")[5]);
      this.anFabricare = Integer.parseInt(text.split(",")[6]);
      this.rulata = Boolean.parseBoolean(text.split(",")[7]);
      this.kilometrii = Integer.parseInt(text.split(",")[8]);
   }


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

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getMarca() {
      return marca;
   }

   public void setMarca(String marca) {
      this.marca = marca;
   }

   public String getModel() {
      return model;
   }

   public void setModel(String model) {
      this.model = model;
   }

   public String getCuloare() {
      return culoare;
   }

   public void setCuloare(String culoare) {
      this.culoare = culoare;
   }

   public int getPretInitial() {
      return pretInitial;
   }

   public void setPretInitial(int pretInitial) {
      this.pretInitial = pretInitial;
   }

   public int getPretInchiriere() {
      return pretInchiriere;
   }

   public void setPretInchiriere(int pretInchiriere) {
      this.pretInchiriere = pretInchiriere;
   }

   public int getAnFabricare() {
      return anFabricare;
   }

   public void setAnFabricare(int anFabricare) {
      this.anFabricare = anFabricare;
   }

   public boolean isRulata() {
      return rulata;
   }

   public void setRulata(boolean rulata) {
      this.rulata = rulata;
   }

   public int getKilometrii() {
      return kilometrii;
   }

   public void setKilometrii(int kilometrii) {
      this.kilometrii = kilometrii;
   }
   @Override
   public boolean equals(Object o){
      Masina masina=(Masina) o;
      return masina.pretInitial==((Masina) o).pretInitial && masina.id==((Masina) o).id&& masina.anFabricare==((Masina) o).anFabricare;
   }

   @Override
   public String toString(){
      return id+","+marca+","+model+","+culoare+","+pretInitial+","+pretInchiriere+","+anFabricare+","+rulata+","+kilometrii;
   }

   @Override
   public int compareTo(Masina o) {
      if(o.pretInitial>this.pretInitial){
         return -1;
      }
      if (o.pretInitial<this.pretInitial){
         return 1;
      }
      return 0;
   }
}


