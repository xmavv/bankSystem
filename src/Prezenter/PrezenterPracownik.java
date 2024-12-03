package Prezenter;

import Model.*;
import Widok.IWidokPracownik;
import Widok.WidokPracownik;

public class PrezenterPracownik implements IPrezenterPracownik {
    private IWidokPracownik widokPracownik;
    private IModelKlient modelKlient;

    public void menu(String wybor) {
        widokPracownik = new WidokPracownik();

        switch(wybor) {
            case("1"): widokPracownik.wyswietlUtworzKonto(); break;
            case("2"): widokPracownik.wyswietlZmienDaneOsobowe(); break;
            default: {
                widokPracownik.wyswietlKomunikat("zly wybor");
                break;
            }
        }

        widokPracownik.wyswietlMenu();
    }

    public void zmienDaneOsobowe(String pesel, int wybor, String wartosc) {
        modelKlient = new ModelKlient();
        widokPracownik = new WidokPracownik();

        Klient klient = modelKlient.wyszukajKlienta(pesel);
        if(klient == null) {
            widokPracownik.wyswietlKomunikat("nie ma takiego klienta");
            return;
        }

        if(wybor == 1) {
            if(!czyPeselPoprawny(wartosc)) {
                widokPracownik.wyswietlKomunikat("niepoprawna dlugosc peselu");
                widokPracownik.wyswietlZmienDaneOsobowe();
                return;
            };
            modelKlient.zmienImieKlienta(klient, wartosc);
        } else if(wybor == 2) {
            if(!czyImieNazwiskoPoprawne(wartosc)) {
                widokPracownik.wyswietlKomunikat("w twoich danych wystepuja cyfry!");
                widokPracownik.wyswietlZmienDaneOsobowe();
                return;
            }
            modelKlient.zmienNazwiskoKlienta(klient, wartosc);
        } else {
            if(!czyImieNazwiskoPoprawne(wartosc)) {
                widokPracownik.wyswietlKomunikat("w twoich danych wystepuja cyfry!");
                widokPracownik.wyswietlZmienDaneOsobowe();
                return;
            }
            modelKlient.zmienAdresKlienta(klient, wartosc);
        }

        widokPracownik.wyswietlKomunikat("dane poprawnie zmienione!");
        widokPracownik.wyswietlKomunikat("dane po zmianie");
        widokPracownik.wyswietlKomunikat(klient.getImie());
        widokPracownik.wyswietlKomunikat(klient.getNazwisko());
        widokPracownik.wyswietlKomunikat(klient.getAdres());
    }

    private boolean czyPeselPoprawny(String wartosc) {return wartosc.length() != 11;}
    private boolean czyImieNazwiskoPoprawne(String wartosc) {
//        if(wartosc.length() < 3) return false;
        return wartosc.matches("[a-zA-Z]+");
    }

    public static void main(String[] args) {
        WidokPracownik widokPracownik = new WidokPracownik();
        widokPracownik.wyswietlMenu();
    }
}
