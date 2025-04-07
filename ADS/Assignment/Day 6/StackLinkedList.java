import java.util.Scanner;

// Class representing a node in the linked list
class Node {
    int data;
    Node next;
    
    Node(int new_data) {
        this.data = new_data;
        this.next = null;
    }
}

// Class to implement stack using a singly linked list
class StackLL {
    Node head;

    StackLL() {
        this.head = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
        System.out.println(new_data + " pushed onto stack.");
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! No elements to pop.");
            return;
        }
        System.out.println("Popped element: " + head.data);
        head = head.next;
    }

    int peek() {
        if (!isEmpty()) {
            return head.data;
        } else {
            System.out.println("Stack is empty.");
            return Integer.MIN_VALUE;
        }
    }
    
    void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        Node temp = head;
        System.out.print("Stack elements: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

// Driver code
public class StackLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackLL stack = new StackLL();
        int choice;
        
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Check if Stack is Empty");
            System.out.println("5. Print Stack");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = sc.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    int top = stack.peek();
                    if (top != Integer.MIN_VALUE)
                        System.out.println("Top element: " + top);
                    break;
                case 4:
                    System.out.println(stack.isEmpty() ? "Stack is Empty." : "Stack is NOT Empty.");
                    break;
                case 5:
                    stack.printStack();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
        
        sc.close();
    }
}
