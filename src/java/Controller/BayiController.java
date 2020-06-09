/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.BayiDAO;
import Entity.Bayi;
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
public class BayiController implements Serializable{
    private Bayi bayi;
    private BayiDAO bayiDAO;
    private List<Bayi> list;
    
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
        this.pageCount = (int) Math.ceil(getBayiDAO().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
     

    public void clearForm(){
        this.bayi= new Bayi();
    }
    
    public List<Bayi> getList() {
        list =this.getBayiDAO().read(page, pageSize);
        return list;
    }
    
    public void setList(List<Bayi> list) {
        this.list = list;
    }
    
    public String create() {
        this.getBayiDAO().Create(bayi);
        this.clearForm();
        return "/Bayi/List";
    }
   
    public String updateForm(Bayi b) {
        this.bayi = b;
        return "update";
    }
    public String update() {
        this.bayiDAO.update(bayi);
        return "/Bayi/List";
    }
    public void delete(Bayi b) {
        this.getBayiDAO().delete(b);
    }
    public BayiController() {
    }
    public Bayi getBayi() {
        if (this.bayi == null) {
            this.bayi = new Bayi();
        }
        return bayi;
    }
    public void setBayi(Bayi bayi) {
        this.bayi = bayi;
    }
    public BayiDAO getBayiDAO() {
        if (this.bayiDAO == null) {
            this.bayiDAO = new BayiDAO();
        }
        return bayiDAO;
    }
    public void setBayiDAO(BayiDAO bayiDAO) {
        this.bayiDAO = bayiDAO;
    }
    
    
    
}
