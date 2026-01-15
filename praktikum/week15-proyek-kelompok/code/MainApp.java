import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n[ MINI SIMULASI OS - KELOMPOK ]");
            System.out.println("1. CPU Scheduling (FCFS)");
            System.out.println("2. Page Replacement (FIFO)");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            String pil = sc.nextLine();

            if (pil.equals("1")) FCFS.run();
            else if (pil.equals("2")) {
                System.out.print("Masukkan jumlah frame: ");
                int f = Integer.parseInt(sc.nextLine());
                FIFO.run(f);
            } else if (pil.equals("3")) break;
        }
    }
}