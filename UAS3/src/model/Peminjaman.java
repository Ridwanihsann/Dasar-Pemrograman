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








    // public void setIdPeminjaman(String idPeminjaman) {
    //     this.idPeminjaman = idPeminjaman;
    // }
    // public void setBuku(Buku buku) {
    //     this.buku = buku;
    // }
    // public void setAnggota(Mahasiswa mahasiswa) {
    //     this.anggota = anggota;
    // }
    // public void setTanggalPinjam(LocalDate tanggalPinjam) {
    //     this.tanggalPinjam = tanggalPinjam;
    // }
    // public void setTanggalKembali(LocalDate tanggalKembali) {
    //     this.tanggalKembali = tanggalKembali;
    // }
    // public void setSudahDikembalikan(boolean sudahDikembalikan) {
    //     this.sudahDikembalikan = sudahDikembalikan;
    // }


    // public String getIdPeminjaman() {
    //     return idPeminjaman;
    // }
    // public Buku getBuku() {
    //     return buku;
    // }
    // public Mahasiswa getAnggota() {
    //     return anggota;
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
