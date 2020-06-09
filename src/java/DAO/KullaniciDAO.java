/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Kullanici;
import Utility.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rozerin
 */
public class KullaniciDAO {
    private DBConnection db;
    
    public void Create(Kullanici k){
        try {
            Statement st = this.getDb().connect().createStatement();
            st.executeUpdate("insert into kullanici (kullanici_mail,kullanici_sifre,kullanici_tel,iletisim_id) values ('" + k.getKullanici_mail()+ "','" + k.getKullanici_sifre()+ "','" + k.getKullanici_tel()+ "','" + k.getIletisim_id()+"')");
        } catch (Exception e) {
            System.out.println("hata");
        }
    }
    
    public List<Kullanici> read(int page , int pageSize) {
        List<Kullanici> list = new ArrayList<>();
        int start = (page-1)*pageSize;
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select * from kullanici order by kullanici_id asc limit"+start+","+pageSize);

            while (rs.next()) {
                Kullanici tmp = new Kullanici(rs.getInt("kullanici_id"), rs.getString("kullanici_mail"), rs.getString("kullanici_sifre"), rs.getString("kullanici_tel"), rs.getInt("iletisim_id"));
                list.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public int count() {
        int count =0;
        
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select count(kullanici_id) as kullanici_count from kullanici");
            rs.next();
            count = rs.getInt("kullanici_count");
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
    
    public void update(Kullanici k) {
        try {
           Statement st = this.getDb().connect().createStatement();
            st.executeUpdate("update kullanici set kullanici_mail='" + k.getKullanici_mail()+ "', kullanici_sifre='"+k.getKullanici_sifre()+"',kullanici_tel='"+k.getKullanici_tel()+"',iletisim_id='"+k.getIletisim_id()+"'where kullanici_id=" + k.getKullanici_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(Kullanici k) {
        try {
            Statement st = this.getDb().connect().createStatement();
            st.executeUpdate("delete from kullanici where kullanici_id=" + k.getKullanici_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public DBConnection getDb() {
        if( this.db== null){
            this.db= new DBConnection();
        }
        return db;
    }

    public void setDb(DBConnection db) {
        this.db = db;
    }
    
    
    
}
