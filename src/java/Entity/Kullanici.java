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
public class Kullanici {
    private int kullanici_id;
    private String kullanici_mail;
    private String kullanici_sifre;
    private String kullanici_tel;
    private int iletisim_id;
    
    public Kullanici(){
    }

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public String getKullanici_mail() {
        return kullanici_mail;
    }

    public void setKullanici_mail(String kullanici_mail) {
        this.kullanici_mail = kullanici_mail;
    }

    public String getKullanici_sifre() {
        return kullanici_sifre;
    }

    public void setKullanici_sifre(String kullanici_sifre) {
        this.kullanici_sifre = kullanici_sifre;
    }

    public String getKullanici_tel() {
        return kullanici_tel;
    }

    public void setKullanici_tel(String kullanici_tel) {
        this.kullanici_tel = kullanici_tel;
    }

    public int getIletisim_id() {
        return iletisim_id;
    }

    public void setIletisim_id(int iletisim_id) {
        this.iletisim_id = iletisim_id;
    }

    public Kullanici(int kullanici_id, String kullanici_mail, String kullanici_sifre, String kullanici_tel, int iletisim_id) {
        this.kullanici_id = kullanici_id;
        this.kullanici_mail = kullanici_mail;
        this.kullanici_sifre = kullanici_sifre;
        this.kullanici_tel = kullanici_tel;
        this.iletisim_id = iletisim_id;
    }
    
    
    @Override
    public String toString() {
        return "Kullanici{" + "kullanici_id=" + kullanici_id + ", kullanici_mail=" + kullanici_mail + ", kullanici_sifre=" + kullanici_sifre + ", kullanici_tel=" + kullanici_tel + ", iletisim_id=" + iletisim_id+ '}';
    }
    
    
}
