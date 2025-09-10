package app.masini.model;

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
   public Masina(int id) {
      this.id = id;
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


   private Masina(Builder builder){
      this.id = builder.id;
      this.marca = builder.marca;
      this.model = builder.model;
      this.culoare = builder.culoare;
      this.pretInitial = builder.pretInitial;
      this.pretInchiriere = builder.pretInchiriere;
      this.anFabricare = builder.anFabricare;
      this.rulata = builder.rulata;
      this.kilometrii = builder.kilometrii;
   }


   public Masina(String marca, String model, String culoare, int pretInitial, int pretInchiriere, int anFabricare, boolean rulata, int kilometrii) {
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

   public static Builder builder(){
      return  new Builder();
   }

   public static class Builder{
      private int id;
      private String marca;
      private String model;
      private String culoare;
      private int pretInitial;
      private int pretInchiriere;
      private int anFabricare;
      private boolean rulata;
      private int kilometrii;

      public Builder id(int id){
         this.id=id;
         return this;
      }

      public Builder marca(String marca){
         this.marca=marca;
         return this;
      }

      public Builder model(String model){
         this.model=model;
         return this;
      }

      public Builder culoare(String culoare){
         this.culoare=culoare;
         return this;
      }

      public Builder pretInitial(int pretInitial){
         this.pretInitial=pretInitial;
         return this;
      }

      public Builder pretInchiriere(int pretInchiriere){
         this.pretInchiriere=pretInchiriere;
         return this;
      }

      public Builder anFabricare(int anFabricare){
         this.anFabricare=anFabricare;
         return this;
      }

      public Builder rulata(boolean rulata){
         this.rulata=rulata;
         return this;
      }

      public Builder kilometrii(int kilometrii){
         this.kilometrii=kilometrii;
         return this;
      }

      public Masina build(){
         return new Masina(this);
      }

   }


   @Override
   public boolean equals(Object o){
      Masina masina=(Masina) o;
      return  this.getId()==masina.id;
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


