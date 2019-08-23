import java.util.*;
import java.io.*;
import java.lang.*;
class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();
            for(int i = 0; i < nov+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if(new DetectCycle().isCyclic(list, nov) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
/*Complete the function below*/
/*
ArrayList<ArrayList<Integer>> list: to represent graph containing 'v'
                                    vertices and edges between them
V: represent number of vertices
*/
class DetectCycle
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
			boolean[] recStack  = new boolean[V], isVisited = new boolean[V];
			while(--V>-1)
				if(CycleUtil(V, list, recStack, isVisited))
					return true;
			return false;
		}
		static boolean CycleUtil(int i, ArrayList<ArrayList<Integer>> list, boolean[] recStack, boolean[] isVisited)
		{
			if(recStack[i])
				return true;
			else if(isVisited[i])
				return false;
			else
			{
				recStack[i] = isVisited[i] = true;
				List<Integer> children = list.get(i);
				for(int j : children)
					if(CycleUtil(j, list, recStack, isVisited))
						return true;				
			}
			return (recStack[i] = false);
		}
}