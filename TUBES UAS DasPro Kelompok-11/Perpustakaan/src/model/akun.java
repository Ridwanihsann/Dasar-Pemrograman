package model;

public class akun {
    private String nama;
    private String email;
    private boolean terdaftar;
    


    public akun setNama(String nama) {
        this.nama = nama;
        return this;
    }

    public String getNama() {
        return this.nama;
    }

    public akun setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getEmail() {
        return this.email;
    }

    public akun setTerdaftar(boolean terdaftar) {
        this.terdaftar = terdaftar;
        return this;
    }
    public boolean isTerdaftar() {
        return terdaftar;
    }


}