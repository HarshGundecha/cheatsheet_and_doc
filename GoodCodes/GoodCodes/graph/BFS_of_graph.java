
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();
            
            for(int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            boolean vis[] = new boolean[nov];
            for(int i = 0; i < nov; i++)
                vis[i] = false;
            new Traversal().bfs(0, list, vis);
            System.out.println();
        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
/*
*ArrayList<ArrayList<Integer>> list: represent graph containing vertices
                                    and edges between them
*vis[]: boolean array to represent visited vertex
*s: starting vertex 
*/
class Traversal
{
    static void bfs(int s, ArrayList<ArrayList<Integer>> list, boolean vis[])
    {
        Queue<Integer> q = new LinkedList<>();
				int i=0, j=0, n=0;
				vis[s]=true;
				for(q.add(s);!q.isEmpty();)
				{
					i = q.remove();
					System.out.print(i+" ");
					for(j=0;j<list.get(i).size();j++)
					{
						n = list.get(i).get(j);
						if(!vis[n])
						{
							vis[n]=true;
							q.add(n);	
						}
					}
				}
    }
}