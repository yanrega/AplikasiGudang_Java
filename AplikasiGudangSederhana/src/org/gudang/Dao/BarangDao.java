/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gudang.Dao;

import java.util.List;
import org.gudang.model.Barang;

public interface BarangDao {
    public void saveDataBarang(Barang b);
    public Barang getDataBarang(int id);
    public List<Barang> getAllBarang();
    
}
