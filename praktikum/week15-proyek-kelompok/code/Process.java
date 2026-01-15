public class Process {
    String pid;
    int arrivalTime;
    int burstTime;
    int finishTime, tat, wt;

    public Process(String pid, int arrivalTime, int burstTime) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}