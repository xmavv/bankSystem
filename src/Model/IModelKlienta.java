package Model;

public interface IModelKlienta {
    Klient wyszukajKlienta(String pesel);
    Klient utworzKlienta(String imie, String nazwisko, String pesel, String adres);
    void zmienImieKlienta(Klient klient, String wartosc);
    void zmienNazwiskoKlienta(Klient klient, String wartosc);
    void zmienAdresKlienta(Klient klient, String wartosc);
}
