package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import java.util.Scanner;

import model.Anggota;
import model.Buku;
import model.Peminjaman;

public class PerpustakaanController {
    private HashMap<String, Buku> daftarBuku = new HashMap<>();
    private HashMap<String, Anggota> daftarAnggota = new HashMap<>();
    private ArrayList<Peminjaman> daftarPeminjaman = new ArrayList<>();

    public void inisialisasiDataDummy() {
        Buku buku1 = new Buku();
        Buku buku2 = new Buku();

        buku1
            .setIdBuku("01")
            .setJudul("PPP")
            .setPengarang("Ashon")
            .setTahunTerbit(2000)
            .setTersedia(true);
        buku2
            .setIdBuku("02")
            .setJudul("zzz")
            .setPengarang("aaa")
            .setTahunTerbit(2010)
            .setTersedia(true);

        daftarBuku.put(buku1.getIdBuku(), buku1);
        daftarBuku.put(buku2.getIdBuku(), buku2);

        Anggota anggota1 = new Anggota();
        Anggota anggota2 = new Anggota();

        anggota1.setIdAnggota("01").setNama("ucok").setEmail("aaa@gmail.com");
        anggota2.setIdAnggota("02").setNama("baba").setEmail("baba@gmail.com");
        
        daftarAnggota.put(anggota1.getIdAnggota(), anggota1);
        daftarAnggota.put(anggota2.getIdAnggota(), anggota2);
    }


    public Buku getBuku(String idBuku) {
        return daftarBuku.get(idBuku);
    }

    public Anggota getAnggota(String idAnggota) {
        return daftarAnggota.get(idAnggota);
    }


    public void menuPinjamBuku() {
        Scanner input = new Scanner(System.in);
        ArrayList<Peminjaman> daftarPeminjaman = new ArrayList<>();
        String lanjut = "";
        System.out.print("Masukkan ID Buku yang ingin dipinjam: ");
        String idBuku = input.nextLine();

        System.out.print("Masukkan ID Anggota: ");
        String idAnggota = input.nextLine();

        pinjamBuku(idBuku, idAnggota);
    }

    public void menuKembalikanBuku() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan ID Peminjaman yang ingin dikembalikan: ");
        String idPeminjaman = input.nextLine();

        kembalikanBuku(idPeminjaman);
    }



    public void pinjamBuku(String idBuku, String idAnggota) {
        Buku buku = daftarBuku.get(idBuku);
        Anggota anggota = daftarAnggota.get(idAnggota);

        if (buku != null && anggota != null && buku.isTersedia()) {
            Peminjaman peminjaman = new Peminjaman("P" + (daftarPeminjaman.size() + 1), buku, anggota);
            daftarPeminjaman.add(peminjaman);
            buku.setTersedia(false);
            System.out.println("Peminjaman berhasil. ID Peminjaman: " + peminjaman.getIdPeminjaman());
        } else {
            System.out.println("Peminjaman gagal. Pastikan buku tersedia dan anggota terdaftar.");
        }
    }

    public void kembalikanBuku(String idPeminjaman) {
        for (Peminjaman peminjaman : daftarPeminjaman) {
            if (peminjaman.getIdPeminjaman().equals(idPeminjaman) && !peminjaman.isSudahDikembalikan()) {
                peminjaman.setSudahDikembalikan(true);
                peminjaman.getBuku().setTersedia(true);
                peminjaman.setTanggalKembali(LocalDate.now());
                System.out.println("Pengembalian berhasil. Terima kasih!");
                return;
            }
        }
        System.out.println("Pengembalian gagal. Pastikan ID peminjaman valid.");
    }

    public void tampilkanLaporanPeminjaman() {
        System.out.println("=== Laporan Peminjaman ===");
        for (Peminjaman peminjaman : daftarPeminjaman) {
            System.out.println("ID Peminjaman: " + peminjaman.getIdPeminjaman());
            System.out.println("Tanggal Pinjam: " + peminjaman.getTanggalPinjam());
            System.out.println("Buku: " + peminjaman.getBuku().getJudul());
            System.out.println("Anggota: " + peminjaman.getAnggota().getNama());
            System.out.println("=================================");
        }
    }

    public void tampilkanDaftarBukuTersedia() {
        System.out.println("\n=== Daftar Buku Tersedia ===\n");
        for (Map.Entry<String, Buku> entry : daftarBuku.entrySet()) {
            Buku buku = entry.getValue();
            if (buku.isTersedia()) {
                System.out.println("ID Buku: " + buku.getIdBuku());
                System.out.println("Judul: " + buku.getJudul());
                System.out.println("Pengarang: " + buku.getPengarang());
                System.out.println("===============================");
            }
        }
    }
}