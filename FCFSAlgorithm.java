import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class FCFSAlgorithm {
    public static void main(String[] args) {
        
        JOptionPane.showMessageDialog(null, "FCFS (First-Come-First-Serve) Scheduling Simulation! \nPress OK to start", "Welcome to", JOptionPane.INFORMATION_MESSAGE);
        
        int currentTime = 0; // Declaring current time as 0 as to allow for a starting point.
        int numberOfProcesses = 0; // Declaring number of processes as 0 as to allow for a starting point.

        Scanner input = new Scanner(System.in);


        // ask the user for the number of processes and loop until it matches the required input
        while (true) {
            System.out.print("Enter the number of processes: ");

            // checks if the users input is an integer
            if (input.hasNextInt()) {
                numberOfProcesses = input.nextInt();    // stores the users input into the variable used for number of processes
                if (numberOfProcesses >= 2) {           // then it checks if it's greater than or equal to 2
                    break;                              // breaks out of the for loop if it is
                }
                else {      // if it's an integer but not greater than or equal to 2, it prints a message and loops again
                    System.out.println("Number of processes must be >= 2\n");
                }
            }
            else {          // if it's NOT an integer, it prints a message and loops again
                System.out.println("Invalid Input - Enter an Integer\n");
                input.next();   // clears input variable allowing to try again
            }

        }

        QueueImplementation<Process> queue = new QueueImplementation<>();   // implements our Queue implementation file
        Process[] processes = new Process[numberOfProcesses];               // create a Process array to store the processes

        
        // call process and queue classes
        for (int i = 0; i < numberOfProcesses; i++) {

            int processID = i+1; // It needs to be i+1 because the index starts at 0, while the process starts at P1, hence i+1.
    
            // Inputting the numbers
            System.out.print("\nEnter arrival time for process P" + (i+1) + ": ");
            int arrivalTime = input.nextInt();
            
            System.out.print("Enter burst time for process P" + (i+1) + ": ");
            int burstTime = input.nextInt();

            // Create new process and add to processes array
            processes[i] = new Process(
                processID, arrivalTime, burstTime
            );
            
        }

        /* Sorting the processses by using the compareTo() method within the Process class.
        This will ensure that if the process numbers have out of order arrival times. */
        Arrays.sort(processes); 
        for (Process p : processes) {
            queue.enqueue(p);
        }
        
        String results = ""; // Initialization results string
        int totalWaitingTime = 0; // Java requires variables to be declared, therefore it's necessary to declare the totalWaitingTime as 0 before anything else.
        int totalTurnaround = 0; // Java requires variables to be declared, therefore it's necessary to declare the totalTurnaround as 0 before anything else.

        // Loop through processes array to run through calculations.
        for (int i = 0; i < numberOfProcesses; i++) { 
            Process currentProc = queue.dequeue(); // Take the front queued object as our current process.
            int arrivalTime = currentProc.getArrivalTime(); 
        	
            // Set current time if arrival time is greater.
            if (currentTime < arrivalTime) { 
            	currentTime = arrivalTime;
            }
            
            //  time calculations
            int completionTime = currentTime + currentProc.getBurstTime();
            int turnaroundTime = completionTime - arrivalTime;
        	int waitingTime = currentTime - arrivalTime;
            
            // concatenating results string of required times and variables
            results = (results + "Process P" + currentProc.getProcessID() + " <<..>> Arrival Time " + arrivalTime + " <<..>> Waiting Time " + waitingTime + " <<...>> Turnaround Time " + turnaroundTime + "\n");
            
            // update current time of process queue
            currentTime += currentProc.getBurstTime();
            
            // add waiting time and turnaround time to total time for average calculations
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

