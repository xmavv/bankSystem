package Model;

public class Klient extends Uzytkownik {
    private String pesel;
    private String adres;
    public Klient(String imie, String nazwisko, int id, String pesel, String adres) {
        super(imie, nazwisko, id);
        this.pesel = pesel;
        this.adres = adres;
    }

    public String getPesel() {
        return pesel;
    }
}
