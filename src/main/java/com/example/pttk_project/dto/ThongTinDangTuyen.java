package com.example.pttk_project.dto;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.ObjectProperty;
import java.time.LocalDate;


//doi ten file
public class ThongTinDangTuyen  {
    private final SimpleIntegerProperty ma_thong_tin = new SimpleIntegerProperty();
    private final SimpleIntegerProperty ma_doanh_nghiep = new SimpleIntegerProperty();
    private final SimpleIntegerProperty ma_vi_tri = new SimpleIntegerProperty();
    private final SimpleIntegerProperty so_luong = new SimpleIntegerProperty();
    private final  SimpleObjectProperty<LocalDate> ngay_bat_dau = new  SimpleObjectProperty<>();
    private final SimpleStringProperty yeu_cau = new SimpleStringProperty();
    private final SimpleIntegerProperty ma_hinh_thuc = new SimpleIntegerProperty();
    private final SimpleObjectProperty<LocalDate> ngay_het_han = new  SimpleObjectProperty<>();
    private final SimpleIntegerProperty tiem_nang = new SimpleIntegerProperty();
    private final ObjectProperty<doanhNghiepDto> DoanhNghiepProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<ViTriUngTuyen> ViTriUngTuyenProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<HinhThucQuangCao> HinhThucQuangCaoProperty = new SimpleObjectProperty<>();


    public ThongTinDangTuyen (){

    }

    public ThongTinDangTuyen (int ma_thong_tin, int ma_doanh_nghiep, int ma_vi_tri, int so_luong, LocalDate ngay_bat_dau, String yeu_cau, int ma_hinh_thuc, LocalDate ngay_het_han, int tiem_nang){
        this.ma_thong_tin.set(ma_thong_tin);
        this.ma_vi_tri.set(ma_vi_tri);
        this.so_luong.set(so_luong);
        this.ngay_bat_dau.set(ngay_bat_dau);
        this.yeu_cau.set(yeu_cau);
        this.ma_hinh_thuc.set(ma_hinh_thuc);
        this.ngay_het_han.set(ngay_het_han);
        this.tiem_nang.set(tiem_nang);
    }

    public int getma_thong_tin(){
        return ma_thong_tin.get();
    }
    public void setma_thong_tin(int ma_thong_tin){
        this.ma_thong_tin.set(ma_thong_tin);
    }
    public SimpleIntegerProperty ma_thong_tinproperty(){
        return ma_thong_tin;
    }

    public int getma_doanh_nghiep(){
        return ma_doanh_nghiep.get();
    }
    public void setma_doanh_nghiep(int ma_doanh_nghiep){
        this.ma_doanh_nghiep.set(ma_doanh_nghiep);
    }
    public SimpleIntegerProperty ma_doanh_nghiepproperty(){
        return ma_doanh_nghiep;
    }

    public int getma_vi_tri(){
        return ma_vi_tri.get();
    }
    public void setma_vi_tri(int ma_vi_tri){
        this.ma_vi_tri.set(ma_vi_tri);
    }
    public SimpleIntegerProperty ma_vi_triproperty(){
        return ma_vi_tri;
    }

    public int getso_luong(){
        return so_luong.get();
    }
    public void setso_luong(int so_luong){
        this.so_luong.set(so_luong);
    }
    public SimpleIntegerProperty so_luongproperty(){
        return so_luong;
    }

    public LocalDate getngay_bat_dau(){
        return ngay_bat_dau.get();
    }
    public void setngay_bat_dau(LocalDate ngay_bat_dau){
        this.ngay_bat_dau.set(ngay_bat_dau);
    }
    public SimpleObjectProperty<LocalDate>  ngay_bat_dauproperty(){
        return ngay_bat_dau;
    }

    public String getyeu_cau(){
        return yeu_cau.get();
    }
    public void setyeu_cau(String yeu_cau){
        this.yeu_cau.set(yeu_cau);
    }
    public SimpleStringProperty yeu_cauproperty(){
        return yeu_cau;
    }
    public int getma_hinh_thuc() {
        return ma_hinh_thuc.get();
    }

    public void setma_hinh_thuc(int ma_hinh_thuc) {
        this.ma_hinh_thuc.set(ma_hinh_thuc);
    }

    public SimpleIntegerProperty ma_hinh_thucproperty(){
        return ma_hinh_thuc;
    }
    public LocalDate getngay_het_han() {
        return ngay_het_han.get();
    }

    public void setngay_het_han(LocalDate ngay_het_han) {
        this.ngay_het_han.set(ngay_het_han);
    }

    public SimpleObjectProperty<LocalDate>  ngay_het_hanproperty(){
        return ngay_het_han;
    }
    public int gettiem_nang() {
        return tiem_nang.get();
    }

    public void settiem_nang(int tiem_nang) {
        this.tiem_nang.set(tiem_nang);
    }

    public SimpleIntegerProperty tiem_nangproperty(){
        return tiem_nang;
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

    public ViTriUngTuyen getViTriUngTuyen() {
        return ViTriUngTuyenProperty.get();
    }

    public void setViTriUngTuyen(ViTriUngTuyen ViTriUngTuyen) {
        this.ViTriUngTuyenProperty.set(ViTriUngTuyen);
    }

    public ObjectProperty<ViTriUngTuyen> ViTriUngTuyenProperty() {
        return ViTriUngTuyenProperty;
    }

    public HinhThucQuangCao getHinhThucQuangCao() {
        return HinhThucQuangCaoProperty.get();
    }

    public void setHinhThucQuangCao(HinhThucQuangCao HinhThucQuangCao) {
        this.HinhThucQuangCaoProperty.set(HinhThucQuangCao);
    }

    public ObjectProperty<HinhThucQuangCao> HinhThucQuangCaoProperty() {
        return HinhThucQuangCaoProperty;
    }

}
