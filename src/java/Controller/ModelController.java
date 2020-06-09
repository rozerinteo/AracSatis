/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ModelDAO;
import Entity.Model;
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
public class ModelController implements Serializable{
    private Model model;
    private ModelDAO modelDAO;
    private List<Model> list;
    
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
        this.pageCount = (int) Math.ceil(getModelDAO().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void clearForm(){
        this.model= new Model();
    }
    public Model getModel() {
        if (this.model == null) {
            this.model = new Model();
        }
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public ModelDAO getModelDAO() {
        if (this.modelDAO == null) {
            this.modelDAO = new ModelDAO();
        }
        return modelDAO;
    }

    public void setModelDAO(ModelDAO modelDAO) {
        this.modelDAO = modelDAO;
    }

    public List<Model> getList() {
        list =this.getModelDAO().read(page, pageSize);
        return list;
    }

    public void setList(List<Model> list) {
        this.list = list;
    }
    
     public String create() {
        this.getModelDAO().Create(model);
        this.clearForm();
        return "/Model/List";
    }
     
     public String updateForm(Model m) {
        this.model = m;
        return "update";
    }
     
      public String update() {
        this.modelDAO.update(model);
        return "/Model/List";
    }
      
      public void delete(Model m) {
        this.getModelDAO().delete(m);
    }
    
    public ModelController(){
    }
    
}
