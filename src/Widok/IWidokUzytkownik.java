package Widok;

public interface IWidokUzytkownik {
    void wyswietlLogowanie();
    void wyswietlMenu();
    default void wyswietlKomunikat(String komunikat) {
        System.out.println(komunikat);
    };
}
