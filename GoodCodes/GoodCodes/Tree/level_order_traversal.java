// INITIAL CODE
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;
// A Binary Tree node
class Drivercode
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
		
						Level_order_traversal g = new Level_order_traversal();
						g.levelOrder(root);
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
class Level_order_traversal
{
	//You are required to complete this method
	static void levelOrder(Node root) 
	{
		Deque<Node> nList = new LinkedList<>(Arrays.asList(new Node[]{root}));
		for(int parentLevelNodeCount = 1, childLevelNodeCount = 1, i;childLevelNodeCount!=0;parentLevelNodeCount = childLevelNodeCount)
			for(childLevelNodeCount=i=0; i<parentLevelNodeCount; i++)
			{
				System.out.print((root = nList.removeFirst()).data+" ");
				if(root.left!=null && nList.add(root.left))
						childLevelNodeCount++;
				if(root.right!=null && nList.add(root.right))
					childLevelNodeCount++;
			}
	}
}

//maintain two list for parent and child nodes
//print paranet data and at same time get its child and take them in the list

//try doing in singl list and use a count