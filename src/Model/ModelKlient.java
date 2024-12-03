package Model;

import java.util.ArrayList;

public class ModelKlient implements IModelKlient {
    private static ArrayList<Klient> klienci = new ArrayList<>() {{
        add(new Klient("minos", "menos", 23, "haha", "ziomek"));
    }};

    private static int klientId = 0;

    public Klient utworzKlienta(String imie, String nazwisko, String pesel, String adres) {
        Klient klient = new Klient(imie, nazwisko, klientId, pesel, adres);

        klienci.add(klient);
        klientId++;

        return klient;
    }
    public Klient wyszukajKlienta(String pesel) {
        for (Klient k : klienci) {
            if (k.getPesel().equals(pesel)) return k;
        }

        return null;
    }

    public void zmienImieKlienta(Klient klient, String wartosc) {klient.setImie(wartosc);}
    public void zmienNazwiskoKlienta(Klient klient, String wartosc) {klient.setNazwisko(wartosc);}
    public void zmienAdresKlienta(Klient klient, String wartosc) {klient.setAdres(wartosc);}
}
