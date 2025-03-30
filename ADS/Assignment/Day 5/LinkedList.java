import java.util.Scanner;

class LinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void insertAtPosition(int data, int position) {
        if (position < 1) {
            System.out.println("Invalid position");
            return;
        }
        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteByValue(int data) {
        if (head == null) return;
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void deleteAtPosition(int position) {
        if (head == null || position < 1) return;
        if (position == 1) {
            head = head.next;
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public boolean search(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) return true;
            temp = temp.next;
        }
        return false;
    }

    public int length() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void reverse() {
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public Node findMiddle() {
        if (head == null) return null;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean hasCycle() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public void removeDuplicates() {
        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice, data, position;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete by Value");
            System.out.println("5. Delete at Position");
            System.out.println("6. Search");
            System.out.println("7. Length");
            System.out.println("8. Check if Empty");
            System.out.println("9. Print List");
            System.out.println("10. Reverse List");
            System.out.println("11. Find Middle");
            System.out.println("12. Remove Duplicates");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter data for insertion at Start: ");
                    data = scanner.nextInt();
                    list.insertAtBeginning(data);
                }
                case 2 -> {
                    System.out.print("Enter data for insertion at End: ");
                    data = scanner.nextInt();
                    list.insertAtEnd(data);
                }
                case 3 -> {
                    System.out.print("Enter data in between: ");
                    data = scanner.nextInt();
                    System.out.print("Enter position: ");
                    position = scanner.nextInt();
                    list.insertAtPosition(data, position);
                }
                case 4 -> {
                    System.out.print("Enter value to delete: ");
                    data = scanner.nextInt();
                    list.deleteByValue(data);
                }
                case 5 -> {
                    System.out.print("Enter position to delete: ");
                    position = scanner.nextInt();
                    list.deleteAtPosition(position);
                }
                case 6 -> {
                    System.out.print("Enter value to search: ");
                    data = scanner.nextInt();
                    System.out.println(list.search(data) ? "Found" : "Not Found");
                }
                case 7 -> System.out.println("Length: " + list.length());
                case 8 -> System.out.println(list.isEmpty() ? "List is empty" : "List is not empty");
                case 9 -> list.printList();
                case 10 -> list.reverse();
                case 11 -> System.out.println("Middle: " + (list.findMiddle() != null ? list.findMiddle().data : "No middle node"));
                case 12 -> list.removeDuplicates();
            }
        } while (choice != 0);
        scanner.close();
    }
}
