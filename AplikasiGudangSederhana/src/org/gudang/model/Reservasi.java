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
@Table(name = "reservasi")
public class Reservasi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReservasi")
    private int id;
    @Column(name = "idBarang")
    String idB;
    @Column(name = "jumlahBarang")
    String jumlahBarang;
    @Column(name = "satuan")
    String satuan;
    @Column(name = "status")
    String status;
    @Column(name = "tujuan")
    String tujuan;

    public Reservasi() {
    }

    public Reservasi(int id, String idB, String jumlahBarang, String satuan, String status, String tujuan) {
        this.id = id;
        this.idB = idB;
        this.jumlahBarang = jumlahBarang;
        this.satuan = satuan;
        this.status = status;
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

    public String getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(String jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    
}
