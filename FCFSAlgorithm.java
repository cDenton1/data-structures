import java.util.Scanner;

public class FCFSAlgorithm {
    public static void main(String[] args) {
        // JOptionPane.showMessageDialog(null, "FCFS (First-Come-First-Serve) Scheduling Simulation! \nPress OK to start", "Welcome to", JOptionPane.INFORMATION_MESSAGE);
        
        /* The following code is just to get the main logic out of the way.
        It's assumed the other classes will handle the variables. */

        int numberOfProcesses;
        int arrivalTime;
        int burstTime;
        int turnaroundTime;
        int waitingTime;
        int averageTurnaroundTime;
        int averageWaitingTime;
        int completionTime;
        
        int currentTime = 0;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        numberOfProcesses = input.nextInt();
        // call process and queue classes
 
        for (int i = 0; i <= numberOfProcesses; i++) {

            // Inputting the numbers
            System.out.print("\nEnter arrival time for process " + "P" + (i) + ": ");
            arrivalTime = input.nextInt();
            
            System.out.print("Enter burst time for process " + "P" + (i) + ": ");
            burstTime = input.nextInt();
            
        }

        // Actual calculations
        // assuming this needs to start from arrival time 0 and work through to the last
        for (int i = 0; i <= numberOfProcesses; i++) {
        	if (currentTime < arrivalTime) {
            	currentTime = arrivalTime
            }
            
            completionTime = currentTime + burstTime
            turnaroundTime = completionTime - arrivalTime
        	waitingTime = turnaroundTime - burstTime
            
            currentTime += burstTime;
        }
        
        // Display message - don't worry about it for now
        /*
        for (int j = 1; j <= numberOfProcesses; j++ ) {
                JOptionPane.showMessageDialog(null, "Process P" + j);
            }
         */
        
        // Message displaying average waiting and turnaround times
        // JOptionPane.showMessageDialog(null, "Average Waiting Time > " + averageWaitingTime + "\nAverage Turnaround Time > " + averageTurnaroundTime);
    }
}
