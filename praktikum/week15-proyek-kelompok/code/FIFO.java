import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Data input Page Replacement (Contoh standar praktikum)
        int[] pages = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3};
        int capacity = 3; // Jumlah Frame

        System.out.println("========== SIMULASI PAGE REPLACEMENT (FIFO) ==========");
        System.out.println("Reference String: " + Arrays.toString(pages));
        System.out.println("Kapasitas Frame: " + capacity);
        System.out.println("------------------------------------------------------");

        HashSet<Integer> frames = new HashSet<>(capacity);
        Queue<Integer> queue = new LinkedList<>();
        int pageFaults = 0;

        System.out.printf("%-15s | %-20s | %-10s\n", "Page Request", "Frames in Memory", "Status");
        System.out.println("------------------------------------------------------");

        for (int page : pages) {
            String status = "";
            if (!frames.contains(page)) {
                if (frames.size() < capacity) {
                    frames.add(page);
                } else {
                    int val = queue.poll();
                    frames.remove(val);
                    frames.add(page);
                }
                queue.add(page);
                pageFaults++;
                status = "Page Fault";
            } else {
                status = "Page Hit";
            }
            System.out.printf("%-15d | %-20s | %-10s\n", page, frames.toString(), status);
        }

        System.out.println("------------------------------------------------------");
        System.out.println("Total Page Faults: " + pageFaults);
        System.out.println("Total Page Hits: " + (pages.length - pageFaults));
    }
}
