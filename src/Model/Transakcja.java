package Model;

import java.util.Date;

public class Transakcja {
    Date data;
    float kwota;
    int numerKontaOdbiorcy;

    public Transakcja(Date data, float kwota, int numerKontaOdbiorcy) {
        this.data = data;
        this.kwota = kwota;
        this.numerKontaOdbiorcy = numerKontaOdbiorcy;
    }

    public float getKwota() {
        return kwota;
    }

    @Override
    public String toString() {
        return this.kwota + "  " + data + "  " + numerKontaOdbiorcy;
    }
}
