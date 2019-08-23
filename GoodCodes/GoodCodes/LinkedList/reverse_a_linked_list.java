//Initial Template for Java
import java.util.*;
import java.io.*;
public class LinkedList1
{
    Node head;  // head of lisl
    Node lastNode;
    static PrintWriter out;
    /* Linked list Node*/
    /* Utility functions */
    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node)
    {
        if (head == null)
        {
            head = node;
            lastNode = node;
        }
        else
        {
            Node temp = head;
            lastNode.next = node;
            lastNode = node;
        }
    }
    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            out.print(temp.data+" ");
            temp = temp.next;
        }
        out.println();
    }
    
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int t= Integer.parseInt(br.readLine());
        while(t>0)
        {
            int n = Integer.parseInt(br.readLine());
            LinkedList1 llist = new LinkedList1();
                        String nums[] = br.readLine().split(" ");
            if (n > 0)
            {
                int a1= Integer.parseInt(nums[0]);
                Node head= new Node(a1);
                llist.addToTheLast(head);
            }
            for (int i = 1; i < n; i++)
            {
                int a = Integer.parseInt(nums[i]);
                llist.addToTheLast(new Node(a));
            }
            llist.head = new ReverseLL().reverseList(llist.head);
            
            llist.printList();
            
            t--;
        }
        out.close();
    }
}

class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}

/*This is a function problem.You only need to complete the function given below*/
//function Template for Java
/* Return reference of new head of the reverse linked list 
 class Node {
     int value;
    Node next;
    Node(int value) {
        this.value = value;
    }
} */
class ReverseLL
{
    // This function should reverse linked list and return
   // head of the modified linked list.
	Node reverseList(Node head)
	{
		Node p1 = head, p2 = null, p3 = null;
		if(p1.next==null); // 1 element case
		else
		{
			p2 = p1.next;
            p1.next = null;
            if(p2.next==null) // 2 element case
                head = p2;
			else              // 3 element case
			{
				for(p3 = p2.next;p3.next!=null;p2.next = p1,p1 = p2,p2 = p3, p3 = p3.next);
				p3.next = p2;
				head = p3;
			}
            p2.next = p1;
        }
		return head;
        // for(Node current = head, prev = null;current!=null;)
        // {
        //     head = current.next;
        //     current.next = prev;
        //     prev = current;
        //     current = head;
        // }
        // return prev;
    }
}