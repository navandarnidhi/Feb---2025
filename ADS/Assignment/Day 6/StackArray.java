import java.util.Scanner;

class Stack {
    private int arr[];
    private int top;
    private int capacity;

    // Constructor to initialize stack
    Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    // Push (Insertion)
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full! Cannot push.");
            return;
        }
        arr[++top] = value;
        System.out.println(value + " pushed into stack.");
    }

    // Pop (Deletion)
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop.");
            return -1;
        }
        return arr[top--];
    }

    // Peek (Top Element)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! No top element.");
            return -1;
        }
        return arr[top];
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Print all stack elements from top to bottom
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Traverse each element of stack
    public void traverse() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Nothing to traverse.");
            return;
        }
        System.out.println("Traversing stack:");
        for (int i = top; i >= 0; i--) {
            System.out.println("Element at position " + (top - i + 1) + ": " + arr[i]);
        }
    }
}

public class StackArray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Asking user for stack size
        System.out.print("Enter the size of the stack: ");
        int size = sc.nextInt();
        Stack stack = new Stack(size);

        while (true) {
            // Menu
            System.out.println("\nStack Operations Menu:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Check if Empty");
            System.out.println("5. Check if Full");
            System.out.println("6. Print Stack");
            System.out.println("7. Traverse Stack");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: // Push
                    System.out.print("Enter value to push: ");
                    int value = sc.nextInt();
                    stack.push(value);
                    break;

                case 2: // Pop
                    int poppedValue = stack.pop();
                    if (poppedValue != -1) {
                        System.out.println("Popped: " + poppedValue);
                    }
                    break;

                case 3: // Peek
                    int topValue = stack.peek();
                    if (topValue != -1) {
                        System.out.println("Top element: " + topValue);
                    }
                    break;

                case 4: // isEmpty
                    System.out.println(stack.isEmpty() ? "Stack is empty." : "Stack is not empty.");
                    break;

                case 5: // isFull
                    System.out.println(stack.isFull() ? "Stack is full." : "Stack is not full.");
                    break;

                case 6: // Print Stack
                    stack.printStack();
                    break;

                case 7: // Traverse Stack
                    stack.traverse();
                    break;

                case 8: // Exit
                    System.out.println("Exiting program...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}
