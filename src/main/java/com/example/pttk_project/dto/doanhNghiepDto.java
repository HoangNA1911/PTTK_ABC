package com.example.pttk_project.dto;

public class doanhNghiepDto {
   String ten_cty;
   String ms_thue;
   String dia_chi;
   String dai_dien;
   String email;

   doanhNghiepDto(String ten_cty, String ms_thue, String dia_chi, String dai_dien,  String email){
       this.ten_cty = ten_cty;
       this.ms_thue = ms_thue;
       this.dia_chi = dia_chi;
       this.dai_dien = dai_dien;
       this.email = email;
   }
    public String getTen_cty() {
        return ten_cty;
    }

    public void setTen_cty(String ten_cty) {
        this.ten_cty = ten_cty;
    }

    public String getMs_thue() {
        return ms_thue;
    }

    public void setMs_thue(String ms_thue) {
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
