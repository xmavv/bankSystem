package Widok;

import Model.Transakcja;

import java.util.ArrayList;

public interface IWidokKlient extends IWidokUzytkownik {
    void wyswieltWyslijPrzelew();
    void wyswietlHistorieTransakcji(ArrayList<Transakcja> historiaTransakcji);
    void wyswietlWymianaWalut();
    void wyswietlSaldo(float saldo);
}
