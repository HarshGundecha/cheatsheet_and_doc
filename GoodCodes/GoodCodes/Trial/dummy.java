import java.util.*;
class Main {
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			while (t-- > 0) {
					int n = sc.nextInt();
					Node head = null;
					for (int i = 0; i < n; i++) {
							int a = sc.nextInt();
							head = addToTheLast(new Node(a), head);
					}
					int k = sc.nextInt();
					Rotate g = new Rotate();
					head = g.rotate(head,
													k); // rotate linked list anti-clockwise by k nodes
					printList(head);
			}
	}
	// insert function to build linked list
	public static Node addToTheLast(Node node, Node head) {
			if (head == null) {
					head = node;
			} else {
					Node temp = head;
					while (temp.next != null) {
							temp = temp.next;
					}
					temp.next = node;
			}
			return head;
	}
	public static void printList(Node node) {
			while (node != null) {
					System.out.print(node.data + " ");
					node = node.next;
			}
			System.out.println();
	}
}
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
} 
/*This is a function problem.You only need to complete the function given below*/
/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
*/
class Rotate {
    
     /*  This function should rotate list counter-
    clockwise by k and return new head (if changed) */
	public Node rotate(Node head, int k)
	{
		Node curr = head, prev = null;
		while(curr!=null)
		{
			curr = curr.next;
			head.next = prev;
			prev = head;
			head = curr;
		}
		// head.next=prev;
		return prev;
  }
}