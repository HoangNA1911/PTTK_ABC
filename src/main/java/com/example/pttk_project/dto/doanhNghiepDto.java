package com.example.pttk_project.dto;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class doanhNghiepDto {
    public SimpleIntegerProperty ma_doanh_nghiep  = new SimpleIntegerProperty();
    public SimpleStringProperty ten_cty  = new SimpleStringProperty();
    public SimpleStringProperty ms_thue  = new SimpleStringProperty();
    public SimpleStringProperty dia_chi  = new SimpleStringProperty();
    public SimpleStringProperty Dai_dien = new SimpleStringProperty();
    public SimpleStringProperty email   = new SimpleStringProperty();

    public doanhNghiepDto() {

    }

    public doanhNghiepDto(String ten_cty, String ms_thue, String dia_chi, String Dai_dien, String email) {
        this.ten_cty.set(ten_cty);
        this.ms_thue.set(ms_thue);
        this.dia_chi.set(dia_chi);
        this.Dai_dien.set(Dai_dien);
        this.email.set(email);
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

    public String getDai_dien() {
        return Dai_dien.get();
    }

    public void setDai_dien(String Dai_dien) {
        this.Dai_dien.set(Dai_dien);
    }

    public SimpleStringProperty Dai_dienproperty(){
        return Dai_dien;
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