import java.util.Scanner;
import java.util.*;
class BT_To_DLL
{
	void inorder(Node node)
	{
		if(node==null)
			return ;
		else
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
	}
	void printList(Node head) 
		{
		Node prev = head;
				while (head != null) 
				{
						System.out.print(head.data + " ");
			prev = head;
						head = head.right;
				}
		
		System.out.println();
		while(prev != null)
		{
			System.out.print(prev.data+" ");
			prev = prev.left;
		}
		}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		BT_To_DLL obj = new BT_To_DLL();
		//DLL d = new DLL();
		int t = sc.nextInt();
		while(t>0)
		{
			HashMap<Integer, Node> hm = new HashMap<Integer, Node>();
			int n = sc.nextInt();
			
			Node root = null;
			
			while(n>0)
			{
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				char lr = sc.next().charAt(0);
				
				Node parent = hm.get(n1);
				if(parent == null)
				{
					parent = new Node(n1);
					hm.put(n1, parent);
					if(root == null)
					{
						root = parent;
						//d.head = root;
					}
					
				}
				
				Node child = new Node(n2);
				if(lr == 'L')
					parent.left = child;
				else
					parent.right = child;
				
				hm.put(n2,child);
			n--;
			}
			
			GfG g = new GfG();
			Node node = g.bToDLL(root);
			obj.printList(node);
		t--;
		System.out.println();
		}
	}
}
class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}
/*This is a function problem.You only need to complete the function given below*/
/* class Node
class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}*/
// This function should convert a given Binary tree to Doubly
// Linked List
class GfG
{
	Node head;
	Node bToDLL(Node root)
	{
		// a better idea is to just traverse in inorder fashion and append nodes to a head pointer
		for(root = recur(null, root, -1);root.left!=null;root=root.left);
		return root;
	}
	public static Node recur(Node parent, Node root, int side)
	{
		if(root == null)
			return null;
		else
		{
			Node temp;
			if(root.left!=null)
			{
				for(temp = recur(root, root.left, -1); temp.right!=null; temp = temp.right);
				temp.right = root;
				root.left = temp;
			}
			if(root.right!=null)
			{
				for(temp = recur(root, root.right, 1); temp.left!=null;	temp = temp.left);
				temp.left = root;
				root.right = temp;
			}
		
			if(root.right==null || root.left == null || parent==null)
				return root;
			else
				return side == -1?root.right:root.left;
		}
	}
}