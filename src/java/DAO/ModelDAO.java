/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Model;
import Utility.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rozerin
 */
public class ModelDAO {
    private DBConnection db;
    
    public void Create(Model m){
        try {
            Statement st = this.getDb().connect().createStatement();
            st.executeUpdate("insert into model (model_isim,model_yakit,model_renk,model_yil,model_vites) values ('" + m.getModel_isim()+ "','" + m.getModel_yakit()+ "','" + m.getModel_renk()+ "','" + m.getModel_yil()+"','" + m.getModel_vites()+"')");
        } catch (Exception e) {
        }
    }
    
    public List<Model> read(int page , int pageSize) {
        List<Model> list = new ArrayList<>();
        int start = (page-1)*pageSize;
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select * from model order by model_id asc limit "+start+","+pageSize);

            while (rs.next()) {
                Model tmp = new Model(rs.getInt("model_id"), rs.getString("model_isim"), rs.getString("model_yakit"), rs.getString("model_renk"), rs.getString("model_yil"), rs.getString("model_vites"));
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
            ResultSet rs = st.executeQuery("select count(model_id) as model_count from model");
            rs.next();
            count = rs.getInt("model_count");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
    
    public void update(Model m) {
        try {
           Statement st = this.getDb().connect().createStatement();
            st.executeUpdate("update model set model_isim='" + m.getModel_isim()+ "', model_yakit='"+m.getModel_yakit()+"',model_renk='"+m.getModel_renk()+"',model_yil='"+m.getModel_yil()+"',model_vites='"+m.getModel_vites()+"'where model_id=" + m.getModel_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(Model m) {
        try {
            Statement st = this.getDb().connect().createStatement();
            st.executeUpdate("delete from model where model_id=" + m.getModel_id());
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
