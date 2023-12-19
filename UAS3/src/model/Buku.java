package model;

public class Buku {
    private String idBuku;
    private String judul;
    private String pengarang;
    private int tahunTerbit;
    private boolean tersedia;
    
    
    public Buku setIdBuku(String idBuku) {
        this.idBuku = idBuku;
        return this;
    }
    public Buku setJudul(String judul) {
        this.judul = judul;
        return this;
    }
    public Buku setPengarang(String pengarang) {
        this.pengarang = pengarang;
        return this;
    }
    public Buku setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
        return this;
    }
    public Buku setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
        return this;
    }

    
    public String getIdBuku() {
        return idBuku;
    }
    public String getJudul() {
        return judul;
    }
    public String getPengarang() {
        return pengarang;
    }
    public int getTahunTerbit() {
        return tahunTerbit;
    }
    public boolean isTersedia() {
        return tersedia;
    }

}
