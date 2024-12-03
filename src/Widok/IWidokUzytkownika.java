package Widok;

public interface IWidokUzytkownika {
    void wyswietlLogowanie();
    default void wyswietlKomunikat(String komunikat) {
        System.out.println(komunikat);
    };
}
