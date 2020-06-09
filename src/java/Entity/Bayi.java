/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Rozerin
 */
public class Bayi {
    private int bayi_id;
    private String bayi_adres;
    private String bayi_sehir;
    private String bayi_ad;
    private int bayi_tel;
    
    public Bayi(){
    }

    public Bayi(int bayi_id, String bayi_adres, String bayi_sehir, String bayi_ad, int bayi_tel) {
        this.bayi_id = bayi_id;
        this.bayi_adres = bayi_adres;
        this.bayi_sehir = bayi_sehir;
        this.bayi_ad = bayi_ad;
        this.bayi_tel = bayi_tel;
    }

    public int getBayi_id() {
        return bayi_id;
    }

    public void setBayi_id(int bayi_id) {
        this.bayi_id = bayi_id;
    }

    public String getBayi_adres() {
        return bayi_adres;
    }

    public void setBayi_adres(String bayi_adres) {
        this.bayi_adres = bayi_adres;
    }

    public String getBayi_sehir() {
        return bayi_sehir;
    }

    public void setBayi_sehir(String bayi_sehir) {
        this.bayi_sehir = bayi_sehir;
    }

    public String getBayi_ad() {
        return bayi_ad;
    }

    public void setBayi_ad(String bayi_ad) {
        this.bayi_ad = bayi_ad;
    }

    public int getBayi_tel() {
        return bayi_tel;
    }

    public void setBayi_tel(int bayi_tel) {
        this.bayi_tel = bayi_tel;
    }

    @Override
    public String toString() {
        return "Bayi{" + "bayi_id=" + bayi_id + ", bayi_adres=" + bayi_adres + ", bayi_sehir=" + bayi_sehir + ", bayi_ad=" + bayi_ad + ", bayi_tel=" + bayi_tel+ '}';
    }
}



