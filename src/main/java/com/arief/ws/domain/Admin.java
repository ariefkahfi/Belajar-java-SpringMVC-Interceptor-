package com.arief.ws.domain;

import javax.validation.constraints.NotBlank;

public class Admin {






    @NotBlank(message = "Kode Web Admin tidak boleh kosong")
    private String kode;


    @NotBlank(message = "Password Web Admin tidak boleh kosong")
    private String password;


    public Admin() {
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
