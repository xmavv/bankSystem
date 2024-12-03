package Model;

public interface IModelKonto {
    void utworzKonto(String login, String haslo, String typ, String imie, String nazwisko, String pesel, String adres);
    Konto wyszukajKonto(int numerKonta);
    void dodanieSrodkow(Konto konto, float kwota);
    void odjecieSrodkow(Konto konto, float kwota);
//    void zmienTypKonta(Konto konto, String wartosc);
//    void zmienLoginKonta(Konto konto, String wartosc);
//    void zmienHasloKonta(Konto konto, String wartosc);
}
