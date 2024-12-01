package Model;

public interface IModelLogowania {
    boolean sprawdzLogowanie(int numerKonta, String haslo);
    Konto getZalogowaneKonto();
}

