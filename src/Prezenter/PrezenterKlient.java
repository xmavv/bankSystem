package Prezenter;

import Model.*;
import Widok.IWidokKlient;
import Widok.WidokKlient;

import java.util.ArrayList;

public class PrezenterKlient implements IPrezenterKlient {
    private IModelLogowania modelLogowania = new ModelLogowania();
    private IWidokKlient widokKlient;
    private IModelKonto modelKonto;
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
            case("2"): sprawdzHistorieTransakcji(); break;
            case("3"): widokKlient.wyswietlWymianaWalut(); break;
            case("4"): sprawdzSaldo(); break;
            default: {
                widokKlient.wyswietlKomunikat("zly wybor");
                break;
            }
        }

        widokKlient.wyswietlMenu();
    }

    public void wyslijPrzelew(float kwota, int numerKonta, String tytul) {
        modelKonto = new ModelKonto();

        Konto konto = modelKonto.wyszukajKonto(numerKonta);
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

        modelKonto.dodanieSrodkow(konto, kwota);
        modelKonto.odjecieSrodkow(zalogowaneKonto, kwota);

        widokKlient.wyswietlKomunikat("przelew wyslany!");
        widokKlient.wyswietlKomunikat("saldo ziomeczka do ktorego wyslales przelew");
        widokKlient.wyswietlKomunikat(konto.getSaldo() + "\n");

        widokKlient.wyswietlKomunikat("twoje saldo po przlewie");
        widokKlient.wyswietlKomunikat(Float.toString(zalogowaneKonto.getSaldo()));
    }

    private void sprawdzSaldo() {
        Konto zalogowaneKonto = modelLogowania.getZalogowaneKonto();
        widokKlient.wyswietlSaldo(zalogowaneKonto.getSaldo());
    }

    public void zmienWalute (int wybor) {
        Konto zalogowaneKonto = modelLogowania.getZalogowaneKonto();
        float saldo = zalogowaneKonto.getSaldo();

        ////api call

        zalogowaneKonto.setSaldo(saldo);
    }

    private void sprawdzHistorieTransakcji() {
        Konto zalogowaneKonto = modelLogowania.getZalogowaneKonto();
        widokKlient.wyswietlHistorieTransakcji(zalogowaneKonto.getHistoriaTransakcji());
    }

    private void generowanieMiesiecznegoWyciaguKonta() {
        float kwota = 0;

        ArrayList<Transakcja> historiaTransakcji = modelLogowania.getZalogowaneKonto().getHistoriaTransakcji();
        for(Transakcja trans: historiaTransakcji) {
            kwota += trans.getKwota();
        }

        widokKlient.wyswietlKomunikat(Float.toString(kwota));
    }

    private void ustawienieStalychZlecen() {
        //
    }

    public static void main(String[] args) {
        WidokKlient widokKlient = new WidokKlient();
        widokKlient.wyswietlLogowanie();
    }
}
