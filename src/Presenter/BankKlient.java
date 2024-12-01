package Presenter;

import Model.IModelKonta;
import Model.IModelLogowania;
import Model.ModelKonta;
import Model.Konto;
import Model.ModelLogowania;
import Widok.IWidokKlient;
import Widok.WidokKlient;

public class BankKlient implements IBankKlient {
    IModelLogowania modelLogowania = new ModelLogowania();
    IWidokKlient widokKlient;
    IModelKonta modelKonta;
    public void zaloguj(int numerKonta, String haslo) {
        widokKlient = new WidokKlient();

        if(modelLogowania.sprawdzLogowanie(numerKonta, haslo)) {
            System.out.println("zalogowano");
            widokKlient.wyswietlMenu();
        } else {
            System.out.printf("nie zalogowano, sporobj jeszcze raz");
            widokKlient.wyswietlLogowanie();
        }
    }

    public void menu(String wybor) {
        widokKlient = new WidokKlient();

        switch(wybor) {
            case("1"): widokKlient.wyswieltWyslijPrzelew(); break;
            case("2"): widokKlient.wyswietlHistorieTransakcji(); break;
            case("3"): widokKlient.wyswietlWymianaWalut(); break;
            case("4"): widokKlient.wyswietlSaldo(); break;
            default: {
                System.out.println("zly wybor xd");
                break;
            }
        }

        widokKlient.wyswietlMenu();
    }

    public void wyslijPrzelew(int kwota, int numerKonta, String tytul) {
        modelKonta = new ModelKonta();

        Konto konto = modelKonta.wyszukajKonto(numerKonta);
        if(konto == null) {
            System.out.println("nie ma takiego konta!");
            return;
        }

        Konto zalogowaneKonto = modelLogowania.getZalogowaneKonto();
        if(zalogowaneKonto.getSaldo() < kwota) {
            System.out.println("nie masz wystarczjaco pieniedzy!");
            return;
        };

        if(tytul.length() < 5) {
            System.out.println("tytul powinien miec minimum 5 znakow!");
            return;
        }

        modelKonta.dodanieSrodkow(konto, kwota);
        modelKonta.odjecieSrodkow(zalogowaneKonto, kwota);

        System.out.println("przelew wyslany!");
        System.out.println("saldo ziomeczka do ktorego wyslales przelew");
        System.out.println(konto.getSaldo() + "\n");

        System.out.println("twoje saldo po przlewie");
        System.out.println(zalogowaneKonto.getSaldo());
    }

    public static void main(String[] args) {
        WidokKlient widokKlient = new WidokKlient();
        widokKlient.wyswietlLogowanie();
    }
}
