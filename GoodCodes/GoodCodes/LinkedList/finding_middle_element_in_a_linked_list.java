import java.util.*;
public class FindMiddle
{
    Node head;  // head of list
  public void addToTheLast(Node node) {
  if (head == null) {
   head = node;
  } else {
   Node temp = head;
   while (temp.next != null)
    temp = temp.next;
   temp.next = node;
  }
 }
	  
    public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t>0)
         {
			int n = sc.nextInt();
			FindMiddle llist = new FindMiddle();
			//int n=Integer.parseInt(br.readLine());
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
          
        GFG gfgobj = new GFG(); 
		//llist.head = new GFG().Middle(llist.head);
		System.out.println(gfgobj.getMiddle(llist.head));
        
		//llist.printList();
		
			t--;
		}
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
/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}
This is method only submission.  You only need to complete the method. */
class GFG
{
    // Function to find middle element a linked list
  int getMiddle(Node head)
  {
		Node p1 = head, p2 = head, p1Bak = null;
		byte c=0;
		while(p2!=null)
		{
			p1Bak = p1;
			p1=p1.next;
			p2=p2.next;
			if(p2!=null)
			{
				p2=p2.next;
				c+=2;
			}
			else
				c++;
		}
		return c%2==0?p1.data:p1Bak.data;
	}
}