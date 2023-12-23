package model;

public class Mahasiswa extends akun {
    private String idMahasiswa;
    // private boolean terdaftar;

    public Mahasiswa setIdMahasiswa(String idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
        return this;
    }
    
    public String getIdMahasiswa() {
        return idMahasiswa;
    }
    

}