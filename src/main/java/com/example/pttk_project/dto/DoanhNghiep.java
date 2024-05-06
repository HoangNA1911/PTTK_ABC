package com.example.pttk_project.dto;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.ObjectProperty;
//doi ten file

public class DoanhNghiep  {
    private final SimpleIntegerProperty ma_doanh_nghiep  = new SimpleIntegerProperty();
    private final SimpleStringProperty ten_cty  = new SimpleStringProperty();
    private final SimpleStringProperty ms_thue  = new SimpleStringProperty();
    private final SimpleStringProperty dia_chi  = new SimpleStringProperty();
    private final SimpleStringProperty SOTIETTH = new SimpleStringProperty();
    private final SimpleStringProperty email   = new SimpleStringProperty();

    public DoanhNghiep() {

    }

    public DoanhNghiep(int ma_doanh_nghiep , String ten_cty , String ms_thue , String dia_chi , String SOTIETTH, String email  ){
        this.ma_doanh_nghiep.set(ma_doanh_nghiep );
        this.ten_cty.set(ten_cty );
        this.ms_thue.set(ms_thue );
        this.dia_chi.set(dia_chi );
        this.SOTIETTH.set(SOTIETTH);
        this.email.set(email  );
        // this.MADV.set(MADV);
    }

    // Getters and setters
    public int getma_doanh_nghiep (){
        return ma_doanh_nghiep.get();
    }

    public void setma_doanh_nghiep (int ma_doanh_nghiep ){
        this.ma_doanh_nghiep .set(ma_doanh_nghiep );
    }

    public SimpleIntegerProperty ma_doanh_nghiepproperty(){
        return ma_doanh_nghiep ;
    }

    public String getten_cty (){
        return ten_cty.get();
    }

    public void setten_cty (String ten_cty ){
        this.ten_cty.set(ten_cty );
    }

    public SimpleStringProperty ten_ctyproperty(){
        return ten_cty ;
    }

    public String getms_thue () {
        return ms_thue.get();
    }

    public void setms_thue (String ms_thue ) {
        this.ms_thue .set(ms_thue );
    }

    public SimpleStringProperty ms_thueproperty(){
        return ms_thue ;
    }

    public String getdia_chi () {
        return dia_chi.get();
    }

    public void setdia_chi (String dia_chi ) {
        this.dia_chi .set(dia_chi );
    }

    public SimpleStringProperty dia_chiproperty(){
        return dia_chi ;
    }

    public String getSOTIETTH() {
        return SOTIETTH.get();
    }

    public void setSOTIETTH(String SOTIETTH) {
        this.SOTIETTH.set(SOTIETTH);
    }

    public SimpleStringProperty SOTIETTHproperty(){
        return SOTIETTH;
    }

    public String getemail() {
        return email.get();
    }

    public void setemail  (String email  ) {
        this.email.set(email);
    }

    public SimpleStringProperty emailproperty(){
        return email  ;
    }

}

