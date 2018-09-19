/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gudang.Dao.impl;

import java.util.List;
import org.gudang.Dao.PenerimaanBarangDao;
import org.gudang.model.PenerimaanBarang;
import org.gudang.util.HibernateUtil;
import org.hibernate.Session;

public class PenerimaanBarangDaoImplHibernate implements PenerimaanBarangDao{

    @Override
    public void saveDataPenerimaanBarang(PenerimaanBarang pb) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(pb);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public PenerimaanBarang getDataPenerimaanBarang(int id) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        PenerimaanBarang penerimaanBarang = (PenerimaanBarang) session.get(PenerimaanBarang.class, id);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return penerimaanBarang;
    }

    @Override
    public List<PenerimaanBarang> getAllPenerimaanBarang() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<PenerimaanBarang> simpans = session.createCriteria(PenerimaanBarang.class).list();
        session.getTransaction().commit();
        return simpans;
    }
    
}
