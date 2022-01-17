package com.example.logincallapi;

import java.io.Serializable;

public class User implements Serializable {
    String SoDienThoai;
    String PassWord;
    int DonVi;
    String MaMay;
    String MaHeDieuHanh;
    String TokenFirebase;

    public User(String soDienThoai, String passWord, int donVi, String maMay, String maHeDieuHanh, String tokenFirebase) {
        SoDienThoai = soDienThoai;
        PassWord = passWord;
        DonVi = donVi;
        MaMay = maMay;
        MaHeDieuHanh = maHeDieuHanh;
        TokenFirebase = tokenFirebase;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        SoDienThoai = soDienThoai;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public int getDonVi() {
        return DonVi;
    }

    public void setDonVi(int donVi) {
        DonVi = donVi;
    }

    public String getMaMay() {
        return MaMay;
    }

    public void setMaMay(String maMay) {
        MaMay = maMay;
    }

    public String getMaHeDieuHanh() {
        return MaHeDieuHanh;
    }

    public void setMaHeDieuHanh(String maHeDieuHanh) {
        MaHeDieuHanh = maHeDieuHanh;
    }

    public String getTokenFirebase() {
        return TokenFirebase;
    }

    public void setTokenFirebase(String tokenFirebase) {
        TokenFirebase = tokenFirebase;
    }
}
