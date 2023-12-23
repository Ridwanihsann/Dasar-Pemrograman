import java.util.Scanner;

import controller.PerpustakaanController;
import model.Mahasiswa;
import model.Buku;

public class App {


    public static void main(String[] args) {
        System.out.println("\n+====================================+");
        System.out.println("|========== SELAMAT DATANG ==========|");
        System.out.println("|--- Perpustakaan Peminjaman Buku ---|");
        System.out.println("+====================================+\n");

        PerpustakaanController perpustakaanController = new PerpustakaanController();
        perpustakaanController.Data();
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
                case "2" :
                    perpustakaanController.tampilkanDaftarMahasiswa();
                    break;
                case "3":
                    perpustakaanController.menuPinjamBuku();
                    break;
                case "4" :
                    perpustakaanController.menuKembalikanBuku();
                    break;
                case "5" :
                    perpustakaanController.tampilkanLaporanPeminjaman();
                    break;
                case "6" :
                    System.out.println("\n=== Terima kasih! ===\n");
                    break;
                default:
                    System.out.println("\n!!! Pilihan tidak valid. Masukan angka yang sesuai. !!!\n");
                    break;
            }
        }
    }



    public static void tampilkanMenu() {
        System.out.println("\n+====================================+");
        System.out.println("|       Silahkan pilih menu:         |");
        System.out.println("|------------------------------------|");
        System.out.println("|1.| Tampilkan Daftar Buku           |");        
        System.out.println("|2.| Tampilkan Daftar Mahasiswa      |");   
        System.out.println("|3.| Pinjam Buku                     |");
        System.out.println("|4.| Kembalikan Buku                 |");
        System.out.println("|5.| Tampilkan Laporan Peminjaman    |");
        System.out.println("|6.| Keluar                          |");
        System.out.println("+====================================+");
    }


}
