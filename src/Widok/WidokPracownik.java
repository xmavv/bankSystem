package Widok;

import Prezenter.PrezenterPracownik;
import Prezenter.IPrezenterPracownik;

import java.util.Scanner;

public class WidokPracownik implements IWidokPracownik{
    private IPrezenterPracownik prezenterPracownik;

    public void wyswietlLogowanie() {}

    public void wyswietlMenu() {
        prezenterPracownik = new PrezenterPracownik();

        System.out.println("wybierz cos");
        System.out.println("1. utworz konto");
        System.out.println("2. zmiana danych osobowych");

        Scanner scanner =  new Scanner(System.in);
        String wybor = scanner.nextLine();

        prezenterPracownik.menu(wybor);
    }

    public void wyswietlZmienDaneOsobowe() {
        prezenterPracownik = new PrezenterPracownik();

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

        prezenterPracownik.zmienDaneOsobowe(pesel, Integer.parseInt(wybor), wartosc);
    }

    public void wyswietlUtworzKonto() {
        prezenterPracownik = new PrezenterPracownik();
    }
    public void wyswietlUsunKonto() {}
}
