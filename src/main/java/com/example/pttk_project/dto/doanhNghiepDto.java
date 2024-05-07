package com.example.pttk_project.dto;

public class doanhNghiepDto {
    int ma_dn;
   String ten_cty;
   int ms_thue;
   String dia_chi;
   String dai_dien;
   String email;

    public doanhNghiepDto(){

    }

   public doanhNghiepDto(String ten_cty, int ms_thue, String dia_chi, String dai_dien, String email){
       this.ten_cty = ten_cty;
       this.ms_thue = ms_thue;
       this.dia_chi = dia_chi;
       this.dai_dien = dai_dien;
       this.email = email;
   }

    public doanhNghiepDto(int maDN, String ten) {
        this.ma_dn = maDN;
        this.ten_cty = ten;
    }

    public int getMa_dn() {
        return ma_dn;
    }

    public void setMa_dn(int ma_dn) {
        this.ma_dn = ma_dn;
    }

    public String getTen_cty() {
        return ten_cty;
    }

    public void setTen_cty(String ten_cty) {
        this.ten_cty = ten_cty;
    }

    public int getMs_thue() {
        return ms_thue;
    }

    public void setMs_thue(int ms_thue) {
        this.ms_thue = ms_thue;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public String getDai_dien() {
        return dai_dien;
    }

    public void setDai_dien(String dai_dien) {
        this.dai_dien = dai_dien;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
