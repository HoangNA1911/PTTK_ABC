package com.example.pttk_project.dto;

//package dto;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.ObjectProperty;
import java.sql.Timestamp;
//doi ten file

//DTO for ViTriUngTuyen table
public class ViTriUngTuyenDto {
    private final SimpleIntegerProperty ma_vi_tri  = new SimpleIntegerProperty();
    private final SimpleStringProperty ten = new SimpleStringProperty();


    public ViTriUngTuyenDto(){

    }

    public ViTriUngTuyenDto(int ma_vi_tri, String ten){
        this.ma_vi_tri.set(ma_vi_tri);
        this.ten.set(ten);

    }
    // Getters and setters
    public int getma_vi_tri(){
        return ma_vi_tri.get();
    }

    public void setma_vi_tri(int ma_vi_tri){
        this.ma_vi_tri.set(ma_vi_tri);
    }

    public SimpleIntegerProperty ma_vi_triproperty(){
        return ma_vi_tri;
    }

    public String getten(){
        return ten.get();
    }

    public void setten(String ten){
        this.ten.set(ten);
    }

    public SimpleStringProperty tenproperty(){
        return ten;
    }




}