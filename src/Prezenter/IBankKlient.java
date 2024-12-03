package Prezenter;

public interface IBankKlient {
    void zaloguj(int numerKonta, String haslo);
    void menu(String wybor);
    void wyslijPrzelew(float kwota, int numerKonta, String tytul);
}
