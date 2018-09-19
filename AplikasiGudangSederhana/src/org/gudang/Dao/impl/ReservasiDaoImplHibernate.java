/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gudang.Dao.impl;

import java.util.List;
import org.gudang.Dao.ReservasiDao;
import org.gudang.model.Reservasi;
import org.gudang.util.HibernateUtil;
import org.hibernate.Session;

public class ReservasiDaoImplHibernate implements ReservasiDao {

    @Override
    public void saveDataReservasi(Reservasi r) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(r);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public Reservasi getDataReservasi(int id) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Reservasi reservasi = (Reservasi) session.get(Reservasi.class, id);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return reservasi;
    }

    @Override
    public List<Reservasi> getAllReservasi() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Reservasi> simpans = session.createCriteria(Reservasi.class).list();
        session.getTransaction().commit();
        return simpans;
    }

    @Override
    public void deleteReservasi(int id) {
        for (Reservasi reservasi : getAllReservasi()) {
            if (reservasi.getId() == id) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                session.delete(reservasi);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

    @Override
    public String getTujuan(int id) {
        String str = null;
        for (Reservasi reservasi : getAllReservasi()) {
            if (reservasi.getId() == id) {
                str = reservasi.getTujuan();
                break;
            }
        }
        return str;
    }
}
