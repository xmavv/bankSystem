package Prezenter;

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
            widokKlient.wyswietlKomunikat("zalogowano");
            widokKlient.wyswietlMenu();
        } else {
            widokKlient.wyswietlKomunikat("nie zalogowano, sporobj jeszcze raz");
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
                widokKlient.wyswietlKomunikat("zly wybor");
                break;
            }
        }

        widokKlient.wyswietlMenu();
    }

    public void wyslijPrzelew(float kwota, int numerKonta, String tytul) {
        modelKonta = new ModelKonta();

        Konto konto = modelKonta.wyszukajKonto(numerKonta);
        if(konto == null) {
            widokKlient.wyswietlKomunikat("nie ma takiego konta!");
            return;
        }

        Konto zalogowaneKonto = modelLogowania.getZalogowaneKonto();
        if(zalogowaneKonto.getSaldo() < kwota) {
            widokKlient.wyswietlKomunikat("nie masz wystarczjaco pieniedzy!");
            return;
        };

        if(tytul.length() < 5) {
            widokKlient.wyswietlKomunikat("tytul powinien miec minimum 5 znakow!");
            return;
        }

        modelKonta.dodanieSrodkow(konto, kwota);
        modelKonta.odjecieSrodkow(zalogowaneKonto, kwota);

        widokKlient.wyswietlKomunikat("przelew wyslany!");
        widokKlient.wyswietlKomunikat("saldo ziomeczka do ktorego wyslales przelew");
        widokKlient.wyswietlKomunikat(konto.getSaldo() + "\n");

        widokKlient.wyswietlKomunikat("twoje saldo po przlewie");
        widokKlient.wyswietlKomunikat(Float.toString(zalogowaneKonto.getSaldo()));
    }

    public static void main(String[] args) {
        WidokKlient widokKlient = new WidokKlient();
        widokKlient.wyswietlLogowanie();
    }
}
