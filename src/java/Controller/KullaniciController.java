/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.KullaniciDAO;
import Entity.Kullanici;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Rozerin
 */
@Named
@SessionScoped
public class KullaniciController implements Serializable{
    private Kullanici kullanici;
    private KullaniciDAO kullaniciDAO;
    private List<Kullanici> list;
    
    private int page =1;
    private int pageSize=2;
    private int pageCount;

    public void next(){
        if(this.page == this.getPageCount())
            this.page=1;
        else
            this.page++;
    }    

    public void previous(){
        if(this.page ==1)
            this.page=this.getPageCount();
        else
            this.page--;
    }
    
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(getKullaniciDAO().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    public void clearForm(){
        this.kullanici= new Kullanici();
    }

    public Kullanici getKullanici() {
        if (this.kullanici == null) {
            this.kullanici = new Kullanici();
        }
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public KullaniciDAO getKullaniciDAO() {
        if (this.kullaniciDAO == null) {
            this.kullaniciDAO = new KullaniciDAO();
        }
        return kullaniciDAO;
    }

    public void setKullaniciDAO(KullaniciDAO kullaniciDAO) {
        this.kullaniciDAO = kullaniciDAO;
    }

    public List<Kullanici> getList() {
        list =this.getKullaniciDAO().read(page, pageSize);
        return list;
    }

    public void setList(List<Kullanici> list) {
        this.list = list;
    }
    
    public String create() {
        this.getKullaniciDAO().Create(kullanici);
        this.clearForm();
        return "/Kullanici/List";
    }
    
     public String updateForm(Kullanici k) {
        this.kullanici = k;
        return "update";
    }
     
     public String update() {
        this.kullaniciDAO.update(kullanici);
        return "/Kullanici/List";
    }
     
     public void delete(Kullanici k) {
        this.getKullaniciDAO().delete(k);
    }
     
     public KullaniciController(){
    }
    
}
