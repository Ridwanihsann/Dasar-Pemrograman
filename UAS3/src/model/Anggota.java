package model;

public class Anggota {
    private String idAnggota;
    private String nama;
    private String email;

    public Anggota setIdAnggota(String idAnggota) {
        this.idAnggota = idAnggota;
        return this;
    }
    public Anggota setNama(String nama) {
        this.nama = nama;
        return this;
    }
    public Anggota setEmail(String email) {
        this.email = email;
        return this;
    }


    public String getIdAnggota() {
        return idAnggota;
    }
    public String getNama() {
        return nama;
    }
    public String getEmail() {
        return email;
    }

}