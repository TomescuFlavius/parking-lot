package app.Rents.Model;

import app.Rents.Status;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

public class Rent implements Comparable<Rent> {
    private int id;
    private int idUser;
    private int idMasina;
    private Status status;
    private LocalDate inchiriere;
    private LocalDate returnare;


    public Rent(int idUser,int idMasina){
        this.id =0;
        this.idUser = idUser;
        this.idMasina = idMasina;
        this.status=Status.PROCESSING;
        this.inchiriere= LocalDate.now();
        this.returnare= null;
    }

    public Rent(int id, int idUser, int idMasina, Status status, LocalDate inchiriere, LocalDate returnare) {
        this.id = id;
        this.idUser = idUser;
        this.idMasina = idMasina;
        this.status = status;
        this.inchiriere=inchiriere;
        this.returnare=returnare;
    }

    public Rent(String text){
        text.split(",");
        this.id = Integer.parseInt(text.split(",")[0]);
        this.idUser = Integer.parseInt(text.split(",")[1]);
        this.idMasina = Integer.parseInt(text.split(",")[2]);
        this.status = Status.valueOf(text.split(",")[3]);
        this.inchiriere= LocalDate.parse((text.split(",")[4]),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.returnare= this.status==Status.COMPLETED?LocalDate.parse(text.split(",")[5],DateTimeFormatter.ofPattern("yyyy-MM-dd")):null;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdMasina() {
        return idMasina;
    }

    public void setIdMasina(int idMasina) {
        this.idMasina = idMasina;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getInchiriere() {
        return inchiriere;
    }

    public void setInchiriere(LocalDate inchiriere) {
        this.inchiriere = inchiriere;
    }

    public LocalDate getReturnare() {
        return returnare;
    }

    public void setReturnare(LocalDate returnare) {
        this.returnare = returnare;
    }

    @Override
    public boolean equals(Object o){
        Rent rent=(Rent) o;
        return rent.id==((Rent) o).id&&rent.idMasina==((Rent) o).idMasina&&rent.idUser==((Rent) o).idUser;
    }

    @Override
    public String toString(){

        String retur=returnare!=null?returnare.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")):"";
        String inchi=inchiriere.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return id+","+idUser+","+idMasina+","+status+","+inchi+","+retur;
    }

    @Override
    public int compareTo(Rent o) {
       return  this.inchiriere.compareTo(o.inchiriere);

    }
}
