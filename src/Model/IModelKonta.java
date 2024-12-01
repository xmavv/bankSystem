package Model;

public interface IModelKonta {
    void utworzKonto(String login, String haslo, String typ, String imie, String nazwisko, String pesel, String adres);
    Konto wyszukajKonto(int numerKonta);
    void dodanieSrodkow(Konto konto, int kwota);
    void odjecieSrodkow(Konto konto, int kwota);
}
