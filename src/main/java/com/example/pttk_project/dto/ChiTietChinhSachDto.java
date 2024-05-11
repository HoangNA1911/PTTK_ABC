package com.example.pttk_project.dto;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class ChiTietChinhSachDto {
    private final SimpleIntegerProperty ma_chinh_sach  = new SimpleIntegerProperty();
    private final SimpleObjectProperty<LocalDate> ngay_bd  = new SimpleObjectProperty<>();
    private final SimpleObjectProperty<LocalDate> ngay_kt  = new SimpleObjectProperty<>();
    private final ObjectProperty<doanhNghiepDto> DoanhNghiepProperty = new SimpleObjectProperty<>();

    public ChiTietChinhSachDto() {

    }

    public ChiTietChinhSachDto(LocalDate ngay_bd , LocalDate ngay_kt, int ma_chinh_sach){
        this.ngay_bd.set(ngay_bd );
        this.ngay_kt.set(ngay_kt );
        this.ma_chinh_sach.set(ma_chinh_sach );

    }

    // Getters and setters
    public LocalDate getngay_bd (){
        return ngay_bd.get();
    }

    public void setngay_bd (LocalDate ngay_bd ){
        this.ngay_bd .set(ngay_bd );
    }

    public SimpleObjectProperty<LocalDate> ngay_bdproperty(){
        return ngay_bd ;
    }

    public LocalDate getngay_kt (){
        return ngay_kt.get();
    }

    public void setngay_kt (LocalDate ngay_kt ){
        this.ngay_kt.set(ngay_kt );
    }

    public SimpleObjectProperty<LocalDate> ngay_ktproperty(){
        return ngay_kt ;
    }

    public int ma_chinh_sach (){
        return ma_chinh_sach.get();
    }

    public void setma_chinh_sach (int ma_chinh_sach ){
        this.ma_chinh_sach.set(ma_chinh_sach );
    }

    public SimpleIntegerProperty ma_chinh_sachproperty(){
        return ma_chinh_sach ;
    }
    public doanhNghiepDto getDoanhNghiep() {
        return DoanhNghiepProperty.get();
    }

    public void setDoanhNghiep(doanhNghiepDto DoanhNghiep) {
        this.DoanhNghiepProperty.set(DoanhNghiep);
    }

    public ObjectProperty<doanhNghiepDto> DoanhNghiepProperty() {
        return DoanhNghiepProperty;
    }


}
