/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gudang.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pengeluaranbarang")

public class PengeluaranBarang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPengeluaranBarang")
    private int id;
    @Column(name = "idReservasi")
    int idR;
    @Column(name = "idBarang")
    String idB;
    @Column(name = "idStaff")
    String idS;
    @Column(name = "jumlahBarang")
    String jumlahBarang;
    @Column(name = "tanggal")
    String tanggal;
    @Column(name = "satuan")
    String satuanBarang;
    @Column(name = "tujuan")
    String tujuan;

    public PengeluaranBarang() {
    }

    public PengeluaranBarang(int id, int idR, String idB, String idS, String jumlahBarang, String tanggal, String satuanBarang, String tujuan) {
        this.id = id;
        this.idR = idR;
        this.idB = idB;
        this.idS = idS;
        this.jumlahBarang = jumlahBarang;
        this.tanggal = tanggal;
        this.satuanBarang = satuanBarang;
        this.tujuan = tujuan;
    }

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    
    

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdB() {
        return idB;
    }

    public void setIdB(String idB) {
        this.idB = idB;
    }

    public String getIdS() {
        return idS;
    }

    public void setIdS(String idS) {
        this.idS = idS;
    }


    public String getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(String jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getSatuanBarang() {
        return satuanBarang;
    }

    public void setSatuanBarang(String satuanBarang) {
        this.satuanBarang = satuanBarang;
    }

}
