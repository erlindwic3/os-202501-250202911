result = detect_deadlock(processes, allocation, request)

print("=== Hasil Deteksi Deadlock ===")
if result:
    print(f"Status: TERJADI DEADLOCK")
    print(f"Proses yang terlibat: {', '.join(sorted(result))}")
else:
    print("Status: SISTEM AMAN (Tidak ada Deadlock)")
```