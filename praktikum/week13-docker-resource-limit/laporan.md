# Laporan Praktikum Minggu [13]

Topik: [Docker - Resource Limit (CPU dan Memory)]

---

## Identitas

- **Nama** : [Erlin Dwi CAhyanti]
- **NIM** : [250202911]
- **Kelas** : [1IKRB]

---

## Tujuan

Tuliskan tujuan praktikum minggu ini.  
Contoh:

1. Membuat Dockerfile sederhana untuk menjalankan program uji.
2. Melakukan build dan menjalankan container Docker.
3. Menerapkan pembatasan resource CPU dan memori pada container.
4. MElakukan monitring resource container menggunakan docker stats.
5. Menjelaskan dampak batasan resource terhadap eksekusi progam.

---

## Dasar Teori

1. **Docker** adalah platform containerization yang menjalankan aplikasi dalam lingkunga terisolasi.
2. **Namespaces** digunakan untuk mengisolasi environment atau proses, network, filesystem.
3. **Control Groups (cgroups)** digunakan untuk membatasi dan menonitoring CPU, memori, dan I/O container.
4. **CPU limit**mengurangi jatah waktu eksekusi CPU, sehinggan program berjalan lebih lambat.
5. **Memory limit** menetapkan batas memori dan menyebabkan aplikasi dihentikan (OOM) jika melebihi batas terseut.

---

## Langkah Praktikum

1. Memferifikasi instalasi Docker:

```bash
docker version
docker ps
```

2. Membuat progra uji Python yang melakukan komputasi besar dan alokasi memori.
3. Membuat Dockerfile untuk menjalankan program tersebut.
4. Membangun image Docker:

```bash
  docker build -t week13-resource-limit .
```

5. Menjalankan container tanpa batasan resource.
6. Menjalankan container dengan limit CPU dan memori.

```bash
docker run --rm --cpus="0.5" --memory="256m" week13-resource-limit
```

7.  MElakukan monitoring dengan:

```bash
docker stats
```

8. Mengambil screenshot hasil eksekusi (ditaruh di folder screenshots/)
9. Melakukan commit & push ke repository:

```bash
git add .
git commit -m "Minggu 13 - Docker Resource Limit"
git push origin main
```

---

## Kode / Perintah

Tuliskan potongan kode atau perintah utama:

```bash
import time
data = []
print("Start compute & allocate")
for i in range(10_000_000):
    if i % 1_000_000 == 0:
        print("i =", i)
    data.append(i)
print("Done")
time.sleep(2)

```

---

## Hasil Eksekusi

Sertakan screenshot hasil percobaan atau diagram:
![Screenshot hasil](screenshots/Build%20image.png)
![Screenshot hasil](screenshots/container%20dengan%20batasan%20resource.png)
![Screenshot hasil](screenshots/container%20normal.png)
![Screenshot hasil](screenshots/docker%20stats.png)

---

## Analisis

- Jelaskan makna hasil percobaan.
- Hubungkan hasil dengan teori (fungsi kernel, system call, arsitektur OS).
- Apa perbedaan hasil di lingkungan OS berbeda (Linux vs Windows)?

---

## Kesimpulan

Tuliskan 2–3 poin kesimpulan dari praktikum ini.

1. Docker mendukung pengaturan batasan sumber daya untuk container diatur menggunakan cgroups.
2. Pembatasan CPU dapat memperlambat eksekusi, sedangkan pembatasan memori terbatas, potensi program dapat terhenti.
3. Pembatasan sumber daya sangat vital untuk menghindari satu container menggunakan sumber daya berlebihan dan mengganggu container lainnya.

---

## Quiz

1. [Mengapa container perlu dibatasi CPU dan memori?]  
   **Jawaban:**
   Container perldibatasi CPU dan memori karena untuk mencegah satu container menghabiskan sumber daya host, menjaga stabilitas sistem, dan membagi sumber daya secara adil antar container.
2. [Apa perbedaan VM dan container dalam konteks isolasi resource?]  
   **Jawaban:**  
   VM menggunakan hypervisor dan memiliki kernel sendiri, sehingga isolasi lebih kuat tetapi berat.
   Container berbagi kernel host menggunakan namespace & cgroups, sehingga lebih ringan tetapi isolasi resource tidak sekuat VM.
3. [Apa dampak limit memori terhadap aplikasi yang boros memori?]  
    **Jawaban:**  
   Dampak limit memori terhadap aplikasi moros memori adalah Aplikasi dapat berjalan lambat, gagal mengalokasikan memori, atau dihentikan secara paksa oleh OOM Killer.

---

## Refleksi Diri

Tuliskan secara singkat:

- Apa bagian yang paling menantang minggu ini?
- Bagaimana cara Anda mengatasinya?

---

**Credit:**  
_Template laporan praktikum Sistem Operasi (SO-202501) – Universitas Putra Bangsa_
