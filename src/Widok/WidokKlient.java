package Widok;

import Model.Transakcja;
import Prezenter.PrezenterKlient;
import Prezenter.IPrezenterKlient;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class WidokKlient implements IWidokKlient{
    private IPrezenterKlient prezenterKlient;
    public void wyswietlLogowanie() {
        prezenterKlient = new PrezenterKlient();

        System.out.println("zaloguj sie spoko");
        System.out.println("podaj numer konta");
        Scanner scanner =  new Scanner(System.in);
        String numerKonta = scanner.nextLine();
        System.out.println("podaj haslo");
        String haslo = scanner.nextLine();

        prezenterKlient.zaloguj(Integer.parseInt(numerKonta), haslo);
    }

    public void wyswietlMenu() {
        prezenterKlient = new PrezenterKlient();

        System.out.println("wybierz cos");
        System.out.println("1. przelew bankowy");
        System.out.println("2. historia transakcji");
        System.out.println("3. wymiana walut");
        System.out.println("4. sprawdzenie salda");

        Scanner scanner =  new Scanner(System.in);
        String wybor = scanner.nextLine();

        prezenterKlient.menu(wybor);
    }

    public void wyswieltWyslijPrzelew() {
        prezenterKlient = new PrezenterKlient();

        System.out.println("podaj kwote");
        Scanner scanner =  new Scanner(System.in);
        String kwota = scanner.nextLine();
        System.out.println("podaj numer konta");
        String numerKonta = scanner.nextLine();
        System.out.println("podaj tytul przelewu (min 5 znakow)");
        String tytulPrzelewu = scanner.nextLine();

        prezenterKlient.wyslijPrzelew(Float.parseFloat(kwota), Integer.parseInt(numerKonta), tytulPrzelewu);

    }

    public void wyswietlHistorieTransakcji(ArrayList<Transakcja> historiaTransakcji) {
        historiaTransakcji.forEach(trans -> {
            System.out.println(trans.toString());
        });
    }

    public void wyswietlWymianaWalut() {
        prezenterKlient = new PrezenterKlient();

        System.out.println("wybierz walute");
        System.out.println("1. euro");
        System.out.println("2. dolar");
        System.out.println("3. funt");
        Scanner scanner =  new Scanner(System.in);
        String wybor = scanner.nextLine();

        prezenterKlient.zmienWalute(Integer.parseInt(wybor));
    }

    public void wyswietlSaldo(float saldo) {
        System.out.println("twoje saldo wynosi: " + saldo);
    }
}
