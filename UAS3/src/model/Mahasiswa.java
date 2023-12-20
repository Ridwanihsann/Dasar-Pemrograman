package model;

public class Mahasiswa {
    private String idMahasiswa;
    private String nama;
    private String email;
    private boolean tersedia;

    public Mahasiswa setIdMahasiswa(String idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
        return this;
    }
    public Mahasiswa setNama(String nama) {
        this.nama = nama;
        return this;
    }
    public Mahasiswa setEmail(String email) {
        this.email = email;
        return this;
    }
    public Mahasiswa setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
        return this;
    }


    public String getIdMahasiswa() {
        return idMahasiswa;
    }
    public String getNama() {
        return nama;
    }
    public String getEmail() {
        return email;
    }
    public boolean isTersedia() {
        return tersedia;
    }

}