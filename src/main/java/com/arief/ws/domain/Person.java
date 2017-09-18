package com.arief.ws.domain;

public class Person {


    private int id;
    private String nama;
    private String alamat;


    public Person(){}


    public Person(int id, String nama, String alamat) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
    }

    public Person(String nama, String alamat){
        this.nama=nama;
        this.alamat=alamat;
    }

    public void setId(int id){
        this.id=id;
    }
    public void setNama(String nama){
        this.nama=nama;
    }
    public void setAlamat(String alamat){
        this.alamat=alamat;
    }

    public int getId(){
        return id;
    }
    public String getNama(){
        return nama;
    }
    public String getAlamat(){
        return alamat;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", alamat='" + alamat + '\'' +
                '}';
    }
}
