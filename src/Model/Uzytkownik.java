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
}
//POLSKA GUROM POSLKIE NAZWY