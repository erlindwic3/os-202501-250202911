
# Laporan Praktikum Minggu [3]
### Topik: ["Manajemen File dan Permission di Linux"]

---

## Identitas
- **Nama**  : [Erlin Dwi Cahyanti]  
- **NIM**   : [250202911]  
- **Kelas** : [1IKRB]

---

## Tujuan
Tuliskan tujuan praktikum minggu ini.  
Contoh:  
> Mahasiswa mampu menjelaskan fungsi utama sistem operasi dan peran kernel serta system call.

---

## Dasar Teori
Tuliskan ringkasan teori (3–5 poin) yang mendasari percobaan.
Pemahaman bahwa Linux mengelola semua yang ada di sistem sebagai file, dan keamanan sistem sangat bergantung pada mekanisme kontrol akses yang kuat yang didefinisikan oleh Kepemilikan (chown) dan Izin Akses (chmod).

---

## Langkah Praktikum
1. Langkah-langkah yang dilakukan.  
2. Perintah yang dijalankan.  
3. File dan kode yang dibuat.  
4. Commit message yang digunakan.

---

## Kode / Perintah
Tuliskan potongan kode atau perintah utama:
```bash
pwd
ls -l
cd /tmp
ls -a
cat /etc/passwd | head -n 5
echo "Hello <NAME><NIM>" > percobaan.txt
ls -l percobaan.txt
chmod 600 percobaan.txt
ls -l percobaan.txt
sudo chown root percobaan.txt
ls -l percobaan.txt
```

---
### Experimen 1
 Navigasi Sistem File Jalankan perintah berikut:
```
pwd
ls -l
cd /tmp
ls -a
```
Jelaskan hasil tiap perintah

- pwd

 output
 
 /home/user/praktikum/week3-linux-fs-permission

 
 	Menampilkan Direktori Kerja Saat Ini (Print Working Directory). Ini adalah lokasi Anda di sistem file.

- ls -lcd /tmp

Output 

	drwxrwxrwt 12 root root 4096 Oct 16 14:00 /tmp
   
   	Menampilkan detail direktori /tmp. - l: format panjang - c: urutkan dan tampilkan waktu status change - d: hanya tampilkan info direktori itu sendiri, bukan isinya. Hasil menunjukkan izin (drwxrwxrwt), jumlah link, pemilik (root), grup (root), ukuran, waktu perubahan status, dan nama direktori. Direktori aktif dicatat: /home/user/praktikum/week3-linux-fs-permission.
```
- ls -a
```
Output

	. .. percobaan.txt .gitignore

   Menampilkan semua file dan direktori, termasuk file tersembunyi (yang diawali dengan ., seperti . untuk direktori saat ini dan .. untuk direktori induk). Isi folder mencakup semua yang ditampilkan.

### Eksperimen 2 – Membaca File
```
cat /etc/passw 
```
Output
dhead
-n 5

`root:x:0:0:root:/root:/bin/bash 
 daemon:x:1:1:daemon:/usr/sbin:/usr/sbin/nologin 
 bin:x:2:2:bin:/bin:/usr/sbin/nologin 
 sys:x:3:3:sys:/dev:/usr/sbin/nologin 
 sync:x:4:65534:sync:/bin:/bin/sync


- Eksperimen 3 – Permission & Ownership
```
echo "Hello <NAME><NIM>" > percobaan.txt
```
Membuat file percobaan.txt dengan isi teks.


```
ls -l percobaan.txt
```
-rw-rw-r-- 1 user group 23 Oct 16 14:05 percobaan.txt	Sebelum chmod: File memiliki izin rw- untuk pemilik (user), rw- untuk grup (group), dan r-- untuk lainnya (others).

```
chmod 600 percobaan.txt
```

Mengubah izin menjadi 600 (pemilik: read, write; grup: ---; lainnya: ---).
```
ls -l percobaan.txt
```
-rw------- 1 user group 23 Oct 16 14:05 percobaan.txt	Sesudah chmod: Izin berubah menjadi rw-------. Hanya pemilik yang dapat membaca dan menulis file tersebut. Grup dan others tidak memiliki izin sama sekali.
```
sudo chown root percobaan.txt
```
Mengubah pemilik file dari user menjadi root.
```
ls -l percobaan.txt
```
-rw------- 1 root group 23 Oct 16 14:05 percobaan.txt	Hasil chown: Pemilik file sekarang adalah root. Grup tetap, dan izin tetap rw-------. Hanya root yang kini dapat membaca/menulis file ini.



## Hasil Eksekusi
Sertakan screenshot hasil percobaan atau diagram:
![Screenshot hasil](screenshots/praktikumweek3-linux-fs-permissionscreenshots.png)

---

## Analisis
- Jelaskan makna hasil percobaan.  
- Hubungkan hasil dengan teori (fungsi kernel, system call, arsitektur OS).  
- Apa perbedaan hasil di lingkungan OS berbeda (Linux vs Windows)?  

---

## Kesimpulan
Tuliskan 2–3 poin kesimpulan dari praktikum ini.

---

## Quiz
1. [Apa fungsi dari perintah chmod?]  
   **Jawaban:** 

   Fungsi perintah chmod (Change Mode) adalah untuk mengubah hak akses (izin/permission) sebuah file atau direktori. Izin ini mengatur siapa (pemilik, grup, atau lainnya) yang dapat membaca (r), menulis (w), atau mengeksekusi (x) objek tersebut.

2. [Apa arti dari kode permission rwxr-xr--?]  
   **Jawaban:** 
   Kode permission rwxr-xr-- berarti:

- Pemilik (User): Memiliki izin Baca (r), Tulis (w), dan Eksekusi (x).

- Grup (Group): Memiliki izin Baca (r) dan Eksekusi (x), tetapi tidak ada izin Tulis (-).

- Lainnya (Others): Hanya memiliki izin Baca (r), tetapi tidak ada izin Tulis (-) dan Eksekusi (-). (Notasi oktalnya adalah 754).

3. [Jelaskan perbedaan antara chown dan chmod.]  
   **Jawaban:**  

   

---

## Refleksi Diri
Tuliskan secara singkat:
- Apa bagian yang paling menantang minggu ini?  
- Bagaimana cara Anda mengatasinya?  

---

**Credit:**  
_Template laporan praktikum Sistem Operasi (SO-202501) – Universitas Putra Bangsa_
