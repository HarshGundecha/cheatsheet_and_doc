import java.util.*;
import java.lang.*;

class Chainlength {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
			int n = sc.nextInt();
			Pair pr[] = new Pair[n];
			int arr[] = new int[2 * n];
			for (int i = 0; i < 2 * n; i++) {
				arr[i] = sc.nextInt();
			}
			for (int i = 0, j = 0; i < 2 * n - 1 && j < n; i = i + 2, j++) {
				pr[j] = new Pair(arr[i], arr[i + 1]);
			}
			GfG g = new GfG();
			System.out.println(g.maxChainLength(pr, n));
		}
	}
}

class Pair {
	int x;
	int y;
	
	public Pair(int a, int b) {
		x = a;
		y = b;
	}
}

/*
* This is a function problem.You only need to complete the function given below
*/

/*
* class CompareByFirst implements Comparator<Pair> { public int compare(Pair a,
	* Pair b) { return a.x - b.x; } }
*/
class GfG
{
	int maxChainLength(Pair arr[], int n)
	{
		int tbl[] = new int[n];
		Arrays.sort(arr, (a, b) -> a.x - b.x);
		for (int j, max, i = n - 1; i > -1; tbl[i] = max, i--)
			for (max = 1, j = i; j < n; j++)
				if (arr[i].y < arr[j].x && tbl[j] >= max)
					max = tbl[j] + 1;
		return Arrays.stream(tbl).max().getAsInt();
	}
}
	
	// int maxChainLength(Pair arr[], int n)
	// {
	// 	// your code here
	// 	Arrays.sort(arr,(a,b)-> a.y -b.y) ; // notice sorting on y
	// 	int cur = Integer.MIN_VALUE, ans = 0;
		
	// 	for(Pair p : arr){
	// 		if(cur < p.x) {
	// 			cur = p.y ;
	// 			ans++;
	// 		}
	// 	}
	// 	return ans ;
	// }