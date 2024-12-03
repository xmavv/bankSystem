package Model;

import java.util.ArrayList;

public class Konto {
    private Klient klient;
    private ArrayList<Transakcja> historiaTransakcji;
    private float saldo = 500;
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

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    public ArrayList<Transakcja> getHistoriaTransakcji() {
        return historiaTransakcji;
    }
    public void setHistoriaTransakcji(ArrayList<Transakcja> historiaTransakcji) {
        this.historiaTransakcji = historiaTransakcji;
    }
//    public void setTyp(String typ) {this.typ = typ;}
//    public void setLogin(String login) {this.login = login;}
//    public void setHaslo(String haslo) {this.haslo = haslo;}
//    public String getTyp() {return typ;}
//    public String getLogin() {return login;}
}
