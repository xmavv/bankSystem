package Model;

import java.util.ArrayList;

public class ModelKonta implements IModelKonta{
    static ArrayList<Konto> konta = new ArrayList<>() {{
        add(new Konto(new Klient("ziomek", "ziomek", 421, "ziomek", "ziomek"), "ziomek", "ziomek", "oszczednosciowe", 500));
        add(new Konto(new Klient("jali", "lipka", 888, "xd", "gahahahlolxd"), "essa", "zio", "walutowe", 501));
    }};
    IModelKlienta modelKlienta;
    private static int numerKonta = 555;

    public void utworzKonto(String login, String haslo, String typ, String imie, String nazwisko, String pesel, String adres) {
        modelKlienta = new ModelKlienta();

        Klient klient = modelKlienta.wyszukajKlienta(pesel);
        if (klient == null) {
            Klient utworzonyKlient = modelKlienta.utworzKlienta(imie, nazwisko, pesel, adres);
            konta.add(new Konto(utworzonyKlient, login, haslo, typ, numerKonta));
        } else {
            konta.add(new Konto(klient, login, haslo, typ, numerKonta));
        }
    }

    public Konto wyszukajKonto(int numerKonta) {
        for (Konto k : konta) {
            if ((k.getNumerKonta() == numerKonta)) return k;
        }

        return null;
    }
    public void dodanieSrodkow(Konto konto, float kwota) {
        float saldo = konto.getSaldo();
        konto.setSaldo(saldo + kwota);
    }
    public void odjecieSrodkow(Konto konto, float kwota) {
        float saldo = konto.getSaldo();
        konto.setSaldo(saldo - kwota);
    }
//    public void zmienTypKonta(Konto konto, String wartosc) {
//        konto.setTyp(wartosc);
//    }
//    public void zmienLoginKonta(Konto konto, String wartosc) {
//        konto.setLogin(wartosc);
//    }
//    public void zmienHasloKonta(Konto konto, String wartosc) {
//        konto.setHaslo(wartosc);
//    }
}
