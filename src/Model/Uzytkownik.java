package Model;

public abstract class Uzytkownik {
    private String imie;
    private String nazwisko;
    private int uzytkownikId;
    public Uzytkownik(String imie, String nazwisko, int id) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.uzytkownikId = id;
    }

    protected void setImie(String imie) {this.imie = imie;}
    public String getImie() {return imie;}
    protected void setNazwisko(String nazwisko) {this.nazwisko = nazwisko;}
    public String getNazwisko() {return nazwisko;}
}
