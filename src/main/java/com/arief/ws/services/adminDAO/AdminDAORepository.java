package com.arief.ws.services.adminDAO;

import com.arief.ws.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAORepository implements AdminDAO{

    @Autowired
    private JdbcTemplate jdbc;

    public Admin getOne(String kode) {
        String sql = "select * from admin where kode = ? ";

        Admin a = jdbc.queryForObject(sql,new BeanPropertyRowMapper<Admin>(Admin.class),kode);

        return a;
    }

    public Admin getOneByAllProperties(String kode, String password) {
        String sql = "select * from admin where kode = ? and password = ? ";
        Admin a = jdbc.queryForObject(sql,new BeanPropertyRowMapper<Admin>(Admin.class),kode,password);

        return a;
    }
}
