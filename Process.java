
public class Process implements Comparable<Process> {

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

    // compareTo() to compare the arrival times
    public int compareTo(Process other) {
        int comparison = Integer.compare(this.arrivalTime, other.arrivalTime);
        if (comparison != 0) { // If the arrival time isn't the same
            return comparison;
        }
        else { 
            return Integer.compare(this.processID, other.processID); // If the arrival times match, compare the process IDs instead.
        }
        
    }
}
