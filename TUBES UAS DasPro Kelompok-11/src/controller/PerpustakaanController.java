// AWAL BAGIAN 1=====
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
import model.akun;

public class PerpustakaanController {
    // Deklarasikan HasMap & ArrayList
    // type<keyword, data> variable
    private HashMap<String, Buku> daftarBuku = new HashMap<>();
    private HashMap<String, Mahasiswa> daftarMahasiswa = new HashMap<>();
    private ArrayList<Peminjaman> daftarPeminjaman = new ArrayList<>();


    public void Data() {
        // Inisialisasi objek
        Buku buku1 = new Buku();
        Buku buku2 = new Buku();
        Buku buku3 = new Buku();
        Buku buku4 = new Buku();
        Buku buku5 = new Buku();

        buku1
            .setIdBuku("01")
            .setJudul("Laskar Pelangi")
            .setPengarang("Andrea Hirata")
            .setTahunTerbit(2005)
            .setTersedia(true);
        buku2
            .setIdBuku("02")
            .setJudul("Sejarah Indonesia Modern")
            .setPengarang("Adrian Vickers")
            .setTahunTerbit(2005)
            .setTersedia(true);
        buku3
            .setIdBuku("03")
            .setJudul("Bumi Manusia")
            .setPengarang("Pramoedya Ananta")
            .setTahunTerbit(1980)
            .setTersedia(true);
        buku4
            .setIdBuku("04")
            .setJudul("Negeri 5 Menara")
            .setPengarang("Ahmad Fuadi")
            .setTahunTerbit(2009)
            .setTersedia(true);
        buku5
            .setIdBuku("05")
            .setJudul("The Birth of Indonesia")
            .setPengarang("R.E. Elson")
            .setTahunTerbit(2003)
            .setTersedia(true);

        daftarBuku.put(buku1.getIdBuku(), buku1);
        daftarBuku.put(buku2.getIdBuku(), buku2);
        daftarBuku.put(buku3.getIdBuku(), buku3);
        daftarBuku.put(buku4.getIdBuku(), buku4);
        daftarBuku.put(buku5.getIdBuku(), buku5);

        Mahasiswa mahasiswa1 = new Mahasiswa();
        Mahasiswa mahasiswa2 = new Mahasiswa();
        Mahasiswa mahasiswa3 = new Mahasiswa();

        mahasiswa1.setIdMahasiswa("01").setNama("Ucok").setEmail("ucok@gmail.com").setTerdaftar(true);
        mahasiswa2.setIdMahasiswa("02").setNama("Baba").setEmail("baba@gmail.com").setTerdaftar(true);
        mahasiswa3.setIdMahasiswa("03").setNama("Udin").setEmail("udin@gmail.com").setTerdaftar(true);
        
        daftarMahasiswa.put(mahasiswa1.getIdMahasiswa(), mahasiswa1);
        daftarMahasiswa.put(mahasiswa2.getIdMahasiswa(), mahasiswa2);
        daftarMahasiswa.put(mahasiswa3.getIdMahasiswa(), mahasiswa3);
    }


    public Buku getBuku(String idBuku) {
        return daftarBuku.get(idBuku);
    }


    public Mahasiswa getMahasiswa(String idMahasiswa) {
        return daftarMahasiswa.get(idMahasiswa);
    }

// AKHIR BAGIAN 1=====


// AWAL BAGIAN 2=====
    public void menuPinjamBuku() {
        Scanner input = new Scanner(System.in);
        ArrayList<Peminjaman> daftarPeminjaman = new ArrayList<>();
        System.out.print("\nMasukkan ID Buku yang ingin dipinjam: ");
        String idBuku = input.nextLine();

        System.out.print("Masukkan NIM: ");
        String idMahasiswa = input.nextLine();

        pinjamBuku(idBuku, idMahasiswa);

    }


    
    public void menuKembalikanBuku() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nMasukkan ID Peminjaman yang ingin dikembalikan: ");
        String idPeminjaman = input.nextLine();

        kembalikanBuku(idPeminjaman);
    }


    public void pinjamBuku( String idBuku, String idMahasiswa) {
        Buku buku = daftarBuku.get(idBuku);
        Mahasiswa mahasiswa = daftarMahasiswa.get(idMahasiswa);

        if (buku != null && mahasiswa != null && buku.isTersedia()) {
            Peminjaman peminjaman = new Peminjaman("P" + (daftarPeminjaman.size() + 1), buku, mahasiswa);
            daftarPeminjaman.add(peminjaman);
            System.out.println("\nPeminjaman berhasil. ID Peminjaman: " + peminjaman.getIdPeminjaman());
        

        } else {
            System.out.println("\n=== !!! Peminjaman gagal. Pastikan buku tersedia dan Mahasiswa terdaftar.!!! ===");
        }
       

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
// AKHIR BAGIAN 2=====

// AWAL BAGIAN 3=====

    public void tampilkanDaftarBukuTersedia() {
        System.out.println("\n======== Daftar Buku Tersedia ========\n");
        // Pengunalngan HasMap
        for (Map.Entry<String, Buku> book : daftarBuku.entrySet()) {
            Buku buku = book.getValue();
            if (buku.isTersedia()) {
                System.out.println("ID Buku\t\t: " + buku.getIdBuku());
                System.out.println("Judul\t\t: " + buku.getJudul());
                System.out.println("Pengarang\t: " + buku.getPengarang());
                System.out.println("======================================");
            }
        }
    }


    public void tampilkanDaftarMahasiswa() {
        System.out.println("\n======== Daftar Mahasiswa ========\n");
        for (Entry<String, Mahasiswa> entry : daftarMahasiswa.entrySet()) {
            Mahasiswa Mahasiswa = entry.getValue();
            if (Mahasiswa.isTerdaftar()) {
                System.out.println("NIM\t: " + Mahasiswa.getIdMahasiswa());
                System.out.println("Nama\t: " + Mahasiswa.getNama());
                System.out.println("Email\t: " + Mahasiswa.getEmail());
                System.out.println("======================================");
            }
        }
    }


    public void tampilkanLaporanPeminjaman() {
        System.out.println("\n======== Laporan Peminjaman ========");
        for (Peminjaman peminjaman : daftarPeminjaman) {
            System.out.println("ID Peminjaman\t: " + peminjaman.getIdPeminjaman());
            System.out.println("Tanggal Pinjam\t: " + peminjaman.getTanggalPinjam());
            System.out.println("Buku\t\t: " + peminjaman.getBuku().getJudul());
            System.out.println("Nama\t\t: " + peminjaman.getMahasiswa().getNama());
                System.out.println("======================================");
        }
    }

    public void tampilkanLaporanPengembalian() {
        System.out.println("\n======== Laporan Pengembalian ========");
        for (Peminjaman peminjaman : daftarPeminjaman) {
            if (peminjaman.isSudahDikembalikan()) {
                System.out.println("ID Peminjaman\t: " + peminjaman.getIdPeminjaman());
                System.out.println("Tanggal Kembali\t: " + peminjaman.getTanggalKembali());
                System.out.println("Buku\t\t: " + peminjaman.getBuku().getJudul());
                System.out.println("Nama\t\t: " + peminjaman.getMahasiswa().getNama());
                System.out.println("======================================");
            }
        }
    }
    
// AKHIR BAGIAN 3=====
}