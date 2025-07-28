package app.Rents.Model;

import app.Rents.Status;

public class Rent implements Comparable<Rent> {
    private int id;
    private int idUser;
    private int idMasina;
    private Status status;

    public Rent(){
        this.id = 0;
        this.idUser = 0;
        this.idMasina = 0;
        this.status=Status.COMPLETED;
    }

    public Rent(int id, int idUser, int idMasina, Status status) {
        this.id = id;
        this.idUser = idUser;
        this.idMasina = idMasina;
        this.status = status;
    }

    public Rent(String text){
        text.split(",");
        this.id = Integer.parseInt(text.split(",")[0]);
        this.idUser = Integer.parseInt(text.split(",")[1]);
        this.idMasina = Integer.parseInt(text.split(",")[2]);
        this.status = Status.valueOf(text.split(",")[3]);
    }
    public String descriere() {
        String text = "";
        text +="Id : " + this.id + "\n";
        text +="Id User : " + this.idUser + "\n";
        text +="Id Masina : " + this.idMasina + "\n";
        text +="Status : " + this.status + "\n";
        return text;
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

    @Override
    public boolean equals(Object o){
        Rent rent=(Rent) o;
        return rent.id==((Rent) o).id&&rent.idMasina==((Rent) o).idMasina&&rent.idUser==((Rent) o).idUser;
    }

    @Override
    public String toString(){
        return id+","+idUser+","+idMasina+","+status;
    }

    @Override
    public int compareTo(Rent o) {
        if (o.idUser>this.idUser){
            return -1;
        }
        if(o.idUser<this.idUser){
            return 1;
        }
        return 0;
    }
}
