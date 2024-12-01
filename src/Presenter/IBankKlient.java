package Presenter;

public interface IBankKlient {
    void zaloguj(int numerKonta, String haslo);
    void menu(String wybor);
    void wyslijPrzelew(int kwota, int numerKonta, String tytul);
}
