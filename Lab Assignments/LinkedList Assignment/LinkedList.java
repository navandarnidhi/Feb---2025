class LinkedList{
	Node head; //head pointer of the list
	
	//node class to represent each node
	class Node{
		int data;
		Node next;
		
		Node (int data){
			this.data = data;
			this.next = null;
		}
	}
	
	// insert at begining
	
	public void insertAtBegin(int data){ 
		Node newNode = new Node(data); 
		
		if (head == null){
			head = newNode;
		}
		else {
			newNode.next = head;
			head = newNode;
		}
	}
	
	// insert at the end 
	public void insertAtEnd(int data){
		Node newNode = new Node(data);
		if (head == null){
			head = newNode;
		}
		Node end = head;
		
		while(end.next != null){
			end = end.next;
		}
		end.next = newNode;
	}
	
	
	// insert in the specific posiiton
	
	public void insertAtPosition (Node temp, int new_data){
		Node new_node = new Node (new_data);
		new_node.next = temp.next;
		temp.next = new_node;
	}
	
	
	// display
	public void display(){
		Node current = head;
		
		while(current != null){
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
	
	public static void main (String args[]){
		LinkedList list = new LinkedList();
		
		System.out.println("insert at the begining: ");
		list.insertAtBegin(10);
		list.insertAtBegin(20);
		list.insertAtBegin(30);
		
		list.display();
		
		System.out.println("insert at the end: ");
		list.insertAtEnd(5);
		
		list.display();
		
		System.out.println("insert at specific position: ");
		list.insertAtPosition(list.head.next,13);
		list.insertAtPosition(list.head.next.next,15);
		list.display();
		
	}
}


