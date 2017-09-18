package com.arief.ws.services.adminDAO;

import com.arief.ws.domain.Admin;

public interface AdminDAO {
    Admin getOne(String kode);
    Admin getOneByAllProperties(String kode,String password);
}
