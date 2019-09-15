import java.util.Scanner;
import java.io.*;
class GFG2
{
		public static void main(String args[])
		{
				Scanner sc=new Scanner(System.in);
				int t=sc.nextInt();
				while(t-->0)
				{
						int n=sc.nextInt();
						Node start1=null,cur1=null,start2=null,cur2=null;
						while(n-->0)
						{
								int a=sc.nextInt();
								int b=sc.nextInt();
								Node ptr=new Node(a,b);
								if(start1==null)
								{
										start1=ptr;
										cur1=ptr;
								}
								else{
										cur1.next=ptr;
										cur1=ptr;
								}
						}
						n=sc.nextInt();
						while(n-->0)
						{
								int a=sc.nextInt();
								int b=sc.nextInt();
								Node ptr=new Node(a,b);
								if(start2==null)
								{
										start2=ptr;
										cur2=ptr;
								}
								else{
										cur2.next=ptr;
										cur2=ptr;
								}
						}
						GFG obj=new GFG();
						obj.addPolynomial(start1,start2);
						System.out.println();
				}
		}
}
	class Node{
			int coeff;
			int pow;
			Node next;
			Node(int a,int b)
			{
					coeff=a;
					pow=b;
					next=null;
			}
	}
	/*This is a function problem.You only need to complete the function given below*/
	
	/*class Node{
			int coeff;
			int pow;
			Node next;
			Node(int a,int b)
			{
					coeff=a;
					pow=b;
					next=null;
			}
	}*/
	//Print the polynomial formed by adding both LL in the function itself.
	class GFG
	{
			public static void addPolynomial(Node p1,Node p2)
			{
			java.util.Map<java.lang.Integer, java.lang.Integer> tmap = new java.util.TreeMap<>(java.util.Collections.reverseOrder());
			StringBuilder sb = new StringBuilder();
			for(;p1!=null; tmap.put(p1.pow, tmap.getOrDefault(p1.pow, 0)+p1.coeff), p1=p1.next);
			for(;p2!=null; tmap.put(p2.pow, tmap.getOrDefault(p2.pow, 0)+p2.coeff), p2=p2.next);
			for (java.util.Map.Entry<Integer,Integer> entry : tmap.entrySet())
				sb.append(entry.getValue()+"x^"+entry.getKey()+" + ");
			sb.delete(sb.length()-3, sb.length());
			System.out.print(sb.toString());
			}
	}