package com.example.pttk_project.dto;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.ObjectProperty;
//doi ten file

public class HinhThucQuangCao  {
    private final SimpleIntegerProperty ma_hinh_thuc  = new SimpleIntegerProperty();
    private final SimpleStringProperty ten  = new SimpleStringProperty();
    private final SimpleIntegerProperty gia   = new SimpleIntegerProperty();

    public HinhThucQuangCao() {

    }

    public HinhThucQuangCao(int ma_hinh_thuc , String ten ,int gia  ){
        this.ma_hinh_thuc.set(ma_hinh_thuc );
        this.ten.set(ten );
        this.gia.set(gia  );
        // this.MADV.set(MADV);
    }

    // Getters and setters
    public int getma_hinh_thuc (){
        return ma_hinh_thuc.get();
    }

    public void setma_hinh_thuc (int ma_hinh_thuc ){
        this.ma_hinh_thuc.set(ma_hinh_thuc );
    }

    public SimpleIntegerProperty ma_hinh_thucproperty(){
        return ma_hinh_thuc ;
    }

    public String getten (){
        return ten.get();
    }

    public void setten (String ten ){
        this.ten.set(ten);
    }

    public SimpleStringProperty tenproperty(){
        return ten ;
    }


    public int getgia() {
        return gia.get();
    }

    public void setgia  (int gia  ) {
        this.gia.set(gia);
    }

    public SimpleIntegerProperty giaproperty(){
        return gia  ;
    }

}


