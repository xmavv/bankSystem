package Model;

public class ModelLogowania implements IModelLogowania {
    private IModelKonto modelKonto = new ModelKonto();
    private static Konto zalogowaneKonto;
    public boolean sprawdzLogowanie(int numerKonta, String haslo) {
        zalogowaneKonto = modelKonto.wyszukajKonto(numerKonta);
        if(zalogowaneKonto == null) return false;

        if(zalogowaneKonto.getHaslo().equals(haslo)) {
            return true;
        } else return false;
    }

    public Konto getZalogowaneKonto() {return zalogowaneKonto;}
}
