// INITIAL CODE
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.HashMap;
import java.util.*;
import java.lang.*;
import java.io.*;
// A Binary Tree node
class Level_Order_Traversal
{
	
    // driver function to test the above functions
    public static void main(String args[])
    {
		
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
		//Node root=null;
        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            Node root=null;
            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null)
                {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }
		
            Spiral g = new Spiral();
            g.printSpiral(root);
			System.out.println();
            t--;
			
        }
    }
}
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
/*This is a function problem.You only need to complete the function given below*/
/*
// A Binary Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Spiral
{
	void printSpiral(Node node) 
	{
		Node n;
		int c=1,nc=0;
		List<Node> al = new ArrayList<>();
		boolean order = true;
		for(Queue<Node> q = new LinkedList<>(Arrays.asList(node));!q.isEmpty();)
		{
			al.add(n = q.remove());
			c--;
			if(n.left!=null && q.add(n.left))
				nc++;
			if(n.right!=null && q.add(n.right))
				nc++;
			if(c==0)
			{
				c=nc;
				nc=0;
				if(order)
					Collections.reverse(al);
				al.forEach(x->System.out.append(x.data+" "));
				al.clear();
				order = !order;
			}
		}
		System.out.flush();
	}
}