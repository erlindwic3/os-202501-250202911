# Laporan Praktikum Minggu [4]

## Topik: Topik: Manajemen Proses dan User di Linux

---

## Identitas
- **Nama**  : [Erlin Dwi Cahyanti]  
- **NIM**   : [250202911]  
- **Kelas** : [1IKRB]

---

## Tujuan praktikum minggu ini. 
1. Mahasiswa mampu mnjelaskan konsep proses dan user dalam sistem operasi Linux.
2. Mahasiswa mampu menampilkan daftar proses yang sedang berjalan dan statusnya.
3. Mahasiwa mampu menjalankan perintah untuk membuat dan mengelola user.
4. Mahasiwa mampu menghentikan atau mengontrol proses tertentu menggunakan PID.
5. Mahasiswa mampu menjelaskan kaitan antara manajemen user dan keamanan sistem.


---



## Dasar Teori
  Linux menggunakan Manajemen Proses untuk memastikan semua program berjalan dengan teratur dan Manajemen Pengguna untuk memastikan hanya yang berhak yang dapat mengaksesnya,artinya sistem membatasi siapa yang boleh berinteraksi dengan sistem operasi multi-user seperti Linux yang merujuk pada prinsip Fundemental Keamanan dan Otorisasi yang diimplememtasikan melalui Manajemen Pengguna.



---

##  Langkah Praktikum
 1. Pastikan telah menginstal Ubuntu atau WSL 
 2. Buka terminal
 3. Pastikan telah login sebagai akun user biasa, bukan   
      root untuk menjalankan perintah dengan sudo.
 4. Buat Struktur folder untuk praktikum minggu ini
 5. Lakukan **Eksperimen 1** dengan menjalankan perintah   
      `whoami` , `id` , serta perintah `groups` kemudian screenshots dan hasilnya letakan di  `screenshots/user.png` .
 6. Lakukan **Eksperimen 2**  untuk memantau dan menganalisis proses yang sedang berjalan jalankan perintah `ps aux | head -10`
          `top -n 1`  kemudian screenshots dan hasilnya letakan di  `screenshots/user.png` .
 7. LAkukan **Eksperimen 3** untuk mengntrol proses di latar belakang menggunakan PID dengan menjalankan perintah
           `sleep 1000 &`
           `ps aux | grep sleep`  kemudian screenshots dan hasilnya letakan di  `screenshots/user.png` .
 8.  Commit & Push
```
   git add .
   git commit -m "Minggu 4 - Manajemen Proses & User"
   git push origin main
 
```

 ## Kode / Perintah yang Dilakukan

# Eksperimen 1
 ```
 whoami
id
groups
sudo adduser praktikan
sudo passwd praktikan

```
# Eksperimen 2 
``` 
ps aux | head -10
top -n 1

```
# Eksperimen 3
```
sleep 1000 &
ps aux | grep sleep
kill <PID>
``` 

# ksperimen 4 
```
pstree -p | head -20
``` 


## Hasil Eksekusi dan Analisis
Sertakan screenshot hasil percobaan atau diagram:

![Screenshot hasil](screenshots/praktikumweek4-proses-userscreenshotstop.png%20(2).png)
 
 | Perintah | Hasil Output | Keteranagn |
| :--- | :---: | ---: |
| `whoami` | erlinkbm3| Menampilkan username dari pengguna yang sedang login.|
| `id` | uid=1000(erlinkbm3) |Identitas  user. |
|      | gid=1000(erlinkbm3) |Identitas grup utama user.|
|      | groups=1000(erlinkbm3),4(adm),27(sudo),966(docter)|User ini memiliki hak istimewa untuk menjalankan perintah administratif sebagai root menggunakan sudo.|
| groups | erlinkbm3 adm sudo docker| Menampilkan daftar nama grup tempat user yang sedang aktif menjadi anggota |




![Screenshot hasil](screenshots/Eksperimen%202.png)

 | Perintah | Penjelasan  | Keteranagn |
| :--- | :---: | ---: |
| PID (proses ID) | Angka unik yang ditetapkan oleh kernel untuk setiap proses yang sedang berjalan.| Mengidentifikasi proses secara unik untuk manajemen (misalnya, untuk dihentikan dengan kill).|
| USER | Nama pengguna yang memiliki atau menjalankan proses tersebut.| Menunjukkan hak akses dan siapa yang bertanggung jawab atas proses.|
| %CPU | Persentase waktu CPU yang digunakan oleh proses sejak terakhir kali diukur (atau secara rata-rata).| Indikator seberapa intensif proses menggunakan sumber daya CPU.|
| %MEM | Persentase memori fisik (RAM) yang digunakan oleh proses.| Indikator seberapa banyak memori yang dialokasikan untuk proses.| 
| COMMAND | Perintah yang digunakan untuk menjalankan proses (termasuk argumen).| Menjelaskan tujuan atau fungsi dari proses yang sedang berjalan.|



![Screenshothasil](screenshots/Eksperimen%203.png)

```
erlinkbm3@cloudshell:~$ sleep 100 &
[1] 1285
erlinkbm3@cloudshell:~$ ps aux | grep sleep
root           1  0.0  0.0   4324  3308 ?        Ss   15:13   0:00 /bin/bash /google/scripts/onrun.sh sleep infinity
root         448  0.0  0.0   2696  1528 ?        S    15:13   0:00 sleep infinity
erlinkb+    1285  0.0  0.0   5688  2104 pts/2    S<   15:15   0:00 sleep 100
erlinkb+    1291  0.0  0.0   6548  2424 pts/2    S<+  15:16   0:00 grep --color=auto sleep
erlinkbm3@cloudshell:~$ kill 1285
[1]+  Terminated              sleep 100
erlinkbm3@cloudshell:~$ ps aux | grep sleep
root           1  0.0  0.0   4324  3308 ?        Ss   15:13   0:00 /bin/bash /google/scripts/onrun.sh sleep infinity
root         448  0.0  0.0   2696  1528 ?        S    15:13   0:00 sleep infinity
erlinkb+    1297  0.0  0.0   6548  2428 pts/2    S<+  15:16   0:00 grep --color=auto sleep
erlinkbm3@cloudshell:~$ 

``` 
Menjalankan program latar belakang: sleep 1000 &

sleep 1000: Program yang hanya akan tidur selama 1000 detik.

&: Menjalankan perintah di latar belakang (background), melepaskan terminal untuk digunakan perintah lain.

Mencatat PID: Output dari ps aux | grep sleep akan menunjukkan baris untuk proses sleep 1000. Catat angka di kolom PID.

Menghentikan proses: kill <PID>

kill (secara default mengirim sinyal SIGTERM atau 15) digunakan untuk mengirim sinyal ke proses berdasarkan PID-nya, yang biasanya meminta proses untuk mengakhiri dirinya sendiri dengan anggun (gracefully).

Memastikan proses berhenti: ps aux | grep sleep akan menunjukkan bahwa proses dengan PID tersebut tidak lagi berjalan (kecuali baris untuk proses grep itu sendiri).








![Screenshothasil](screenshots/Eksperimen%204.png)

erlinkbm3@cloudshell:~$ pstree -p | head -20
bash(1)-+-dockerd(210)-+-containerd(237)-+-{containerd}(255)
        |              |                 |-{containerd}(256)
        |              |                 |-{containerd}(257)
        |              |                 |-{containerd}(259)
        |              |                 |-{containerd}(261)
        |              |                 |-{containerd}(262)
        |              |                 `-{containerd}(265)
        |              |-{dockerd}(217)
        |              |-{dockerd}(218)
        |              |-{dockerd}(219)
        |              |-{dockerd}(220)
        |              |-{dockerd}(232)
        |              |-{dockerd}(235)
        |              |-{dockerd}(266)
        |              |-{dockerd}(267)
        |              `-{dockerd}(278)
        |-logger(26)
        |-python(25)-+-editor-proxy(238)-+-runuser(472)---sh(474)---node(493)-+-node(1211)-+-cloudcode_cli(1278)-+-{cloudcode_cli}(+
        |            |                   |                                    |            |                     |-{cloudcode_cli}(+
        |            |                   |                                    |            |                     |-{cloudcode_cli}(+
erlinkbm3@cloudshell:~$ 



![Screenshothasil](screenshots/Ekspesimen%205.png)






---



## Kesimpulan
1. Linux mencapai efisiensi operasional dengan mengatur semua program sebagai proses yang terstruktur secara hierarkis (berawal dari systemd/init, PID 1). Administrator dapat memonitor proses (ps, top) dan mengontrolnya secara tepat melalui PID dengan mengirimkan sinyal (kill).
2. Sistem memastikan keamanan dan stabilitas dengan menetapkan identitas melalui UID/GID. Ini memberlakukan Prinsip Hak Istimewa Paling Kecil (PoLP), memisahkan user biasa dari root, sehingga hanya yang berwenang yang dapat mengakses sumber daya, mencegah kerusakan sistem, dan menjamin isolasi antar pengguna melalui Manajemen User.

---

## Quiz

1. Apa fungsi dari proses init atau systemd dalam sistem Linux?
## jawaban: Proses inti atau systemed menjasi proses utama yag dijalankan oleh karnel untuk memulai dan mengkonfigurasikan senua layanan dasar dari sistem saat *booting*,dan mengatur siklus hidup start,stop,dan restart ,serta menjadi induk dari semua roses lain dan mengadopsi proses *orphan processes* untuk memastikan semuanya diakhiri dengan benar.Tanpa inti atau systemed,sistem Linux tidak dapat menyelesaikan proses *booting* dan meneglola proses yang berjalan.

2. Apa perbedaan antara kill dan killall?
## jawaban: Inti perbedaan yang paling terlihat pada kill dan killall terletal pada argumen yang digunakan untuk menentukan target aksi Perintah	Argumen Input	Target Aksi
kill	Angka unik (PID)	Menargetkan satu atau beberapa proses spesifik berdasarkan ID uniknya.
killall	Nama Perintah (Teks)	Menargetkan semua proses yang memiliki nama yang sama, biasanya menghentikan beberapa proses sekaligus.

3. Mengapa user root memiliki hak istimewa di sistem Linux?
## jawaban: User root memiliki hak istimewa atau yang disebut juga hak akses terbatas di sistem Linux karena ia adalah akun Administrator Utama. Hak istimewa ini diperlukan untuk menjalankan tugas-tugas kritis yang memengaruhi seluruh sistem dan pengguna lain.Memberikan user root hak istimewa memberikan kemampuan untuk mengelola, memelihara, dan mengamankan seluruh sistem Linux tanpa batasan izin.

---

## Refleksi Diri
Tuliskan secara singkat:
- Apa bagian yang paling menantang minggu ini? memesukan pasword
- Bagaimana cara Anda mengatasinya?  meminta bantuan teman

---

**Credit:**  
_Template laporan praktikum Sistem Operasi (SO-202501) – Universitas Putra Bangsa_
