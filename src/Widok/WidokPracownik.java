package Widok;

import Prezenter.BankKlient;
import Prezenter.BankPracownik;
import Prezenter.IBankPracownik;

import java.util.Scanner;

public class WidokPracownik implements IWidokPracownik{
    IBankPracownik bankPracownik;

    public void wyswietlLogowanie() {}

    public void wyswietlMenu() {
        bankPracownik = new BankPracownik();

        System.out.println("wybierz cos");
        System.out.println("1. utworz konto");
        System.out.println("2. zmiana danych osobowych");

        Scanner scanner =  new Scanner(System.in);
        String wybor = scanner.nextLine();

        bankPracownik.menu(wybor);
    }

    public void wyswietlZmienDaneOsobowe() {
        bankPracownik = new BankPracownik();

        System.out.println("podaj pesel uzytkownika dla ktorego chcesz zmienic dane");
        Scanner scanner =  new Scanner(System.in);
        String pesel = scanner.nextLine();
        System.out.println("co chcesz zmienic?");
        System.out.println("1. imie");
        System.out.println("2. nazwisko");
        System.out.println("3. adres");
        String wybor = scanner.nextLine();
        System.out.println("wprowadz nowa wartosc:");
        String wartosc = scanner.nextLine();

        bankPracownik.zmienDaneOsobowe(pesel, Integer.parseInt(wybor), wartosc);
    }

    public void wyswietlUtworzKonto() {
        bankPracownik = new BankPracownik();
    }
}
