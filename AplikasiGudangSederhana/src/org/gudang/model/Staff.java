package org.gudang.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="staffgudang")
public class Staff 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;
    @Column(name ="nama")
    private String nama;
    @Column(name ="nomorHp")
    private String nomorHp;
    @Column(name ="alamat")
    private String alamat;
    @Column(name ="username")
    private String username;
    @Column(name ="password")
    private String password;    

    public Staff(int id, String nama, String nomorHp, String alamat, String username, String password) {
        this.id = id;
        this.nama = nama;
        this.nomorHp = nomorHp;
        this.alamat = alamat;
        this.username = username;
        this.password = password;
    }
    
    

    
    
    public Staff() 
    {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomorHp() {
        return nomorHp;
    }

    public void setNomorHp(String nomorHp) {
        this.nomorHp = nomorHp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
    
    
}
