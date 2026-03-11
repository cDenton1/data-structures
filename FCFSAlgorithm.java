import java.util.Scanner;
import javax.swing.JOptionPane;

public class FCFSAlgorithm {
    public static void main(String[] args) {
        
        JOptionPane.showMessageDialog(null, "FCFS (First-Come-First-Serve) Scheduling Simulation! \nPress OK to start", "Welcome to", JOptionPane.INFORMATION_MESSAGE);
        
        /* The following code is just to get the main logic out of the way.
        It's assumed the other classes will handle the variables. */
        
        int currentTime = 0;
        int numberOfProcesses = 0;

        Scanner input = new Scanner(System.in);

        // Asking the user for the number of processes. If it's less
        while (numberOfProcesses < 2) {
            System.out.print("Enter the number of processes: ");

            if (input.hasNextInt()) {
                numberOfProcesses = input.nextInt();
                if (numberOfProcesses < 2) {
                    System.out.println("Number of processes must be >= 2\n");
                }
            }
            // Look into fixing the error if there's time. 
            else {
                throw new NumberFormatException("Invalid Input - Enter an Integer");
            }

        }

        QueueImplementation<Process> queue = new QueueImplementation<>();
        Process[] processes = new Process[numberOfProcesses];
        
        // call process and queue classes
        for (int i = 0; i < numberOfProcesses; i++) { // 

            int processID = i+1;
    
            // Inputting the numbers
            System.out.print("\nEnter arrival time for process P" + (i+1) + ": ");
            int arrivalTime = input.nextInt();
            
            System.out.print("Enter burst time for process P" + (i+1) + ": ");
            int burstTime = input.nextInt();

            // will replace with linked list or whatever, placeholder for now 
            processes[i] = new Process(
                processID, arrivalTime, burstTime
            );

            queue.enqueue(processes[i]);
            
        }

        // System.out.println(queue.getFront()); // testing
        
        String results = "";
        int totalWaitingTime = 0;
        int totalTurnaround = 0;

        for (int i = 0; i < numberOfProcesses; i++) {
            Process currentProc = queue.dequeue();
            int arrivalTime = currentProc.getArrivalTime();
        	
            if (currentTime < arrivalTime) {
            	currentTime = arrivalTime;
            }
            
            // calculations
            int completionTime = currentTime + currentProc.getBurstTime();
            int turnaroundTime = completionTime - currentProc.getArrivalTime();
        	int waitingTime = currentTime - arrivalTime;
            
            results = (results + "Process P" + (i+1) + " <<..>> Arrival Time " + arrivalTime + " <<..>> Waiting Time " + waitingTime + " <<...>> Turnaround Time " + turnaroundTime + "\n");
            currentTime += currentProc.getBurstTime();
            
            totalWaitingTime += waitingTime;
            totalTurnaround += turnaroundTime;
        }

        // message displaying results
        JOptionPane.showMessageDialog(null, results);
        
        // calculating averages
        double averageWaitingTime = totalWaitingTime / numberOfProcesses;
        double averageTurnaroundTime = totalTurnaround / numberOfProcesses;

        // message displaying average waiting and turnaround times
        JOptionPane.showMessageDialog(null, "Average Waiting Time: " + averageWaitingTime + "\nAverage Turnaround Time: " + averageTurnaroundTime);
        
    }
}

