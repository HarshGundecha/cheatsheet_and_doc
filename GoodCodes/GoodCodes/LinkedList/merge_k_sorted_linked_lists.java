import java.util.*;
class MergeLL
{
   static Node head;
    public static void addToTheLast(Node node) 
	{
		if (head == null) 
		{
			head = node;
		} 
		else
		{
		   Node temp = head;
		   while (temp.next != null)
		   temp = temp.next;
		   temp.next = node;
		}
    }
    public static void printList(Node node)
    {
        if(node == null)
          return;
          while(node != null)
          {
              System.out.print(node.data + " ");
              node = node.next;
          }
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {   
            int N = sc.nextInt();
            Node []a=new Node[N];
            for(int i = 0; i < N; i++)
              {
                  int n = sc.nextInt();
                  int p = sc.nextInt();
                  Node start=null,cur=null;
                Node head = new Node(p);
                start=head;
                cur=head;
                    for(int j = 1; j < n; j++)
                    {
                        int a1 = sc.nextInt();
                        Node ptr=new Node(a1);
                        cur.next=ptr;
                        cur=ptr;
                    }
                    a[i]=start;
              }
             Node start=a[0];
             Merge g = new Merge();
             
             Node res = g.mergeKList(a,N);
             if(res!=null)
             printList(res);
             System.out.println();
            
        }
        
    }
}
class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}
/*This is a function problem.You only need to complete the function given below*/
/*class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
/*a is an array of Nodes of the heads of linked lists
  and N is size of array a*/
class Merge
{
	Node mergeKList(Node[] a, int N)
	{
		Node nl = new Node(0), temp=nl;
		int i, mini, min;
		boolean flag;
		here:
		while(true)
		{
			for(
				flag = false,	min = Integer.MAX_VALUE, mini = -1, i=0; 
				i<N; 
				i++
			)
				if(a[i] != null)
				{
					flag = true;
					if(a[i].data<=min)
						min = a[mini = i].data;
				}

			if(flag)
			{
				nl = nl.next = a[mini];
				a[mini]=a[mini].next;
			}
			else
				break here;

		}

		return temp.next;
	}
}