import java.util.Scanner;
import java.util.*;
class LRU_cache
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			Set<Integer> s = new HashSet<Integer>() ;
				int n = sc.nextInt();
				LRUCache g = new LRUCache(n);
			int q = sc.nextInt();
			
			while(q>0)
			{
			
				String c = sc.next();
			//	System.out.println(c);
				if(c.equals("GET"))
				{
					int x = sc.nextInt();
					System.out.print(g.get(x)+" ");
				}
				if(c.equals("SET"))
				{
					int x = sc.nextInt();
					int y  = sc.nextInt();
					g.set(x,y);
				}
			
			q--;
			//System.out.println();
			}
		t--;
		System.out.println();
		}
	}
}


/*This is a function problem.You only need to complete the function given below*/
/*You are required to complete below class */
class LRUCache {
	Map<Integer,Integer> map;
	Deque<Integer> dq;
	int capacity;
	// Set<Integer> existance;
	/*Inititalize an LRU cache with size N */
	public LRUCache(int N) {
		capacity = N;
		map = new HashMap<>();
		dq = new LinkedList<>();
	}
	
	/*Returns the value of the key x if 
		present else returns -1 */
	public int get(int x) {
		if(map.containsKey(x))
			if(dq.remove(x))
				dq.addFirst(x);
		return map.get(x)!=null?map.get(x):-1;
	}
	
	/*Sets the key x with value y in the LRU cache */
	public void set(int x, int y)
	{
		if(dq.contains(x))
			dq.remove(x);
		else if( dq.size() == capacity )
			map.remove(dq.removeLast());
		dq.addFirst(x);
		map.put(x,y);
	}
}
