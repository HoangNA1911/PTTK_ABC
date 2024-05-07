package com.example.pttk_project.dto;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ChinhSachDto {
    private final SimpleIntegerProperty ma_chinh_sach  = new SimpleIntegerProperty();
    private final SimpleStringProperty mo_ta  = new SimpleStringProperty();


    public ChinhSachDto() {

    }

    public ChinhSachDto(int ma_chinh_sach , String mo_ta , String ms_thue , String dia_chi , String SOTIETTH, String email  ){
        this.ma_chinh_sach.set(ma_chinh_sach );
        this.mo_ta.set(mo_ta );

    }

    // Getters and setters
    public int getma_chinh_sach (){
        return ma_chinh_sach.get();
    }

    public void setma_chinh_sach (int ma_chinh_sach ){
        this.ma_chinh_sach .set(ma_chinh_sach );
    }

    public SimpleIntegerProperty ma_chinh_sachproperty(){
        return ma_chinh_sach ;
    }

    public String getmo_ta (){
        return mo_ta.get();
    }

    public void setmo_ta (String mo_ta ){
        this.mo_ta.set(mo_ta );
    }

    public SimpleStringProperty mo_taproperty(){
        return mo_ta ;
    }



}
