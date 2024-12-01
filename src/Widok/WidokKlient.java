package Widok;

import Presenter.BankKlient;
import Presenter.IBankKlient;

import java.util.Scanner;

public class WidokKlient implements IWidokKlient{
    IBankKlient bankKlient;
    public void wyswietlLogowanie() {
        bankKlient = new BankKlient();

        System.out.println("zaloguj sie spoko");
        System.out.println("podaj numer konta");
        Scanner scanner =  new Scanner(System.in);
        String numerKonta = scanner.nextLine();
        System.out.println("podaj haslo");
        String haslo = scanner.nextLine();

        bankKlient.zaloguj(Integer.parseInt(numerKonta), haslo);
    }

    public void wyswietlMenu() {
        bankKlient = new BankKlient();

        System.out.println("wybierz cos");
        System.out.println("1. przelewik");
        System.out.println("2. historia transakcji");
        System.out.println("3. wymiana walut");
        System.out.println("4. sprawdzenie salda");

        Scanner scanner =  new Scanner(System.in);
        String wybor = scanner.nextLine();

        bankKlient.menu(wybor);
    }

    public void wyswieltWyslijPrzelew() {
        bankKlient = new BankKlient();

        System.out.println("podaj kwote");
        Scanner scanner =  new Scanner(System.in);
        String kwota = scanner.nextLine();
        System.out.println("podaj numer konta");
        String numerKonta = scanner.nextLine();
        System.out.println("podaj tytul przelewu (min 5 znakow)");
        String tytulPrzelewu = scanner.nextLine();

        bankKlient.wyslijPrzelew(Integer.parseInt(kwota), Integer.parseInt(numerKonta), tytulPrzelewu);

    }

    public void wyswietlHistorieTransakcji() {
        System.out.println("ostatnie transakcje: 150zl to jakub lipka");
    }

    public void wyswietlWymianaWalut() {
        System.out.println("wybierz walute");
    }

    public void wyswietlSaldo() {
        System.out.println("twoje saldo to 0zl xd");
    }
}
