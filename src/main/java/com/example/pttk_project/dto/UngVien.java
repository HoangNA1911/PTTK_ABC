package com.example.pttk_project.dto;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class UngVien {
    private final SimpleIntegerProperty ma_ung_vien  = new SimpleIntegerProperty();
    private final SimpleStringProperty ten  = new SimpleStringProperty();
    private final SimpleStringProperty password  = new SimpleStringProperty();
    private final SimpleStringProperty dia_chi  = new SimpleStringProperty();
    private final SimpleObjectProperty<LocalDate> ngay_sinh = new SimpleObjectProperty<>();
    private final SimpleStringProperty email   = new SimpleStringProperty();

    public UngVien() {

    }

    public UngVien(int ma_ung_vien , String ten , String password , String dia_chi , LocalDate ngay_sinh, String email  ){
        this.ma_ung_vien.set(ma_ung_vien );
        this.ten.set(ten );
        this.password.set(password );
        this.dia_chi.set(dia_chi );
        this.ngay_sinh.set(ngay_sinh);
        this.email.set(email  );
        // this.MADV.set(MADV);
    }

    // Getters and setters
    public int getma_ung_vien (){
        return ma_ung_vien.get();
    }

    public void setma_ung_vien (int ma_ung_vien ){
        this.ma_ung_vien .set(ma_ung_vien );
    }

    public SimpleIntegerProperty ma_ung_vienproperty(){
        return ma_ung_vien ;
    }

    public String getten (){
        return ten.get();
    }

    public void setten (String ten ){
        this.ten.set(ten );
    }

    public SimpleStringProperty tenproperty(){
        return ten ;
    }

    public String getpassword () {
        return password.get();
    }

    public void setpassword (String password ) {
        this.password .set(password );
    }

    public SimpleStringProperty passwordproperty(){
        return password ;
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

    public LocalDate getngay_sinh() {
        return ngay_sinh.get();
    }

    public void setngay_sinh(LocalDate ngay_sinh) {
        this.ngay_sinh.set(ngay_sinh);
    }

    public SimpleObjectProperty<LocalDate>  ngay_sinhproperty(){
        return ngay_sinh;
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

