/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gudang.Dao.impl;

import java.util.List;
import org.gudang.Dao.BarangDao;
import org.gudang.model.Barang;
import org.gudang.util.HibernateUtil;
import org.hibernate.Session;

public class BarangDaoImplHibernate implements BarangDao {

    @Override
    public void saveDataBarang(Barang b) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(b);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public Barang getDataBarang(int id) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Barang barang = (Barang) session.get(Barang.class, id);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return barang;
    }

    @Override
    public List<Barang> getAllBarang() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Barang> simpans = session.createCriteria(Barang.class).list();
        session.getTransaction().commit();
        return simpans;
    }

}
