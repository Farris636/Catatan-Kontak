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

Tampilan awal ketika program dijalankan akan menampilkan pilihan-pilihan yang tersedia.


<img width="358" height="258" alt="image" src="https://github.com/user-attachments/assets/e8c5887e-41c9-45f0-86ca-751824c4f21b" />

Tamapilan ketika memilih opsi yang pertama yaitu menambah kontak, setelah itu sistem akan meminta user untuk memasukkan nama dan nomer hansphone yang inggin ditambahkan.



<img width="371" height="281" alt="image" src="https://github.com/user-attachments/assets/22cf6bc7-e1c4-491e-b70e-136d42272889" />

Menu kedua adalah melihat kontak yang sudah tersimpan di sistem, ketika memilih opsu 2 maka sistem akan menampilkan kontaknya.



<img width="529" height="288" alt="image" src="https://github.com/user-attachments/assets/a74aab27-ea1a-4e01-9868-1433ea8a6e5f" />

Menu ketiga adalah mengubah kontak yang sebelumnya sudah dibuat menggunakan menu 1, untuk mengubah kontak yang sudah ada dengan cara memasukkan nama dan kontak baru.



<img width="525" height="502" alt="image" src="https://github.com/user-attachments/assets/9e1b4e46-5b8d-4b55-8b4d-a382b4bcfebc" />

Menu keempat adalah menghapus kontak yang sudah dibuat dengan cara memasukkan index dari nama dan nomer kontak yang ingin dihapus.



<img width="361" height="373" alt="image" src="https://github.com/user-attachments/assets/3d3d340c-f987-4dd4-b330-191a04d26cd3" />

Menu kelima adalah untuk mengurutkan nama kontak sesuai dengan abjad yaitu dari A-Z, gambar di atas adalah kondisi sebelum menggunakan menu 5 jadi masih tidak sesuai dengan abjad.



<img width="349" height="589" alt="image" src="https://github.com/user-attachments/assets/53a2edfc-a054-4c80-8c68-009b942e7e71" />

Ini adalah tampilan ketika nama kontak sudah sesuai urutan abjad, jadi nama kontak akan terurut dan tersusun rapi sesuai abjad.



<img width="362" height="229" alt="image" src="https://github.com/user-attachments/assets/4fd9408c-c779-4391-9b2a-8f53dfadf22a" />

Menu keenam adalah keluar dari program, jika sudah tidak ada lagi yang ingin dilakukan pada sistem catatan kontak.



<img width="359" height="456" alt="image" src="https://github.com/user-attachments/assets/cabde741-c405-4b98-bad4-4a98b5041e0e" />

Ini adalah tampilan looping atau perulangan ketika setelah memilih menu 
