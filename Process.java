public class Process {

    // Attributes
    private int processID;
    private int arrivalTime;
    private int burstTime;

    // Constructor
    public Process(int processID, int arrivalTime, int burstTime) {
        this.processID = processID;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }

    // Getters
    public int getProcessID() {
        return processID;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    // Setters
    public void setProcessID(int processID) {
        this.processID = processID;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    // Summary of the process
    public String toString() {
        return "Process ID: " + processID + " | Arrival Time: " + arrivalTime + " | Burst Time: " + burstTime;

    }

}
