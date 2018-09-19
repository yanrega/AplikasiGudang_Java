/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gudang.Dao.impl;

import java.util.List;
import org.gudang.Dao.PengeluaranBarangDao;
import org.gudang.model.PengeluaranBarang;
import org.gudang.model.Reservasi;
import org.gudang.util.HibernateUtil;
import org.hibernate.Session;

public class PengeluaranBarangDaoImplHibernate implements PengeluaranBarangDao {

    @Override
    public void saveDataPengeluaranBarang(PengeluaranBarang pb) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(pb);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public PengeluaranBarang getDataPengeluaranBarangBarang(int id) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        PengeluaranBarang pengeluaranBarang = (PengeluaranBarang) session.get(PengeluaranBarang.class, id);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return pengeluaranBarang;
    }

    @Override
    public List<PengeluaranBarang> getAllPengeluaranBarang() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<PengeluaranBarang> simpans = session.createCriteria(PengeluaranBarang.class).list();
        session.getTransaction().commit();
        return simpans;
    }

//    @Override
//    public void deleteReservasi(int id) {
//        for (Reservasi reservasi :get) {
//            
//        }
//    }

    @Override
    public void konfirmasi(String tujuan,int id) {
        for (PengeluaranBarang pengeluaranBarang : getAllPengeluaranBarang()) {
            if (pengeluaranBarang.getTujuan().equalsIgnoreCase(tujuan)) {
                Session session=HibernateUtil.getSession();
                session.getTransaction().begin();
                pengeluaranBarang.setId(pengeluaranBarang.getId());
                pengeluaranBarang.setJumlahBarang(pengeluaranBarang.getJumlahBarang());
                pengeluaranBarang.setTujuan(pengeluaranBarang.getTujuan());
                session.update(pengeluaranBarang);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

}
