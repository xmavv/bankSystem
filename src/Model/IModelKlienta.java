package Model;

public interface IModelKlienta {
    Klient utworzKlienta(String imie, String nazwisko, String pesel, String adres);
    Klient wyszukajKlienta(String pesel);
}
