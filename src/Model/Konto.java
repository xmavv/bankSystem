package Model;

import java.util.ArrayList;

public class Konto {
    private Klient klient;
    private ArrayList<String> listaTransakcji;
    private int saldo = 500;
    private String typ;
    private String login;
    private String haslo;
    private int numerKonta;
    public Konto(Klient klient, String login, String haslo, String typ, int numerKonta) {
        this.klient = klient;
        this.login = login;
        this.haslo = haslo;
        this.typ = typ;
        this.numerKonta = numerKonta;
    }
    public String getHaslo() {
        return haslo;
    }

    public int getNumerKonta() {return numerKonta;}

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
