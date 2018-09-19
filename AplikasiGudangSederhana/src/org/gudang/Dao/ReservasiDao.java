/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gudang.Dao;

import java.util.List;
import org.gudang.model.Reservasi;

public interface ReservasiDao {
 public void saveDataReservasi(Reservasi r);
    public Reservasi getDataReservasi(int id);
    public List <Reservasi> getAllReservasi();   
    public void deleteReservasi(int id);
    public String getTujuan(int id);
}
