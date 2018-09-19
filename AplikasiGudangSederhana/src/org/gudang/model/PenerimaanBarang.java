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
@Table(name = "penerimaanbarang")
//@Table(name = "barang")
public class PenerimaanBarang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPenerimaanBarang")
    private int id;
    @Column(name = "idBarang")
    String idB;
    @Column(name = "idStaff")
    String idS;

    @Column(name = "jumlah")
    String jumlahBarang;
    @Column(name = "tanggal")
    String tanggal;
    @Column(name = "satuan")
    String satuanBarang;

    public PenerimaanBarang() {
    }

    public PenerimaanBarang(int id, String idB, String idS, String jumlahBarang, String tanggal, String satuanBarang) {
        this.id = id;
        this.idB = idB;
        this.idS = idS;
        this.jumlahBarang = jumlahBarang;
        this.tanggal = tanggal;
        this.satuanBarang = satuanBarang;
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
