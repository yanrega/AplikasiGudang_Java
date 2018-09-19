/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gudang.Dao;

import java.util.List;
import org.gudang.model.PenerimaanBarang;

public interface PenerimaanBarangDao {
    public void saveDataPenerimaanBarang(PenerimaanBarang pb);
    public PenerimaanBarang getDataPenerimaanBarang(int id);
    public List <PenerimaanBarang> getAllPenerimaanBarang();
}
