 public class QueueImplementation<T> implements QueueInterface<T> {
    // Delares the class QueueImplementation that implements the QueueInterface with a generic type T, uses the methods defined in the interface to provide functionality for a queue data structure.

    private  class Node { // Class Node that represents a single node in the queue, contains a data field of type T and a reference to the next node in the queue.
        T data;
        Node next;
        
        Node(T data) {
            this.data = data; // Initializes the data field with the provided value.  - example: If we create a new node with the value 5, the data field will be set to 5.
            this.next = null; // Constructor for the Node class that initializes the data and sets the next reference to null.
        }
    }
    //examples of how the Node class works:
    // Node node1 = new Node(5); // Creates a new node with the value 5. The data field of node1 will be set to 5, and the next reference will be null.
    // Node node2 = new Node(10); // Creates a new node with the value 10. The data field of node2 will be set to 10, and the next reference will be null.
    // node1.next = node2; // Sets the next reference of node1 to point to node2. Now, node1 is linked to node2, and we can traverse from node1 to node2 using the next reference.
    private Node front; // Reference to the front of the queue - the node that will be dequeued next.
    private Node back;  // Reference to the back of the queue - the node that was most recently enqueued.

    public QueueImplementation() { // Constructor for the QueueImplementation class that initializes the front and back references to null.
        front = null; //Initially the front is empty, so it is set to null.
        back = null; //Initially the back is empty, so it is set to null.
    }

    @Override // Overrides the enqueue method from the QueueInterface to add a new entry to the back of the queue.
    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry); // Creates a new node with the given entry.
        if (isEmpty()) { // If the queue is empty, set both front and back to the new node.
            front = newNode;
            back = newNode;
        } else { // Otherwise, add the new node to the back of the queue and update the back reference.
        //why? Because in a queue, new entries are added to the back, and the back reference needs to be updated to point to the new last node in the queue.
            back.next = newNode;
            back = newNode;
        }
    }

    @Override // Overrides the dequeue method from the QueueInterface to remove and return the front entry of the queue.
    public T dequeue() {
        if (isEmpty()) { // If the queue is empty, throw an exception.
            throw new IllegalStateException("Queue is empty");
        }
        T frontData = front.data; // Store the data of the front node to return later.
        front = front.next; // Move the front reference to the next node in the queue.
        if (front == null) { // If the queue is now empty after dequeuing, set back to null as well.
        //If the front is null, it means there are no more nodes in the queue, so the back reference should also be set to null to indicate that the queue is empty.
            back = null;
        }
        return frontData; // Return the data of the dequeued node
    }

    @Override // Overrides the getFront method from the QueueInterface to return the front entry of the queue without removing it.
    public T getFront() {
        if (isEmpty()) { // If the queue is empty, throw an exception.
            throw new IllegalStateException("Queue is empty");
        }
        return front.data; // Return the data of the front node without modifying the queue.
    }

    @Override // Overrides the isEmpty method from the QueueInterface to check if the queue is empty.
    public boolean isEmpty() {
        return front == null; // The queue is empty if the front reference is null.
    }

    @Override // Overrides the clear method from the QueueInterface to remove all entries from the queue.
    public void clear() {
        front = null; // Set the front reference to null, which effectively removes all nodes from the queue.
        back = null; // Set the back reference to null as well, since the queue is now empty.
    }
}