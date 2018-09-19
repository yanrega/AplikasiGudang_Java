/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gudang.Dao;

import java.util.List;
import org.gudang.model.PengeluaranBarang;

public interface PengeluaranBarangDao {
    public void saveDataPengeluaranBarang(PengeluaranBarang pb);
    public PengeluaranBarang getDataPengeluaranBarangBarang(int id);
    public List <PengeluaranBarang> getAllPengeluaranBarang();
    public void konfirmasi(String tujuan,int id);
}
