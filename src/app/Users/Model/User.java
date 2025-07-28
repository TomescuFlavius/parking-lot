package app.Users.Model;

public class User implements Comparable<User>{
    private int id;
    private String nume;
    private String adresa;
    private int varsta;
    private String email;
    private String password;


    public User(int id, String nume, String adresa, int varsta, String email, String password) {
        this.id = id;
        this.nume = nume;
        this.adresa = adresa;
        this.varsta = varsta;
        this.email = email;
        this.password = password;
    }

    public User(){
        this.id = 0;
        this.nume = "";
        this.adresa = "";
        this.varsta = 0;
        this.email = "";
        this.password = "";
    }

    public User(String text) {
        text.split(",");
        this.id = Integer.parseInt(text.split(",")[0]);
        this.nume = text.split(",")[1];
        this.adresa = text.split(",")[2];
        this.varsta = Integer.parseInt(text.split(",")[3]);
        this.email = text.split(",")[4];
        this.password = text.split(",")[5];

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o){
        User user=(User) o;
        return user.nume==((User) o).nume && user.email==((User) o).email&& user.password==((User) o).password;
    }

    @Override
    public String toString(){
        return  id +"," + nume + "," +adresa+","+varsta+","+ email + "," + password;
    }

    @Override
    public int compareTo(User o) {

        if(o.varsta>this.varsta){
            return -1;
        }

        if(o.varsta<this.varsta){
            return 1;
        }
        return 0;
    }
}
