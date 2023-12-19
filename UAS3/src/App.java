import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import controller.PerpustakaanController;
import model.Anggota;
import model.Buku;

public class App {

    // private static final Scanner Scanner = null;


    public static void main(String[] args) throws Exception {
        PerpustakaanController perpustakaanController = new PerpustakaanController();
        perpustakaanController.inisialisasiDataDummy();
        boolean lanjut = true;
        Scanner input = new Scanner(System.in);
        while (lanjut) {
            tampilkanMenu();
                System.out.print("Masukkan pilihan Anda:");
                String pilihan = input.nextLine();
            switch (pilihan) {
                case "1":
                    perpustakaanController.tampilkanDaftarBukuTersedia();
                    break;
                case "2":
                    perpustakaanController.menuPinjamBuku();
                    break;
                case "3" :
                    perpustakaanController.menuKembalikanBuku();
                    break;
                case "4" :
                    perpustakaanController.tampilkanLaporanPeminjaman();
                    break;
                case "5" :
                    System.out.println("\n=== Terima kasih! ===");
                    break;
                default:
                    System.out.println("\n!!! Pilihan tidak valid. Masukan angka yang sesuai. !!!");
                    break;
            }
        }

        System.out.println("Sampai Jumpa");

    }



    public static void tampilkanMenu() {
        System.out.println("\n===== Sistem Peminjaman Perpustakaan =====\n");
            System.out.println("1. Tampilkan Daftar Buku");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Kembalikan Buku");
            System.out.println("4. Tampilkan Laporan Peminjaman");
            System.out.println("5. Keluar");
    }


}
