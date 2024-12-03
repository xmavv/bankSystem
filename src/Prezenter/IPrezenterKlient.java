package Prezenter;

public interface IPrezenterKlient {
    void zaloguj(int numerKonta, String haslo);
    void menu(String wybor);
    void wyslijPrzelew(float kwota, int numerKonta, String tytul);
    void zmienWalute (int wybor);
}
