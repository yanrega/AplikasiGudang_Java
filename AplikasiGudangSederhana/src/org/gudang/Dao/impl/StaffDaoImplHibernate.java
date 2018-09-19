package org.gudang.Dao.impl;

import static com.mchange.v2.c3p0.impl.C3P0Defaults.password;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.gudang.Dao.StaffDao;
import org.gudang.model.Staff;
import org.gudang.util.HibernateUtil;

public class StaffDaoImplHibernate implements StaffDao {

    @Override
    public void saveDataStaff(Staff s) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(s);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public List<Staff> getAllStaff() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Staff> staffs = session.createCriteria(Staff.class).list();
        session.getTransaction().commit();
        return staffs;
    }

    Map<String, String> DB = new HashMap<String, String>();
    public static final String SALT = "my-salt-text";

    @Override
    public boolean login(String user, String pass) {
        boolean loginF = false;

        String saltedPassword = SALT + pass;

        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Staff> staffs = getAllStaff();
        for (Staff staff : staffs) {
            if (staff.getUsername().equalsIgnoreCase(user) && staff.getPassword().equalsIgnoreCase(pass)) {
                loginF = true;
                break;
            }
        }
        return loginF;
    }

}
