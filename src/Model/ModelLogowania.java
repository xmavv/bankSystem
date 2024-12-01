package Model;

public class ModelLogowania implements IModelLogowania {
    IModelKonta modelKonta = new ModelKonta();
    private static Konto zalogowaneKonto;
    public boolean sprawdzLogowanie(int numerKonta, String haslo) {
        zalogowaneKonto = modelKonta.wyszukajKonto(numerKonta);
        if(zalogowaneKonto == null) return false;

        if(zalogowaneKonto.getHaslo().equals(haslo)) {
            return true;
        } else return false;
    }

    public Konto getZalogowaneKonto() {
        System.out.println(zalogowaneKonto.getSaldo());
        return zalogowaneKonto;
    }
}
