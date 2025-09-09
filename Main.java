package com.mycompany.catatan_kontak;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Kontak {
    String nama;
    String nomor;

    Kontak(String nama, String nomor) {
        this.nama = nama;
        this.nomor = nomor;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Kontak> daftarKontak = new ArrayList<>();
        Scanner input;
        input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n===== SISTEM CATATAN KONTAK =====");
            System.out.println("1. Tambah Kontak");
            System.out.println("2. Lihat Semua Kontak");
            System.out.println("3. Ubah Kontak");
            System.out.println("4. Hapus Kontak");
            System.out.println("5. Sortir Kontak (A-Z)");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // buang enter

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan nomor: ");
                    String nomor = input.nextLine();
                    daftarKontak.add(new Kontak(nama, nomor));
                    System.out.println("Kontak berhasil ditambahkan!");
                    break;

                case 2:
                    System.out.println("\nDaftar Kontak:");
                    if (daftarKontak.isEmpty()) {
                        System.out.println("Belum ada kontak.");
                    } else {
                        for (int i = 0; i < daftarKontak.size(); i++) {
                            System.out.println((i+1) + ". " + daftarKontak.get(i).nama 
                                + " - " + daftarKontak.get(i).nomor);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Masukkan nomor kontak yang ingin diubah (index): ");
                    int indexUbah = input.nextInt();
                    input.nextLine();
                    if (indexUbah > 0 && indexUbah <= daftarKontak.size()) {
                        System.out.print("Nama baru: ");
                        String namaBaru = input.nextLine();
                        System.out.print("Nomor baru: ");
                        String nomorBaru = input.nextLine();
                        daftarKontak.set(indexUbah-1, new Kontak(namaBaru, nomorBaru));
                        System.out.println("Kontak berhasil diubah!");
                    } else {
                        System.out.println("Index tidak valid!");
                    }
                    break;

                case 4:
                    System.out.print("Masukkan nomor kontak yang ingin dihapus (index): ");
                    int indexHapus = input.nextInt();
                    input.nextLine();
                    if (indexHapus > 0 && indexHapus <= daftarKontak.size()) {
                        daftarKontak.remove(indexHapus-1);
                        System.out.println("Kontak berhasil dihapus!");
                    } else {
                        System.out.println("Index tidak valid!");
                    }
                    break;

                case 5:
                    if (daftarKontak.isEmpty()) {
                        System.out.println("Belum ada kontak untuk disortir.");
                    } else {
                        Collections.sort(daftarKontak, Comparator.comparing(k -> k.nama.toLowerCase()));
                        System.out.println("Kontak berhasil diurutkan (A-Z)!");
                    }
                    break;

                case 6:
                    System.out.println("Keluar dari program...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 6);

        input.close();
    }
}
