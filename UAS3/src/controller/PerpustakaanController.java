package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Map.Entry;

import model.Mahasiswa;
import model.Buku;
import model.Peminjaman;

public class PerpustakaanController {
    private HashMap<String, Buku> daftarBuku = new HashMap<>();
    private HashMap<String, Mahasiswa> daftarMahasiswa = new HashMap<>();
    private ArrayList<Peminjaman> daftarPeminjaman = new ArrayList<>();

    public void Data() {
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

        Mahasiswa mahasiswa1 = new Mahasiswa();
        Mahasiswa mahasiswa2 = new Mahasiswa();

        mahasiswa1.setIdMahasiswa("01").setNama("ucok").setEmail("ucok@gmail.com").setTersedia(true);
        mahasiswa2.setIdMahasiswa("02").setNama("baba").setEmail("baba@gmail.com").setTersedia(true);
        
        daftarMahasiswa.put(mahasiswa1.getIdMahasiswa(), mahasiswa1);
        daftarMahasiswa.put(mahasiswa2.getIdMahasiswa(), mahasiswa2);
    }


    public Buku getBuku(String idBuku) {
        return daftarBuku.get(idBuku);
    }

    public Mahasiswa getMahasiswa(String idMahasiswa) {
        return daftarMahasiswa.get(idMahasiswa);
    }


    public void menuPinjamBuku() {
        Scanner input = new Scanner(System.in);
        // PerpustakaanController lap = new PerpustakaanController();
        ArrayList<Peminjaman> daftarPeminjaman = new ArrayList<>();
        // String lanjut = "";
        System.out.print("\nMasukkan ID Buku yang ingin dipinjam: ");
        String idBuku = input.nextLine();

        System.out.print("Masukkan NIM: ");
        String idMahasiswa = input.nextLine();

        pinjamBuku(idBuku, idMahasiswa);
        // lap.tampilkanLaporanPeminjaman();

    }

    public void menuKembalikanBuku() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nMasukkan ID Peminjaman yang ingin dikembalikan: ");
        String idPeminjaman = input.nextLine();

        kembalikanBuku(idPeminjaman);
    }



    public void pinjamBuku(String idBuku, String idMahasiswa) {
        Buku buku = daftarBuku.get(idBuku);
        Mahasiswa mahasiswa = daftarMahasiswa.get(idMahasiswa);
        // PerpustakaanController lap = new PerpustakaanController();

        if (buku != null && mahasiswa != null && buku.isTersedia()) {
            Peminjaman peminjaman = new Peminjaman("P" + (daftarPeminjaman.size() + 1), buku, mahasiswa);
            daftarPeminjaman.add(peminjaman);
            buku.setTersedia(false);
            System.out.println("\nPeminjaman berhasil. ID Peminjaman: " + peminjaman.getIdPeminjaman());
            
            // System.out.println("\n=== Laporan Peminjaman ===\n");
            // System.out.println("ID Peminjaman: " + peminjaman.getIdPeminjaman());
            // System.out.println("Tanggal Pinjam: " + peminjaman.getTanggalPinjam());
            // System.out.println("Buku: " + peminjaman.getBuku().getJudul());
            // System.out.println("Mahasiswa: " + peminjaman.getMahasiswa().getNama());
            // System.out.println("=================================");
        

        } else {
            System.out.println("\n=== !!! Peminjaman gagal. Pastikan buku tersedia dan Mahasiswa terdaftar.!!! ===");
        }
        // System.out.println("lanjut meminjam? ");
       
        // lap.tampilkanLaporanPeminjaman();
    }

    public void kembalikanBuku(String idPeminjaman) {
        for (Peminjaman peminjaman : daftarPeminjaman) {
            if (peminjaman.getIdPeminjaman().equalsIgnoreCase(idPeminjaman) && !peminjaman.isSudahDikembalikan()) {
                peminjaman.setSudahDikembalikan(true);
                peminjaman.getBuku().setTersedia(true);
                peminjaman.setTanggalKembali(LocalDate.now());
                System.out.println("\nPengembalian berhasil. Terima kasih!");
                return;
            }
        }
        System.out.println("\nPengembalian gagal. Pastikan ID peminjaman valid.");
    }

    public void tampilkanLaporanPeminjaman() {
        System.out.println("=== Laporan Peminjaman ===");
        for (Peminjaman peminjaman : daftarPeminjaman) {
            System.out.println("ID Peminjaman\t: " + peminjaman.getIdPeminjaman());
            System.out.println("Tanggal Pinjam\t: " + peminjaman.getTanggalPinjam());
            System.out.println("Buku\t\t: " + peminjaman.getBuku().getJudul());
            System.out.println("Nama\t\t: " + peminjaman.getMahasiswa().getNama());
            System.out.println("=================================");
        }
    }

    public void tampilkanDaftarBukuTersedia() {
        System.out.println("\n=== Daftar Buku Tersedia ===\n");
        for (Map.Entry<String, Buku> entry : daftarBuku.entrySet()) {
            Buku buku = entry.getValue();
            if (buku.isTersedia()) {
                System.out.println("ID Buku\t\t: " + buku.getIdBuku());
                System.out.println("Judul\t\t: " + buku.getJudul());
                System.out.println("Pengarang\t: " + buku.getPengarang());
                System.out.println("===============================");
            }
        }
    }
    public void tampilkanDaftarMahasiswa() {
        System.out.println("\n=== Daftar Mahasiswa ===\n");
        for (Entry<String, Mahasiswa> entry : daftarMahasiswa.entrySet()) {
            Mahasiswa Mahasiswa = entry.getValue();
            if (Mahasiswa.isTersedia()) {
                System.out.println("NIM\t: " + Mahasiswa.getIdMahasiswa());
                System.out.println("Nama\t: " + Mahasiswa.getNama());
                System.out.println("Email\t: " + Mahasiswa.getEmail());
                System.out.println("===============================");
            }
        }
    }
}