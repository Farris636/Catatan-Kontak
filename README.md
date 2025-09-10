Nama: Moch. Farris Alfiansyah Nim: 2409116079

# Sistem Catatan Kontak

## Deskripsi Singkat
Program ini merupakan sistem sederhana untuk mengelola catatan kontak menggunakan bahasa Java dengan menerapkan operasi dasar CRUD (Create, Read, Update, Delete). Data kontak disimpan menggunakan ArrayList dalam bentuk objek Kontak.

Sistem Ini memiliki beberapa fitur:
- Menambah kontak dengan memasukkan Nama dan Nomor Handphone.
- Melihat kontak yang telah dibuat.
- Mengganti kontak yang sudah ada dengan mengganti Nama dan Nomor Handphone
- Menghapus kontak yang sudah dibuat.

## Alur Program
1. Program dimulai → menampilkan menu utama.
2. User memilih menu (1–6).
3. Program menjalankan perintah sesuai pilihan user:
    -  Tambah Kontak → input nama & nomor, lalu simpan ke ArrayList.
    -  Lihat Semua Kontak → tampilkan semua daftar kontak (looping).
    -  Ubah Kontak → pilih index, masukkan data baru, ganti kontak lama.
    -  Hapus Kontak → pilih index, hapus kontak dari daftar.
    -  Sortir Kontak (A–Z) → urutkan daftar kontak berdasarkan nama.
    -  Keluar → akhiri program.
5. Program kembali ke menu utama setelah aksi selesai.
6. Perulangan berhenti hanya jika user memilih menu 6 (Keluar).

## Penejelasan Program
**Import Library**

```java
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.Comparator;
    import java.util.Scanner;
```
Mengimpor library ArrayList untuk menyimpan data kontak, Collections dan Comparator untuk mengurutkan data, dan Scanner untuk membaca input dari pengguna.

**Deklarasi class Kontak**
```java
class Kontak {
    String nama;
    String nomor;

    Kontak(String nama, String nomor) {
        this.nama = nama;
        this.nomor = nomor;
    }
}
```
Kelas Kontak merepresentasikan setiap data kontak. Kelas ini memiliki atribut nama dan nomor, serta konstruktor untuk mengisi data ketika objek baru dibuat.

**Deklarasi class Main**
```java
public class Main {
    public static void main(String[] args) {
        ArrayList<Kontak> daftarKontak = new ArrayList<>();
        Scanner input;
        input = new Scanner(System.in);
        int pilihan;
```
Kelas Main berisi metode main sebagai titik masuk program. Di dalamnya dibuat ArrayList untuk menyimpan kontak, objek Scanner untuk membaca input, serta variabel pilihan untuk menyimpan menu yang dipilih.

**Perulangan Menu Utama**
```java
do {
    System.out.println("\n--- Menu ---");
    System.out.println("1. Tambah Kontak");
    System.out.println("2. Lihat Semua Kontak");
    System.out.println("3. Ubah Kontak");
    System.out.println("4. Hapus Kontak");
    System.out.println("5. Sortir Kontak (A-Z)");
    System.out.println("6. Keluar");
    System.out.print("Pilih menu: ");
    pilihan = input.nextInt();
    input.nextLine();

```
Program menampilkan menu utama di dalam perulangan do-while. Input dari pengguna disimpan di variabel pilihan.

**Percabangan Menu**
```java
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

```
Menu diproses menggunakan switch-case. Setiap case berisi logika sesuai pilihan user, dan default menangani input yang tidak valid.

**Tambah Kontak**
```java
System.out.print("Masukkan nama: ");
String nama = input.nextLine();
System.out.print("Masukkan nomor: ");
String nomor = input.nextLine();
daftarKontak.add(new Kontak(nama, nomor));
System.out.println("Kontak berhasil ditambahkan.");
```
Program menampilkan menu utama di dalam perulangan do-while. Input dari pengguna disimpan di variabel pilihan.

**Lihat Semua Kontak**
```java
if (daftarKontak.isEmpty()) {
    System.out.println("Belum ada kontak.");
} else {
    for (int i = 0; i < daftarKontak.size(); i++) {
        System.out.println((i+1) + ". " + daftarKontak.get(i).nama + " - " + daftarKontak.get(i).nomor);
    }
}
```
Menu ini menampilkan daftar kontak. Jika kosong, program menampilkan pesan khusus. Jika ada, kontak ditampilkan satu per satu dengan perulangan.

**Ubah Kontak**
```java
System.out.print("Masukkan nomor urut kontak yang ingin diubah: ");
int indexUbah = input.nextInt();
input.nextLine();
if (indexUbah > 0 && indexUbah <= daftarKontak.size()) {
    System.out.print("Masukkan nama baru: ");
    String namaBaru = input.nextLine();
    System.out.print("Masukkan nomor baru: ");
    String nomorBaru = input.nextLine();
    daftarKontak.set(indexUbah-1, new Kontak(namaBaru, nomorBaru));
    System.out.println("Kontak berhasil diubah.");
} else {
    System.out.println("Nomor urut tidak valid.");
}
```
Pada menu ubah kontak, pengguna memilih nomor urut kontak yang ingin diubah. Jika valid, data lama diganti dengan data baru menggunakan metode set().

**Hapus Kontak**
```java
System.out.print("Masukkan nomor urut kontak yang ingin dihapus: ");
int indexHapus = input.nextInt();
input.nextLine();
if (indexHapus > 0 && indexHapus <= daftarKontak.size()) {
    daftarKontak.remove(indexHapus-1);
    System.out.println("Kontak berhasil dihapus.");
} else {
    System.out.println("Nomor urut tidak valid.");
}
```
Menu hapus kontak user diminta untuk memasukkan nomor urut dari pengguna. Jika index valid, data kontak dihapus dari daftar menggunakan metode remove().

**Sortir Kontak**
```java
Collections.sort(daftarKontak, Comparator.comparing(k -> k.nama.toLowerCase()));
System.out.println("Kontak berhasil diurutkan berdasarkan nama (A-Z).");
```
Menu sortir menggunakan Collections.sort dengan Comparator agar daftar kontak diurutkan berdasarkan nama secara alfabetis tanpa membedakan huruf besar dan kecil.

**Akhir Program**
```java
} while (pilihan != 6);

```

## Output Program Sistem Catatan Kontak
<img width="391" height="187" alt="image" src="https://github.com/user-attachments/assets/44846a0e-8b4c-4dea-9e14-c672a85272bc" />




