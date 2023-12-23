package model;

import java.time.LocalDate;

public class Peminjaman {
    private String idPeminjaman;
    private Buku buku;
    private Mahasiswa mahasiswa;
    private LocalDate tanggalPinjam;
    private LocalDate tanggalKembali;
    private boolean sudahDikembalikan;

    public Peminjaman(String idPeminjaman, Buku buku, Mahasiswa mahasiswa) {
        this.idPeminjaman = idPeminjaman;
        this.buku = buku;
        this.mahasiswa = mahasiswa;
        this.tanggalPinjam = LocalDate.now();
        this.sudahDikembalikan = false;
    }

    public String getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(String idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }




    
    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }


    public LocalDate getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(LocalDate tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public LocalDate getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(LocalDate tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public boolean isSudahDikembalikan() {
        return sudahDikembalikan;
    }

    public void setSudahDikembalikan(boolean sudahDikembalikan) {
        this.sudahDikembalikan = sudahDikembalikan;
    }















    






    // public Peminjaman setIdPeminjaman(String idPeminjaman) {
    //     this.idPeminjaman = idPeminjaman;
    //     return this;
    // }
    // public Peminjaman setBuku(Buku buku) {
    //     this.buku = buku;
    //     return this;
    // }
    // public Peminjaman setMahasiswa(Mahasiswa mahasiswa) {
    //     this.mahasiswa = mahasiswa;
    //     return this;
    // }
    // public Peminjaman setTanggalPinjam(LocalDate tanggalPinjam) {
    //     this.tanggalPinjam = tanggalPinjam;
    //     return this;
    // }
    // public Peminjaman setTanggalKembali(LocalDate tanggalKembali) {
    //     this.tanggalKembali = tanggalKembali;
    //     return this;
    // }
    // public Peminjaman setSudahDikembalikan(boolean sudahDikembalikan) {
    //     this.sudahDikembalikan = sudahDikembalikan;
    //     return this;
    // }


    // public String getIdPeminjaman() {
    //     return idPeminjaman;
    // }
    // public Buku getBuku() {
    //     return buku;
    // }
    // public Mahasiswa getMahasiswa() {
    //     return mahasiswa;
    // }
    // public LocalDate getTanggalPinjam() {
    //     return tanggalPinjam;
    // }
    // public LocalDate getTanggalKembali() {
    //     return tanggalKembali;
    // }
    // public boolean isSudahDikembalikan() {
    //     return sudahDikembalikan;
    // }




}
