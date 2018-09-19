package org.gudang.Dao;

import java.util.List;
import org.gudang.model.Staff;

public interface StaffDao 
{
    public void saveDataStaff(Staff s);
    public List<Staff> getAllStaff();
    public boolean login(String user, String pass);
}
