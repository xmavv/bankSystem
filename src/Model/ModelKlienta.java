package Model;

import java.util.ArrayList;

public class ModelKlienta implements IModelKlienta{
    static ArrayList<Klient> klienci = new ArrayList<>() {{
        new Klient("minos", "menos", 23, "ziomek", "ziomek");
    }};

    private static int id = 0;

    public Klient utworzKlienta(String imie, String nazwisko, String pesel, String adres) {
        Klient klient = new Klient(imie, nazwisko, id, pesel, adres);

        klienci.add(klient);
        id++;

        return klient;
    }
    public Klient wyszukajKlienta(String pesel) {
        for (Klient k : klienci) {
            if (k.getPesel() == pesel) return k;
        }

        return null;
    }
}
