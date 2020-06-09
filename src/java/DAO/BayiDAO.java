/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Bayi;
import Utility.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rozerin
 */
public class BayiDAO {
    private DBConnection db;
    
    public void Create(Bayi b){
        try {
            Statement st = this.getDb().connect().createStatement();
            st.executeUpdate("insert into bayi (bayi_sehir,bayi_adres,bayi_ad,bayi_tel) values ('" + b.getBayi_sehir() + "','" + b.getBayi_adres() + "','" + b.getBayi_ad() + "','" + b.getBayi_tel()+"')");
        } catch (Exception e) {
        }
    }
    
    public List<Bayi> read(int page , int pageSize) {
        List<Bayi> list = new ArrayList<>();
        int start = (page-1)*pageSize;
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select * from bayi order by bayi_id asc limit "+start+","+pageSize);

            while (rs.next()) {
                Bayi tmp = new Bayi(rs.getInt("bayi_id"), rs.getString("bayi_sehir"), rs.getString("bayi_adres"), rs.getString("bayi_ad"), rs.getInt("bayi_tel"));
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
            ResultSet rs = st.executeQuery("select count(bayi_id) as bayi_count from bayi");
            rs.next();
            count = rs.getInt("bayi_count");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
    
    public void update(Bayi b) {
        try {
           Statement st = this.getDb().connect().createStatement();
            st.executeUpdate("update bayi set bayi_sehir='" + b.getBayi_sehir()+ "', bayi_adres='"+b.getBayi_adres()+"',bayi_ad='"+b.getBayi_ad()+"',bayi_tel='"+b.getBayi_tel()+"'where bayi_id=" + b.getBayi_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(Bayi b) {
        try {
            Statement st = this.getDb().connect().createStatement();
            st.executeUpdate("delete from bayi where bayi_id=" + b.getBayi_id());
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
