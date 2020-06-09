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
public class Model {
    private int model_id;
    private String model_isim;
    private String model_yakit;
    private String model_renk;
    private String model_yil;
    private String model_vites;
    
    public Model(){
    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public String getModel_isim() {
        return model_isim;
    }

    public void setModel_isim(String model_isim) {
        this.model_isim = model_isim;
    }

    public String getModel_yakit() {
        return model_yakit;
    }

    public void setModel_yakit(String model_yakit) {
        this.model_yakit = model_yakit;
    }

    public String getModel_renk() {
        return model_renk;
    }

    public void setModel_renk(String model_renk) {
        this.model_renk = model_renk;
    }

    public String getModel_yil() {
        return model_yil;
    }

    public void setModel_yil(String model_yil) {
        this.model_yil = model_yil;
    }

    public String getModel_vites() {
        return model_vites;
    }

    public void setModel_vites(String model_vites) {
        this.model_vites = model_vites;
    }

    public Model(int model_id, String model_isim, String model_yakit, String model_renk, String model_yil, String model_vites) {
        this.model_id = model_id;
        this.model_isim = model_isim;
        this.model_yakit = model_yakit;
        this.model_renk = model_renk;
        this.model_yil = model_yil;
        this.model_vites = model_vites;
    }
    
    @Override
    public String toString() {
        return "Model{" + "model_id=" + model_id + ", model_isim=" + model_isim + ", model_yakit=" + model_yakit + ", model_renk=" + model_renk + ", model_yil=" + model_yil+ ", model_vites=" + model_vites+'}';
    }
}
