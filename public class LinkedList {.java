public class LinkedList {
    Node head; // Reference to the first node in the list

    public LinkedList() {
        this.head = null; // Initially, the list is empty
    }

    // Method to insert a new node at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; // If the list is empty, the new node becomes the head
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next; // Traverse to the last node
            }
            current.next = newNode; // Link the new node to the end
        }
    }

    // Method to display the elements of the list
    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to delete a node by its value
    public void deleteByValue(int value) {
        if (head == null) {
            System.out.println("List is empty, cannot delete.");
            return;
        }

        if (head.data == value) {
            head = head.next; // If the head needs to be deleted
            return;
        }

        Node current = head;
        Node previous = null;
        while (current != null && current.data != value) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Value not found in the list.");
        } else {
            previous.next = current.next; // Bypass the node to be deleted
        }
    }

    // Method to search for a value in the list
    public boolean search(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true; // Value found
            }
            current = current.next;
        }
        return false; // Value not found
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.display(); // Output: Linked List: 10 20 30 

        list.deleteByValue(20);
        list.display(); // Output: Linked List: 10 30 

        System.out.println("Is 30 in the list? " + list.search(30)); // Output: Is 30 in the list? true
        System.out.println("Is 50 in the list? " + list.search(50)); // Output: Is 50 in the list? false
    }
}