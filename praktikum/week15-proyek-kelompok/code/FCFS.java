import java.io.*;
import java.util.*;

public class FCFS {
    public static void run() {
        List<Process> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("data/proses.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                list.add(new Process(d[0], Integer.parseInt(d[1].trim()), Integer.parseInt(d[2].trim())));
            }
        } catch (IOException e) {
            System.out.println("Gagal baca data/proses.csv"); return;
        }

        int currentTime = 0;
        double totalTAT = 0, totalWT = 0;

        System.out.println("\n=================================================================");
        System.out.printf("| %-10s | %-8s | %-8s | %-8s | %-8s | %-5s |\n", "PID", "Arrival", "Burst", "Finish", "TAT", "WT");
        System.out.println("-----------------------------------------------------------------");

        for (Process p : list) {
            if (currentTime < p.arrivalTime) currentTime = p.arrivalTime;
            p.finishTime = currentTime + p.burstTime;
            p.tat = p.finishTime - p.arrivalTime;
            p.wt = p.tat - p.burstTime;
            currentTime = p.finishTime;

            totalTAT += p.tat;
            totalWT += p.wt;

            System.out.printf("| %-10s | %-8d | %-8d | %-8d | %-8d | %-5d |\n", p.pid, p.arrivalTime, p.burstTime, p.finishTime, p.tat, p.wt);
        }
        System.out.println("=================================================================");
        System.out.printf("Avg TAT: %.2f | Avg WT: %.2f\n", (totalTAT/list.size()), (totalWT/list.size()));
    }
}