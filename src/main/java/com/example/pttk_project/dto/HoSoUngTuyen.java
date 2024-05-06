package com.example.pttk_project.dto;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.ObjectProperty;

import java.sql.Blob;

public class HoSoUngTuyen {
    private final SimpleIntegerProperty ma_ho_so  = new SimpleIntegerProperty();
    private final SimpleStringProperty trang_thai  = new SimpleStringProperty();
    private final SimpleIntegerProperty level  = new SimpleIntegerProperty();
    private final SimpleObjectProperty<Blob> cv  = new SimpleObjectProperty<>();
    private final SimpleIntegerProperty ma_ung_vien = new SimpleIntegerProperty();
    private final SimpleIntegerProperty ma_thong_tin   = new SimpleIntegerProperty();

    private final ObjectProperty<UngVien> UngVienProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<ThongTinDangTuyen> ThongTinDangTuyenProperty = new SimpleObjectProperty<>();



    public HoSoUngTuyen() {

    }

    public HoSoUngTuyen(int ma_ho_so , String trang_thai , int level , Blob cv , int ma_ung_vien, int ma_thong_tin  ){
        this.ma_ho_so.set(ma_ho_so );
        this.trang_thai.set(trang_thai );
        this.level.set(level );
        this.cv.set(cv );
        this.ma_ung_vien.set(ma_ung_vien);
        this.ma_thong_tin.set(ma_thong_tin  );
        // this.MADV.set(MADV);
    }

    // Getters and setters
    public int getma_ho_so (){
        return ma_ho_so.get();
    }

    public void setma_ho_so (int ma_ho_so ){
        this.ma_ho_so .set(ma_ho_so );
    }

    public SimpleIntegerProperty ma_ho_soproperty(){
        return ma_ho_so ;
    }

    public String gettrang_thai (){
        return trang_thai.get();
    }

    public void settrang_thai (String trang_thai ){
        this.trang_thai.set(trang_thai );
    }

    public SimpleStringProperty trang_thaiproperty(){
        return trang_thai ;
    }

    public int getlevel () {
        return level.get();
    }

    public void setlevel (int level ) {
        this.level .set(level );
    }

    public SimpleIntegerProperty levelproperty(){
        return level ;
    }

    public Blob getcv () {
        return cv.get();
    }

    public void setcv (Blob cv ) {
        this.cv.set(cv);
    }

    public SimpleObjectProperty<Blob> cvproperty(){
        return cv ;
    }

    public int getma_ung_vien() {
        return ma_ung_vien.get();
    }

    public void setma_ung_vien(int ma_ung_vien) {
        this.ma_ung_vien.set(ma_ung_vien);
    }

    public SimpleIntegerProperty ma_ung_vienproperty(){
        return ma_ung_vien;
    }

    public int getma_thong_tin() {
        return ma_thong_tin.get();
    }

    public void setma_thong_tin  (int ma_thong_tin  ) {
        this.ma_thong_tin.set(ma_thong_tin);
    }

    public SimpleIntegerProperty ma_thong_tinproperty(){
        return ma_thong_tin  ;
    }

    public UngVien getUngVien() {
        return UngVienProperty.get();
    }

    public void setUngVien  (UngVien UngVien  ) {
        this.UngVienProperty.set(UngVien);
    }

    public ObjectProperty<UngVien> UngVienproperty(){
        return UngVienProperty  ;
    }

    public ThongTinDangTuyen getThongTinDangTuyen() {
        return ThongTinDangTuyenProperty.get();
    }

    public void setThongTinDangTuyen  (ThongTinDangTuyen ThongTinDangTuyen  ) {
        this.ThongTinDangTuyenProperty.set(ThongTinDangTuyen);
    }

    public ObjectProperty<ThongTinDangTuyen> ThongTinDangTuyenproperty(){
        return ThongTinDangTuyenProperty  ;
    }

}
